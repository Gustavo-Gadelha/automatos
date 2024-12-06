package linguagens;

import automata.DFAutomaton;
import automata.State;

import java.util.Set;

public class Q6 {
    public static void main(String[] args) {
        State q0 = new State("q0");
        State q1 = new State("q1");
        State q2 = new State("q2");
        State q3 = new State("q3");
        Set<Character> alphabet = Set.of('0', '1');

        Set<State> states = Set.of(q0, q1, q2, q3);
        Set<State> finals = Set.of(q3);

        DFAutomaton automaton = new DFAutomaton(alphabet, states, q0, finals);
        automaton.transition(q0, '0', q1);
        automaton.transition(q0, '1', q0);
        automaton.transition(q1, '0', q1);
        automaton.transition(q1, '1', q2);
        automaton.transition(q2, '0', q3);
        automaton.transition(q2, '1', q0);
        automaton.transition(q3, '0', q3);
        automaton.transition(q3, '1', q3);

        String input = "111111010";

        if (automaton.accept(input)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
