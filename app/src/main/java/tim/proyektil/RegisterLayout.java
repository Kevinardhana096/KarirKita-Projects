package tim.proyektil;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import tim.proyektil.config.DbConnect;

public class RegisterLayout {

    private HBox mainLayout;
    private Button loginButton;

    public RegisterLayout(Stage primaryStage, Scene mainScene) {
        // Left pane with illustration
        Image image = new Image(getClass().getResource("/image/Picture1.png").toString()); // Load image from resources
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(255);
        imageView.setFitHeight(280);
        StackPane leftPane = new StackPane(imageView);
        leftPane.setStyle("-fx-background-color: #fbfcfa;");
        
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
        registerTitle.setFont(Font.font("Quicksand", FontWeight.BOLD, 24));
        
        Label creatUserLabel = new Label("Create User Name");
        TextField createUserField = new TextField();
        createUserField.setStyle("-fx-background-radius:30;");

        Label nameLabel = new Label("Nama Lengkap");
        TextField nameField = new TextField();
        nameField.setStyle("-fx-background-radius:30;");

        Label emailLabel = new Label("Email");
        TextField emailField = new TextField();
        emailField.setPromptText("example@gmail.com");
        emailField.setStyle("-fx-background-radius:30;");

        Label createPasswordLabel = new Label("Create Password");

        // Password and Show Password Fields
        PasswordField createPasswordField = new PasswordField();
        createPasswordField.setStyle("-fx-background-radius:30;");

        TextField showPasswordField = new TextField();
        showPasswordField.setVisible(false);

        CheckBox showPasswordCheckBox = new CheckBox("Show Password");

        // Listener to toggle visibility
        showPasswordCheckBox.selectedProperty().addListener((obs, wasSelected, isSelected) -> {
            if (isSelected) {
                showPasswordField.setText(createPasswordField.getText());
                showPasswordField.setVisible(true);
                createPasswordField.setVisible(false);
            } else {
                createPasswordField.setText(showPasswordField.getText());
                createPasswordField.setVisible(true);
                showPasswordField.setVisible(false);
            }
        });

        // Bind the text properties so that they stay in sync
        createPasswordField.textProperty().bindBidirectional(showPasswordField.textProperty());

        Button registerButton = new Button("Daftar");
        registerButton.setStyle("-fx-background-color: #6DC4D0;" +  "-fx-text-fill: white;" + "-fx-background-radius:50;" + "-fx-padding: 5 5;");
        registerButton.setPrefWidth(200);
        registerButton.setOnAction(event -> {
            boolean isRegistered = DbConnect.registerUser(createUserField.getText(), nameField.getText(), emailField.getText(), createPasswordField.getText());
            if (isRegistered) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Registration Successful");
                alert.setHeaderText(null);
                alert.setContentText("Registration successful! Please log in.");
                alert.showAndWait();

                // Buka form layout setelah registrasi berhasil
                FormLayout formLayout = new FormLayout(primaryStage, mainScene, createUserField.getText());
                Scene formScene = new Scene(formLayout.createForm(), 800, 600);
                primaryStage.setScene(formScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Registration Failed");
                alert.setHeaderText(null);
                alert.setContentText("Registration failed. Please try again.");
                alert.showAndWait();
            }
        });

        loginButton = new Button("Masuk");
        loginButton.setStyle("-fx-background-color: #cc7a32;" +  "-fx-text-fill: white;" + "-fx-background-radius:50;" + "-fx-padding:3 3;");
        loginButton.setPrefWidth(200);

        Label hasAccountLabel = new Label("Sudah memiliki akun?");
        
        VBox form = new VBox(10, registerTitle, creatUserLabel, createUserField, nameLabel, nameField, emailLabel, emailField, createPasswordLabel, createPasswordField, showPasswordCheckBox, registerButton, hasAccountLabel, loginButton);
        form.setAlignment(Pos.CENTER);
        form.setPadding(new Insets(20));
        form.setMaxWidth(300);

        // Create a VBox with a border
        VBox formWithBorder = new VBox(form);
        formWithBorder.setStyle("-fx-border-color: #BFBCBC; -fx-border-width: 1; -fx-border-radius:20; -fx-padding: 10;");
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
