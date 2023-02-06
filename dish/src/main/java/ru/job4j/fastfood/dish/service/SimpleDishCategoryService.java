package ru.job4j.fastfood.dish.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.dish.repository.DishCategoryRepository;
import ru.job4j.fastfood.domain.model.DishCategory;

import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами DishCategory
 */
@Service
@AllArgsConstructor
public class SimpleDishCategoryService implements DishCategoryService {

    /**
     * Репозиторий для хранения объектов DishCategory
     */
    private final DishCategoryRepository dishCategoryRepository;

    /**
     * Получить список всех категорий блюд
     *
     * @return Список всех категорий блюд
     */
    @Override
    public List<DishCategory> findAll() {
        return dishCategoryRepository.findAll();
    }

    /**
     * Найти категорию блюд по ID
     *
     * @param id Идентификатор категории блюд
     * @return Optional, содержаний найденный объект DishCategory. Optional.empty, если ничего не найдено
     */
    @Override
    public Optional<DishCategory> findById(int id) {
        return dishCategoryRepository.findById(id);
    }

    /**
     * Добавить новую категорию блюд в систему
     *
     * @param dishCategory Новая категория блюд
     */
    @Override
    public void add(DishCategory dishCategory) {
        dishCategoryRepository.save(dishCategory);
    }

    /**
     * Обновить данные категории блюд в системе
     *
     * @param dishCategory Категория блюд, данные которой необходимо обновить
     */
    @Override
    public void update(DishCategory dishCategory) {
        dishCategoryRepository.save(dishCategory);
    }

    /**
     * Удалить категорию блюд из системы
     *
     * @param dishCategory Категория блюд, которую необходимо удалить
     */
    @Override
    public void delete(DishCategory dishCategory) {
        dishCategoryRepository.delete(dishCategory);
    }
}