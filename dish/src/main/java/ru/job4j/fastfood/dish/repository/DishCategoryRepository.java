package ru.job4j.fastfood.dish.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.domain.model.DishCategory;

/**
 * Репозиторий для хранения объектов DishCategory
 */
@Repository
public interface DishCategoryRepository extends JpaRepository<DishCategory, Integer> {
}