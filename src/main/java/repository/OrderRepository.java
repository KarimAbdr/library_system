package repository;

import connection.DB;
import entites.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderRepository {
    public void makeOrder(Order order){
        DB databaseConnection = new DB();
        Connection connection = null;
        try {
            connection = databaseConnection.getConnection();
            String sqlQuery = "INSERT INTO orders(userId ,bookId, quantity, totalprice) VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setInt(1,order.getUserId());
            preparedStatement.setInt(2, order.getBookId());
            preparedStatement.setInt(3,order.getQuantity());
            preparedStatement.setDouble(4, order.getTotalPrice());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
