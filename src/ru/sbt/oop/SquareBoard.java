package ru.sbt.oop;

import java.util.ArrayList;
import java.util.List;

public class SquareBoard extends Board {

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    public void fillBoard(List<Integer> list) {
        for (int c = 0; c < list.size(); c++) {
            int i = c % weigh;
            int j = c / height;
            Key key = new Key(i, j);
            board.put(key, list.get(c));
        }
    }

    @Override
    public List<Key> availableSpace() {
        //return board.entrySet().stream().filter(entry -> entry.getValue() == null).map(Map.Entry::getKey).collect(Collectors.toList());
        ArrayList list = new ArrayList();
        for (Key key : board.keySet()) {
            if (board.get(key) == null) {
                list.add(key);
            }
        }
        return list;
    }

    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    @Override
    public Key getKey(int i, int j) {
        for (Key key : board.keySet()) {
            if (key.getI() == i && key.getJ() == j) {
                return key;
            }
        }
        return null;
    }

    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        ArrayList<Key> listReturn = new ArrayList<>();
        for (Key key : board.keySet()) {
            if (key.getJ() == j) {
                listReturn.add(key);
            }
        }
        return listReturn;
    }

    @Override
    public List<Key> getRow(int i) {
        ArrayList<Key> listReturn = new ArrayList<>();
        for (Key key : board.keySet()) {
            if (key.getI() == i) {
                listReturn.add(key);
            }
        }
        return listReturn;
    }

    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> list = new ArrayList<>();
        for (Key key : keys) {
            list.add(board.get(key));
        }
        return list;
    }
}
