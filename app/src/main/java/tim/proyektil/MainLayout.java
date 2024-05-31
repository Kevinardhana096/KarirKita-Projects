package tim.proyektil;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainLayout {
    
    private AnchorPane mainLayout;
    private ImageView profileImageView;
    private ImageView programmingImageView;
    private Label fullNameLabel;
    private SceneSwitcher sceneSwitcher; // Interface for scene switching
    private Button komunikasiButton;
    private Button ITButton;
    private Button keuanganButton;
    private Button pendidikanButton;
    private Button seniButton;
    private Stage primaryStage;

    public MainLayout() {
        mainLayout = createMainLayout();
    }

    public AnchorPane getMainLayout() {
        return mainLayout;
    }

    public ImageView getProfileImage() {
        return profileImageView;
    }

    public ImageView getProgrammingImage() {
        return programmingImageView;
    }

    public void setFullName(String fullName) {
        fullNameLabel.setText("Welcome, " + fullName);
    }

    public Button getKomunikasiButton() {
        return komunikasiButton;
    }

    public Button getITButton() {
        return ITButton;
    }

    public Button getKeuanganButton() {
        return keuanganButton;
    }

    public Button getPendidikanButton() {
        return pendidikanButton;
    }

    public Button getSeniButton() {
        return seniButton;
    }

    private AnchorPane createMainLayout() {
        AnchorPane anchorPane = new AnchorPane();

        HBox topBox = createTopBox();
        HBox yellowBox = createYellowBox();
        HBox logoBox = createLogoBox();
        HBox imBox = createImageTopBox();

        // Create the full name label
        fullNameLabel = new Label();
        fullNameLabel.setLayoutX(20);
        fullNameLabel.setLayoutY(10);

        anchorPane.getChildren().addAll(
            createTopBox(),
            createYellowBox(),
            createLogoBox(),
            createImageTopBox(),
            createLabel("KarirKita", 62, 20, 72, 24, 15, "#cd9c49"),
            createWhiteSpace(),
            createExitButton(), // Add the exit button to the main layout
            fullNameLabel // Add the full name label to the main layout
        );

        addAdditionalLabels(anchorPane);

        return anchorPane;
    }

    private HBox createImageTopBox() {
        HBox imBox = createHBox(15, 750, 20, new ImageView[]{
            createImageView("/image/Sertifikat.png", null),
            createImageView("/image/Profil.png", event -> openFormLayout())
        });
        return imBox;
    }

    private ImageView createImageView(String imagePath, javafx.event.EventHandler<MouseEvent> eventHandler) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitHeight(20);
        imageView.setFitWidth(20);

        if (eventHandler != null) {
            imageView.setOnMouseClicked(eventHandler);
        }

        if (imagePath.equals("/image/Profil.png")) {
            profileImageView = imageView;
        }

        return imageView;
    }

    private void openFormLayout() {
        System.out.println("Navigating to FormLayout...");
    }

    private HBox createLogoBox() {
        HBox logoBox = new HBox();
        logoBox.setLayoutX(20);
        logoBox.setLayoutY(11);
        logoBox.getChildren().add(createImageView("/image/Logo.png", null, 40, 40));
        return logoBox;
    }

    private ImageView createImageView(String imagePath, javafx.event.EventHandler<MouseEvent> eventHandler, double width, double height) {
        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

        if (eventHandler != null) {
            imageView.setOnMouseClicked(eventHandler);
        }

        return imageView;
    }

    private HBox createTopBox() {
        HBox topBox = createHBox(20, 0, 84, new Button[]{
            createButtonWithLabelAndImage("/image/Komunikasi.png", null),
            createButtonWithLabelAndImage("/image/IT.png", null),
            createButtonWithLabelAndImage("/image/Akuntansi.png", null),
            createButtonWithLabelAndImage("/image/Pendidikan.png", null),
            createButtonWithLabelAndImage("/image/Seni.png", null)
        });
        topBox.setPrefSize(865, 66);

        topBox.getChildren().addAll(
            komunikasiButton,
            ITButton,
            keuanganButton,
            pendidikanButton,
            seniButton 
        );

        return topBox;
    }

    private void addAdditionalLabels(AnchorPane anchorPane) {
        anchorPane.getChildren().addAll(
            createLabel("Komunikasi dan Media", 15, 160, 131, 20, 12, null),
            createLabel("IT", 189, 160, 16, 20, 12, null),
            createLabel("Keuangan dan Akuntansi", 370, 160, 144, 20, 12, null),
            createLabel("Pendidikan", 555, 160, 65, 20, 12, null),
            createLabel("Seni dan Desain", 730, 160, 116, 20, 12, null)
        );
    }

    private HBox createYellowBox() {
        HBox yellowBox = new HBox();
        yellowBox.setAlignment(Pos.BASELINE_LEFT);
        yellowBox.setLayoutY(220);
        yellowBox.setPrefSize(890, 233);
        yellowBox.setStyle("-fx-background-color: #F1BC5A;");

        AnchorPane innerAnchorPane = new AnchorPane();
        innerAnchorPane.setPrefSize(865, 242);

        innerAnchorPane.getChildren().addAll(
            createLabel("Tingkatkan skill dengan", 38, 71, 154, 20, 13, null),
            createLabel("kursus!", 38, 91, 154, 20, 13, null),
            createLabel("Kursus pilihan untuk anda", 38, 126, 154, 20, 12, null),
            createLabel("dengan pengajar terbaik", 38, 146, 154, 20, 12, null),
            createButtonWithIcon("Programming", "/image/Programming1.png", 267, 24, 163, 52, event -> sceneSwitcher.switchToCourseProgramming()),
            createButtonWithIcon("Desain Visual", "/image/Design.png", 470, 24, 163, 52, event -> sceneSwitcher.switchToCourseDesignVisual()),
            createButtonWithIcon("Marketing", "/image/Marketing.png", 672, 24, 163, 52, event -> sceneSwitcher.switchToCourseMarketing()),
            createButtonWithIcon("Digital", "/image/Digital.png", 267, 91, 163, 52, event -> sceneSwitcher.switchToCourseDigital()),
            createButtonWithIcon("Komunikasi", "/image/Telekomunikasi.png", 470, 91, 163, 52, event -> sceneSwitcher.switchToCourseCommunication())
        );

        yellowBox.getChildren().add(innerAnchorPane);
        return yellowBox;
    }

    private AnchorPane createWhiteSpace() {
        AnchorPane whiteSpace = new AnchorPane();
        whiteSpace.setPrefSize(865, 50);
        whiteSpace.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #70390B;");
        AnchorPane.setTopAnchor(whiteSpace, 455.0);
        return whiteSpace;
    }

    private Button createButtonWithLabelAndImage(String imagePath, javafx.event.EventHandler<MouseEvent> eventHandler) {
        Button button = new Button();
        button.setPrefSize(146, 66);
        button.setStyle("-fx-background-color: #FFFFFF;");

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitWidth(146);
        imageView.setFitHeight(66);
        button.setGraphic(imageView);

        if (eventHandler != null) {
            button.setOnMouseClicked(eventHandler);
        }

        return button;
    }

    private Button createButtonWithIcon(String text, String iconPath, double layoutX, double layoutY, double prefWidth, double prefHeight, javafx.event.EventHandler<MouseEvent> eventHandler) {
        Button button = new Button(text);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setPrefSize(prefWidth, prefHeight);
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #70390B;");

        ImageView icon = new ImageView(new Image(getClass().getResourceAsStream(iconPath)));
        icon.setFitWidth(20);
        icon.setFitHeight(20);
        button.setGraphic(icon);
        button.setContentDisplay(ContentDisplay.LEFT);

        if (eventHandler != null) {
            button.setOnMouseClicked(eventHandler);
        }

        if (iconPath.equals("/image/Programming1.png")) {
            programmingImageView = icon;
        }

        return button;
    }

    private Label createLabel(String text, double layoutX, double layoutY, double prefWidth, double prefHeight, int fontSize, String textColor) {
        Label label = new Label(text);
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setPrefSize(prefWidth, prefHeight);
        label.setStyle("-fx-font-size: " + fontSize + "px;");
        if (textColor != null) {
            label.setStyle(label.getStyle() + "-fx-text-fill: " + textColor + ";");
        }
        return label;
    }

    private HBox createHBox(double spacing, double layoutX, double layoutY, javafx.scene.Node[] nodes) {
        HBox hBox = new HBox(spacing);
        hBox.setLayoutX(layoutX);
        hBox.setLayoutY(layoutY);
        hBox.getChildren().addAll(nodes);
        return hBox;
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-background-color: #FF0000; -fx-text-fill: white;");
        exitButton.setOnAction(event -> {
            Stage stage = (Stage) exitButton.getScene().getWindow();
            stage.close();
        });
        AnchorPane.setBottomAnchor(exitButton, 10.0);
        AnchorPane.setLeftAnchor(exitButton, 10.0);
        return exitButton;
    }

    public interface SceneSwitcher {
        void switchToCourseProgramming();
        void switchToCourseDesignVisual();
        void switchToCourseMarketing();
        void switchToCourseDigital();
        void switchToCourseCommunication();
    }
}

