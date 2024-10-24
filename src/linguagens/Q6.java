package linguagens;

import automata.AutomatoFD;
import automata.Estado;

import java.util.Set;

public class Q6 {
    public static void main(String[] args) {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");
        Set<Character> linguagem = Set.of('0', '1');

        Set<Estado> estados = Set.of(q0, q1, q2, q3);
        Set<Estado> finais = Set.of(q3);

        AutomatoFD automato = new AutomatoFD(linguagem, estados, q0, finais);
        automato.fazerTransicao(q0, '0', q1);
        automato.fazerTransicao(q0, '1', q0);
        automato.fazerTransicao(q1, '0', q1);
        automato.fazerTransicao(q1, '1', q2);
        automato.fazerTransicao(q2, '0', q3);
        automato.fazerTransicao(q2, '1', q0);
        automato.fazerTransicao(q3, '0', q3);
        automato.fazerTransicao(q3, '1', q3);

        String cadeia = "111111010";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
