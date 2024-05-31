package tim.proyektil;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import tim.proyektil.config.DbConnect;

public class App extends Application implements MainLayout.SceneSwitcher{

    private Stage primaryStage;
    private Scene mainScene;
    private Scene courseProgrammingScene;
    private Scene courseDesignVisualScene;
    private Scene courseMarketingScene;
    private Scene courseDigitalScene;
    private Scene courseCommunicationScene;
    private FormLayout formLayout;
    private MainLayout mainLayout;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("KarirKita");

        Image icon = new Image(getClass().getResourceAsStream("/Picture2.png")); // Replace with your icon file
        primaryStage.getIcons().add(icon);

        // Create an instance of the login and register layout
        LoginLayout loginLayout = new LoginLayout();
        RegisterLayout registerLayout = new RegisterLayout();
        MainLayout mainLayout = new MainLayout(primaryStage); // Instantiate MainLayout
        mainLayout = new MainLayout(this); // Pass the SceneSwitcher to MainLayout

        mainScene = new Scene(mainLayout.getMainLayout(), 900, 505); // Create scene for MainLayout

        // Create instances of the course layouts
        CourseProgramming courseProgramming = new CourseProgramming(event -> primaryStage.setScene(mainScene), primaryStage);
        CourseDesignVisual courseDesignVisual = new CourseDesignVisual(event -> primaryStage.setScene(mainScene), primaryStage);
        CourseMarketing courseMarketing = new CourseMarketing(event -> primaryStage.setScene(mainScene), primaryStage);
        CourseDigital courseDigital = new CourseDigital(event -> primaryStage.setScene(mainScene), primaryStage);
        CourseCommunication courseCommunication = new CourseCommunication(event -> primaryStage.setScene(mainScene), primaryStage);

        courseProgrammingScene = courseProgramming.getCourseScene();
        courseDesignVisualScene = courseDesignVisual.getCourseScene();
        courseMarketingScene = courseMarketing.getCourseScene();
        courseDigitalScene = courseDigital.getCourseScene();
        courseCommunicationScene = courseCommunication.getCourseScene();


        Scene loginScene = new Scene(loginLayout.getMainLayout(), 650, 640);
        Scene registerScene = new Scene(registerLayout.getMainLayout(), 650, 640);
        Scene mainScene = new Scene(mainLayout.getMainLayout(), 890, 505); // Create scene for MainLayout

        formLayout = new FormLayout(primaryStage, mainScene, null, null);
        Scene formScene = new Scene(formLayout.createForm(), 650, 505);

        InfoKarir infoKarir = new InfoKarir(primaryStage, mainScene); // Instantiate InfoKarir with primaryStage and mainScene
        Scene infoKarirScene1 = infoKarir.getScene1(); // Scene for "Komunikasi dan Media"
        Scene infoKarirScene2 = infoKarir.getScene2(); // Scene for "IT"
        Scene infoKarirScene3 = infoKarir.getScene3(); // Scene for "Keuangan dan Akuntansi"
        Scene infoKarirScene4 = infoKarir.getScene4(); // Scene for "Pendidikan"
        Scene infoKarirScene5 = infoKarir.getScene5(); // Scene for "Seni dan Desain"

        // Switch to register scene when register button is clicked
        loginLayout.getRegisterButton().setOnAction(event -> primaryStage.setScene(registerScene));
    
        // Switch to login scene when login button in register layout is clicked
        registerLayout.getLoginButton().setOnAction(event -> primaryStage.setScene(loginScene));
    
        // Set scene to MainLayout when login is successful
        loginLayout.loginButton.setOnAction(event -> {
            String username = loginLayout.getUserName();
            String password = loginLayout.getPassword();
            boolean isValid = DbConnect.validasiLogin(username, password);
            if (isValid) {
                String[] userDetails = DbConnect.getUserDetails(username);
                if (userDetails != null) {
                    String fullName = userDetails[0];
                    String email = userDetails[1];
                    formLayout.setUserDetails(fullName, email);
                }
                primaryStage.setScene(mainScene);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Login Failed");
                alert.setHeaderText(null);
                alert.setContentText("Invalid username or password.");
                alert.showAndWait();
            }
        });
    
        // Set scene to FormLayout when profile image is clicked
        mainLayout.getProfileImage().setOnMouseClicked(event -> primaryStage.setScene(formScene));
        // Set scene to InfoKarirScene1 when "Komunikasi dan Media" button is clicked
        mainLayout.getKomunikasiButton().setOnAction(event -> primaryStage.setScene(infoKarirScene1));
    
        // Set scene to InfoKarirScene2 when "IT" button is clicked
        mainLayout.getITButton().setOnAction(event -> primaryStage.setScene(infoKarirScene2));
    
        // Set scene to InfoKarirScene3 when "Keuangan dan Akuntansi" button is clicked
        mainLayout.getKeuanganButton().setOnAction(event -> primaryStage.setScene(infoKarirScene3));

        // Set scene to InfoKarirScene4 when "Pendidikan" button is clicked
        mainLayout.getPendidikanButton().setOnAction(event -> primaryStage.setScene(infoKarirScene4));

        // Set scene to InfoKarirScene5 when "Seni dan Desain" button is clicked
        mainLayout.getSeniButton().setOnAction(event -> primaryStage.setScene(infoKarirScene5));
    
        primaryStage.setScene(loginScene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    @Override
    public void switchToCourseProgramming() {
        primaryStage.setScene(courseProgrammingScene);
        primaryStage.centerOnScreen();
    }

    @Override
    public void switchToCourseDesignVisual() {
        primaryStage.setScene(courseDesignVisualScene);
        primaryStage.centerOnScreen();
    }

    @Override
    public void switchToCourseMarketing() {
        primaryStage.setScene(courseMarketingScene);
        primaryStage.centerOnScreen();
    }

    @Override
    public void switchToCourseDigital() {
        primaryStage.setScene(courseDigitalScene);
        primaryStage.centerOnScreen();
    }

    @Override
    public void switchToCourseCommunication() {
        primaryStage.setScene(courseCommunicationScene);
        primaryStage.centerOnScreen();
    }
    public static void main(String[] args) {
        DbConnect.connection(); // Establish database connection
        launch(args);
    }

    public Object getGreeting() {
        throw new UnsupportedOperationException("Unimplemented method 'getGreeting'");
    }
}
