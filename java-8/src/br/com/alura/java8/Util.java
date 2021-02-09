package br.com.alura.java8;

import java.util.Arrays;
import java.util.List;

public class Util {
    public static List<String> getPalavras() {
        return Arrays.asList("xicara", "carro vermelho", "aviao Verde", "zig zag");
    }

    public static List<Curso> getCursos() {
        return Arrays.asList(
                new Curso("Python",45),
                new Curso("JavaScript", 150),
                new Curso("Java 8", 113),
                new Curso("C", 55)
        );
    }

}
