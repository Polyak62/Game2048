package ru.sbt.oop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Board {

    int weigh;
    int height;
    Map<ru.sbt.oop.Key, Integer> board = new HashMap<>();

    public Board(int weigh, int height) {
        this.weigh = weigh;
        this.height = height;
    }

    abstract public void fillBoard(List<Integer> list);

    abstract public List<Key> availableSpace();

    abstract public void addItem(Key key, Integer value);

    abstract public Key getKey(int i, int j);

    abstract public Integer getValue(Key key);

    abstract public List<Key> getColumn(int j);

    abstract public List<Key> getRow(int i);

    abstract public boolean hasValue(Integer value);

    abstract public List<Integer> getValues(List<Key> keys);

}
