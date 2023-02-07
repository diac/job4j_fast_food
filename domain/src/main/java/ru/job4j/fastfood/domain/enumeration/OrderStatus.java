package ru.job4j.fastfood.domain.enumeration;

/**
 * Перечисление статусов заказа
 */
public enum OrderStatus {

    CREATED,
    PROCESSING,
    READY,
    COMPLETED,
    ON_HOLD,
    CANCELED
}