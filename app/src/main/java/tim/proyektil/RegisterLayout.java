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

public class RegisterLayout {

    private HBox mainLayout;
    private Button loginButton;

    public RegisterLayout() {
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

        // Right pane with register form
        Text registerTitle = new Text("Daftar");
        registerTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label phoneLabel = new Label("Nomor Telepon");
        TextField phoneField = new TextField();
        phoneField.setPromptText("Nomor Telepon");

        Label nameLabel = new Label("Nama Lengkap");
        TextField nameField = new TextField();
        nameField.setPromptText("Nama Lengkap");

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("Email");

        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Password");

        Button registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #6FC3DF; -fx-text-fill: white;");
        registerButton.setPrefWidth(200);
        
        loginButton = new Button("Masuk");
        loginButton.setStyle("-fx-background-color: #FF6F00; -fx-text-fill: white;");
        loginButton.setPrefWidth(200);

        Label hasAccountLabel = new Label("Sudah memiliki akun?");
        
        VBox form = new VBox(10, registerTitle, phoneLabel, phoneField, nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, registerButton, hasAccountLabel, loginButton);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.setMaxWidth(300);

        // Create a VBox with a border
        VBox formWithBorder = new VBox(form);
        formWithBorder.setStyle("-fx-border-color: #000000; -fx-border-width: 1; -fx-border-radius: 5; -fx-padding: 10;");
        formWithBorder.setAlignment(Pos.CENTER);
        formWithBorder.setMaxWidth(350); // Optional: To control the width of the border
        formWithBorder.setPadding(new Insets(10));

        // Align the form with border to center within rightPane
        VBox rightPane = new VBox(10, logoPane, formWithBorder);
        rightPane.setAlignment(Pos.TOP_CENTER);
        rightPane.setStyle("-fx-background-color: white;");
        rightPane.setPadding(new Insets(20));

        // Main layout
        mainLayout = new HBox(leftPane, rightPane);
        mainLayout.setStyle("-fx-background-color: #FFFFFF;");  // Set background color to white
    }

    public HBox getMainLayout() {
        return mainLayout;
    }

    public Button getLoginButton(){
        return loginButton;
    }
}
