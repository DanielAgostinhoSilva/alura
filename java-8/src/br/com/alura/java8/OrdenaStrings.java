package br.com.alura.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStrings {

    public static void main(String[] args) {
        /* Forma antiga de ordernar um array de strings */
        List<String> palavras = Util.getPalavras();

        Comparator<String> comparador = new ComparadorPorTamanho();
        Collections.sort(palavras, comparador);
        System.out.println("Com java 7");
        System.out.println(palavras);

        /* Forma no java8 de ordernar um array de strings */
        List<String> palavra2 = Util.getPalavras();
        palavra2.sort(new ComparadorPorTamanho());

        System.out.println("Com java 8");
        System.out.println(palavra2);

    }


}

class ComparadorPorTamanho implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {
        if (s1.length() < s2.length())
            return -1;
        if(s1.length() > s2.length())
            return 1;
        return 0;
    }
}
