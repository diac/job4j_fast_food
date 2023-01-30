package ru.job4j.fastfood.admin.service;

import ru.job4j.fastfood.domain.model.Dish;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
public interface DishService {

    /**
     * Получить все блюда
     *
     * @return Список блюд
     */
    List<Dish> findAll();

    /**
     * Найти блюдо по ID
     *
     * @param id Идентификатор блюда
     * @return Optional для найденного блюда. Optional.empty(), если ничего не найдено
     */
    Optional<Dish> findById(int id);

    /**
     * Добавить новое блюдо
     *
     * @param dish Новое блюдо
     * @return Новое блюдо
     */
    Dish add(Dish dish);

    /**
     * Обновить данные блюда
     *
     * @param id Идентификатор блюда, которое необходимо обновить
     * @param dish Объект с новыми данными для блюда
     * @return true -- если данные блюда удалось обновить. Иначе -- false
     */
    boolean update(int id, Dish dish);

    /**
     * Удалить блюдо
     *
     * @param id Идентификатор блюда, которое необходимо удалить
     * @return true -- если блюдо удалось удалить. Иначе -- false
     */
    boolean delete(int id);
}