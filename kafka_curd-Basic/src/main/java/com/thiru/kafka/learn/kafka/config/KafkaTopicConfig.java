package com.thiru.kafka.learn.kafka.config;

 
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic topicAdd() {
        return TopicBuilder.name("topic.employee.add")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    public NewTopic topicUpdate() {
        return TopicBuilder.name("topic.employee.update")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
