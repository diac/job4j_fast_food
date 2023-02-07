package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Модель данных "Задание для кухни"
 */
@Entity
@Table(name = "preorder")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Preorder {

    /**
     * Идентификатор задания
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Идентификатор заказа
     */
    @Column(name = "order_id")
    private int orderId;

    /**
     * Примечания
     */
    private String notes;
}