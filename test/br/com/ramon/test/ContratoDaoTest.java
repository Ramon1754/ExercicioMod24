package br.com.ramon.test;

import static org.junit.Assert.*;

import br.com.ramon.dao.ContratoDao;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ContratoDaoTest {
    private ContratoDao gerenciador;

    @Before
    public void setUp() {
        gerenciador = new ContratoDao(0, "", "", "");
        gerenciador.adicionar(new ContratoDao(1, "Rodrigo", "São Paulo", "SP"));
        gerenciador.adicionar(new ContratoDao(2, "Maria", "Rio de Janeiro", "RJ"));
    }

    @Test
    public void testAdicionar() {
        ContratoDao novoContrato = new ContratoDao(3, "Fernanda", "Belo Horizonte", "MG");
        gerenciador.adicionar(novoContrato);
        ContratoDao encontrado = gerenciador.buscarPorId(3);
        assertNotNull(encontrado);
        assertEquals("Fernanda", encontrado.getNome());
    }

    @Test
    public void testBuscarPorId() {
        ContratoDao encontrado = gerenciador.buscarPorId(1);
        assertNotNull(encontrado);
        assertEquals("Rodrigo", encontrado.getNome());
    }

    @Test
    public void testExcluirPorId() {
        boolean excluido = gerenciador.excluirPorId(2);
        assertTrue(excluido);
        assertNull(gerenciador.buscarPorId(2));
    }

    @Test
    public void testAtualizar() {
        ContratoDao contratoAtualizado = new ContratoDao(1, "Contrato Atualizado", "São Paulo", "SP");
        gerenciador.atualizar(contratoAtualizado);
        ContratoDao encontrado = gerenciador.buscarPorId(1);
        assertNotNull(encontrado);
        assertEquals("Contrato Atualizado", encontrado.getNome());
    }

    @Test
    public void testListar() {
        List<ContratoDao> lista = gerenciador.listar();
        assertEquals(2, lista.size());
    }
}
