package tim.proyektil;

import javafx.stage.Stage;

public class CourseProgramming extends BaseCourseScene {

    public CourseProgramming(javafx.event.EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage) {
        super("Programming",
              new String[]{
                  "/image/Program.png",
                  "/image/C Programming __ The Ultimate Way to Learn The Fundamentals of The C Language. ( PDFDrive ).png"
              },
              new String[]{
                  "/pdf/Komputer dan Dasar Pemrograman ( PDFDrive ).pdf",
                  "/pdf/C Programming __ The Ultimate Way to Learn The Fundamentals of The C Language. ( PDFDrive ).pdf"
              },
              backButtonHandler, primaryStage);
    }
}
