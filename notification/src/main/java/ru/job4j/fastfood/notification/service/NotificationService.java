package ru.job4j.fastfood.notification.service;

import ru.job4j.fastfood.domain.model.Notification;
import ru.job4j.fastfood.domain.model.Order;

/**
 * Сервис, реализующий логику, связанную с объектами Notification
 */
public interface NotificationService {

    /**
     * Добавить новое уведомление
     *
     * @param notification Уведомление
     * @return Сохраненное уведомление
     */
    Notification add(Notification notification);

    /**
     * Добавить уведомление о новом заказе
     *
     * @param order Новый заказ
     * @return Сохраненное уведомление
     */
    Notification registerNewOrder(Order order);
}