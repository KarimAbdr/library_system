package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static Connection getConnection() throws RuntimeException {
        String url = "jdbc:postgresql://localhost:5432/bookShop";
        String user = "postgres";
        String password = "123";
        Connection connection=null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("PostgreSQL JDBC driver not found");
        } catch (SQLException e) {
            System.err.println("Database connection failed");
            e.printStackTrace();
        }
        return connection;
    }


}
