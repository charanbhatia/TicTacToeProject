package com.charan.model;

import java.util.List;

public class Bot extends Player{
    private BotDiffultLevel botDiffultLevel;

    public Bot(String name, Symbol symbol, PlayerType playerType, BotDiffultLevel botDiffultLevel) {
        super(name, symbol, playerType);
        this.botDiffultLevel = botDiffultLevel;
    }

    @Override
    public Move makeMove(Board board) {
        for(List<Cell> row : board.getBoard()){
            for(Cell cell : row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    return new Move(cell, this);
                }
            }
        }
        return null;
    }
}
