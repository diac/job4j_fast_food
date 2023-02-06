CREATE TABLE dish (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR UNIQUE NOT NULL,
    price INTEGER NOT NULL,
    dish_category_id INTEGER NOT NULL references dish_category(id)
);

COMMENT ON TABLE dish IS 'Блюдо';
COMMENT ON COLUMN dish.id IS 'Идентификатор блюда';
COMMENT ON COLUMN dish.price IS 'Название блюда';
COMMENT ON COLUMN dish.dish_category_id IS 'Идентификатор категории блюда (FK)';