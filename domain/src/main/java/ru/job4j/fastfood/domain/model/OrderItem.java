package ru.job4j.fastfood.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных "Позиция заказа"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {

    /**
     * Идентификатор позиции заказа
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Блюдо
     */
    private Dish dish;

    /**
     * Количество одинаковых блюд в позиции
     */
    private int quantity;

    /**
     * Цена позиции (цена блюда, умноженная на количество)
     */
    private int price;
}