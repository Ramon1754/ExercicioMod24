package br.com.ramon.dao;

import java.util.List;

import java.util.List;

public interface IContratoDao {
    int getId();
    String getNome();
    String getCidade();
    String getEstado();

    // Novos métodos
    ContratoDao buscarPorId(int id);
    boolean excluirPorId(int id);
    void atualizar(ContratoDao contrato);
    List<ContratoDao> listar();
}
