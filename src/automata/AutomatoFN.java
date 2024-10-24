package automata;

import java.util.*;

public class AutomatoFN extends Automato {
    protected final Map<Estado, Map<Character, Set<Estado>>> transicoes;

    public AutomatoFN(Set<Character> alfabeto, Set<Estado> estados, Estado inicial, Set<Estado> finais) {
        super(alfabeto, estados, inicial, finais);

        this.transicoes = new HashMap<>();
        this.estados.forEach((estado) -> this.transicoes.put(estado, new HashMap<>()));
    }

    public void fazerTransicao(Estado origem, Character simbolo, Set<Estado> destinos) {
        this.transicoes.get(origem).put(simbolo, destinos);
    }

    public Set<Estado> get(Estado origem, Character simbolo) {
        return this.transicoes.get(origem).get(simbolo);
    }

    public Set<Estado> getAll(Set<Estado> origens, Character simbolo) {
        Set<Estado> destinos = new HashSet<>();
        for (Estado origem : origens) {
            Set<Estado> destino = this.get(origem, simbolo);
            if (destino != null) {
                destinos.addAll(destino);
            }
        }

        return destinos;
    }

    @Override
    public boolean aceita(String cadeia) {
        Set<Estado> atuais = new HashSet<>();
        atuais.add(this.inicial);

        for (char simbolo : cadeia.toCharArray()) {
            if (!this.alfabeto.contains(simbolo)) {
                throw new RuntimeException("Simbolo não faz parte do alfabeto");
            }

            atuais = this.getAll(atuais, simbolo);

            if (atuais.isEmpty()) {
                return false;
            }
        }

        atuais.retainAll(finais);
        return !atuais.isEmpty();
    }

    public AutomatoFD paraAFD() {
        // TODO: reescrever essa função
        Map<Set<Estado>, Estado> estadosMap = new HashMap<>();
        Queue<Set<Estado>> fila = new LinkedList<>();

        Set<Estado> estadosAFD = new HashSet<>();
        Set<Estado> finaisAFD = new HashSet<>();
        Map<Estado, Map<Character, Estado>> transicoesAFD = new HashMap<>();

        Set<Estado> inicialConjunto = Set.of(this.inicial);
        Estado inicialAFD = new Estado(inicialConjunto.toString());
        estadosMap.put(inicialConjunto, inicialAFD);
        fila.add(inicialConjunto);
        estadosAFD.add(inicialAFD);
        transicoesAFD.put(inicialAFD, new HashMap<>());

        while (!fila.isEmpty()) {
            Set<Estado> conjuntoAtual = fila.poll();
            Estado estadoAtualAFD = estadosMap.get(conjuntoAtual);

            if (conjuntoAtual.stream().anyMatch(this.finais::contains)) {
                finaisAFD.add(estadoAtualAFD);
            }

            for (Character simbolo : this.alfabeto) {
                Set<Estado> destinos = this.getAll(conjuntoAtual, simbolo);

                if (destinos.isEmpty()) {
                    continue;
                }

                if (!estadosMap.containsKey(destinos)) {
                    Estado destinoAFD = new Estado(destinos.toString());
                    estadosMap.put(destinos, destinoAFD);
                    estadosAFD.add(destinoAFD);
                    transicoesAFD.put(destinoAFD, new HashMap<>());
                    fila.add(destinos);
                }

                transicoesAFD.get(estadoAtualAFD).put(simbolo, estadosMap.get(destinos));
            }
        }

        AutomatoFD afd = new AutomatoFD(this.alfabeto, estadosAFD, inicialAFD, finaisAFD);
        transicoesAFD.forEach((origem, transicoes) ->
                transicoes.forEach((simbolo, destino) -> afd.fazerTransicao(origem, simbolo, destino))
        );

        return afd;
    }
}
