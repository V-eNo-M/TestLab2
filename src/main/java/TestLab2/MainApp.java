package TestLab2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Optional;

/**
 * Created by 1 on 24.11.2015.
 */
public class MainApp extends Application{
    private static Optional<Callback<Parent>> callback = Optional.empty();

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    public static void onLoad(Callback<Parent> r)
    {
        callback = Optional.of(r);
    }

    @Override
    public void start(Stage stage) throws Exception {
        String fxmlFile = "/fxml/hello.fxml";
        FXMLLoader loader = new FXMLLoader();
        Parent root = (Parent) FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.setTitle("JavaFX and Maven");
        stage.setScene(new Scene(root));
        stage.show();
        /*String fxmlFile = "/fxml/hello.fxml";
        Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.setTitle("Hello World");
        //callback.ifPresent(o -> o.call(root));
        stage.setScene(new Scene(root, stage.getWidth(), stage.getHeight()));
        stage.show();*/
    }
}
