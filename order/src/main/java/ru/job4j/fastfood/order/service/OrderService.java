package ru.job4j.fastfood.order.service;

import ru.job4j.fastfood.domain.dto.OrderStatusChangeDto;
import ru.job4j.fastfood.domain.enumeration.OrderStatus;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.order.dto.OrderPlacementDto;

/**
 * Сервис, реализующий логику, связанную с объектами Order
 */
public interface OrderService {

    /**
     * Разместить заказ, т.е. создать новый
     *
     * @param dto DTO с параметрами нового заказа
     * @return Созданный заказ
     */
    Order place(OrderPlacementDto dto);

    /**
     * Завершить заказ
     *
     * @param order Заказ, который необходимо завершить
     * @return Завершенный заказ
     */
    Order complete(Order order);

    /**
     * Перевести заказ в состояние "приостановлен"
     *
     * @param order Заказ, который необходимо перевести в состояние "приостановлен"
     * @return Приостановленный заказ
     */
    Order putOnHold(Order order);

    /**
     * Отменить заказ
     *
     * @param order Заказ, который необходимо отменить
     * @return Отмененный заказ
     */
    Order cancel(Order order);

    /**
     * Обновить статус заказа по ID
     *
     * @param id Идентификатор заказа
     * @param orderStatus Новый статус заказа
     */
    void updateStatus(int id, OrderStatus orderStatus);

    /**
     * Обновить статус заказа
     *
     * @param dto DTO с параметрами изменения статуса
     */
    void updateStatus(OrderStatusChangeDto dto);
}