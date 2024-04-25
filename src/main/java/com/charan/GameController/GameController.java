package com.charan.GameController;

import com.charan.model.Game;
import com.charan.model.GameState;
import com.charan.model.Player;

import java.util.List;

public class GameController {
    public Game startgame(int dimension, List<Player> players){
        return new Game(dimension, players);
    }

    public void makeMove(Game game){
        return;
    }

    public GameState checkState(Game game){
        return game.getGameState();
    }

    public  Player getWinner(Game game){
        return game.getWinner();
    }

    public  void printBoard(Game game){
        game.printBoard();
    }

}
