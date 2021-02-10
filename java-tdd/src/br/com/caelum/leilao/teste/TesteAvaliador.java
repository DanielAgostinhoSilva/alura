package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

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

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance());
        assertEquals(menorEsperado, leiloeiro.getMenorLance());
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        // parte 1: cenario
        Usuario joao = new Usuario("Joao");
        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 1000.0));

        // parte 2 : acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {
        Usuario joao = new Usuario("Joao");
        Usuario maria = new Usuario("Maria");

        Leilao leilao = new Leilao("Playstation 3 Novo");

        leilao.propoe(new Lance(joao, 100.0));
        leilao.propoe(new Lance(maria, 200.0));
        leilao.propoe(new Lance(joao, 300.0));
        leilao.propoe(new Lance(maria, 400.0));

        // parte 2 : acao
        Avaliador leiloeiro = new Avaliador();
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(3, tresMaiores.size());
        assertEquals(400.0, tresMaiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, tresMaiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, tresMaiores.get(2).getValor(), 0.00001);
    }
}
