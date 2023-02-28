package rps.gui.model;

import rps.bll.game.GameManager;
import rps.bll.game.Move;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

public class GameModel {

    private GameManager gameManager;
    IPlayer human = new Player("REEEE", PlayerType.Human);
    IPlayer bot = new Player("R2D2", PlayerType.AI);

    public GameModel() {
        this.gameManager = new GameManager(human, bot);
    }
    public void playRound(Move human_move){
        gameManager.playRound(human_move);
    }

    public String getWinningPlayer(){
        String winningPlayer = gameManager.getWinningPlayer();
        return winningPlayer;
    }
}
