package tim.proyektil;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import tim.proyektil.config.DbConnect;

public class LoginLayout {

    private HBox mainLayout;
    private Button registerButton;

    public LoginLayout() {
        // Left pane with illustration
        Image image = new Image(getClass().getResource("/Picture1.png").toString()); // Load image from resources
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(400);
        StackPane leftPane = new StackPane(imageView);
        leftPane.setStyle("-fx-background-color: #f8f8f8;");

        // Logo
        Image logoImage = new Image(getClass().getResource("/Picture2.png").toString()); // Load logo from resources
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(100);
        logoImageView.setPreserveRatio(true);
        StackPane logoPane = new StackPane(logoImageView);
        logoPane.setAlignment(Pos.TOP_CENTER);
        logoPane.setPadding(new Insets(20, 0, 0, 0));

        // Right pane with login form
        Text loginTitle = new Text("Masuk");
        loginTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));

        Label userName = new Label("User Name");
        TextField userField = new TextField();
        userField.setPromptText("User Name");

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button loginButton = new Button("Masuk");
        loginButton.setStyle("-fx-background-color: #6FC3DF; -fx-text-fill: white;");
        loginButton.setPrefWidth(200);
        loginButton.setOnAction(event -> {
            boolean isValid = DbConnect.validasiLogin(userField.getText(), passwordField.getText());
            if (isValid) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Login Successful");
                alert.setHeaderText(null);
                alert.setContentText("Login successful!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });

        registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #FF6F00; -fx-text-fill: white;");
        registerButton.setPrefWidth(200);

        Label noAccountLabel = new Label("Belum memiliki akun?");

        VBox form = new VBox(10, loginTitle, userName, userField, passwordLabel, passwordField, loginButton, noAccountLabel, registerButton);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.setMaxWidth(300);

        // Create a VBox with a border
        VBox formWithBorder = new VBox(form);
        formWithBorder.setStyle("-fx-border-color: #000000; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 10;");
        formWithBorder.setAlignment(Pos.CENTER);
        formWithBorder.setLayoutX(400);

        VBox rightPane = new VBox(10, logoPane, formWithBorder);
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setStyle("-fx-background-color: white;");
        rightPane.setPadding(new Insets(20));

        // Main layout
        mainLayout = new HBox(leftPane, rightPane);
        mainLayout.setStyle("-fx-background-color: #FFFFFF;"); // Set background color to white
    }

    public HBox getMainLayout() {
        return mainLayout;
    }

    public Button getRegisterButton(){
        return registerButton;
    }
}
