package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {
    private final Deque<Character> descendingElements;
    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder s = new StringBuilder();
        int size = evenElements.size();
        for (int index = 0; index < size; index += 2) {
            s.append(evenElements.pollFirst());
            evenElements.pollFirst();
        }
        return s.toString();
    }

    private String getDescendingElements() {
        StringBuilder s = new StringBuilder();
        int size = descendingElements.size();
        for (int index = 0; index < size; index++) {
            s.append(descendingElements.pollLast());
        }
        return s.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
