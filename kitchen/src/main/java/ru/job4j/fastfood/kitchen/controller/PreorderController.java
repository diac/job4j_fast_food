package ru.job4j.fastfood.kitchen.controller;

import lombok.AllArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.kitchen.service.PreorderService;

/**
 * Контроллер, реализующий доступ к объектам модели Preorder
 */
@Controller
@AllArgsConstructor
public class PreorderController {

    /**
     * Тема Kafka для оповещения сервиса Kitchen о поступившем заказе
     */
    private static final String PREORDER_TOPIC = "preorder";

    /**
     * Сервис, реализующий логику, связанную с объектами Preorder
     */
    private final PreorderService preorderService;

    @KafkaListener(topics = {PREORDER_TOPIC})
    public void onApiCall(ConsumerRecord<Integer, Order> input) {
        preorderService.receiveOrder(input.value());
    }
}