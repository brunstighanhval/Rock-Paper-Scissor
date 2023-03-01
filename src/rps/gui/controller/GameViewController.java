package rps.gui.controller;


// Java imports
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import rps.bll.game.Move;
import rps.gui.model.GameModel;

import javafx.fxml.FXML;

import java.net.URL;
import java.util.ResourceBundle;


/**
 *
 * @author smsj
 */
public class GameViewController implements Initializable {
    @FXML
    private Label lblAI, lblPlayer;
    @FXML
    private Label txtWinningField;
    private GameModel gameModel;
    private Move human_move;

    public GameViewController() {
        this.gameModel = new GameModel();
    }

    public void handleRock(ActionEvent actionEvent) {
        human_move = Move.Rock;
        gameModel.playRound(human_move);
       txtWinningField.setText(gameModel.getWinningPlayer());
       updateScore();
    }

    public void handlePaper(ActionEvent actionEvent) {
        human_move = Move.Paper;
        gameModel.playRound(human_move);
        txtWinningField.setText(gameModel.getWinningPlayer());
        updateScore();
    }

    public void handleScissor(ActionEvent actionEvent) {
        human_move = Move.Scissor;
        gameModel.playRound(human_move);
        txtWinningField.setText(gameModel.getWinningPlayer());
        updateScore();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        updateScore();
    }

    private void updateScore(){
        lblAI.setText(gameModel.getAIName() + ": " + gameModel.getAIScore());
        lblPlayer.setText(gameModel.getPlayerName() + ": " + gameModel.getPlayerScore());
    }
}
