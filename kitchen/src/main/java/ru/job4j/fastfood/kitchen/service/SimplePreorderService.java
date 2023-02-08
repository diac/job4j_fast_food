package ru.job4j.fastfood.kitchen.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.domain.model.Preorder;
import ru.job4j.fastfood.kitchen.repository.PreorderRepository;

/**
 * Сервис, реализующий логику, связанную с объектами Preorder
 */
@Service
@AllArgsConstructor
public class SimplePreorderService implements PreorderService {

    /**
     * Репозиторий для хранения объектов Preorder
     */
    private final PreorderRepository preorderRepository;

    /**
     * Принять заказ на кухне
     *
     * @param order Заказ
     * @return Задание для кухни
     */
    @Override
    public Preorder receiveOrder(Order order) {
        Preorder preorder = new Preorder(0, order.getId(), String.format("Новый заказ №%d", order.getId()));
        return preorderRepository.save(preorder);
    }
}