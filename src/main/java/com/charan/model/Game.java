package com.charan.model;

import com.charan.expection.InvaildMoveException;
import com.charan.strategies.WinningAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerMoveIdx;
    private WinningAlgorithm winningAlgorithm;

    public Game(int dimension, List<Player> players){
        this.board =new Board(dimension);
        this.players = players;
        this.moves =new ArrayList<>();
        this.gameState = GameState.InProgrees;
        this.winner = null;
        this.nextPlayerMoveIdx = 0;
        this.winningAlgorithm = new WinningAlgorithm();
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIdx() {
        return nextPlayerMoveIdx;
    }

    public void setNextPlayerMoveIdx(int nextPlayerMoveIdx) {
        this.nextPlayerMoveIdx = nextPlayerMoveIdx;
    }

    public void printBoard(){
        this.board.printboard();
    }

    public boolean vaildMove(Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if(row < 0 || row >= board.getSize() || col < 0 || col >= board.getSize()){
            return  false;
        }
        return board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove(Game game) throws InvaildMoveException {
        Player currPlayer = players.get(nextPlayerMoveIdx);

        Move move = currPlayer.makeMove(board);

        if(!vaildMove(move)){
            throw  new InvaildMoveException("Invaild move made by " + currPlayer.getName());
        }

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        Cell celltoChange = board.getBoard().get(row).get(col);
        celltoChange.setPlayer(currPlayer);
        celltoChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(celltoChange, currPlayer);
        moves.add(finalMove);
        nextPlayerMoveIdx = (nextPlayerMoveIdx + 1) % players.size();

        if (winningAlgorithm.checkwinner(board, finalMove)) {
            gameState = GameState.Ended;
            winner = currPlayer;
        }
    }
}
