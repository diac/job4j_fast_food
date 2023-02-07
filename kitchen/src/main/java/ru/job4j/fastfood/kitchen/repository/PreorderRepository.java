package ru.job4j.fastfood.kitchen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.domain.model.Preorder;

/**
 * Репозиторий для хранения объектов Preorder
 */
@Repository
public interface PreorderRepository extends JpaRepository<Preorder, Integer> {
}