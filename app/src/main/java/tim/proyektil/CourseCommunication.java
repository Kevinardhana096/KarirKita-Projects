package tim.proyektil;

import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CourseCommunication extends BaseCourseScene {
    public CourseCommunication(EventHandler<javafx.event.ActionEvent> backButtonHandler, Stage primaryStage){
        super("Communication", 
                new String[]{
                    "/image/Communication Theory.png",
                    "/image/International Communication.png"
                },
                new String[]{
                    "/pdf/communication_theory_media_tech_society.pdf",
                    "/pdf/International Communications Strategy_ Developments in Cross-Cultural Communications, PR and Social Media ( PDFDrive ).pdf"
                },
                backButtonHandler, primaryStage);
    }
}
