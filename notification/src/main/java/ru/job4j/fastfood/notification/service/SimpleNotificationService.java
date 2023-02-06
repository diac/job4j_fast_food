package ru.job4j.fastfood.notification.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.domain.model.Notification;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.notification.repository.NotificationRepository;

/**
 * Сервис, реализующий логику, связанную с объектами Notification
 */
@Service
@AllArgsConstructor
public class SimpleNotificationService implements NotificationService {

    private final NotificationRepository notificationRepository;

    /**
     * Добавить новое уведомление
     *
     * @param notification Уведомление
     * @return Сохраненное уведомление
     */
    @Override
    public Notification add(Notification notification) {
        return notificationRepository.save(notification);
    }

    /**
     * Добавить уведомление о новом заказе
     *
     * @param order Новый заказ
     * @return Сохраненное уведомление
     */
    @Override
    public Notification registerNewOrder(Order order) {
        Notification notification = new Notification(
                0,
                String.format("Новый заказ №%d", order.getId()),
                order.getId()
        );
        return notificationRepository.save(notification);
    }
}