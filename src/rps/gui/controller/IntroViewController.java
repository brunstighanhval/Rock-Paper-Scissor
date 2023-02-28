package rps.gui.controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.IOException;

public class IntroViewController {

@FXML
    private Button btnPlay;



@FXML
    private void handleButtonPlay()  {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/rps/gui/view/GameView.fxml"));

            Parent root = fxmlLoader.load();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));
            stage.setTitle("The unbeatable Rock Paper Scissor Game has began");

            stage.show();
            stage = (Stage) btnPlay.getScene().getWindow();
            stage.close();
        } catch (IOException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Could not load GameView.fxml");
            alert.showAndWait();
        }
    }

}

