package linguagens;

import automata.AutomatoFD;
import automata.Estado;

import java.util.Set;

public class Q2 {
    public static void main(String[] args) {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Set<Character> alfabeto = Set.of('0', '1');

        Set<Estado> estados = Set.of(q0, q1, q2);
        Set<Estado> finais = Set.of(q1);

        AutomatoFD automato = new AutomatoFD(alfabeto, estados, q0, finais);
        automato.fazerTransicao(q0, '0', q1);
        automato.fazerTransicao(q0, '1', q2);
        automato.fazerTransicao(q1, '0', q1);
        automato.fazerTransicao(q1, '1', q1);
        automato.fazerTransicao(q2, '0', q2);
        automato.fazerTransicao(q2, '1', q2);

        String cadeia = "0110000";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
