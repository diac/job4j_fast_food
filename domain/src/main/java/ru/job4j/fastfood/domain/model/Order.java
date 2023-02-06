package ru.job4j.fastfood.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import ru.job4j.fastfood.domain.enumeration.OrderStatus;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Модель данных "Заказ"
 */
@Entity
@Table(name = "order")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    /**
     * Идентификатор заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Перечень позиций в заказе
     */
    @OneToMany
    @JoinColumn(name = "order_id")
    private List<OrderItem> orderItems;

    /**
     * Подытог (промежуточная итоговая стоимость заказа)
     */
    private int subtotal;

    /**
     * Итоговая стоимость заказа
     */
    private int total;

    /**
     * Дата и время регистрации заказа в системе
     */
    private LocalDateTime dateTime;

    /**
     * Статус заказа
     */
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}