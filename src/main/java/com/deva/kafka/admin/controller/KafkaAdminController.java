package com.deva.kafka.admin.controller;

import com.deva.kafka.admin.response.GroupResponse;
import com.deva.kafka.admin.response.ClusterResponse;
import com.deva.kafka.admin.response.TopicResponse;
import com.deva.kafka.admin.service.KafkaAdminService;
import com.deva.kafka.admin.utils.Constants;
import com.deva.kafka.admin.utils.KafkaOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka-admin")
public class KafkaAdminController {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaAdminController.class);

    @Autowired
    private KafkaAdminService kafkaAdminService;

    @GetMapping(value = "getCluster", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClusterResponse> getCluster() {
        ClusterResponse response = new ClusterResponse();
        try {
            response.setClusterInfo(kafkaAdminService.getCluster());
            response.setStatus(Constants.STATUS_SUCCESS);
        } catch (KafkaOperationException ex) {
            LOGGER.error("Exception occurred while fetching cluster nodes :", ex);
            response.setStatus(Constants.STATUS_FAILURE);
            response.setErrorMessage("Failed to retrieve node details : " + ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "getTopics", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TopicResponse> getTopics() {
        TopicResponse response = new TopicResponse();
        try {
            response.setTopicInfoMap(kafkaAdminService.getTopics());
            response.setStatus(Constants.STATUS_SUCCESS);
        } catch (KafkaOperationException ex) {
            LOGGER.error("Exception occurred while fetching cluster nodes :", ex);
            response.setStatus(Constants.STATUS_FAILURE);
            response.setErrorMessage("Failed to retrieve node details : " + ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "getConsumerGroups", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponse> getConsumerGroups() {
        GroupResponse response = new GroupResponse();
        try {
            response.setConsumerGroups(kafkaAdminService.getConsumerGroups());
            response.setStatus(Constants.STATUS_SUCCESS);
        } catch (KafkaOperationException ex) {
            LOGGER.error("Exception occurred while fetching consumer groups :", ex);
            response.setStatus(Constants.STATUS_FAILURE);
            response.setErrorMessage("Failed to retrieve consumer groups : " + ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "describeConsumerGroup/{groupId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GroupResponse> describeConsumerGroup(@PathVariable("groupId") String groupId) {
        GroupResponse response = new GroupResponse();
        try {
            response.addConsumerGroupInfo(kafkaAdminService.describeConsumerGroup(groupId));
            response.setStatus(Constants.STATUS_SUCCESS);
        } catch (KafkaOperationException ex) {
            LOGGER.error("Exception occurred while fetching cluster nodes :", ex);
            response.setStatus(Constants.STATUS_FAILURE);
            response.setErrorMessage("Failed to retrieve node details : " + ex.getMessage());
        }
        return ResponseEntity.ok(response);
    }
}
