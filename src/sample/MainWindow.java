package sample;

import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.io.InputStream;


public class MainWindow {
    private HBox buttonsBox = new HBox(15);
    private Label betNumLabel;
    private Label lineNumLabel;
    Canvas canvas = new Canvas(800, 450);
    private Controller controller;
    public VBox createScene(){
        VBox mainVBox = new VBox(10);
        controller = new Controller(this);
        createButtons();
        mainVBox.getChildren().addAll(createCellsArea(),buttonsBox);
        return mainVBox;
    }

   public Canvas createCellsArea() {
       ObservableList<ObservableList<ImageView>> list = controller.randomizeCells();
       System.out.println(list.size());
       int x=0;
       int y=0;
       for(int i=0;i<list.get(0).size();i++){
           canvas.getGraphicsContext2D().drawImage(additionalElem(),x,y,7,150);
           y+=150;
       }
       x+=7;
       for(int i=0;i<list.size();i++) {
           y=0;
           for(int j=0;j<list.get(i).size(); j++) {
               canvas.getGraphicsContext2D().drawImage(list.get(i).get(j).getImage(),x,y,150,150);
               canvas.getGraphicsContext2D().drawImage(additionalElem(),x+150,y,7,150);

               y+=150;
           }
           x+=157;
       }
       return canvas;
   }
    public void createButtons(){
       // buttonsBox.setStyle("-fx-background-color: dimgray");
        buttonsBox.setAlignment(Pos.CENTER);
        Button autoPlayBut = new Button("Auto");
        VBox creditBox = new VBox(5);
        Label cashLabel = new Label("Credits");
        cashLabel.setFont(new Font("Arial",20));
        Label cashNumLabel = new Label("0");
        cashNumLabel.setFont(new Font("Arial",30));
        creditBox.getChildren().addAll(cashLabel,cashNumLabel);
        VBox betsBox = new VBox(5);
        betsBox.setAlignment(Pos.CENTER);
        Label betLabel = new Label("Bet");
        betNumLabel = new Label("1");
        betLabel.setFont(new Font("Arial",20));
        betNumLabel.setFont(new Font("Arial",30));
        HBox changeBetsBox = new HBox(4);
        Button increaseBetBut = new Button("+");
        increaseBetBut.setOnAction(event -> controller.riseBet());
        Button decreaseBetBut = new Button("-");
        decreaseBetBut.setOnAction(event -> controller.lowBet());
        VBox linesBox = new VBox(5);
        linesBox.setAlignment(Pos.CENTER);
        Label lineLabel = new Label("Lines");
        lineLabel.setFont(new Font("Arial",20));
        HBox changeLinesBox = new HBox(5);
        Button riseLineBut = new Button("+");
        riseLineBut.setOnAction(event -> controller.riseLine());
        Button fallLineBut = new Button("-");
        fallLineBut.setOnAction(event -> controller.lowLine());
        lineNumLabel = new Label("1");
        lineNumLabel.setFont(new Font("Arial",30));
        changeLinesBox.getChildren().addAll(fallLineBut,lineNumLabel,riseLineBut);
        VBox totalBetBox = new VBox(5);
        Label totalBetLabel = new Label("Total Bet");
        Label totalBetNumLabel = new Label("1");
        totalBetLabel.setFont(new Font("Arial",20));
        totalBetNumLabel.setFont(new Font("Arial",30));
        totalBetBox.getChildren().addAll(totalBetLabel,totalBetNumLabel);
        linesBox.getChildren().addAll(lineLabel,changeLinesBox);
        changeBetsBox.getChildren().addAll(decreaseBetBut,betNumLabel,increaseBetBut);
        betsBox.getChildren().addAll(betLabel,changeBetsBox);
        betLabel.setStyle("-fx-background-color: dimgray");
        Button playBut = new Button("Play");
        buttonsBox.getChildren().addAll(autoPlayBut,creditBox,betsBox,linesBox,totalBetBox, playBut);
    }

    public Image additionalElem(){
        Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream("/images/between.jpg");
        Image image = new Image(input);
        return image;
    }
    public void updateBet(String bet){
        betNumLabel.setText(bet);
    }
    public void updateLine(String line){
        lineNumLabel.setText(line);
    }
}
