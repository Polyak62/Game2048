package ru.sbt.oop;

import java.util.ArrayList;
import java.util.List;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        ArrayList<Integer> listNotNull = new ArrayList<>();
        ArrayList<Integer> mergeList = new ArrayList<>();
        for (Integer count : list) {
            if (count != null) {
                listNotNull.add(count);
            }
        }

        for (int i = 0; i < listNotNull.size(); i++) {
            if (listNotNull.get(i).equals(listNotNull.get(i - 1))) {
                mergeList.add(listNotNull.get(i - 1) * 2);
            }
        }

        int countNull = list.size() - mergeList.size();
        for (int i = 0; i < countNull; i++) {
            mergeList.add(null);
        }
        return mergeList;
    }
}
