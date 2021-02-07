package br.com.alura.javaio;

import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaPrintWriter {

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter("lorem-saida-print-writer.txt");

        pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        pw.println();
        pw.println();
        pw.println("Teste");

        pw.close();

    }
}
