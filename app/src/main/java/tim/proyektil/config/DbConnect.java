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

    public static void connection() {
        try {
            connection = DriverManager.getConnection(DB_URL);
            System.out.println("Database Connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean registerUser(String username, String fullname, String email, String password) {
        connection();
        String query = "INSERT INTO user (user_name, full_name, email, password) VALUES (?, ?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, fullname);
            preparedStatement.setString(3, email);
            preparedStatement.setString(4, password);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean validasiLogin(String userName, String password) {
        connection();
        String query = "SELECT user_name, password FROM user WHERE user_name=? AND password=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            try (var login = preparedStatement.executeQuery()) {
                return login.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String[] getUserDetails(String username) {
        connection();
        String query = "SELECT full_name, email FROM user WHERE user_name=?";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new String[]{resultSet.getString("full_name"), resultSet.getString("email")};
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
