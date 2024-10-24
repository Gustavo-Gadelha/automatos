package automata;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutomatoFD extends Automato {
    protected final Map<Estado, Map<Character, Estado>> transicoes;

    public AutomatoFD(Set<Character> alfabeto, Set<Estado> estados, Estado inicial, Set<Estado> finais) {
        super(alfabeto, estados, inicial, finais);

        this.transicoes = new HashMap<>();
        this.estados.forEach((estado) -> this.transicoes.put(estado, new HashMap<>()));
    }

    public void fazerTransicao(Estado origem, Character simbolo, Estado destino) {
        this.transicoes.get(origem).put(simbolo, destino);
    }

    public Estado get(Estado origem, Character simbolo) {
        return this.transicoes.get(origem).get(simbolo);
    }

    @Override
    public boolean aceita(String cadeia) {
        Estado atual = this.inicial;

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(simbolo)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            // System.out.printf("%s -> %s -> %s%n", atual, simbolo, this.get(atual, simbolo));
            atual = this.get(atual, simbolo);
        }

        return this.finais.contains(atual);
    }
}
