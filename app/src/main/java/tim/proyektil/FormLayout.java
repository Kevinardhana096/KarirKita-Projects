package tim.proyektil;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FormLayout {

    private Stage primaryStage;
    private Scene mainScene;

    public FormLayout(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage;
        this.mainScene = mainScene;
    }

    public StackPane createForm() {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER); // Center align the grid

        // Center align columns
        ColumnConstraints column1 = new ColumnConstraints();
        column1.setHalignment(HPos.RIGHT);
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHalignment(HPos.LEFT);
        grid.getColumnConstraints().addAll(column1, column2);

        // Create the form elements
        Label nameLabel = new Label("Nama Lengkap");
        TextField nameInput = new TextField();

        Label educationLabel = new Label("Pendidikan");
        TextField educationInput = new TextField();

        Label emailLabel = new Label("Email");
        TextField emailInput = new TextField();

        Label workExperienceLabel = new Label("Pengalaman Kerja");
        TextField workExperienceInput = new TextField();

        Label skillsLabel = new Label("Keterampilan");
        TextField skillsInput = new TextField();

        Button saveButton = new Button("Simpan");
        saveButton.setStyle("-fx-background-color: #D67C29; -fx-text-fill: white;");
        
        // Add action for saveButton (not specified in the original code)
        saveButton.setOnAction(event -> {
            // Here you would typically save the form data or perform other actions
            // For demonstration, let's just print the form data to the console
            System.out.println("Nama: " + nameInput.getText());
            System.out.println("Pendidikan: " + educationInput.getText());
            System.out.println("Email: " + emailInput.getText());
            System.out.println("Pengalaman Kerja: " + workExperienceInput.getText());
            System.out.println("Keterampilan: " + skillsInput.getText());
        });

        // Add a placeholder for the profile picture
        ImageView profilePicture = new ImageView(new Image(getClass().getResourceAsStream("/image/Profil.png")));
        profilePicture.setFitHeight(35);
        profilePicture.setFitWidth(35);

        // Add elements to the grid and center them
        GridPane.setHalignment(profilePicture, HPos.CENTER);
        grid.add(profilePicture, 0, 0, 2, 1);

        GridPane.setHalignment(nameLabel, HPos.RIGHT);
        grid.add(nameLabel, 0, 1);
        grid.add(nameInput, 1, 1);

        GridPane.setHalignment(educationLabel, HPos.RIGHT);
        grid.add(educationLabel, 0, 2);
        grid.add(educationInput, 1, 2);

        GridPane.setHalignment(emailLabel, HPos.RIGHT);
        grid.add(emailLabel, 0, 3);
        grid.add(emailInput, 1, 3);

        GridPane.setHalignment(workExperienceLabel, HPos.RIGHT);
        grid.add(workExperienceLabel, 0, 4);
        grid.add(workExperienceInput, 1, 4);

        GridPane.setHalignment(skillsLabel, HPos.RIGHT);
        grid.add(skillsLabel, 0, 5);
        grid.add(skillsInput, 1, 5);

        GridPane.setHalignment(saveButton, HPos.CENTER);
        grid.add(saveButton, 0, 6, 2, 1);

        // Create a VBox for the form with a white background
        VBox formBox = new VBox();
        formBox.setAlignment(Pos.CENTER); // Center align the VBox
        formBox.setStyle("-fx-background-color: white; -fx-background-radius: 20;");
        formBox.setPadding(new Insets(20));
        formBox.getChildren().add(grid);

        // Center the formBox in a StackPane
        StackPane centeredForm = new StackPane();
        centeredForm.setAlignment(Pos.CENTER); // Center align the StackPane
        centeredForm.getChildren().add(formBox);

        // Create a VBox for the scene with a yellow background
        VBox outerBox = new VBox();
        outerBox.setAlignment(Pos.CENTER); // Center align the VBox
        outerBox.setStyle("-fx-background-color: #F9E8B3;");
        outerBox.setPadding(new Insets(50));
        outerBox.getChildren().add(centeredForm);

        // Create a button for returning to the main scene
        Button backButton = new Button("Kembali");
        backButton.setOnAction(event -> {
            primaryStage.setScene(mainScene);
        });
        outerBox.getChildren().add(backButton);

        StackPane root = new StackPane();
        root.setAlignment(Pos.CENTER); // Center align the StackPane
        root.getChildren().add(outerBox);
        return root;
    }
}
