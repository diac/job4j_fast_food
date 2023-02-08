package ru.job4j.fastfood.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.fastfood.domain.enumeration.OrderStatus;
import ru.job4j.fastfood.domain.model.Dish;
import ru.job4j.fastfood.domain.model.Order;
import ru.job4j.fastfood.order.dto.OrderPlacementDto;
import ru.job4j.fastfood.order.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Сервис, реализующий логику, связанную с объектами Order
 */
@Service
@AllArgsConstructor
public class SimpleOrderService implements OrderService {

    /**
     * Тема Kafka для обмена сообщениями с сервисом notification
     */
    private static final String NOTIFICATION_TOPIC = "messengers";

    /**
     * Тема Kafka для оповещения сервиса Kitchen о поступившем заказе
     */
    private static final String PREORDER_TOPIC = "preorder";

    /**
     * Репозиторий для хранения объектов Order
     */
    private final OrderRepository orderRepository;

    /**
     * Сервис для работы с объектами модели Dish
     */
    private final DishService dishService;

    /**
     * Бин KafkaTemplate, через который осуществляется взаимодействие между микросервисами
     */
    private final KafkaTemplate<Integer, Order> kafkaTemplate;

    /**
     * Разместить заказ, т.е. создать новый
     *
     * @param dto DTO с параметрами нового заказа
     * @return Созданный заказ
     */
    @Override
    public Order place(OrderPlacementDto dto) {
        Order order = orderRepository.save(
                new Order(0,
                        dto.orderItems(),
                        calculateSubtotal(dto),
                        calculateTotal(dto),
                        LocalDateTime.now(),
                        OrderStatus.CREATED
                )
        );
        kafkaTemplate.send(NOTIFICATION_TOPIC, order);
        kafkaTemplate.send(PREORDER_TOPIC, order);
        return order;
    }

    /**
     * Завершить заказ
     *
     * @param order Заказ, который необходимо завершить
     * @return Завершенный заказ
     */
    @Override
    public Order complete(Order order) {
        order.setStatus(OrderStatus.COMPLETED);
        return orderRepository.save(order);
    }

    /**
     * Перевести заказ в состояние "приостановлен"
     *
     * @param order Заказ, который необходимо перевести в состояние "приостановлен"
     * @return Приостановленный заказ
     */
    @Override
    public Order putOnHold(Order order) {
        order.setStatus(OrderStatus.ON_HOLD);
        return orderRepository.save(order);
    }

    /**
     * Отменить заказ
     *
     * @param order Заказ, который необходимо отменить
     * @return Отмененный заказ
     */
    @Override
    public Order cancel(Order order) {
        order.setStatus(OrderStatus.CANCELED);
        return orderRepository.save(order);
    }

    /**
     * Рассчитать подытог для нового заказа
     *
     * @param dto DTO с параметрами нового заказа
     * @return Подытог для нового заказа
     */
    private int calculateSubtotal(OrderPlacementDto dto) {
        return dto.orderItems().stream()
                .mapToInt(orderItem -> {
                    Optional<Dish> dish = dishService.findById(orderItem.getDishId());
                    return dish.map(value -> value.getPrice() * orderItem.getQuantity()).orElse(0);
                })
                .sum();
    }

    /**
     * Рассчитать итог для нового заказа
     *
     * @param dto DTO с параметрами нового заказа
     * @return Итог для нового заказа
     */
    private int calculateTotal(OrderPlacementDto dto) {
        return calculateSubtotal(dto);
    }
}