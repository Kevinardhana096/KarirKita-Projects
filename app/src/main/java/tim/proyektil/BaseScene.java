package tim.proyektil;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public abstract class BaseScene {

    protected Stage primaryStage;
    protected Scene mainScene;

    public BaseScene(Stage primaryStage, Scene mainScene) {
        this.primaryStage = primaryStage;
        this.mainScene = mainScene;
    }

    public Scene createScene(String title, String contentText, String imagePath) {
        AnchorPane root = new AnchorPane();
        root.setPrefSize(842.0, 520.0); // Set preferred size for root

        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setLayoutX(15.0);
        scrollPane.setLayoutY(50.0);
        scrollPane.setPrefSize(812.0, 550.0); // Adjust the size as needed

        VBox content = new VBox();
        content.setPrefWidth(800.0);
        content.setPrefHeight(400.0); // Adjust the size as needed

        // Add image
        Image image = new Image(getClass().getResourceAsStream(imagePath));
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(800.0);
        imageView.setPreserveRatio(true);
        content.getChildren().add(imageView);

        Text text = new Text(contentText);
        text.setWrappingWidth(800.0);
        content.getChildren().add(text);
        scrollPane.setContent(content);

        Button buttonToMainScene = createButton("Kembali");
        buttonToMainScene.setOnAction(e -> primaryStage.setScene(mainScene));
        buttonToMainScene.setStyle("-fx-background-color: #FFC048; -fx-text-fill: white;");
        buttonToMainScene.setLayoutX(348.0);
        buttonToMainScene.setLayoutY(600.0); // Adjust the button position as needed

        Label label = new Label(title);
        label.setLayoutX(15.0);
        label.setLayoutY(15.0);
        label.setPrefSize(812.0, 40.0);
        label.setFont(new Font("System Bold", 19.0));

        root.getChildren().addAll(scrollPane, buttonToMainScene, label);

        Scene scene = new Scene(root, 842.0, 640.0); // Set the scene size here
        return scene;
    }

    private Button createButton(String buttonText) {
        Button button = new Button(buttonText);
        button.setPrefSize(146.0, 25.0);
        return button;
    }

    public abstract Scene getScene();
}
