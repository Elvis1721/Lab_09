package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple implementation of the {@link Controller} interface.
 */
public final class SimpleController implements Controller {

    private String string;
    private final List<String> history;

    /**
     * Constructor of the class SimpleController.
     */
    public SimpleController() {
        this.string = "";
        this.history = new ArrayList<>();
    }

    @Override
    public void setString(final String next) {
        if (next == null) {
            throw new IllegalArgumentException();
        }
        this.history.add(next);
        this.string = next;
    }

    @Override
    public String getNextString() {
        return this.string;
    }

    @Override
    public List<String> getHistory() {
        return new ArrayList<>(this.history);
    }

    @Override
    public void printString() {
        if (this.string.isEmpty()) {
            throw new IllegalStateException();
        }
        System.out.println(this.string);
    }
}
