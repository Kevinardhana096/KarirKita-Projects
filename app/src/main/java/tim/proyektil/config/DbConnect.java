package tim.proyektil.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConnect {
    private static final String DB_URL = "jdbc:sqlite:db/db_user.db";

    private static Connection connection;

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
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
        String query = "SELECT full_name, email, education, work_experience, skills FROM user WHERE user_name=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
    
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new String[]{
                        resultSet.getString("full_name"),
                        resultSet.getString("email"),
                        resultSet.getString("education"),
                        resultSet.getString("work_experience"),
                        resultSet.getString("skills")
                    };
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean updateUserDetails(String username, String education, String workExperience, String skills) {
        connection();
        String query = "UPDATE user SET education = ?, work_experience = ?, skills = ? WHERE user_name = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, education);
            preparedStatement.setString(2, workExperience);
            preparedStatement.setString(3, skills);
            preparedStatement.setString(4, username);
            int rowsUpdated = preparedStatement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

