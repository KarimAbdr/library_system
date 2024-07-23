package services;

import entites.Book;
import entites.Order;
import repository.BookRepository;
import repository.OrderRepository;
import repository.UserRepository;
import entites.User;
import java.util.Scanner;

public class OrderService {
    public void makeOrder(){
        OrderRepository orderRepository = new OrderRepository();
        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();
        Book book = null;
        User user = null;
        Scanner scanner = new Scanner(System.in);
        System.out.println(userRepository.getAllUsers());
        System.out.println("Choose user by id");
        int userId = scanner.nextInt();
        user = userRepository.getUserById(userId);
        System.out.println(bookRepository.getAllBooks());
        System.out.println("Choose book by id");
        int bookId = scanner.nextInt();
        book = bookRepository.getBookById(bookId);
        System.out.println("How many quantity do u want?");
        int quantity = scanner.nextInt();
        double totalPrice = book.getPrice() * quantity;
        if(quantity<book.getQuantity() && totalPrice< user.getBalance()){
            bookRepository.decreasingQuantity(bookId,quantity);
            double balance =user.getBalance() - totalPrice ;
            userRepository.decreaseBalance(userId,balance);
        }else{
            System.out.println("Sorry, check quantity or users balance");
        }
        Order order = new Order(userId,bookId,quantity,totalPrice);
        orderRepository.makeOrder(order);
    }
}
