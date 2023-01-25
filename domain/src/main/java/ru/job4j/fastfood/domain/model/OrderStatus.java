package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных "Статус заказа"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderStatus {

    /**
     * Идентификатор статуса заказа
     */
    private int id;

    /**
     * Имя статуса заказа
     */
    private String name;
}