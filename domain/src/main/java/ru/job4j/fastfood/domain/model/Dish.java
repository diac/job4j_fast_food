package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Модель данных "Блюдо"
 */
@Entity
@Table(name = "dish")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {

    /**
     * Идентификатор блюда
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Название блюда
     */
    private String name;

    /**
     * Стоимость блюда
     */
    private int price;

    /**
     * Категория блюда
     */
    @ManyToOne
    @JoinColumn(name = "dish_category_id")
    private DishCategory dishCategory;
}