package services;

import entites.User;
import repository.UserRepository;

import java.util.Scanner;

public class UserService {
    public void addUser(){
        UserRepository userRepository = new UserRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write your name");
        String name = scanner.next();
        System.out.println("Write your balance");
        double balance = scanner.nextDouble();
        User user = new User(name,balance);
        userRepository.addUser(user);
    }
    public void getAllUsers(){
        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.getAllUsers());

    }
    public void deleteUser(){
        UserRepository userRepository = new UserRepository();
        System.out.println(userRepository.getAllUsers());
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose user whom u would like to delete");
        int userId = scanner.nextInt();
        userRepository.deleteUser(userId);
    }
}
