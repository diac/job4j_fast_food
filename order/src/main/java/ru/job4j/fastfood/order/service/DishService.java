package ru.job4j.fastfood.order.service;

import ru.job4j.fastfood.domain.model.Dish;

import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
public interface DishService {

    /**
     * Найти блюдо по ID
     *
     * @param id Идентификатор блюда
     * @return Optional, содержащий найденный объект Dish. Optional.empty, если ничего не найдено
     */
    Optional<Dish> findById(int id);
}