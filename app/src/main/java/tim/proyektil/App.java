package tim.proyektil;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
        RegisterLayout registerLayout = new RegisterLayout();
        MainLayout mainLayout = new MainLayout(primaryStage, mainScene); // Instantiate MainLayout with mainScene
        
        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);
        mainScene = new Scene(mainLayout.getMainLayout(), 890, 505); // Create scene for MainLayout
        
        FormLayout formLayout = new FormLayout(primaryStage, mainScene); // Instantiate FormLayout with primaryStage and mainScene
        Scene formScene = new Scene(formLayout.createForm(), 900, 600); // Create scene for FormLayout
        
        // Instantiate Info Scenes
        KomunikasiScene komunikasiScene = new KomunikasiScene(primaryStage, mainScene);
        ITScene itScene = new ITScene(primaryStage, mainScene);
        KeuanganScene keuanganScene = new KeuanganScene(primaryStage, mainScene);
        PendidikanScene pendidikanScene = new PendidikanScene(primaryStage, mainScene);
        SeniDesainScene seniDesainScene = new SeniDesainScene(primaryStage, mainScene);

        EventHandler<ActionEvent> backButtonHandler = event -> primaryStage.setScene(mainScene);
        
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
        
        // Set scene transitions from MainLayout to other scenes
        mainLayout.getProfileImage().setOnMouseClicked(event -> primaryStage.setScene(formScene));
        mainLayout.getKomunikasiButton().setOnAction(event -> primaryStage.setScene(komunikasiScene.getScene()));
        mainLayout.getITButton().setOnAction(event -> primaryStage.setScene(itScene.getScene()));
        mainLayout.getKeuanganButton().setOnAction(event -> primaryStage.setScene(keuanganScene.getScene()));
        mainLayout.getPendidikanButton().setOnAction(event -> primaryStage.setScene(pendidikanScene.getScene()));
        mainLayout.getSeniButton().setOnAction(event -> primaryStage.setScene(seniDesainScene.getScene()));
        
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
