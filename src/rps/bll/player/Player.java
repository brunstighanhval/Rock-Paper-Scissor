package rps.bll.player;

//Project imports
import rps.bll.game.IGameState;
import rps.bll.game.Move;
import rps.bll.game.Result;

//Java imports
import java.util.ArrayList;
import java.util.Random;

/**
 * Example implementation of a player.
 *
 * @author smsj
 */
public class Player implements IPlayer {


    private String name;
    private PlayerType type;

    private Move move;

    /**
     * @param name
     */
    public Player(String name, PlayerType type) {
        this.name = name;
        this.type = type;
    }


    @Override
    public String getPlayerName() {
        return name;
    }


    @Override
    public PlayerType getPlayerType() {
        return type;
    }


    /**
     * Decides the next move for the bot...
     *
     * @param state Contains the current game state including historic moves/results
     * @return Next move
     */
    @Override
    public Move doMove(IGameState state) {
        //Historic data to analyze and decide next move...
        ArrayList<Result> results = (ArrayList<Result>) state.getHistoricResults();

        //Implement better AI here...


        if (results.size() == 0) {
            Random randomNumber = new Random();
            int resultNumber = randomNumber.nextInt(3);

            switch (resultNumber) {
                case 0 -> move = Move.Paper;
                case 1 -> move = Move.Scissor;
                case 2 -> move = Move.Rock;
            }
        } else {
            double paperCount = 0, rockCount = 0, scissorCount = 0;
            for (int i = 0; i < results.size(); i++) {
                String winningMove = results.get(i).getWinnerMove().toString();
                switch (winningMove) {
                    case "Paper":
                        paperCount++;
                        break;
                    case "Rock":
                        rockCount++;
                        break;
                    case "Scissor":
                        scissorCount++;
                        break;
                }

                double paperCountPro = paperCount / results.size();
                double rockCountPro = rockCount / results.size();


                double scissorCountPro = scissorCount / results.size();



                final double MAKS = 0.50;
                double difference;
                if (paperCountPro >= MAKS) {

                    difference = paperCountPro - MAKS;
                    paperCountPro = MAKS;
                    rockCountPro = rockCountPro + difference / 2;
                    scissorCountPro = scissorCountPro + difference / 2;
                } else if (rockCountPro >= MAKS) {

                    difference = rockCountPro - MAKS;
                    rockCountPro = MAKS;

                    paperCountPro = paperCountPro + difference / 2;
                    scissorCountPro = scissorCountPro + difference / 2;

                } else if (scissorCountPro >= MAKS) {
                    difference = scissorCountPro - MAKS;
                    scissorCountPro = MAKS;
                    paperCountPro = paperCountPro + difference / 2;
                    rockCountPro = rockCountPro + difference / 2;
                }


                //double scissorCountPro = scissorCount/ results.size();
                System.out.println("Første" + rockCountPro + " " + paperCountPro + " " + scissorCountPro);


                Random newRandomNumber = new Random();
                int newResultNumber = newRandomNumber.nextInt(99) + 1;

                    if (newResultNumber <= paperCountPro * 100)
                        move = Move.Paper;
                     else if (newResultNumber <= paperCountPro * 100 + rockCountPro * 100)
                        move = Move.Rock;
                     else
                        move = Move.Scissor;
            }



        }


        return move;
}
}