package br.com.alura.java8;

import java.util.Comparator;
import java.util.List;

public class OrdenaStringMehodReferences {
    public static void main(String[] args) {
        List<String> palavras = Util.getPalavras();

        palavras.sort(Comparator.comparing(String::length));

        palavras.forEach(System.out::println);
    }
}
