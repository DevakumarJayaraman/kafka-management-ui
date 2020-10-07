package com.deva.kafka.admin.service;

import com.deva.kafka.admin.domains.*;
import com.deva.kafka.admin.utils.KafkaOperationException;
import org.apache.kafka.clients.CommonClientConfigs;
import org.apache.kafka.clients.admin.*;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.Node;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.config.ConfigResource;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

@Service
public class KafkaAdminService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaAdminService.class);

    @Autowired
    private KafkaAdminClient kafkaAdminClient;

    public ClusterInfo getCluster() throws KafkaOperationException {
        try {
            List<NodeInfo> nodeInfoList = new ArrayList<>();
            DescribeClusterResult clusterResult = kafkaAdminClient.describeCluster();
            Collection<Node> nodes = clusterResult.nodes().get(10, TimeUnit.SECONDS);
            nodes.forEach(node -> {
                nodeInfoList.add(new NodeInfo(node.idString(), node.host() + ":" + node.port()));
            });
            ClusterInfo clusterInfo = new ClusterInfo(clusterResult.clusterId().get(10, TimeUnit.SECONDS), nodeInfoList);
            LOGGER.info("Nodes : {}", clusterInfo);
            return clusterInfo;
        } catch (Exception ex) {
            LOGGER.error("Internal Exception: ", ex);
            throw new KafkaOperationException("Exception while fetching nodes", ex);
        }
    }

    public ConfigInfo getConfig(final String resourceType,final String resourceName) throws KafkaOperationException {
        try {
            ConfigInfo configInfo=new ConfigInfo(resourceType,resourceName);
            ConfigResource brokerConfig = new ConfigResource(ConfigResource.Type.valueOf(resourceType), resourceName);
            Map<ConfigResource, Config> config = kafkaAdminClient.describeConfigs(Arrays.asList(brokerConfig)).all()
                    .get(10, TimeUnit.SECONDS);
            Map<String, String> nodeConfigurations = new HashMap<>();
            config.get(brokerConfig).entries().forEach(configEntry -> {
                nodeConfigurations.put(configEntry.name(),configEntry.value());
            });
            configInfo.setConfigMap(nodeConfigurations);
            return configInfo;
        } catch (Exception ex) {
            LOGGER.error("Internal Exception: ", ex);
            throw new KafkaOperationException("Exception while fetching nodes", ex);
        }
    }

    public List<TopicInfo> getTopics() throws KafkaOperationException {
        try {
            List<TopicInfo> topicInfoList=new ArrayList<>();
            Collection<String> topicNames = kafkaAdminClient.listTopics().names().get(10, TimeUnit.SECONDS);
            Map<String, TopicDescription> topicDescriptionMap = kafkaAdminClient.describeTopics(topicNames).all().get();
            topicDescriptionMap.forEach((topicName, topicDescription) -> {
                TopicInfo topicInfo = new TopicInfo(topicName, topicDescription.partitions().size());
                topicDescription.partitions().forEach(topicPartitionInfo -> {
                    //Get partition Leader Details
                    NodeInfo leader = new NodeInfo(topicPartitionInfo.leader().idString(), topicPartitionInfo.leader().host() + ":" + topicPartitionInfo.leader().port());
                    //Get partition Replica Details
                    List<NodeInfo> replicas = new ArrayList<>();
                    topicPartitionInfo.replicas().forEach(node -> {
                        replicas.add(new NodeInfo(node.idString(), node.host() + ":" + node.port()));
                    });
                    PartitionInfo partitionInfo = new PartitionInfo(topicPartitionInfo.partition(), leader, replicas);
                    topicInfo.addPartitionInfo(partitionInfo);
                });
                topicInfoList.add(topicInfo);
            });
            LOGGER.info("topicInfoList : {}", topicInfoList);
            return topicInfoList;
        } catch (Exception ex) {
            LOGGER.error("Internal Exception: ", ex);
            throw new KafkaOperationException("Exception while fetching topics", ex);
        }
    }

    public List<String> getConsumerGroups() throws KafkaOperationException {
        try {
            return kafkaAdminClient.listConsumerGroups().all().get(10, TimeUnit.SECONDS).stream().map(group -> group.groupId()).collect(Collectors.toList());
        } catch (Exception ex) {
            LOGGER.error("Internal Exception: ", ex);
            throw new KafkaOperationException("Exception while fetching topics", ex);
        }
    }

    public ConsumerGroupInfo describeConsumerGroup(String groupId) throws KafkaOperationException {
        try {
            ConsumerGroupInfo consumerGroupInfo = new ConsumerGroupInfo(groupId);
            Map<TopicPartition, OffsetAndMetadata> offsetMetaDataMap = kafkaAdminClient.listConsumerGroupOffsets(groupId).partitionsToOffsetAndMetadata().get(10, TimeUnit.SECONDS);

            final Map<TopicPartition, Long> endOffsets = new HashMap<>();
            doWithKafkaConsumer(groupId, (c) -> {
                endOffsets.putAll(c.endOffsets(offsetMetaDataMap.keySet()));
            });
            offsetMetaDataMap.forEach(((topicPartition, offsetAndMetadata) -> {
                GroupPartitionInfo groupPartitionInfo = new GroupPartitionInfo(topicPartition.topic(), topicPartition.partition(), offsetAndMetadata.offset());
                consumerGroupInfo.addGroupPartitionInfo(groupPartitionInfo);
                if (endOffsets.get(topicPartition) != null) {
                    groupPartitionInfo.setEndOffset(endOffsets.get(topicPartition));
                    groupPartitionInfo.setLag(groupPartitionInfo.getEndOffset() - groupPartitionInfo.getCurrentOffset());
                }
            }));

            return consumerGroupInfo;
        } catch (Exception ex) {
            LOGGER.error("Internal Exception: ", ex);
            throw new KafkaOperationException("Exception while fetching topics", ex);
        }
    }

    private static void doWithKafkaConsumer(String groupId,
                                            Consumer<KafkaConsumer<String, String>> consumerRunner) {
        Properties props = new Properties();
        props.put(CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG, "localhost:8100,localhost:8101,localhost:8102");
        props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());

        try (final KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props)) {
            consumerRunner.accept(consumer);
        }
    }
}