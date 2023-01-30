package ru.job4j.fastfood.admin.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fastfood.domain.model.Dish;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
@Service
@AllArgsConstructor
public class SimpleDishService implements DishService {

    /**
     * Объект RestTemplate, через который сервис взаимодействует с API модуля "Dish"
     */
    private final RestTemplate restTemplate;

    /**
     * URL API сервиса "Dish"
     */
    @Value("${api-url}")
    private String apiUrl;

    /**
     * Получить все блюда
     *
     * @return Список блюд
     */
    @Override
    public List<Dish> findAll() {
        List<Dish> dishes = restTemplate.exchange(
                apiUrl,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Dish>>() {
                }
        ).getBody();
        return dishes != null ? dishes : Collections.emptyList();
    }

    /**
     * Найти блюдо по ID
     *
     * @param id Идентификатор блюда
     * @return Optional для найденного блюда. Optional.empty(), если ничего не найдено
     */
    @Override
    public Optional<Dish> findById(int id) {
        Dish dish = restTemplate.getForEntity(
                String.format("%s/%d", apiUrl, id),
                Dish.class
        ).getBody();
        return Optional.ofNullable(dish);
    }

    /**
     * Добавить новое блюдо
     *
     * @param dish Новое блюдо
     * @return Новое блюдо
     */
    @Override
    public Dish add(Dish dish) {
        return restTemplate.postForEntity(apiUrl, dish, Dish.class).getBody();
    }

    /**
     * Обновить данные блюда
     *
     * @param id Идентификатор блюда, которое необходимо обновить
     * @param dish Объект с новыми данными для блюда
     * @return true -- если данные блюда удалось обновить. Иначе -- false
     */
    @Override
    public boolean update(int id, Dish dish) {
        return restTemplate.exchange(
                String.format("%s/%d", apiUrl, id),
                HttpMethod.PUT,
                new HttpEntity<>(dish),
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }

    /**
     * Удалить блюдо
     *
     * @param id Идентификатор блюда, которое необходимо удалить
     * @return true -- если блюдо удалось удалить. Иначе -- false
     */
    @Override
    public boolean delete(int id) {
        return restTemplate.exchange(
                String.format("%s/%d", apiUrl, id),
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class
        ).getStatusCode() != HttpStatus.NOT_FOUND;
    }
}