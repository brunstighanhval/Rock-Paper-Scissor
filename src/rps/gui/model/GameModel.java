package rps.gui.model;

import rps.bll.game.GameManager;
import rps.bll.game.Move;
import rps.bll.player.IPlayer;
import rps.bll.player.Player;
import rps.bll.player.PlayerType;

public class GameModel {

    private GameManager gameManager;
    IPlayer human = new Player("Luke Skypewalker", PlayerType.Human);
    IPlayer bot = new Player("ArtoD2", PlayerType.AI);

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

    public int getPlayerScore() {
        int updatedScore = gameManager.getPlayerScore();
        return updatedScore;
    }

    public int getAIScore() {
        int updatedScore = gameManager.getAiScore();
        return updatedScore;
    }
    public String getPlayerName(){
        return human.getPlayerName();
    }

    public String getAIName(){
        return bot.getPlayerName();
    }
}
