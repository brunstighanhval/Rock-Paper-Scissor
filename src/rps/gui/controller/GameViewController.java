package rps.gui.controller;

// Java imports
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import rps.bll.game.Move;
import rps.gui.model.GameModel;

/**
 *
 * @author smsj
 */
public class GameViewController {

    public TextField txtWinningField;
    private GameModel gameModel;

    private Move human_move;

    public GameViewController() {
        this.gameModel = new GameModel();
    }

    public void handleRock(ActionEvent actionEvent) {
        human_move = Move.Rock;
        gameModel.playRound(human_move);
       txtWinningField.setText(gameModel.getWinningPlayer());
    }

    public void handlePaper(ActionEvent actionEvent) {
        human_move = Move.Paper;
        gameModel.playRound(human_move);
        txtWinningField.setText(gameModel.getWinningPlayer());
    }

    public void handleScissor(ActionEvent actionEvent) {
        human_move = Move.Scissor;
        gameModel.playRound(human_move);
        txtWinningField.setText(gameModel.getWinningPlayer());
    }
}
