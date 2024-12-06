package automata;

import java.util.*;
import java.util.stream.Collectors;

public class NFAutomaton extends Automaton {
    protected final Map<State, Map<Character, Set<State>>> transitions;

    public NFAutomaton(Set<Character> alphabet, Set<State> states, State initial, Set<State> finals) {
        super(alphabet, states, initial, finals);
        transitions = new HashMap<>();
    }

    public void transition(State origin, Character character, Set<State> routes) {
        this.transitions
                .computeIfAbsent(origin, _ -> new HashMap<>())
                .put(character, routes);
    }

    public void transition(State origin, Character character, State... routes) {
        this.transitions
                .computeIfAbsent(origin, _ -> new HashMap<>())
                .put(character, Set.of(routes));
    }

    private Set<State> getRoute(State origin, Character character) {
        return this.transitions.get(origin).get(character);
    }

    private Set<State> getRoutes(Set<State> states, Character character) {
        return states.stream()
                .map(each -> this.getRoute(each, character))
                .filter(Objects::nonNull)
                .flatMap(Collection::stream)
                .collect(Collectors.toSet());
    }

    @Override
    public boolean accept(String cadeia) {
        Set<State> states = new HashSet<>();
        states.add(this.initial);

        for (char character : cadeia.toCharArray()) {
            if (!this.alphabet.contains(character)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            states = this.getRoutes(states, character);

            if (states.isEmpty()) {
                return false;
            }
        }

        return states.stream().anyMatch(this.finals::contains);
    }

    public DFAutomaton createDFA() {
        // NFA set of States -> DFA single State
        Map<Set<State>, State> table = new HashMap<>();

        // Mapping the initial States
        Set<State> initialsNFA = Set.of(this.initial);

        State initialDFA = new State(initialsNFA);
        table.put(initialsNFA, initialDFA);

        // Creating the DFA transitions
        Map<State, Map<Character, State>> transitionsDFA = new HashMap<>();

        // Creating processing queue
        Queue<Set<State>> queue = new LinkedList<>();
        queue.add(initialsNFA);

        while (!queue.isEmpty()) {
            Set<State> stateNFA = queue.poll();

            for (Character character : this.alphabet) {
                Set<State> routesNFA = this.getRoutes(stateNFA, character);
                if (routesNFA.isEmpty()) {
                    continue;
                }

                // Check if these routes map to a single state, if not map it to a new single state
                if (!table.containsKey(routesNFA)) {
                    table.put(routesNFA, new State(routesNFA.toString()));
                    queue.add(routesNFA);
                }

                // Making the DFA transitions, use the table as a translator from NFA to DFA
                transitionsDFA
                        .computeIfAbsent(table.get(stateNFA), _ -> new HashMap<>())
                        .put(character, table.get(routesNFA));
            }
        }

        Set<State> statesDFA = Set.copyOf(table.values());

        // Any NFA set, containing at least one state of the NFA set of final states, is a DFA final state
        Set<State> finalsDFA = table.keySet()
                .stream()
                .filter(states -> states.stream().anyMatch(this.finals::contains))
                .map(table::get)
                .collect(Collectors.toSet());

        return new DFAutomaton(this.alphabet, statesDFA, initialDFA, finalsDFA, transitionsDFA);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("> NFAutomaton\n");
        sb.append("Alphabet: ").append(alphabet).append("\n");
        sb.append("States: ").append(states).append("\n");
        sb.append("Initial State: ").append(initial).append("\n");
        sb.append("Final States: ").append(finals).append("\n");
        sb.append("Transitions:\n");

        transitions.forEach((origin, transition) ->
                transition.forEach((character, states) ->
                        sb.append("\tfrom ")
                                .append(origin)
                                .append(" reading ")
                                .append(character)
                                .append(" to ")
                                .append(states)
                                .append("\n")
                )
        );

        return sb.toString();
    }
}
