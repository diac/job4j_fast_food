package ru.job4j.fastfood.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.domain.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}