package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game {
    private int bet = 0;
    private int cash = 0;
    private int totalBet;
    private int previousWinCash;
    private int winCash;
    private int numberOfLines;
    private ObservableList<CasinoCell> cellArray;
    private ObservableList<ObservableList<ImageView>> imagesList;
    private CasinoCell tenCell;
    private CasinoCell JCell;
    private CasinoCell QCell;
    private CasinoCell KCell;
    private CasinoCell ACell;
    private CasinoCell birdCell;
    private CasinoCell bugCell;
    private CasinoCell pharaohCell;
    private CasinoCell manCell;
    public Game(){
        tenCell = new CasinoCell("/images/10.jpg",0,5,25,100);
        JCell = new CasinoCell("/images/j.jpg",0,5,25,100);
        QCell = new CasinoCell("/images/q.jpg",0,5,25,100);
        KCell = new CasinoCell("/images/k.jpg",0,5,40,150);
        ACell = new CasinoCell("/images/a.jpg",0,5,40,150);
        birdCell= new CasinoCell("/images/bird.jpg",5,30,100,750);
        bugCell= new CasinoCell("/images/bug.jpg",5,30,100,750);
        pharaohCell= new CasinoCell("/images/pharaoh.jpg",5,40,400,2000);
        manCell = new CasinoCell("/images/man.jpg",10,100,1000,5000);
        cellArray = FXCollections.observableArrayList(tenCell,JCell,QCell,KCell,ACell,birdCell,bugCell,pharaohCell,manCell
        );
        imagesList = FXCollections.observableArrayList();
           }
           public void randomizeImagesList(){
               Random random = new Random();
               for(int j=0;j<5;j++) {
                   ObservableList<ImageView> list = FXCollections.observableArrayList();
                   for (int i = 0; i < cellArray.size(); i++) {
                       int index = random.nextInt(cellArray.size());
                       list.add(cellArray.get(index).getImageView());
                   }
                   imagesList.add(list);
               }

           }

    public CasinoCell getACell() {
        return ACell;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    public int getBet() {
        return bet;
    }

    public void setBet(int bet) {
        this.bet = bet;
    }
    public void increaseBet(){
        bet++;
    }
    public void decreaseBet(){
        if (bet>1)bet--;
    }
    public void increaseLine(){
        if(numberOfLines<9) numberOfLines++;
    }

    public void decreaseLine(){
        if(numberOfLines>1) numberOfLines--;
    }
    public ObservableList<ObservableList<ImageView>> getImagesList() {
        return imagesList;
    }

    public int getNumberOfLines() {
        return numberOfLines;
    }
}
