package ru.job4j.fastfood.admin.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import ru.job4j.fastfood.admin.service.DishService;
import ru.job4j.fastfood.domain.model.Dish;

import java.util.Optional;

/**
 * Контроллер, выполняющий операции с объектами модели Dish
 */
@Controller
@AllArgsConstructor
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("dishes", dishService.findAll());
        return "dishes/index";
    }

    @GetMapping("/new")
    public String create(Model model) {
        model.addAttribute("dish", new Dish());
        return "dishes/new";
    }

    @PostMapping("/store")
    public String store(@ModelAttribute("dish") Dish dish) {
        dishService.add(dish);
        return "redirect:/dishes";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model, RedirectAttributes redirectAttributes) {
        Optional<Dish> dish = dishService.findById(id);
        if (dish.isEmpty()) {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    String.format("Блюдо %d не существует", id)
            );
            return "redirect:/dishes";
        }
        model.addAttribute("dish", dish.get());
        return "dishes/edit";
    }

    @PutMapping("/{id}")
    public String put(
            @ModelAttribute("dish") Dish dish,
            @PathVariable("id") int id,
            RedirectAttributes redirectAttributes
    ) {
        if (dishService.update(id, dish)) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Данные блюда обновлены"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Не удалось обновить данные блюда"
            );
        }
        return "redirect:/dishes";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id, RedirectAttributes redirectAttributes) {
        if (dishService.delete(id)) {
            redirectAttributes.addFlashAttribute(
                    "successMessage",
                    "Блюда удалено"
            );
        } else {
            redirectAttributes.addFlashAttribute(
                    "errorMessage",
                    "Не удалось удалить блюдо"
            );
        }
        return "redirect:/dishes";
    }
}