package tim.proyektil.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
    private static final String DB_URL = "jdbc:sqlite:db/db_user.db";

    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    private static String query;

    public static void connection(){
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static boolean validasiLogin(String userName, String password) {
        connection();
        String query = "SELECT user_name, password FROM user WHERE user_name=? AND password=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            try (ResultSet login = preparedStatement.executeQuery()){
                return login.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
