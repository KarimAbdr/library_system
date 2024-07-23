package repository;

import connection.DB;
import entites.Book;
import entites.User;

import java.sql.*;
import java.util.ArrayList;

public class BookRepository {
    public void addBook(Book book) {
        DB databaseConnection = new DB();
        Connection connection = null;
        try{
            connection = databaseConnection.getConnection();
            String sqlQuery = "INSERT INTO books(name,year,author,price,quantity) VALUES(?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1,book.getName());
            preparedStatement.setInt(2 ,book.getYear());
            preparedStatement.setString(3, book.getAuthor());
            preparedStatement.setDouble(4,book.getPrice());
            preparedStatement.setInt(5,book.getQuantity());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<Book> getAllBooks(){
        DB databaseConnection = new DB();
        Connection connection = null;
        try {
            connection = databaseConnection.getConnection();
            String sqlQuery = "SELECT * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<Book> books = new ArrayList<>();
            while (resultSet.next()) {

                Book newBook = new Book(resultSet.getInt("bookid"),
                        resultSet.getString("name"),
                        resultSet.getInt("year"),
                        resultSet.getString("author"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"));
                books.add(newBook);
            }return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void decreasingQuantity(int bookId, int quantity){
        DB databaseConnection = new DB();
        Connection connection = null;
        try{
            connection = databaseConnection.getConnection();
            String sqlQuery = "update  books set quantity=quantity - ? where bookId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1 , quantity);
            preparedStatement.setInt(2, bookId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Book getBookById(int bookId){
        Connection connection = null;
        DB databaseConnection = new DB();
        Book book = null;
        try {
            connection = databaseConnection.getConnection();
            String sqlQuery = "select * from books where bookId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, bookId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                book=new Book(resultSet.getInt("bookId"),
                        resultSet.getString("name"),
                        resultSet.getInt("year"),
                        resultSet.getString("author"),
                        resultSet.getDouble("price"),
                        resultSet.getInt("quantity"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }
    public boolean deleteBook(int bookId){
        Connection connection = null;
        DB databseConnection = new DB();
        try{
            connection = databseConnection.getConnection();
            String sqlQuery = "delete from books where bookId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,bookId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return false;
    }
    }



