package com.charan.model;

import java.util.Scanner;

public class Player {
    private  String name;
    private Symbol symbol;
    private  PlayerType playerType;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol, PlayerType playerType) {
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }

    public Move makeMove(Board board){
        System.out.println("Plaese enter row no. where you want to move !!");
        int row = scanner.nextInt();

        System.out.println("Plaese enter col no. where you want to move !!");
        int col = scanner.nextInt();


        return new Move(new Cell(row, col),this);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public static Scanner getScanner() {
        return scanner;
    }

    public static void setScanner(Scanner scanner) {
        Player.scanner = scanner;
    }
}
