package tim.proyektil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws UnsupportedOperationException {

        primaryStage.setTitle("KarirKita");

        // Set the application icon
        Image icon = new Image(getClass().getResourceAsStream("/Picture2.png"));
        primaryStage.getIcons().add(icon);

        // Create instances of the login and register layouts
        LoginLayout loginLayout = new LoginLayout();
        RegisterLayout registerLayout = new RegisterLayout();

        // Create scenes for login and register
        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);

        // Set up button actions to switch scenes
        loginLayout.getRegisterButton().setOnAction(event -> primaryStage.setScene(registerScene));
        registerLayout.getLoginButton().setOnAction(event -> primaryStage.setScene(loginScene));

        // Set the initial scene to loginScene
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
