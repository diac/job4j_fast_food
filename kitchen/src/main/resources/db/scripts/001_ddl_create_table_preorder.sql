CREATE TABLE preorder (
    id SERIAL PRIMARY KEY NOT NULL,
    order_id INT UNIQUE NOT NULL,
    notes TEXT
);

COMMENT ON TABLE preorder IS 'Задание для кухни на выполнение заказа';
COMMENT ON COLUMN preorder.id IS 'Идентификатор задания для кухни';
COMMENT ON COLUMN preorder.order_id IS 'Идентификатор заказа';
COMMENT ON COLUMN preorder.notes IS 'Примечания';