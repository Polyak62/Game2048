package ru.sbt.oop;

import ru.sbt.oop.Board;
import ru.sbt.oop.Direction;
import ru.sbt.oop.Game;

import java.util.Random;

public class Game2048 implements Game {
    GameHelper helper = new GameHelper();
    Board board;
    Random random = new Random();

    public Game2048(Board board){
        this.board = board;
    }

    @Override
    public void init() {

    }

    @Override
    public boolean canMove() {
        return false;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return null;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
