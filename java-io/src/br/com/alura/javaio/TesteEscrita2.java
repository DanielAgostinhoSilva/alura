package br.com.alura.javaio;

import java.io.*;

public class TesteEscrita2 {

    public static void main(String[] args) throws IOException {
//        OutputStream outputStream = new FileOutputStream("lorem-saida.txt");
//        Writer writer = new OutputStreamWriter(outputStream);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        FileWriter fileWriter = new FileWriter("lorem-saida2.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
        bufferedWriter.newLine();
        bufferedWriter.newLine();
        bufferedWriter.write("Teste");

        bufferedWriter.close();

    }
}
