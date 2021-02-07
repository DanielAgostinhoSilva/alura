package br.com.alura.java8;

import java.util.List;

public class PercorrendoArrays {

    public static void main(String[] args) {
        /* java 7 */
        List<String> palavras1 = Util.getPalavras();

        System.out.println("Percorendo uma lista com java 7");
        for (String palavra : palavras1){
            System.out.println(palavra);
        }

        /* java 8 */
        List<String> palavras2 = Util.getPalavras();

        System.out.println("Percorendo uma lista com java 8");
        palavras2.forEach(System.out::println);
    }
}
