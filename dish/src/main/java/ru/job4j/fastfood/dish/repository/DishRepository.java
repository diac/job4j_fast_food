package ru.job4j.fastfood.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.domain.model.Dish;
import ru.job4j.fastfood.domain.model.DishCategory;

import java.util.List;

/**
 * Репозиторий для хранения объектов модели Dish
 */
@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {

    List<Dish> findAllByDishCategory(DishCategory dishCategory);
}