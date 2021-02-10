package br.com.caelum.leilao.dominio;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Avaliador {

    private Double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private Double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public void avalia(Leilao leilao) {
        leilao.getLances().forEach( lance -> {
            if ( lance.getValor() > maiorDeTodos)
                maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos)
                menorDeTodos = lance.getValor();
        });

        maiores = leilao.getLances().stream()
                .sorted(Comparator.comparingDouble(Lance::getValor).reversed())
                .collect(Collectors.toList());

        maiores = maiores.subList(0 , Math.min(maiores.size(), 3));


    }

    public List<Lance> getTresMaiores() {
        return maiores;
    }

    public Double getMaiorLance() {
        return maiorDeTodos;
    }

    public Double getMenorLance() {
        return menorDeTodos;
    }
}
