package tim.proyektil;

import javafx.geometry.Pos;
import javafx.scene.Scene;
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
    private Button komunikasiButton;
    private Button ITButton;
    private Button keuanganButton;
    private Button pendidikanButton;
    private Button seniButton;
    private Button programmingButton;
    private Button digitalButton;
    private Button marketingButton;
    private Button telekomunikasiButton;
    private Button desainVisualButton;

    public MainLayout(Stage primaryStage, Scene mainScene) {
        mainLayout = createMainLayout(primaryStage); // Meneruskan primaryStage ke metode createMainLayout
    }

    public AnchorPane getMainLayout() {
        return mainLayout;
    }

    public ImageView getProfileImage() {
        return profileImageView;
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

    public Button getProgrammingButton() {
        return programmingButton;
    }

    public Button getDigitalButton() {
        return digitalButton;
    }

    public Button getMarketingButton() {
        return marketingButton;
    }

    public Button getTelekomunikasiButton() {
        return telekomunikasiButton;
    }

    public Button getDesainVisualButton() {
        return desainVisualButton;
    }

    private AnchorPane createMainLayout(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
    
        // Create components
        HBox topBox = createTopBox();
        HBox yellowBox = createYellowBox();
        HBox logoBox = createLogoBox();
        HBox imBox = createImageTopBox();
        Label karirKitaLabel = createLabel("KarirKita", 62, 20, 72, 24, 15, "#cd9c49");
        Button exitButton = createExitButton(primaryStage); // Tambahkan tombol exit
    
        AnchorPane whiteSpace = createWhiteSpace();
    
        // Add all children to the main AnchorPane
        anchorPane.getChildren().addAll(topBox, yellowBox, logoBox, imBox, karirKitaLabel, whiteSpace, exitButton);
        addAdditionalLabels(anchorPane);
    
        return anchorPane;
    }

    private HBox createImageTopBox() {
        HBox imBox = new HBox(15);
        imBox.setLayoutX(750);
        imBox.setLayoutY(20);
        imBox.getChildren().addAll(
            ImageTop("/image/Profil.png", event -> openFormLayout())
        );
        return imBox;
    }

    private Button createExitButton(Stage primaryStage) {
        Button exitButton = new Button("Exit");
        exitButton.setLayoutX(20);  // Sesuaikan posisi X sesuai kebutuhan
        exitButton.setLayoutY(465);   // Sesuaikan posisi Y sesuai kebutuhan
        exitButton.setOnAction(event -> primaryStage.close());
        return exitButton;
    }

    private ImageView ImageTop(String imagePath, javafx.event.EventHandler<MouseEvent> eventHandler) {
        ImageView imageTopView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageTopView.setFitHeight(20);
        imageTopView.setFitWidth(20);

        if (eventHandler != null) {
            imageTopView.setOnMouseClicked(eventHandler);
        }

        if (imagePath.equals("/image/Profil.png")) {
            profileImageView = imageTopView; // Simpan referensi untuk Profile ImageView
        }

        return imageTopView;
    }

    private void openFormLayout() {
        System.out.println("Navigating to FormLayout...");
    }

    private HBox createLogoBox() {
        HBox logoBox = new HBox();
        ImageView logoImageView = new ImageView(new Image(getClass().getResourceAsStream("/image/Logo.png")));
        logoImageView.setFitHeight(40);
        logoImageView.setFitWidth(40);
        logoBox.setLayoutX(20);
        logoBox.setLayoutY(11);
        logoBox.getChildren().add(logoImageView);

        return logoBox;
    }

    private HBox createTopBox() {
        HBox topBox = new HBox(20);
        topBox.setAlignment(Pos.BASELINE_LEFT);
        topBox.setLayoutY(84);
        topBox.setPrefSize(865, 66);

        komunikasiButton = createButtonWithLabelAndImage("/image/Komunikasi.png", 35, 84, 146, 66, null);
        ITButton = createButtonWithLabelAndImage("/image/IT.png", 206, 84, 146, 66, null);
        keuanganButton = createButtonWithLabelAndImage("/image/Akuntansi.png", 370, 84, 146, 66, null);
        pendidikanButton = createButtonWithLabelAndImage("/image/Pendidikan.png", 532, 84, 146, 66, null);
        seniButton = createButtonWithLabelAndImage("/image/Seni.png", 693, 84, 146, 66, null);
        telekomunikasiButton = createButtonWithLabelAndImage("/image/Telekomunikasi.png", 470, 91, 163, 52, null);
        programmingButton = createButtonWithLabelAndImage("/image/Programming1.png", 267, 24, 163, 52, null);
        digitalButton = createButtonWithLabelAndImage("/image/Digital.png", 470, 24, 163, 52, null);
        marketingButton = createButtonWithLabelAndImage("/image/Marketing.png", 672, 24, 163, 52,null);
        desainVisualButton   = createButtonWithLabelAndImage("/image/Design.png", 267, 91, 163, 52, null);
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
        Label label1 = createLabel("Komunikasi dan Media", 15, 160, 131, 20, 12, null);
        Label label2 = createLabel("IT", 189, 160, 16, 20, 12, null);
        Label label3 = createLabel("Keuangan dan Akuntansi", 370, 160, 144, 20, 12, null);
        Label label4 = createLabel("Pendidikan", 555, 160, 65, 20, 12, null);
        Label label5 = createLabel("Seni dan Desain", 730, 160, 116, 20, 12, null);

        anchorPane.getChildren().addAll(label1, label2, label3, label4, label5);
    }

    private HBox createYellowBox() {
        HBox yellowBox = new HBox();
        yellowBox.setAlignment(Pos.BASELINE_LEFT);
        yellowBox.setLayoutY(220);
        yellowBox.setPrefSize(890, 233);
        yellowBox.setStyle("-fx-background-color: #F1BC5A;");

        AnchorPane innerAnchorPane = new AnchorPane();
        innerAnchorPane.setPrefSize(865, 242);

        addLabelsToInnerPane(innerAnchorPane);
        addButtonsToInnerPane(innerAnchorPane);

        yellowBox.getChildren().add(innerAnchorPane);
        return yellowBox;
    }

    private void addLabelsToInnerPane(AnchorPane innerAnchorPane) {
        Label infoLabel1 = createLabel("Tingkatkan skill dengan", 38, 71, 154, 20, 13, null);
        Label infoLabel2 = createLabel("kursus!", 38, 91, 154, 20, 13, null);
        Label infoLabel3 = createLabel("Kursus pilihan untuk anda", 38, 126, 154, 20, 12, null);
        Label infoLabel4 = createLabel("dengan pengajar terbaik", 38, 146, 154, 20, 12, null);

        innerAnchorPane.getChildren().addAll(infoLabel1, infoLabel2, infoLabel3, infoLabel4);
    }

    private void addButtonsToInnerPane(AnchorPane innerAnchorPane) {
        innerAnchorPane.getChildren().addAll(
            programmingButton = createButtonWithIcon("Programming", "/image/Programming1.png", 267, 24, 163, 52, null),
            digitalButton = createButtonWithIcon("Digital", "/image/Digital.png", 470, 24, 163, 52, null),
            marketingButton = createButtonWithIcon("Marketing", "/image/Marketing.png", 672, 24, 163, 52,null),
            desainVisualButton   = createButtonWithIcon("Desain Visual", "/image/Design.png", 267, 91, 163, 52, null),
            telekomunikasiButton = createButtonWithIcon("Telekomunikasi", "/image/Telekomunikasi.png", 470, 91, 163, 52, null)

        );
    }


    private AnchorPane createWhiteSpace() {
        AnchorPane whiteSpace = new AnchorPane();
        whiteSpace.setPrefSize(865, 50);
        whiteSpace.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #70390B;");
        AnchorPane.setTopAnchor(whiteSpace, 455.0);
        return whiteSpace;
    }

    private Button createButtonWithLabelAndImage(String imagePath, double layoutX, double layoutY, double prefWidth, double prefHeight, javafx.event.EventHandler<MouseEvent> eventHandler) {
        Button button = new Button();
        button.setPrefSize(prefWidth, prefHeight);
        button.setStyle("-fx-background-color: #FFFFFF;");

        ImageView imageView = new ImageView(new Image(getClass().getResourceAsStream(imagePath)));
        imageView.setFitWidth(146);
        imageView.setFitHeight(66);
        button.setGraphic(imageView);

        if (eventHandler != null) {
            button.setOnMouseClicked(eventHandler);
        }

        VBox vbox = new VBox(5);
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(button);

        return button;
    }

    private Button createButtonWithIcon(String text, String iconPath, double layoutX, double layoutY, double prefWidth, double prefHeight, javafx.event.EventHandler<javafx.event.ActionEvent> eventHandler) {
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
            button.setOnAction(eventHandler);
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
}
