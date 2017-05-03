package sample;

import com.melloware.jintellitype.JIntellitype;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class Main extends Application {
    boolean status=false;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("KeyCheater");
        Scene scene = new Scene(root, 150, 100);
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                KeyCode key = event.getCode();
                if(key == KeyCode.F11){
                    status = true;
                }
                else if(key == KeyCode.F10){
                    System.out.println(Boolean.toString(status));
                }
                else if(key == KeyCode.F12){
                    status = false;
                }
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
