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

public class RegisterLayout {

    private HBox mainLayout;
    private Button loginButton;

    public RegisterLayout() {
        // Left pane with illustration
        Image image = new Image(getClass().getResource("/image/Picture1.png").toString()); // Load image from resources
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(300);
        imageView.setFitHeight(400);
        StackPane leftPane = new StackPane(imageView);
        leftPane.setStyle("-fx-background-color: #f8f8f8;");
        
        // Logo
        Image logoImage = new Image(getClass().getResource("/image/Picture2.png").toString()); // Load logo from resources
        ImageView logoImageView = new ImageView(logoImage);
        logoImageView.setFitWidth(100);
        logoImageView.setPreserveRatio(true);
        StackPane logoPane = new StackPane(logoImageView);
        logoPane.setAlignment(Pos.TOP_CENTER);
        logoPane.setPadding(new Insets(20, 0, 0, 0));

        // Right pane with register form
        Text registerTitle = new Text("Daftar");
        registerTitle.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        
        Label creatUserLabel = new Label("Create User Name");
        TextField createUserField = new TextField();
        createUserField.setPromptText("Create User Name");

        Label nameLabel = new Label("Nama Lengkap");
        TextField nameField = new TextField();
        nameField.setPromptText("Nama Lengkap");

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("example@gmail.com");

        Label createPasswordLabel = new Label("Create Password");
        PasswordField createPasswordField = new PasswordField();
        createPasswordField.setPromptText("Create Password");

        // TextField for showing password
        TextField createPasswordFieldVisible = new TextField();
        createPasswordFieldVisible.setPromptText("Create Password");
        createPasswordFieldVisible.setManaged(false);
        createPasswordFieldVisible.setVisible(false);

        // Checkbox to toggle password visibility
        CheckBox showPasswordCheckbox = new CheckBox("Show Password");
        showPasswordCheckbox.setOnAction(event -> {
            if (showPasswordCheckbox.isSelected()) {
                createPasswordFieldVisible.setText(createPasswordField.getText());
                createPasswordFieldVisible.setManaged(true);
                createPasswordFieldVisible.setVisible(true);
                createPasswordField.setManaged(false);
                createPasswordField.setVisible(false);
            } else {
                createPasswordField.setText(createPasswordFieldVisible.getText());
                createPasswordField.setManaged(true);
                createPasswordField.setVisible(true);
                createPasswordFieldVisible.setManaged(false);
                createPasswordFieldVisible.setVisible(false);
            }
        });

        Button registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #6FC3DF; -fx-text-fill: white;");
        registerButton.setPrefWidth(200);
        registerButton.setOnAction(event -> {
            boolean isRegistered = DbConnect.registerUser(createUserField.getText(), nameField.getText(), emailField.getText(), createPasswordField.getText());
            if (isRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText("Registration successful! Please log in.");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Registration Failed");
                alert.setHeaderText(null);
                alert.setContentText("Registration failed. Please try again.");
                alert.showAndWait();
            }
        });

        loginButton = new Button("Masuk");
        loginButton.setStyle("-fx-background-color: #FF6F00; -fx-text-fill: white;");
        loginButton.setPrefWidth(200);

        Label hasAccountLabel = new Label("Sudah memiliki akun?");
        
        VBox form = new VBox(10, registerTitle, creatUserLabel, createUserField, nameLabel, nameField, emailLabel, emailField, createPasswordLabel, createPasswordField, createPasswordFieldVisible, showPasswordCheckbox, registerButton, hasAccountLabel, loginButton);
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
