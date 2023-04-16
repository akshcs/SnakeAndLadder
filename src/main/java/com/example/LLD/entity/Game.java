package com.example.LLD.entity;

import com.example.LLD.service.DiceService;

import java.util.LinkedList;
import java.util.Queue;

public class Game {
    private final Board board;
    private final Queue<Player> players;
    private final Queue<Player> winners;
    private final int diceCount;
    private final int dimension;
    private final int cellCount;

    private final DiceService diceService;

    public Game(int dimension, int diceCount) {
        this.diceService = new DiceService();
        this.winners = new LinkedList<>();
        this.dimension = dimension;
        this.cellCount = dimension*dimension;
        this.players = new LinkedList<>();
        this.diceCount = diceCount;
        this.gameStatus = GameStatus.NOT_STARTED;
        this.board = new Board(cellCount);
    }
    private GameStatus gameStatus;

    public void start(){
        gameStatus = GameStatus.RUNNING;
        play();
        printWinners();
        printPositions();
        gameStatus = GameStatus.FINISHED;
    }

    private void play(){
        while (players.size() > 1){
            Player currPlayer = players.poll();
            move(currPlayer);
            if(currPlayer.getCurrentPosition()!=cellCount){
                players.add(currPlayer);
            } else{
                winners.add(currPlayer);
            }
        }
    }

    public void move(Player p){
        moveToPos(p, diceService.roll(diceCount) + p.getCurrentPosition(), p.getCurrentPosition());
    }

    private void moveToPos(Player p, int finalPosition, int currentPos){
        if(board.isOutsideBoard(finalPosition)){
            finalPosition = currentPos;
        } else if(board.isLadderOrSnake(finalPosition)){
            finalPosition = board.getEntity(finalPosition).getEnd();
        }
        p.setCurrentPosition(finalPosition);
        System.out.println(p.getColor()+":"+p.getCurrentPosition());
    }

    private void printPositions() {
        for(Player player : players) {
            System.out.println(player.getColor()+":"+player.getCurrentPosition());
        }
    }
    public void addPlayer(Player p){
        players.add(p);
    }

    public Board getBoard(){
        return board;
    }

    private void printWinners() {
        int rank = 1;
        for(Player player : winners) {
            System.out.println("Rank " + rank + ": " + player.getColor());
            rank++;
        }
    }
}
