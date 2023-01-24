package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * Модель данных "Блюдо"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Dish {

    /**
     * Идентификатор блюда
     */
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
    private DishCategory dishCategory;
}