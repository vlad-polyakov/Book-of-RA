package sample;

import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.Map;


public class MainWindow {
    private Game game = new Game();
    private HBox cellsHBox = new HBox();
    public VBox createScene(){
        VBox mainVBox = new VBox();
        ListView<ImageView> column1 = new ListView<>();
        column1.setItems(game.getRandomList());
        mainVBox.getChildren().addAll(column1);
        return mainVBox;
    }

}
