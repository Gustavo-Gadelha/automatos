package automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DFAutomaton extends Automaton {
    protected final Map<State, Map<Character, State>> transitions;

    public DFAutomaton(Set<Character> alphabet, Set<State> states, State initial, Set<State> finals, Map<State, Map<Character, State>> transitions) {
        super(alphabet, states, initial, finals);
        this.transitions = transitions;
    }

    public DFAutomaton(Set<Character> alphabet, Set<State> states, State initial, Set<State> finals) {
        this(alphabet, states, initial, finals, new HashMap<>());
    }

    public void transition(State origin, Character character, State route) {
        this.transitions
                .computeIfAbsent(origin, _ -> new HashMap<>())
                .put(character, route);
    }

    private State getRoute(State origin, Character character) {
        return this.transitions.get(origin).get(character);
    }

    @Override
    public boolean accept(String cadeia) {
        State current = this.initial;

        for (char character : cadeia.toCharArray()) {
            if (!this.alphabet.contains(character)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            // System.out.printf("%s -> %s -> %s%n", atual, simbolo, this.get(atual, simbolo));
            current = this.getRoute(current, character);
        }

        return this.finals.contains(current);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("> DFAutomaton\n");
        sb.append("Alphabet: ").append(alphabet).append("\n");
        sb.append("States: ").append(states).append("\n");
        sb.append("Initial State: ").append(initial).append("\n");
        sb.append("Final States: ").append(finals).append("\n");
        sb.append("Transitions:\n");

        transitions.forEach((origin, transition) ->
                transition.forEach((character, state) ->
                        sb.append("\tfrom ")
                                .append(origin)
                                .append(" reading ")
                                .append(character)
                                .append(" to ")
                                .append(state)
                                .append("\n")
                )
        );

        return sb.toString();
    }
}
