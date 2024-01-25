package com.project.template.services.impl;

import com.project.template.events.Event;
import com.project.template.events.EventType;
import com.project.template.events.UserRegisteredEvent;
import com.project.template.services.UserEventService;
import com.project.template.utils.JsonUtils;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class UserEventServiceImpl implements UserEventService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public UserEventServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void publishUserEmail(String email) {

        UserRegisteredEvent userRegisteredEvent = new UserRegisteredEvent();

        userRegisteredEvent.setId(UUID.randomUUID().toString());
        userRegisteredEvent.setDate(new Date());
        userRegisteredEvent.setType(EventType.CREATED);

        userRegisteredEvent.setData(email);

        this.kafkaTemplate.send("emails-topic", JsonUtils.toJson(userRegisteredEvent));
    }
}
