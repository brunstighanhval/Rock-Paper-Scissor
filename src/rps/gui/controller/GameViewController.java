package rps.gui.controller;

import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 *
 * @author smsj
 */
public class GameViewController {


    public ImageView RockImg, PaperImg, ScissorsImg;
    public void setup(){
        Image logoImage1,logoImage2,logoImage3;

        try{
            logoImage1 = new Image(new FileInputStream("/Resources/Pic/Rock.png"));
            logoImage2 = new Image(new FileInputStream("/Resources/Pic/Paper.png"));
            logoImage3 = new Image(new FileInputStream("/Resources/Pic/Scissors.png"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        RockImg.setImage(logoImage1);
        PaperImg.setImage(logoImage2);
        ScissorsImg.setImage(logoImage3);
    }
    public void handleRock(ActionEvent actionEvent) {

    }

    public void handlePaper(ActionEvent actionEvent) {
    }

    public void handleScissor(ActionEvent actionEvent) {
    }
}
