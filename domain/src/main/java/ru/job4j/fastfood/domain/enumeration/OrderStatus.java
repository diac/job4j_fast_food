package ru.job4j.fastfood.domain.enumeration;

/**
 * Перечисление статусов заказа
 */
public enum OrderStatus {

    CREATED,
    PROCESSING,
    COMPLETED,
    ON_HOLD,
    CANCELED
}