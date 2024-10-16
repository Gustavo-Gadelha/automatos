package questoes;

import automata.AutomatoFD;
import automata.Estado;

import java.util.Set;

public class Q4 {
    public static void main(String[] args) {
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Set<Character> linguagem = Set.of('0', '1');

        Set<Estado> estados = Set.of(q0, q1);
        Set<Estado> finais = Set.of(q0);

        AutomatoFD automato = new AutomatoFD(linguagem, estados, q0, finais);
        automato.transicao(q0, '0', q1);
        automato.transicao(q0, '1', q1);
        automato.transicao(q1, '0', q1);
        automato.transicao(q1, '1', q1);

        String cadeia = "101";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
