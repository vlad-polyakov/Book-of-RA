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
        game.calculateTotalBet();
        mainWindow.updateBet(String.valueOf(game.getBet()));
        mainWindow.updateTotalBet(String.valueOf(game.getTotalBet()));
    }

    public void lowBet(){
        game.decreaseBet();
        game.calculateTotalBet();
        mainWindow.updateBet(String.valueOf(game.getBet()));
        mainWindow.updateTotalBet(String.valueOf(game.getTotalBet()));
    }

    public void riseLine(){
        game.increaseLine();
        game.calculateTotalBet();
        mainWindow.updateLine(String.valueOf(game.getNumberOfLines()));
        mainWindow.updateTotalBet(String.valueOf(game.getTotalBet()));
    }

    public void lowLine(){
        game.decreaseLine();
        game.calculateTotalBet();
        mainWindow.updateLine(String.valueOf(game.getNumberOfLines()));
        mainWindow.updateTotalBet(String.valueOf(game.getTotalBet()));
    }
}
