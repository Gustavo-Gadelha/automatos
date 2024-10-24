package linguagens;

import automata.AutomatoFD;
import automata.Estado;

import java.util.Set;

public class Q3 {
    public static void main(String[] args) {
        Estado q0 = new Estado("q0");
        Set<Character> alfabeto = Set.of('0', '1');

        Set<Estado> estados = Set.of(q0);
        Set<Estado> finais = Set.of();

        AutomatoFD automato = new AutomatoFD(alfabeto, estados, q0, finais);
        automato.fazerTransicao(q0, '0', q0);
        automato.fazerTransicao(q0, '1', q0);

        String cadeia = "";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
