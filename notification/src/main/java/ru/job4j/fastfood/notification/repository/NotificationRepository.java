package ru.job4j.fastfood.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.job4j.fastfood.domain.model.Notification;

/**
 * Репозиторий для хранения объектов Notification
 */
@Repository
public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}