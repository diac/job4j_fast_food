package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных "Уведомление"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification {

    /**
     * Идентификатор уведомления
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Текст уведомления
     */
    private String text;

    /**
     * Заказ, к которому относится уведомление
     */
    private Order order;
}