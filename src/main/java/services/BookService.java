package services;

import entites.Book;
import repository.BookRepository;

import java.util.Scanner;

public class BookService {
    public void addBook(){
        BookRepository bookRepository = new BookRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write book name");
        String name = scanner.next();
        System.out.println("Write a year");
        int year = scanner.nextInt();
        System.out.println("Write author");
        String author = scanner.next();
        System.out.println("Write a price");
        double price = scanner.nextDouble();
        System.out.println("Write a quantity");
        int quantity = scanner.nextInt();
        Book book = new Book(name,year, author,price,quantity);
        bookRepository.addBook(book);

    }
    public void getAllBooks(){
        BookRepository bookRepository = new BookRepository();
        System.out.println(bookRepository.getAllBooks());
    }
    public   void deleteBook(){
        BookRepository bookRepository = new BookRepository();
        System.out.println(bookRepository.getAllBooks());
        System.out.println("Choose book by id");
        Scanner scanner = new Scanner(System.in);
        int bookId = scanner.nextInt();
        bookRepository.deleteBook(bookId);
    }

}
