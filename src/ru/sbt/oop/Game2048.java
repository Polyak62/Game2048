package ru.sbt.oop;

import java.util.List;
import java.util.Random;

public class Game2048 implements Game {
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);
    GameHelper helper = new GameHelper();
    Random random = new Random();

//    public Game2048(Board board){
//        this.board = board;
//    }

    @Override
    public void init() {
//закинуть в board две рандомные ячейки (два ключа со значением i и j)
        //сгенирировать 2 рандомных разных ключа и положить их в board
        // вызовом метода getItem
        addItem();
        addItem();


    }

    @Override
    public boolean canMove() {
        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> listKey = board.getRow(i);
            List listValue = board.getValues(listKey);
            for (int j = 0; j < GAME_SIZE - 1; j++) {
                if (listValue.get(j) == null || listValue.get(j + 1) == null) {
                    return true;
                }
                if (listValue.get(j) == listValue.get(j + 1)) {
                    return true;
                }
            }
        }

        for (int i = 0; i < GAME_SIZE; i++) {
            List<Key> listKey = board.getColumn(i);
            List listValue = board.getValues(listKey);
            for (int j = 0; j < GAME_SIZE - 1; j++) {
                if (listValue.get(j) == null || listValue.get(j + 1) == null) {
                    return true;
                }
                if (listValue.get(j) == listValue.get(j + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean move(Direction direction) {
        return false;
    }

    @Override
    public void addItem() {
        Key key = new Key(1 + (int) (Math.random() * ((GAME_SIZE - 1) + 1)), (1 + (int) (Math.random() * ((GAME_SIZE - 1) + 1))));
        board.addItem(key, 2);
    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
