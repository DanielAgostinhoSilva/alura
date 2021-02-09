package br.com.alura.java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2026, Month.JUNE, 5);

        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println(anos);

        Period period = Period.between(hoje, olimpiadasRio);
        System.out.println(period.getDays());

        LocalDate localDate = olimpiadasRio.plusYears(4);

        System.out.println(localDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println(formatter.format(localDate));

        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora.format(formatterTime));

    }
}
