package br.com.alura.javaio;

import java.io.IOException;
import java.io.PrintStream;

public class TesteEscritaPrintStream {

    public static void main(String[] args) throws IOException {

        PrintStream ps = new PrintStream("lorem-saida-print-stream.txt");

        ps.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        ps.println();
        ps.println();
        ps.println("Teste");

        ps.close();

    }
}
