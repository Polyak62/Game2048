package ru.sbt.oop;

import ru.sbt.oop.Board;
import ru.sbt.oop.Direction;

public interface Game {
    void init();
    boolean canMove();
    boolean move (Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();
}
