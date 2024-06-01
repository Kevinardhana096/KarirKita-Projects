package tim.proyektil;

import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CourseDesignVisual extends BaseCourseScene {

    public CourseDesignVisual(EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        super("Design Visual",
                new String[] {
                        "/image/Fundamental .png"
                },
                new String[] {
                        "/pdf/Fundamentals of Computer Graphics, Fourth Edition ( PDFDrive ).pdf" // Add the third PDF
                                                                                                  // path
                },
                backButtonHandler, primaryStage);
    }
}
