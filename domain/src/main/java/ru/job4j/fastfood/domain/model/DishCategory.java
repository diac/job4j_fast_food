package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных "Категория блюд"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class DishCategory {

    /**
     * Идентификатор категории блюд
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Наименование категории блюд
     */
    private String name;
}