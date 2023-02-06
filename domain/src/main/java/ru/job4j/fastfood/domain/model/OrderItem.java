package ru.job4j.fastfood.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Модель данных "Позиция заказа"
 */
@Entity
@Table(name = "order_item")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrderItem {

    /**
     * Идентификатор позиции заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Блюдо
     */
    @Column(name = "dish_id")
    private int dishId;

    /**
     * Количество одинаковых блюд в позиции
     */
    private int quantity;

    /**
     * Цена позиции (цена блюда, умноженная на количество)
     */
    private int price;

    /**
     * Заказ, в котором находится позиция
     */
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}