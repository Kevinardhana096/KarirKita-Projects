package tim.proyektil;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class MainLayout {
    private AnchorPane mainLayout;

    public MainLayout() {
        mainLayout = createMainLayout();
    }

    public AnchorPane getMainLayout() {
        return mainLayout;
    }

    private AnchorPane createMainLayout() {
        AnchorPane anchorPane = new AnchorPane();

        // Create components
        HBox hBox = createYellowBox();
        HBox separator = createSeparator();
        Label karirKitaLabel = createLabel("KarirKita", 62, 20, 72, 24, 15, "#cd9c49");
        Label hiNamaLabel = createLabel("Hi, (nama)", 708, 22, 67, 20, 12, null);
        AnchorPane whiteSpace = createWhiteSpace();
        addAdditionalButtonsAndLabels(anchorPane);

        // Add all children to the main AnchorPane
        anchorPane.getChildren().addAll(hBox, separator, karirKitaLabel, hiNamaLabel, whiteSpace);

        return anchorPane;
    }

    private HBox createYellowBox() {
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BASELINE_LEFT);
        hBox.setLayoutY(220);
        hBox.setPrefSize(865, 233);
        hBox.setStyle("-fx-background-color: #F1BC5A;");

        AnchorPane innerAnchorPane = new AnchorPane();
        innerAnchorPane.setPrefSize(865, 242);

        addLabelsToInnerPane(innerAnchorPane);
        addButtonsToInnerPane(innerAnchorPane);

        hBox.getChildren().add(innerAnchorPane);
        return hBox;
    }

    private void addLabelsToInnerPane(AnchorPane innerAnchorPane) {
        Label infoLabel1 = createLabel("Tingkatkan skill dengan", 38, 71, 154, 20, 13, null);
        Label infoLabel2 = createLabel("kursus!", 38, 91, 154, 20, 13, null);
        Label infoLabel3 = createLabel("Kursus pilihan untuk anda", 38, 126, 154, 20, 12, null);
        Label infoLabel4 = createLabel("dengan pengajar terbaik", 38, 146, 154, 20, 12, null);

        innerAnchorPane.getChildren().addAll(infoLabel1, infoLabel2, infoLabel3, infoLabel4);
    }

    private void addButtonsToInnerPane(AnchorPane innerAnchorPane) {
        Button programmingButton = createButton("Programming", 267, 24, 163, 52);
        Button digitalButton = createButton("Digital", 470, 24, 163, 52);
        Button marketingButton = createButton("Marketing", 672, 24, 163, 52);
        Button pengembanganDiriButton = createButton("Pengembangan\nDiri", 267, 91, 163, 52);
        Button bahasaButton = createButton("Bahasa", 470, 91, 163, 52);
        Button ukmButton = createButton("UKM", 672, 91, 163, 52);
        Button telekomunikasiButton = createButton("Telekomunikasi", 267, 156, 163, 52);
        Button desainVisualButton = createButton("Desain Visual", 470, 156, 163, 52);
        Button analisisDataButton = createButton("Analisis Data", 672, 156, 163, 52);

        innerAnchorPane.getChildren().addAll(
                programmingButton, digitalButton, marketingButton,
                pengembanganDiriButton, bahasaButton, ukmButton,
                telekomunikasiButton, desainVisualButton, analisisDataButton
        );
    }

    private HBox createSeparator() {
        HBox separator = new HBox();
        separator.setLayoutY(56);
        separator.setPrefSize(865, 2);
        separator.setStyle("-fx-background-color: #F1BC5A;");
        return separator;
    }

    private AnchorPane createWhiteSpace() {
        AnchorPane whiteSpace = new AnchorPane();
        whiteSpace.setPrefSize(865, 50);
        whiteSpace.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #70390B;");
        AnchorPane.setTopAnchor(whiteSpace, 455.0);
        return whiteSpace;
    }

    private void addAdditionalButtonsAndLabels(AnchorPane anchorPane) {
        Button button1 = createButton("", 35, 84, 146, 66);
        Button button2 = createButton("", 206, 84, 146, 66);
        Button button3 = createButton("", 370, 84, 146, 66);
        Button button4 = createButton("", 532, 84, 146, 66);
        Button button5 = createButton("", 693, 84, 146, 66);

        Label label1 = createLabel("Komunikasi dan Media", 35, 160, 131, 20, 12, null);
        Label label2 = createLabel("IT", 206, 160, 16, 20, 12, null);
        Label label3 = createLabel("Keuangan dan Akuntansi", 370, 160, 144, 20, 12, null);
        Label label4 = createLabel("Pendidikan", 534, 160, 65, 20, 12, null);
        Label label5 = createLabel("Seni dan Desain", 693, 160, 116, 20, 12, null);

        anchorPane.getChildren().addAll(button1, button2, button3, button4, button5, label1, label2, label3, label4, label5);
    }

    private Button createButton(String text, double layoutX, double layoutY, double prefWidth, double prefHeight) {
        Button button = new Button(text);
        button.setLayoutX(layoutX);
        button.setLayoutY(layoutY);
        button.setPrefSize(prefWidth, prefHeight);
        button.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #70390B;"); 
        button.setAlignment(Pos.CENTER_RIGHT);
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

