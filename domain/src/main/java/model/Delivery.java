package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Модель данных "Доставка"
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Delivery {

    /**
     * Идентификатор доставки
     */
    @EqualsAndHashCode.Include
    private int id;

    /**
     * Перечень заказов в доставке
     */
    private List<Order> orders;

    /**
     * Курьер, выполняющий доставку
     */
    private Courier courier;

    /**
     * Дата и время передачи заказов курьеру на доставку
     */
    private LocalDateTime dateTimeStarted;

    /**
     * Дата и время вручения заказов клиенту
     */
    private LocalDateTime dateTimeCompleted;

    /**
     * Статус доставки. false -- "В пути", true -- "Доставлено клиенту"
     */
    private boolean completed;
}