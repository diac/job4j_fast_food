package ru.job4j.fastfood.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.dish.repository.DishRepository;
import ru.job4j.fastfood.domain.model.Dish;
import ru.job4j.fastfood.domain.model.DishCategory;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    /**
     * Репозиторий для хранения объектов модели Dish
     */
    private final DishRepository dishRepository;

    /**
     * Получить список всех блюд
     *
     * @return Список всех блюд
     */
    @Override
    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    /**
     * Найти блюдо по ID
     *
     * @param id Идентификатор блюда
     * @return Optional, содержащий найденный объект Dish. Optional.empty, если ничего не найдено
     */
    @Override
    public Optional<Dish> findById(int id) {
        return dishRepository.findById(id);
    }

    /**
     * Добавить новое блюдо в систему
     *
     * @param dish Новое блюдо
     * @return Созданное блюдо
     */
    @Override
    public Dish add(Dish dish) {
        return dishRepository.save(dish);
    }

    /**
     * Обновить данные блюда в системе
     *
     * @param dish Блюдо, данные которого необходимо обновить
     * @return Обновленное блюдо
     */
    @Override
    public Dish update(Dish dish) {
        return dishRepository.save(dish);
    }

    /**
     * Удалить блюдо из системы
     *
     * @param dish Блюдо, которое необходимо удалить
     */
    @Override
    public void delete(Dish dish) {
        dishRepository.delete(dish);
    }

    /**
     * Найти все блюда по частичному совпадению наименования
     *
     * @param name Наименование блюда
     * @return Список найденных блюд
     */
    @Override
    public List<Dish> findAllByName(String name) {
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getName().contains(name))
                .toList();
    }

    /**
     * Найти все блюда для заданной категории
     *
     * @param dishCategory Категория блюд
     * @return Список всех блюд для заданной категории
     */
    @Override
    public List<Dish> findAllByDishCategory(DishCategory dishCategory) {
        return dishRepository.findAllByDishCategory(dishCategory);
    }

    /**
     * Найти все блюда в диапазоне цен
     *
     * @param priceFrom Нижняя граница диапазона цен
     * @param priceTo Верхняя граница диапазона цен
     * @return Список найденных блюд
     */
    @Override
    public List<Dish> findAllInPriceRange(int priceFrom, int priceTo) {
        return dishRepository.findAll().stream()
                .filter(dish -> dish.getPrice() >= priceFrom && dish.getPrice() <= priceTo)
                .toList();
    }
}