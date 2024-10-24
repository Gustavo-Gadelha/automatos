package automata;

import java.util.Set;

public abstract class Automato {
    protected final Set<Character> alfabeto;
    protected final Set<Estado> estados;
    protected final Estado inicial;
    protected final Set<Estado> finais;

    public Automato(Set<Character> alfabeto, Set<Estado> estados, Estado inicial, Set<Estado> finais) {
        this.alfabeto = alfabeto;
        this.estados = estados;
        this.inicial = inicial;
        this.finais = finais;
    }

    public abstract boolean aceita(String input);
}
