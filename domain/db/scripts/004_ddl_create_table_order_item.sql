CREATE TABLE order_item (
    id SERIAL PRIMARY KEY NOT NULL,
    dish_id INTEGER NOT NULL REFERENCES dish(id),
    quantity INTEGER NOT NULL,
    price INTEGER NOT NULL,
    order_id INTEGER NOT NULL REFERENCES "order"(id)
);

COMMENT ON TABLE order_item IS 'Позиция заказа';
COMMENT ON COLUMN order_item.dish_id IS 'Идентификатор блюда (FK)';
COMMENT ON COLUMN order_item.quantity IS 'Количество одинаковых блюд в позиции';
COMMENT ON COLUMN order_item.price IS 'Цена позиции (цена блюда, умноженная на количество)';
COMMENT ON COLUMN order_item.order_id IS 'Идентификатор заказа (FK)';