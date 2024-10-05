import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class AutomatoFD {
    private final Set<Character> linguagem;
    private final Set<Estado> estados;
    private final Map<Estado, Map<Character, Estado>> transicoes;
    private final Estado inicial;
    private final Set<Estado> finais;

    public AutomatoFD(Set<Character> linguagem, Set<Estado> estados, Estado inicial, Set<Estado> finais) {
        this.linguagem = linguagem;
        this.estados = estados;
        this.inicial = inicial;
        this.finais = finais;

        this.transicoes = new HashMap<>();
        this.estados.forEach((estado) -> transicoes.put(estado, new HashMap<>()));
    }

    public void transicao(Estado origem, Character simbolo, Estado destino) {
        this.transicoes.get(origem).put(simbolo, destino);
    }

    public boolean aceita(String cadeia) {
        Estado atual = this.inicial;

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.linguagem.contains(simbolo)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            atual = this.transicoes.get(atual).get(simbolo);
        }

        return this.finais.contains(atual);
    }
}
