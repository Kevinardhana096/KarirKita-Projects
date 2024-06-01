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
    public Button loginButton; // Changed from private to public
    private TextField userField;
    private PasswordField passwordField;

    public LoginLayout() {
        // Left pane with illustration
        Image image = new Image(getClass().getResource("/image/Picture1.png").toString()); // Load image from resources
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(255);
        imageView.setFitHeight(280);
        StackPane leftPane = new StackPane(imageView);
        leftPane.setStyle("-fx-background-color: #fbbfcfa;");

        // Logo
        Image logoImage = new Image(getClass().getResource("/image/Picture2.png").toString()); // Load logo from resources
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(100);
        logoImageView.setPreserveRatio(true);
        StackPane logoPane = new StackPane(logoImageView);
        logoPane.setAlignment(Pos.TOP_CENTER);
        logoPane.setPadding(new Insets(20, 0, 0, 0));

        // Right pane with login form
        Text loginTitle = new Text("Masuk");
        loginTitle.setFont(Font.font("Quicksand", FontWeight.BOLD, 24));

        Label userName = new Label("User Name");
        userField = new TextField();
        userField.setStyle("-fx-background-radius:30;");

        Label passwordLabel = new Label("Password");
        passwordField = new PasswordField();
        passwordField.setStyle("-fx-background-radius:30;");

        loginButton = new Button("Masuk");
        loginButton.setStyle("-fx-background-color: #6DC4D0;" +  "-fx-text-fill: white;" + "-fx-background-radius:50;" + "-fx-padding: 5 5;");
        loginButton.setPrefWidth(200);
        loginButton.setFont(Font.font("Quicksand", 15));

        loginButton.setOnAction(event -> handleLogin());

        registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #cc7a32;" +  "-fx-text-fill: white;" + "-fx-background-radius:50;" + "-fx-padding:3 3;");
        registerButton.setPrefWidth(200);
        registerButton.setFont(Font.font("Quicksand", 10));

        Label noAccountLabel = new Label("Belum memiliki akun?");

        VBox form = new VBox(10, loginTitle, userName, userField, passwordLabel, passwordField, loginButton, noAccountLabel, registerButton);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.setMaxWidth(300);

        // Create a VBox with a border
        VBox formWithBorder = new VBox(form);
        formWithBorder.setStyle("-fx-border-color: #BFBCBC; -fx-border-width: 1; -fx-border-radius:20; -fx-padding: 10;");
        formWithBorder.setAlignment(Pos.CENTER);
        formWithBorder.setLayoutX(400);

        // HBox logoo = new HBox(logoPane);
        // logoo.setAlignment(Pos.TOP_CENTER);
        // logoo.setStyle("-fx-background-color: white;");
        // logoo.setPadding(new Insets(20));

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

    public Button getRegisterButton() {
        return registerButton;
    }

    public String getUserName() {
        return userField.getText();
    }

    public String getPassword() {
        return passwordField.getText();
    }

    private void handleLogin() {
        String username = getUserName(); // Use the getUserName() method
        String password = getPassword(); // Use the getPassword() method
        boolean isValid = DbConnect.validasiLogin(username, password);
        if (isValid) {
            // Handle successful login
            // For now, you can just print a message
            System.out.println("Login successful!");
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Failed");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }
    }
}
