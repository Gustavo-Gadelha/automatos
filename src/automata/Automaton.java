package automata;

import java.util.Set;

public abstract class Automaton {
    protected final Set<Character> alphabet;
    protected final Set<State> states;
    protected final State initial;
    protected final Set<State> finals;

    public Automaton(Set<Character> alphabet, Set<State> states, State initial, Set<State> finals) {
        this.alphabet = alphabet;
        this.states = states;
        this.initial = initial;
        this.finals = finals;
    }

    public abstract boolean accept(String input);
}
