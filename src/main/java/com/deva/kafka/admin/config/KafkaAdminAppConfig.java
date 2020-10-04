package com.deva.kafka.admin.config;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class KafkaAdminAppConfig {
    @Bean
    public KafkaAdminClient getAdminClient(){
        return (KafkaAdminClient) AdminClient.create(getClusterProps());
    }

    private Properties getClusterProps(){
        Properties properties = new Properties();
        properties.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:8100,localhost:8101,localhost:8102");
        return properties;
    }
}
