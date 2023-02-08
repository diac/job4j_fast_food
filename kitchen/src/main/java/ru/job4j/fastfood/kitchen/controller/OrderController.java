package ru.job4j.fastfood.kitchen.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.job4j.fastfood.kitchen.service.OrderService;

/**
 * Контроллер, реализующий доступ к объектам модели Order через REST
 */
@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {

    /**
     * Сервис, реализующий логику, связанную с объектами Order
     */
    private final OrderService orderService;

    /**
     * Сообщить об успешном выполнении заказа
     *
     * @param orderId Идентификатор заказа
     * @return Тело ответа со статусом
     */
    @PostMapping("/notify_order_ready/{orderId}")
    public ResponseEntity<Void> notifyOrderReady(@PathVariable("orderId") int orderId) {
        orderService.notifyOrderReady(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Сообщить об отмене заказа
     *
     * @param orderId Идентификатор заказа
     * @return Тело ответа со статусом
     */
    @PostMapping("/notify_order_cancelled/{orderId}")
    public ResponseEntity<Void> notifyOrderCancelled(@PathVariable("orderId") int orderId) {
        orderService.notifyOrderCancelled(orderId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}