package br.com.alura.javaio;

import java.io.*;

public class TesteLeitura {

    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("lorem.txt");
        InputStreamReader isr = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(isr);

        while ( bufferedReader.ready() ) {
            String s = bufferedReader.readLine();
            System.out.println(s);
        }

        bufferedReader.close();

    }
}
