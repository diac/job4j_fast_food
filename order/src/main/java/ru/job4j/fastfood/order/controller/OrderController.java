package ru.job4j.fastfood.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.order.dto.OrderPlacementDto;
import ru.job4j.fastfood.order.service.OrderService;

import javax.validation.Valid;

/**
 * Контроллер, реализующий доступ к объектам модели Order через REST
 */
@RestController
@AllArgsConstructor
public class OrderController {

    /**
     * Сервис, реализующий логику работы с объектами Order
     */
    private final OrderService orderService;

    /**
     * Добавить новый заказ
     *
     * @param dto DTO с параметрами нового заказа
     * @return Созданный и сохраненный в БД заказ
     */
    @PostMapping("/order/place")
    public ResponseEntity<Order> place(@RequestBody @Valid OrderPlacementDto dto) {
        Order order = orderService.place(dto);
        return new ResponseEntity<>(
                order,
                HttpStatus.CREATED
        );
    }

    /**
     * Завершить заказ (отметить как успешно выполненный)
     *
     * @param id Идентификатор заказа, который необходимо завершить
     * @return Завершенный заказ
     */
    @PatchMapping("/order/{id}/complete")
    public ResponseEntity<Order> complete(@PathVariable("id") int id) {
        Order order = new Order();
        order.setId(id);
        return new ResponseEntity<>(
                orderService.complete(order),
                HttpStatus.OK
        );
    }

    /**
     * Перевести заказ в состояние "приостановлен"
     *
     * @param id Идентификатор заказа, который необходимо приостановить
     * @return Приостановленный заказ
     */
    @PatchMapping("/order/{id}/putOnHold")
    public ResponseEntity<Order> putOnHold(@PathVariable("id") int id) {
        Order order = new Order();
        order.setId(id);
        return new ResponseEntity<>(
                orderService.putOnHold(order),
                HttpStatus.OK
        );
    }

    /**
     * Отменить заказ
     *
     * @param id Идентификатор заказа, который необходимо отменить
     * @return Отмененный заказ
     */
    @PatchMapping("/order/{id}/cancel")
    public ResponseEntity<Order> cancel(@PathVariable("id") int id) {
        Order order = new Order();
        order.setId(id);
        return new ResponseEntity<>(
                orderService.cancel(order),
                HttpStatus.OK
        );
    }
}