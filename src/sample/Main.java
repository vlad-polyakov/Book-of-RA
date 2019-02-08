package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        MainWindow mainWindow = new MainWindow();
        Scene scene = new Scene(mainWindow.createScene(), 1000, 700);
        scene.getStylesheets().add
                (this.getClass().getResource("/resources/back.css").toExternalForm());
        primaryStage.setTitle("Book of Ra");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
