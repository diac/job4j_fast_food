package ru.job4j.fastfood.dish.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.fastfood.dish.service.DishService;
import ru.job4j.fastfood.domain.model.Dish;

import javax.validation.Valid;
import java.util.List;

/**
 * Контроллер, реализующий доступ к объектам модели Dish через REST
 */
@RestController
@AllArgsConstructor
public class DishController {

    /**
     * Сервис для работы с объектами модели Dish
     */
    private final DishService dishService;

    /**
     * Получить все блюда
     *
     * @return Список блюд
     */
    @GetMapping("/")
    public ResponseEntity<List<Dish>> findALl() {
        return new ResponseEntity<>(
                dishService.findAll(),
                HttpStatus.OK
        );
    }

    /**
     * Добавить новое блюдо
     *
     * @param dish Новое блюдо
     * @return Созданное блюдо
     */
    @PostMapping("/")
    public ResponseEntity<Dish> post(@RequestBody @Valid Dish dish) {
        return new ResponseEntity<>(
                dishService.add(dish),
                HttpStatus.CREATED
        );
    }

    /**
     * Получить блюдо по ID
     *
     * @param id идентификатор блюда
     * @return Найденное блюдо
     */
    @GetMapping("/{id}")
    public ResponseEntity<Dish> getById(@PathVariable int id) {
        return dishService.findById(id).map(value -> new ResponseEntity<>(
                value,
                HttpStatus.FOUND
        )).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /**
     * Обновить данные блюда
     *
     * @param dish Объект, с новыми данными блюда
     * @return Обновленное блюдо
     */
    @PutMapping("/")
    public ResponseEntity<Dish> put(@RequestBody @Valid Dish dish) {
        return new ResponseEntity<>(
                dishService.update(dish),
                HttpStatus.OK
        );
    }

    /**
     * Удалить блюдо
     *
     * @param id Идентификатор блюда
     * @return Тело ответа со статусом
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        Dish dish = new Dish();
        dish.setId(id);
        dishService.delete(dish);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}