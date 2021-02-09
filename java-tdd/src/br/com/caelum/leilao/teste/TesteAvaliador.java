package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Assert;
import org.junit.Test;

public class TesteAvaliador {

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // parte 1: cenario
        Usuario joao = new Usuario("Joao");
        Usuario jose = new Usuario("Jose");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 250.0));
        leilao.propoe(new Lance(jose, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        // parte 2 : acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        // parte 3 : validacao
        Double maiorEsperado = 400.0;
        Double menorEsperado = 250.0;

        Assert.assertEquals(maiorEsperado, leiloeiro.getMaiorLance());
        Assert.assertEquals(menorEsperado, leiloeiro.getMenorLance());
    }
}
