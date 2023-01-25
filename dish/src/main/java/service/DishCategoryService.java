package service;

import ru.job4j.fastfood.domain.model.DishCategory;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами DishCategory
 */
public interface DishCategoryService {

    /**
     * Получить список всех категорий блюд
     *
     * @return Список всех категорий блюд
     */
    List<DishCategory> findAll();

    /**
     * Найти категорию блюд по ID
     *
     * @param id Идентификатор категории блюд
     * @return Optional, содержаний найденный объект DishCategory. Optional.empty, если ничего не найдено
     */
    Optional<DishCategory> findById(int id);

    /**
     * Добавить новую категорию блюд в систему
     *
     * @param dishCategory Новая категория блюд
     */
    void add(DishCategory dishCategory);

    /**
     * Обновить данные категории блюд в системе
     *
     * @param dishCategory Категория блюд, данные которой необходимо обновить
     */
    void update(DishCategory dishCategory);

    /**
     * Удалить категорию блюд из системы
     *
     * @param dishCategory Категория блюд, которую необходимо удалить
     */
    void delete(DishCategory dishCategory);
}