package br.com.alura.javaio;

import java.io.*;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TesteLeituraScanner {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(new File("contas.csv"))) {

            while ( scanner.hasNext() ) {
                String linha = scanner.nextLine();
                System.out.println(linha);

                Scanner linhaScaner = new Scanner(linha);
                linhaScaner.useLocale(Locale.US);
                linhaScaner.useDelimiter(",");

                String valor1 = linhaScaner.next();
                Integer valor2 = linhaScaner.nextInt();
                Integer valor3 = linhaScaner.nextInt();
                String valor4 = linhaScaner.next();
                Double valor5 = linhaScaner.nextDouble();

                System.out.println(valor1  + valor2 + valor3 + valor4 + valor5);

                linhaScaner.close();

//                String[] valores = linha.split(",");
//                System.out.println(Arrays.toString(valores));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
