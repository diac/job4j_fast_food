CREATE TABLE "order" (
    id SERIAL PRIMARY KEY NOT NULL,
    subtotal INTEGER NOT NULL,
    total INTEGER NOT NULL,
    date_time TIMESTAMP NOT NULL,
    order_status VARCHAR NOT NULL
);

COMMENT ON TABLE "order" IS 'Заказ';
COMMENT ON COLUMN "order".id IS 'Идентификатор заказа';
COMMENT ON COLUMN "order".subtotal IS 'Подытог (промежуточная итоговая стоимость заказа)';
COMMENT ON COLUMN "order".total IS 'Итоговая стоимость заказа';
COMMENT ON COLUMN "order".date_time IS 'Дата и время регистрации заказа в системе';
COMMENT ON COLUMN "order".order_status IS 'Статус заказа';