package br.com.alura.javaio;

import java.io.*;

public class TesteEscrevendoArquivoNoConsole {

    public static void main(String[] args) throws IOException {
        InputStream fileInputStream = System.in;
        Reader isr = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        OutputStream outputStream = new FileOutputStream("lorem-saida.txt");
        Writer writer = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        String line = bufferedReader.readLine();
        if (line != null)
            bufferedWriter.write(line);

        while ( !line.isEmpty() ) {
            line = bufferedReader.readLine();
            bufferedWriter.newLine();
            bufferedWriter.write(line);
        }

        bufferedReader.close();
        bufferedWriter.close();

    }
}
