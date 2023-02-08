package ru.job4j.fastfood.kitchen.service;

import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.domain.model.Preorder;

/**
 * Сервис, реализующий логику, связанную с объектами Preorder
 */
public interface PreorderService {

    /**
     * Принять заказ на кухне
     *
     * @param order Заказ
     * @return Задание для кухни
     */
    Preorder receiveOrder(Order order);
}