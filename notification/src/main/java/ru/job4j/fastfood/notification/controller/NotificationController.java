package ru.job4j.fastfood.notification.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class NotificationController {

    /**
     * Тема Kafka для обмена сообщениями с сервисом notification
     */
    private static final String NOTIFICATION_TOPIC = "messengers";

    private final KafkaTemplate<Integer, String> kafkaTemplate;

    /**
     * @param input Входящее сообщение от брокера
     */
    @KafkaListener(topics = {NOTIFICATION_TOPIC})
    public void onApiCall(ConsumerRecord<Integer, String> input) {
        System.out.println(input);
    }
}