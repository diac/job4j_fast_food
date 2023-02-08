package ru.job4j.fastfood.kitchen.service;

/**
 * Сервис, реализующий логику, связанную с объектами Order
 */
public interface OrderService {

    /**
     * Сообщить об успешном выполнении заказа
     *
     * @param orderId Идентификатор заказа
     */
    void notifyOrderReady(int orderId);

    /**
     * Сообщить об отмене заказа
     *
     * @param orderId Идентификатор заказа
     */
    void notifyOrderCancelled(int orderId);
}