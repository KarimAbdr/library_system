package repository;

import connection.DB;
import entites.Book;
import entites.User;


import java.sql.*;
import java.util.ArrayList;

public class UserRepository {
    public void addUser(User user) {
        DB databaseConnection = new DB();
        Connection connection = null;
        try{
            connection = databaseConnection.getConnection();
            String sqlQuery = "INSERT INTO users( name, balance) VALUES(?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setDouble(2,user.getBalance());
            preparedStatement.execute();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ArrayList<User> getAllUsers() {
        DB databaseConnection = new DB();
        Connection connection = null;
        try {
            connection = databaseConnection.getConnection();
            String sqlQuery = "SELECT * from users";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            ArrayList<User> users = new ArrayList<>();
            while (resultSet.next()) {

                User newUser = new User(resultSet.getInt("userid"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance"));
                users.add(newUser);
            }return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void decreaseBalance(int userId, double balance){
        DB databaseConnection = new DB();
        Connection connection = null;
        try{
            connection = databaseConnection.getConnection();
            String sqlQuery = "update users set balance= ? where userId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setDouble(1 , balance);
            preparedStatement.setInt(2, userId);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public User getUserById(int userId){
        Connection connection = null;
        DB databaseConnection = new DB();
        User user = null;
        try {
            connection = databaseConnection.getConnection();
            String sqlQuery = "select * from users where userId=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user=new User(resultSet.getInt("userId"),
                        resultSet.getString("name"),
                        resultSet.getDouble("balance"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
    public boolean deleteUser(int userId){
        Connection connection = null;
        DB databseConnection = new DB();
        try{
            connection = databseConnection.getConnection();
            String sqlQuery = "delete from users where userId = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }return false;
    }

}
