package automata;

import java.util.Set;

public class State {
    private final String name;

    public State(String name) {
        this.name = name;
    }

    public State(Set<State> states) {
        this.name = states.toString();
    }

    @Override
    public String toString() {
        return name;
    }
}
