package br.com.alura.java8;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class UsandoStreams {
    public static void main(String[] args) {
        List<Curso> cursos = Util.getCursos();

        cursos.sort(Comparator.comparingInt(Curso::getAlunos));

        //cursos.forEach( c -> System.out.println(c.getNome()));

        int soma = cursos.stream()
                .filter(c -> c.getAlunos() >= 100)
                .mapToInt(Curso::getAlunos)
                .sum();

        System.out.println(soma);

        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .findAny()
                .ifPresent( curso -> System.out.println(curso.getNome()));


        List<Curso> resultado = cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toList());

        cursos.stream()
                .filter(c -> c.getAlunos() > 100)
                .collect(Collectors.toMap(
                        Curso::getNome,
                        Curso::getAlunos
                ))
                .forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos"));


    }
}
