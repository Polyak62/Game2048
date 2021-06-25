package ru.sbt.oop;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SquareBoard<V> extends Board<Key, V> {

    public SquareBoard(int size) {
        super(size, size);
    }

    @Override
    public void fillBoard(List<V> list) {
        for (int c = 0; c < list.size(); c++) {
            int j = c % weigh;
            int i = c / height;
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
    public void addItem(Key key, V value) {
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
    public V getValue(Key key) {
        return board.get(key);
    }

    @Override
    public List<Key> getColumn(int j) {
        ArrayList<Key> listReturn = new ArrayList<>();
        ArrayList<Key> list = new ArrayList<>(board.keySet());
        list.sort(Comparator.comparingInt(Key::getI));
        for (int c = 0; c < list.size(); c++) {
            if (list.get(c).getJ() == j) {
                listReturn.add(list.get(c));
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
    public boolean hasValue(V value) {
        return board.containsValue(value);
    }

    @Override
    public List<V> getValues(List<Key> keys) {
        List<V> list = new ArrayList<>();
        for (Key key : keys) {
            list.add(board.get(key));
        }
        return list;
    }
}
