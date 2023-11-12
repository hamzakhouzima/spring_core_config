package com.test;

import com.app.model.User;
import com.app.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println("haha");
        UserService userService = applicationContext.getBean(UserService.class);

        // Create a new user
        User newUser = new User("hamza khouzima", 22);
        newUser.setId(1L);

        // Save the user
        User savedUser = userService.saveUser(newUser);
        if (savedUser != null) {
            System.out.println("User saved successfully: " + savedUser);
        } else {
            System.out.println("Error: Unable to save user.");
        }

        // Find the user by ID
        User existingUser = userService.findUserById(1L);

        if (existingUser != null) {
            existingUser.setName("Hamza");
            System.out.println("User exists");

            // Update the user
            User updatedUser = userService.updateUser(existingUser);

            if (updatedUser != null)
                System.out.println("User updated successfully: " + updatedUser);
            else
                System.out.println("Failed to update the user.");
        } else
            System.out.println("User does not exist");
    }
}
