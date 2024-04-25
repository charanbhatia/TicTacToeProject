package com.charan;

import com.charan.GameController.GameController;
import com.charan.model.*;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner scanner = new Scanner(System.in);
        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Harsh", new Symbol('X'), PlayerType.HUMAN),
                new Bot("Scaler", new Symbol('O'), PlayerType.BOT, BotDiffultLevel.EASY)
        );

        Game game = gameController.startgame(dimension, players);

        while (game.getGameState().equals(GameState.InProgrees)) {
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (!gameController.checkState(game).equals(GameState.Ended)) {
            game.setGameState(GameState.Draw);
            System.out.println("Game DRAW");
        } else {
            gameController.printBoard(game);
            System.out.println("Player " + gameController.getWinner(game).getName() + " is the winner");
        }



    }
}