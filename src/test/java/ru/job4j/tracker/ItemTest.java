package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ItemTest {
    @Test
    public void whenItemAscByName() {
        List<Item> items = new ArrayList<>(List.of(new Item("A"), new Item("D"), new Item("C"), new Item("B")));
        Collections.sort(items, new ItemAscByName());
        List<Item> expected = new ArrayList<>(List.of(new Item("A"), new Item("B"), new Item("C"), new Item("D")));
        assertThat(items).isEqualTo(expected);
    }

    @Test
    public void whenItemDescByName() {
        List<Item> items = new ArrayList<>(List.of(new Item("A"), new Item("D"), new Item("C"), new Item("B")));
        Collections.sort(items, new ItemDescByName());
        List<Item> expected = new ArrayList<>(List.of(new Item("D"), new Item("C"), new Item("B"), new Item("A")));
        assertThat(items).isEqualTo(expected);
    }
}