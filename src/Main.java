import java.util.Set;

public class Main {
    public static void main(String[] args) {
        /* Automata 1 - Aceita todas as cadeias que terminam em 1
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");

        Set<Character> linguagem = Set.of('0', '1');
        Set<Estado> estados = Set.of(q0, q1);
        Set<Estado> finais = Set.of(q1);

        AutomataFD automato = new AutomataFD(linguagem, estados, q0, finais);
        automato.transicao(q0, '0', q0);
        automato.transicao(q0, '1', q1);
        automato.transicao(q1, '0', q0);
        automato.transicao(q1, '1', q1);

        String cadeia = "101011";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
        */

        /*
        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        Set<Character> linguagem = Set.of('0', '1');
        Set<Estado> estados = Set.of(q0, q1, q2, q3);
        Set<Estado> finais = Set.of(q3);

        AutomataFD automato = new AutomataFD(linguagem, estados, q0, finais);
        automato.transicao(q0, '0', q0);
        automato.transicao(q0, '1', q1);
        automato.transicao(q1, '0', q2);
        automato.transicao(q1, '1', q1);
        automato.transicao(q2, '0', q3);
        automato.transicao(q2, '1', q1);
        automato.transicao(q3, '0', q3);
        automato.transicao(q3, '1', q1);

        String cadeia = "101011";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
        */

        Estado q0 = new Estado("q0");
        Estado q1 = new Estado("q1");
        Estado q2 = new Estado("q2");
        Estado q3 = new Estado("q3");

        Set<Character> linguagem = Set.of('0', '1');
        Set<Estado> estados = Set.of(q0, q1, q2, q3);
        Set<Estado> finais = Set.of(q3);

        AutomatoFN automato = new AutomatoFN(linguagem, estados, q0, finais);
        automato.transicao(q0, '0', q0);
        automato.transicao(q0, '1', q0, q1);
        automato.transicao(q1, '0', q2);
        automato.transicao(q1, '1', q2);
        automato.transicao(q2, '0', q3);
        automato.transicao(q2, '1', q3);

        String cadeia = "110000";

        if (automato.aceita(cadeia)) {
            System.out.println("Cadeia aceita por autômata");
        } else {
            System.out.println("Cadeia rejeitada por autômata");
        }
    }
}
