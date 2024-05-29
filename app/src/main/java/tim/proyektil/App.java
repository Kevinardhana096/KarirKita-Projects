package tim.proyektil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tim.proyektil.config.DbConnect;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KarirKita");

        Image icon = new Image(getClass().getResourceAsStream("/Picture2.png")); // Replace with your icon file
        primaryStage.getIcons().add(icon);

        // Create an instance of the login and register layout
        LoginLayout loginLayout = new LoginLayout();
        RegisterLayout registerLayout = new RegisterLayout();
        MainLayout mainLayout = new MainLayout(); // Instantiate MainLayout

        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);
        Scene mainScene = new Scene(mainLayout.getMainLayout(), 865, 505); // Create scene for MainLayout

        // Switch to register scene when register button is clicked
        loginLayout.getRegisterButton().setOnAction(event -> primaryStage.setScene(registerScene));

        // Switch to login scene when login button in register layout is clicked
        registerLayout.getLoginButton().setOnAction(event -> primaryStage.setScene(loginScene));

        // Set scene to MainLayout when login is successful
        loginLayout.loginButton.setOnAction(event -> {
            String username = loginLayout.getUserName();
            String password = loginLayout.getPassword();
            boolean isValid = DbConnect.validasiLogin(username, password);
            if (isValid) {
                primaryStage.setScene(mainScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });

        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        DbConnect.connection(); // Establish database connection
        launch(args);
    }

    public Object getGreeting() {
        throw new UnsupportedOperationException("Unimplemented method 'getGreeting'");
    }
}
