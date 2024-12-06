package linguagens;

import automata.DFAutomaton;
import automata.State;

import java.util.Set;

public class Q5 {
    public static void main(String[] args) {
        State q0 = new State("q0");
        State q1 = new State("q1");
        Set<Character> alphabet = Set.of('0', '1');

        Set<State> states = Set.of(q0, q1);
        Set<State> finals = Set.of(q1);

        DFAutomaton automaton = new DFAutomaton(alphabet, states, q0, finals);
        automaton.transition(q0, '0', q1);
        automaton.transition(q0, '1', q1);
        automaton.transition(q1, '0', q1);
        automaton.transition(q1, '1', q1);

        String input = "1";

        if (automaton.accept(input)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
