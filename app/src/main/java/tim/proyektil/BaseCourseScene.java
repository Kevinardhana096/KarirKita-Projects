package tim.proyektil;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class BaseCourseScene {

    protected Scene courseScene;
    protected String headerText;
    protected String[] imagePaths;
    protected String[] pdfPaths;
    protected Stage primaryStage;

    public BaseCourseScene(String headerText, String[] imagePaths, String[] pdfPaths, javafx.event.EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        this.headerText = headerText;
        this.imagePaths = imagePaths;
        this.pdfPaths = pdfPaths;
        this.primaryStage = primaryStage;

        // Create the header
        HBox header = new HBox();
        header.setStyle("-fx-background-color: #63C1D7;");
        header.setPadding(new Insets(10, 20, 10, 20));
        Text headerTitle = new Text(headerText);
        headerTitle.setFill(Color.WHITE);
        header.getChildren().add(headerTitle);

        // Create the image views for the PDFs and their buttons
        HBox pdfContainer = new HBox(20); // Use HBox for horizontal arrangement
        pdfContainer.setAlignment(Pos.TOP_LEFT);
        pdfContainer.setPadding(new Insets(20));

        for (int i = 0; i < imagePaths.length; i++) {
            ImageView pdfImageView = null;
            try {
                Image image = new Image(getClass().getResourceAsStream(imagePaths[i]));
                pdfImageView = new ImageView(image);
                pdfImageView.setFitWidth(250); // Adjust width as needed
                pdfImageView.setFitHeight(450);
                pdfImageView.setPreserveRatio(true);
            } catch (Exception e) {
                System.err.println("Error loading image: " + imagePaths[i]);
                e.printStackTrace();
                continue; // Skip this iteration if the image is not found
            }

            Button openPdfButton = new Button("Open PDF " + (i + 1));
            openPdfButton.setStyle("-fx-background-color: #FFC048; -fx-text-fill: white;");
            String pdfPath = pdfPaths[i];
            openPdfButton.setOnAction(e -> {
                try {
                    // Save PDF file to temporary directory
                    File pdfFile = savePdfToTemporary(pdfPath);

                    // Open PDF file
                    if (pdfFile != null) {
                        Desktop.getDesktop().open(pdfFile);
                    } else {
                        System.err.println("Failed to open PDF file.");
                    }
                } catch (IOException | URISyntaxException ex) {
                    ex.printStackTrace();
                }
            });

            VBox pdfBox = new VBox(10, pdfImageView, openPdfButton);
            pdfBox.setAlignment(Pos.TOP_LEFT);
            pdfBox.setPadding(new Insets(20));
            pdfContainer.getChildren().add(pdfBox);
        }

        // Create the back button
        Button backButton = new Button("Kembali");
        backButton.setStyle("-fx-background-color: #FFC048; -fx-text-fill: white;");
        backButton.setOnAction(backButtonHandler);

        // Create a layout for the back button
        HBox buttonBox = new HBox(backButton);
        buttonBox.setAlignment(Pos.BOTTOM_RIGHT);
        buttonBox.setPadding(new Insets(20));

        // Create the main layout
        BorderPane mainLayout = new BorderPane();
        mainLayout.setTop(header);
        mainLayout.setCenter(pdfContainer); // Center the HBox with PDFs and buttons
        mainLayout.setBottom(buttonBox);

        // Create the scene
        courseScene = new Scene(mainLayout, 1000, 600);

        // Center the stage
        primaryStage.setScene(courseScene);
        primaryStage.centerOnScreen();
    }

    public Scene getCourseScene() {
        return courseScene;
    }

    private File savePdfToTemporary(String pdfPath) throws IOException, URISyntaxException {
        // Get URL of PDF file in resources
        URL pdfResource = getClass().getResource(pdfPath);

        // If PDF file not found
        if (pdfResource == null) {
            System.err.println("PDF file not found: " + pdfPath);
            return null;
        }

        // Copy PDF file to temporary directory
        Path tempDirectory = Files.createTempDirectory("pdf_viewer");
        Path tempPdfFile = tempDirectory.resolve(new File(pdfPath).getName());
        Files.copy(pdfResource.openStream(), tempPdfFile, StandardCopyOption.REPLACE_EXISTING);

        return tempPdfFile.toFile();
    }
}
