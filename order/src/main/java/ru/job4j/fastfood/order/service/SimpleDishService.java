package ru.job4j.fastfood.order.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.job4j.fastfood.domain.model.Dish;

import java.util.Optional;

/**
 * Сервис для работы с объектами модели Dish
 */
@Service
public class SimpleDishService implements DishService {

    /**
     * Объект RestTemplate, через который сервис взаимодействует с API модуля "Dish"
     */
    private final RestTemplate restTemplate;

    /**
     * URL API сервиса "Dish"
     */
    private final String dishApiUrl;

    public SimpleDishService(RestTemplate restTemplate, @Value("${dishApiUrl}") String dishApiUrl) {
        this.restTemplate = restTemplate;
        this.dishApiUrl = dishApiUrl;
    }

    @Override
    public Optional<Dish> findById(int id) {
        Dish dish = restTemplate.getForEntity(
                String.format("%s/%d", dishApiUrl, id),
                Dish.class
        ).getBody();
        return Optional.ofNullable(dish);
    }
}