package br.com.caelum.leilao.teste;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Avaliador;
import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class AvaliadorTest {

    private Avaliador leiloeiro;
    private Usuario joao;
    private Usuario jose;
    private Usuario maria;

    @Before
    public void criaAvaliador() {
        this.leiloeiro = new Avaliador();
        this.joao = new Usuario("Joao");
        this.jose = new Usuario("Jose");
        this.maria = new Usuario("Maria");
    }

    @Test
    public void deveEntenderLancesEmOrdemCrescente() {
        // parte 1: cenario
         Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 250.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .controi();

        // parte 2 : acao
        leiloeiro.avalia(leilao);

        // parte 3 : validacao
        Double maiorEsperado = 400.0;
        Double menorEsperado = 200.0;

        assertEquals(maiorEsperado, leiloeiro.getMaiorLance());
        assertEquals(menorEsperado, leiloeiro.getMenorLance());
    }

    @Test
    public void deveEntenderLeilaoComApenasUmLance() {
        // parte 1: cenario
        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 1000.0)
                .controi();

        // parte 2 : acao
        leiloeiro.avalia(leilao);

        assertEquals(1000.0, leiloeiro.getMaiorLance(), 0.00001);
        assertEquals(1000.0, leiloeiro.getMenorLance(), 0.00001);
    }

    @Test
    public void deveEncontrarOsTresMaioresLances() {

        Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                .lance(joao, 100.0)
                .lance(maria, 200.0)
                .lance(joao, 300.0)
                .lance(maria, 400.0)
                .controi();

        // parte 2 : acao
        leiloeiro.avalia(leilao);

        List<Lance> tresMaiores = leiloeiro.getTresMaiores();

        assertEquals(3, tresMaiores.size());
        assertEquals(400.0, tresMaiores.get(0).getValor(), 0.00001);
        assertEquals(300.0, tresMaiores.get(1).getValor(), 0.00001);
        assertEquals(200.0, tresMaiores.get(2).getValor(), 0.00001);
    }
}
