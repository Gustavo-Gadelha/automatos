package linguagens.Q9;

import java.util.Set;

public class AFD {
    private Set<Character> alfabeto;

    public AFD(Set<Character> alfabeto) {
        this.alfabeto = alfabeto;
    }

    public boolean aceita(String cadeia) {
        int qntZero = 0;
        int qntUm = 0;

        for(char simbolo : cadeia.toCharArray()) {
            if(!this.alfabeto.contains(simbolo)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            switch(simbolo) {
                case '0':
                    qntZero++;
                    break;
                case '1':
                    qntUm++;
                    break;
            }
        }

        if(qntZero > qntUm) {
            return true;
        }

        return false;
    }
}
