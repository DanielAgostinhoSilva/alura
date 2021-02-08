package br.com.alura.java8;

import java.util.Comparator;
import java.util.List;

public class OrdenaStringComLambda {
    public static void main(String[] args) {
        List<String> palavras = Util.getPalavras();

        palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));

        palavras.forEach( palavra -> System.out.println(palavra));
    }
}
