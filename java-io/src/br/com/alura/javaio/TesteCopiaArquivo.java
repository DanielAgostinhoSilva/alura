package br.com.alura.javaio;

import java.io.*;

public class TesteCopiaArquivo {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("lorem.txt");
        InputStreamReader isr = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        OutputStream outputStream = new FileOutputStream("lorem-saida.txt");
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String line = bufferedReader.readLine();
        if (line != null)
            bufferedWriter.write(line);

        while ( bufferedReader.ready() ) {
            line = bufferedReader.readLine();
            bufferedWriter.newLine();
            bufferedWriter.write(line);
        }

        bufferedReader.close();
        bufferedWriter.close();

    }
}
