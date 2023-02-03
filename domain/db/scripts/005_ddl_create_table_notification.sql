CREATE TABLE notification (
    id SERIAL PRIMARY KEY NOT NULL,
    text TEXT,
    order_id INTEGER NOT NULL REFERENCES "order"(id)
);

COMMENT ON TABLE notification IS 'Уведомление';
COMMENT ON COLUMN notification.id IS 'Идентификатор уведомления';
COMMENT ON COLUMN notification.text IS 'Текст уведомления';
COMMENT ON COLUMN notification.order_id IS 'Идентификатор заказа (FK)';