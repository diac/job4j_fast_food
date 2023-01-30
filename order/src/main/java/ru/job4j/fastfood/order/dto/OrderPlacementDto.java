package ru.job4j.fastfood.order.dto;

import ru.job4j.fastfood.domain.model.Customer;
import ru.job4j.fastfood.domain.model.OrderItem;

import java.util.List;

/**
 * DTO с параметрами нового заказа
 *
 * @param orderItems Перечень позиций в заказе
 * @param customer   Заказчик
 */
public record OrderPlacementDto(List<OrderItem> orderItems, Customer customer) {

}