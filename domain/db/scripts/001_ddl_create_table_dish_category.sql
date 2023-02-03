CREATE TABLE dish_category (
    id SERIAL PRIMARY KEY NOT NULL,
    name VARCHAR UNIQUE NOT NULL
);

COMMENT ON TABLE dish_category IS 'Категория блюд';
COMMENT ON COLUMN dish_category.id IS 'Идентификатор категории блюд';
COMMENT ON COLUMN dish_category.name IS 'Наименование категории блюд';