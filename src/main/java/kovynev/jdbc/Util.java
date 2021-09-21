package kovynev.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    final String DB_URL = "jdbc:mysql://localhost:3306/currencylayer";
    final String DB_LOGIN = "root";
    final String DB_PASSWORD = "root";

    public Connection connection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER).getDeclaredConstructor().newInstance();
            connection = DriverManager.getConnection(DB_URL, DB_LOGIN, DB_PASSWORD);
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException | SQLException e) {
            e.printStackTrace();
        }finally {

        }
        return connection;
    }
}
