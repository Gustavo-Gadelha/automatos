package linguagens.Q9;

import java.util.Set;

public class Q9 {
    public static void main(String[] args) {
        Set<Character> alfabeto = Set.of('0', '1');

        AFD automato = new AFD(alfabeto);

        if(automato.aceita("1100")) {
            System.out.println("Aceita");
        } else {
            System.out.println("Rejeita");
        }
    }
}
