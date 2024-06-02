package tim.proyektil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tim.proyektil.config.DbConnect;

public class App extends Application {

    private Scene mainScene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("KarirKita");
        
        Image icon = new Image(getClass().getResourceAsStream("/image/Picture2.png")); // Replace with your icon file
        primaryStage.getIcons().add(icon);
        
        // Create an instance of the login and register layout
        LoginLayout loginLayout = new LoginLayout();
        RegisterLayout registerLayout = new RegisterLayout(primaryStage, null);
        MainLayout mainLayout = new MainLayout(primaryStage, mainScene); // Instantiate MainLayout with mainScene
        
        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);
        mainScene = new Scene(mainLayout.getMainLayout(), 890, 505); // Create scene for MainLayout
        
        // Set scene transitions from login to register and vice versa
        loginLayout.getRegisterButton().setOnAction(event -> primaryStage.setScene(registerScene));
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
        
        // Set scene transitions from MainLayout to form layout
        mainLayout.getProfileImage().setOnMouseClicked(event -> {
            FormLayout formLayout = new FormLayout(primaryStage, mainScene, loginLayout.getUserName());
            Scene formScene = new Scene(formLayout.createForm(), 900, 600);
            primaryStage.setScene(formScene);
        });

        // Set scene transitions from MainLayout to other scenes
        mainLayout.getKomunikasiButton().setOnAction(event -> primaryStage.setScene(new KomunikasiScene(primaryStage, mainScene).getScene()));
        mainLayout.getITButton().setOnAction(event -> primaryStage.setScene(new ITScene(primaryStage, mainScene).getScene()));
        mainLayout.getKeuanganButton().setOnAction(event -> primaryStage.setScene(new KeuanganScene(primaryStage, mainScene).getScene()));
        mainLayout.getPendidikanButton().setOnAction(event -> primaryStage.setScene(new PendidikanScene(primaryStage, mainScene).getScene()));
        mainLayout.getSeniButton().setOnAction(event -> primaryStage.setScene(new SeniDesainScene(primaryStage, mainScene).getScene()));
        
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
