package sample;

import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

public class Controller {
    private Game game;
    private MainWindow mainWindow;
    private ObservableList<ObservableList<ImageView>> imagesList;
    public Controller (MainWindow mainWindow){
      game = new Game();
      this.mainWindow = mainWindow;
    }
    public ObservableList<ObservableList<ImageView>> randomizeCells(){
        if(imagesList==null) {
            game.randomizeImagesList();
            imagesList = game.getImagesList();
        }
        else {
            imagesList.remove(0,imagesList.size());
            game.randomizeImagesList();
            imagesList = game.getImagesList();
        }
        return imagesList;
    }
    public void riseBet(){
        game.increaseBet();
        mainWindow.updateBet(String.valueOf(game.getBet()));
    }
    public void lowBet(){
        game.decreaseBet();
        mainWindow.updateBet(String.valueOf(game.getBet()));
    }
    public void riseLine(){
        game.increaseLine();
        mainWindow.updateLine(String.valueOf(game.getNumberOfLines()));
    }
    public void lowLine(){
        game.decreaseLine();
        mainWindow.updateLine(String.valueOf(game.getNumberOfLines()));
    }
}
