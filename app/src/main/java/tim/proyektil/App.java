package tim.proyektil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws UnsupportedOperationException {

        primaryStage.setTitle("KarirKita");

        Image icon = new Image(getClass().getResourceAsStream("/Picture2.png")); // Replace with your icon file
        primaryStage.getIcons().add(icon);

        // Create an instance of the login and register layout
        LoginLayout loginLayout = new LoginLayout();
        RegisterLayout registerLayout = new RegisterLayout();

        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);

        // Switch to register scene when register button is clicked
        loginLayout.getRegisterButton().setOnAction(event -> primaryStage.setScene(registerScene));

        // Switch to login scene when login button in register layout is clicked
        registerLayout.getLoginButton().setOnAction(event -> primaryStage.setScene(loginScene));

        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public Object getGreeting() {
        throw new UnsupportedOperationException("Unimplemented method 'getGreeting'");
    }
}
