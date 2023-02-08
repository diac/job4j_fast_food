package ru.job4j.fastfood.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.job4j.fastfood.domain.enumeration.OrderStatus;

/**
 * DTO для обмена сообщениями об изменении статуса заказа
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusChangeDto {

    /**
     * Идентификатор заказа
     */
    private int orderId;

    /**
     * Статус заказа
     */
    private OrderStatus orderStatus;
}