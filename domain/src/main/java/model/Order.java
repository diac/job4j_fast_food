package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Модель данных "Заказ"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Order {

    /**
     * Идентификатор заказа
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Перечень позиций в заказе
     */
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
}