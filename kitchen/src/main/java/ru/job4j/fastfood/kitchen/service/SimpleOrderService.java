package ru.job4j.fastfood.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.domain.dto.OrderStatusChangeDto;
import ru.job4j.fastfood.domain.enumeration.OrderStatus;

/**
 * Сервис, реализующий логику, связанную с объектами Order
 */
@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    /**
     * Тема Kafka для обмена сообщениями об изменении статуса заказа с кухней
     */
    private static final String COOKED_ORDER_TOPIC = "cooked_order";

    /**
     * Бин KafkaTemplate, через который осуществляется взаимодействие между микросервисами
     */
    private final KafkaTemplate<Integer, OrderStatusChangeDto> kafkaTemplate;

    /**
     * Сообщить об успешном выполнении заказа
     *
     * @param orderId Идентификатор заказа
     */
    @Override
    public void notifyOrderReady(int orderId) {
        kafkaTemplate.send(
                COOKED_ORDER_TOPIC,
                new OrderStatusChangeDto(orderId, OrderStatus.READY)
        );
    }

    /**
     * Сообщить об отмене заказа
     *
     * @param orderId Идентификатор заказа
     */
    @Override
    public void notifyOrderCancelled(int orderId) {
        kafkaTemplate.send(
                COOKED_ORDER_TOPIC,
                new OrderStatusChangeDto(orderId, OrderStatus.CANCELED)
        );
    }
}