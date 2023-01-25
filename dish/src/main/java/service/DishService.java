package service;

import ru.job4j.fastfood.domain.model.Dish;
import ru.job4j.fastfood.domain.model.DishCategory;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
public interface DishService {

    /**
     * Получить список всех блюд
     *
     * @return Список всех блюд
     */
    List<Dish> findAll();

    /**
     * Найти блюдо по ID
     *
     * @param id Идентификатор блюда
     * @return Optional, содержащий найденный объект Dish. Optional.empty, если ничего не найдено
     */
    Optional<Dish> findById(int id);

    /**
     * Добавить новое блюдо в систему
     *
     * @param dish Новое блюдо
     */
    void add(Dish dish);

    /**
     * Обновить данные блюда в системе
     *
     * @param dish Блюдо, данные которого необходимо обновить
     */
    void update(Dish dish);

    /**
     * Удалить блюдо из системы
     *
     * @param dish Блюдо, которое необходимо удалить
     */
    void delete(Dish dish);

    /**
     * Найти все блюда по частичному совпадению наименования
     *
     * @param name Наименование блюда
     * @return Список найденных блюд
     */
    List<Dish> findAllByName(String name);

    /**
     * Найти все блюда для заданной категории
     *
     * @param dishCategory Категория блюд
     * @return Список всех блюд для заданной категории
     */
    List<Dish> findAllByDishCategory(DishCategory dishCategory);

    /**
     * Найти все блюда в диапазоне цен
     *
     * @param priceFrom Нижняя граница диапазона цен
     * @param priceTo Верхняя граница диапазона цен
     * @return Список найденных блюд
     */
    List<Dish> findAllInPriceRange(int priceFrom, int priceTo);
}