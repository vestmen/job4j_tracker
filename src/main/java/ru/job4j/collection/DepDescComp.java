package ru.job4j.collection;

import java.util.Comparator;
import java.util.Objects;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        return Objects.equals(o1.split("/")[0], o2.split("/")[0])
                ? o1.compareTo(o2) : o2.split("/")[0].compareTo(o1.split("/")[0]);
    }
}
