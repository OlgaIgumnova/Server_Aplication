package ru.geekbrains.example3sem3hometask.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.example3sem3hometask.domain.User;
import ru.geekbrains.example3sem3hometask.repository.UserRepository;

@Service

public class RegistrationService {

    public DataProcessingService getDataProcessingService() {
        return dataProcessingService;
    }

    @Autowired
    private DataProcessingService dataProcessingService;
    @Autowired
    UserService userService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    UserRepository userRepository;

    public User processRegistration(String userName, int userAge, String email){
        User newUser = userService.createUser(userName, userAge, email);
        userRepository.save(newUser);
        notificationService.sendNotification("Сохранение пользователя в БД");
        return newUser;
    }
}

