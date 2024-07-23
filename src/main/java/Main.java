

import repository.OrderRepository;
import services.BookService;
import services.OrderService;
import services.UserService;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        BookService bookService = new BookService();
        OrderService orderService = new OrderService();
        while (true) {
            start();
            int number = scanner.nextInt();
            switch (number) {
                case 1:
                    userService.addUser();
                    break;
                case 2:
                    bookService.addBook();
                    break;
                case 3:
                    userService.getAllUsers();
                    break;
                case 4:
                    bookService.getAllBooks();
                    break;
                case 5:
                    orderService.makeOrder();
                    break;
                case 6:
                    bookService.deleteBook();
                    break;
                case 7:
                    userService.deleteUser();
            }
        }
    }
    public static void start(){
        System.out.println("1-add new user");
        System.out.println("2-add book");
        System.out.println("3-get users");
        System.out.println("4-get books");
        System.out.println("5-make order");
        System.out.println("6-delete book");
        System.out.println("7-delete user");
    }
}