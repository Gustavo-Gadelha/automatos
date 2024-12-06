package linguagens;

import automata.DFAutomaton;
import automata.State;

import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        State q0 = new State("q0");
        Set<Character> alphabet = Set.of('0', '1');

        Set<State> states = Set.of(q0);
        Set<State> finals = Set.of();

        DFAutomaton automaton = new DFAutomaton(alphabet, states, q0, finals);
        automaton.transition(q0, '0', q0);
        automaton.transition(q0, '1', q0);

        String input = "";

        if (automaton.accept(input)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
