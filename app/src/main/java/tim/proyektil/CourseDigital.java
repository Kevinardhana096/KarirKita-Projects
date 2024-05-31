package tim.proyektil;

import javafx.stage.Stage;

public class CourseDigital extends BaseCourseScene {

    public CourseDigital(javafx.event.EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        super("Digital",
              new String[]{
                  "/image/Marketing 4.0.png",
                  "/image/Understanding.png",
                  "/image/Digital Design.png" // Add the third image path
              },
              new String[]{
                  "/pdf/Marketing 4.0_ Moving from Traditional to Digital ( PDFDrive ).pdf",
                  "/pdf/Understanding Digital Marketing_ Marketing Strategies for Engaging the Digital Generation ( PDFDrive ).pdf",
                  "/pdf/digital design digital design digital design principles & practices  ( PDFDrive ).pdf" // Add the third PDF path
              },
              backButtonHandler, primaryStage);
    }
}
