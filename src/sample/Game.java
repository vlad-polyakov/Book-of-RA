package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Game {
    private int bet;
    private int cash;
    private int previousWinCash;
    private int winCash;
    private int numberOfLines;
    private ObservableList<CasinoCell> cellArray;
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
           }
           public ObservableList<ImageView> getRandomList(){
                ObservableList<ImageView> list = FXCollections.observableArrayList();
                ObservableList<CasinoCell> tempCellsList = cellArray;
               Random random = new Random();
               while(tempCellsList.size()>0){
                    int index = random.nextInt(tempCellsList.size());
                    list.add(tempCellsList.get(index).getImage());
                    tempCellsList.remove(index);
               }
                return list;
           }
}
