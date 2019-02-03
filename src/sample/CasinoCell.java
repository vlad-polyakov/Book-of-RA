package sample;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


import java.io.InputStream;

public class CasinoCell {
    private ImageView imageView;
    private int doubleCellBonus;
    private int trippleCellBonus;
    private int fourthCellBonus;
    private int fiveCellBonus;
    public CasinoCell(String url, int doubleCellBonus, int trippleCellBonus, int fourthCellBonus, int fiveCellBonus){
        Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream(url);
        Image image = new Image(input);
        imageView = new ImageView(image);
        this.doubleCellBonus = doubleCellBonus;
        this.trippleCellBonus = trippleCellBonus;
        this.fourthCellBonus = fourthCellBonus;
        this.fiveCellBonus = fiveCellBonus;
    }
    public ImageView getImage(){
        return  imageView;
    }

}
