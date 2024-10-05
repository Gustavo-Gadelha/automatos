import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AutomatoFN {
    private final Set<Character> linguagem;
    private final Set<Estado> estados;
    private final Map<Estado, Map<Character, Set<Estado>>> transicoes;
    private final Estado inicial;
    private final Set<Estado> finais;

    public AutomatoFN(Set<Character> linguagem, Set<Estado> estados, Estado inicial, Set<Estado> finais) {
        this.linguagem = linguagem;
        this.estados = estados;
        this.inicial = inicial;
        this.finais = finais;

        this.transicoes = new HashMap<>();
        this.estados.forEach((estado) -> transicoes.put(estado, new HashMap<>()));
    }

    public void transicao(Estado origem, Character simbolo, Estado... destinos) {
        this.transicoes.get(origem).put(simbolo, Set.of(destinos));
    }

    public boolean aceita(String cadeia) {
        Set<Estado> atuais = new HashSet<>();
        atuais.add(this.inicial);

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.linguagem.contains(simbolo)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            Set<Estado> rotas = new HashSet<>();
            for (Estado atual : atuais) {
                Set<Estado> destinos = this.transicoes.get(atual).get(simbolo);
                if (destinos != null) {
                    rotas.addAll(destinos);
                }
            }

            atuais = rotas;

            if (atuais.isEmpty()) {
                return false;
            }
        }

        for (Estado atual : atuais) {
            if (this.finais.contains(atual)) {
                return true;
            }
        }

        return false;
    }
}
