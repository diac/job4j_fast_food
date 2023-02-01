package ru.job4j.fastfood.notification.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.notification.service.NotificationService;

@Controller
@AllArgsConstructor
public class NotificationController {

    /**
     * Тема Kafka для обмена сообщениями с сервисом notification
     */
    private static final String NOTIFICATION_TOPIC = "messengers";

    private final NotificationService notificationService;

    /**
     * @param input Входящее сообщение от брокера
     */
    @KafkaListener(topics = {NOTIFICATION_TOPIC})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        notificationService.registerNewOrder(input.value());
    }
}