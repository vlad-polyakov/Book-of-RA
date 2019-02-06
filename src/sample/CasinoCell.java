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
    private Image image;
    public CasinoCell(String url, int doubleCellBonus, int trippleCellBonus, int fourthCellBonus, int fiveCellBonus){
        Class<?> clazz = this.getClass();
        InputStream input = clazz.getResourceAsStream(url);
        image = new Image(input);
        imageView = new ImageView(image);
        imageView.setFitHeight(120);
        imageView.setFitWidth(120);
        this.doubleCellBonus = doubleCellBonus;
        this.trippleCellBonus = trippleCellBonus;
        this.fourthCellBonus = fourthCellBonus;
        this.fiveCellBonus = fiveCellBonus;
    }
    public ImageView getImageView(){
        return  imageView;
    }

    public Image getImage() {
        return image;
    }
}
