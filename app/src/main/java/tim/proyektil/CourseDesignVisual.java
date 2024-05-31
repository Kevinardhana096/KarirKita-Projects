package tim.proyektil;

import javafx.stage.Stage;

public class CourseDesignVisual extends BaseCourseScene {

    public CourseDesignVisual(javafx.event.EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        super("Design Visual",
              new String[]{
                  "/image/Computer Graphic.png",
                  "/image/Introdution Visual.png",
                  "/image/Fundamental .png" 
              },
              new String[]{
                  "/pdf/Computer Graphics Through OpenGL_ From Theory to Experiments ( PDFDrive ).pdf",
                  "/pdf/Introduction to Visual Computing_ Core Concepts in Computer Vision, Graphics, and Image Processing ( PDFDrive ).pdf",
                  "/pdf/Fundamentals of Computer Graphics, Fourth Edition ( PDFDrive ).pdf" // Add the third PDF path
              },
              backButtonHandler, primaryStage);
    }
}
