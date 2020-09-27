package ui;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author diegoa.torres
 * @author jcguerra
 * @author Isabella
 *
 */
public class TI_1 extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader root = new FXMLLoader(getClass().getResource("Back.fxml"));
        root.setController(new ControllerMenu());
        Parent p =  root.load();
        Scene scene = new Scene(p);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
