package tim.proyektil;

import javafx.stage.Stage;

public class CourseMarketing extends BaseCourseScene {

    public CourseMarketing(javafx.event.EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        super("Marketing",
              new String[]{
                  "/image/AI in Marketing.png",
                  "/image/Bank Marketing Management ( PDFDrive ).png",
                  "/image/Financial Risk.png" // Add the third image path
              },
              new String[]{
                  "/pdf/AI in Marketing, Sales and Service_ How Marketers without a Data Science Degree can use AI, Big Data and Bots ( PDFDrive ).pdf",
                  "/pdf/Bank Marketing Management ( PDFDrive ).pdf",
                  "/pdf/Financial Risk Management_ Applications in Market, Credit, Asset and Liability Management and Firmwide Risk ( PDFDrive ).pdf" // Add the third PDF path
              },
              backButtonHandler, primaryStage);
    }
}
