package ru.geekbrains.example3sem3hometask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import ru.geekbrains.example3sem3hometask.domain.User;
import ru.geekbrains.example3sem3hometask.services.DataProcessingService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks() {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge() {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }


    @GetMapping("/filter/{age}")
    public List<User> filterUsersByAge(@PathVariable("age") int age){
        List<User> users = service.getRepository().getUsers();
        return service.filterUsersByAge(users, age);
    }

    /**
     * Получение среднего возраста пользователей.
     * @return JSON ответ со средним возрастом.
     */
    @GetMapping("/calc")
    public double calculateAverageAge(){
        List<User> users = service.getRepository().getUsers();
        return service.calculateAverageAge(users);
    }
}
