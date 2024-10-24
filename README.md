# Atividade 3 de Teoria da Computação

Este repositório contém a implementação de autômatos finitos para diversas linguagens conforme especificado. Os
autômatos podem ser de estados finitos determinísticos (DFA) ou não determinísticos (NFA), dependendo da linguagem.

## Linguagens a serem implementadas

1.
    - **{ w | w contém pelo menos um 1 }**
        - Autômato que reconhece todas as cadeias que contêm pelo menos um símbolo '1'.

    - **{ w | w contém pelo menos um par de zeros }**
        - Autômato que reconhece todas as cadeias que contêm pelo menos dois símbolos '0'.

2. **{ w | w começa com 0 }**
    - Autômato que reconhece todas as cadeias que começam com o símbolo '0'.

3. **∅ (Conjunto Vazio)**
    - Autômato que não reconhece nenhuma cadeia, representando a linguagem vazia.

4. **{ ε }**
    - Autômato que reconhece apenas a cadeia vazia.

5. **{ w | w é qualquer cadeia do alfabeto }**
    - Autômato que aceita qualquer sequência de símbolos do alfabeto.

6. **{ w | w contém 010 como subcadeia }**
    - Autômato que reconhece todas as cadeias que têm '010' como uma subcadeia.

7. **{ w | w começa e termina com o mesmo símbolo }**
    - Autômato que aceita cadeias que começam e terminam com o mesmo símbolo.

8. **{ w | w termina com um número ímpar de 1’s }**
    - Autômato que aceita todas as cadeias que terminam com um número ímpar de '1's.

9. **{ w | w contém mais 0's do que 1's }**
    - Autômato que reconhece cadeias que contêm uma quantidade maior de '0's do que '1's.

10. **Conversão de NFA para DFA**
    - Implementação de uma função que recebe um autômato finito não determinístico (NFA) e retorna o autômato finito
      determinístico (DFA) equivalente.

## Estrutura do Projeto

- `automata/`: Contém as classes e funções para a definição de autômatos, incluindo NFA, DFA e a função de conversão de
  NFA para DFA.
- `linguagens/`: Contém cada autômato implementado para as linguagens especificadas.
