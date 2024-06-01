package br.com.ramon.dao;

import java.util.ArrayList;
import java.util.List;

public class ContratoDao implements IContratoDao {
    private int id;
    private String nome;
    private String cidade;
    private String estado;

    // Lista estática para armazenar os contratos
    private static List<ContratoDao> contratos = new ArrayList<>();

    // Construtor
    public ContratoDao(int id, String nome, String cidade, String estado) {
        this.id = id;
        this.nome = nome;
        this.cidade = cidade;
        this.estado = estado;
    }

    public void Cliente() {

    }

    // Métodos getter implementados da interface IContratoDao
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String getCidade() {
        return cidade;
    }

    @Override
    public String getEstado() {
        return estado;
    }

    @Override
    public ContratoDao buscarPorId(int id) {
        for (ContratoDao contrato : contratos) {
            if (contrato.getId() == id) {
                return contrato;
            }
        }
        return null;
    }

    @Override
    public boolean excluirPorId(int id) {
        for (ContratoDao contrato : contratos) {
            if (contrato.getId() == id) {
                contratos.remove(contrato);
                return true;
            }
        }
        return false;
    }

    @Override
    public void atualizar(ContratoDao contrato) {
        for (int i = 0; i < contratos.size(); i++) {
            if (contratos.get(i).getId() == contrato.getId()) {
                contratos.set(i, contrato);
                return;
            }
        }
    }

    @Override
    public List<ContratoDao> listar() {
        return new ArrayList<>(contratos);
    }

    // Método para adicionar um contrato à lista
    public void adicionar(ContratoDao contrato) {
        contratos.add(contrato);
    }

    @Override
    public String toString() {
        return "ContratoDao{id=" + id + ", nome='" + nome + "', cidade='" + cidade + "', estado='" + estado + "'}";
    }

    public static void main(String[] args) {
        // Criando uma instância para gerenciar contratos
        ContratoDao gerenciador = new ContratoDao(0, "", "", "");

        // Adicionando contratos
        gerenciador.adicionar(new ContratoDao(1, "Rodrigo", "São Paulo", "SP"));
        gerenciador.adicionar(new ContratoDao(2, "Maria", "Rio de Janeiro", "RJ"));
        gerenciador.adicionar(new ContratoDao(3, "Fernanda", "Belo Horizonte", "MG"));

        // Buscando um contrato por ID
        ContratoDao contrato = gerenciador.buscarPorId(1);
        if (contrato != null) {
            System.out.println("Contrato encontrado: " + contrato);
        }

        // Atualizando um contrato
        gerenciador.atualizar(new ContratoDao(2, "Contrato Atualizado", "Rio de Janeiro", "RJ"));

        // Excluindo um contrato por ID
        boolean excluido = gerenciador.excluirPorId(3);
        if (excluido) {
            System.out.println("Contrato excluído com sucesso.");
        }

        // Listando todos os contratos
        List<ContratoDao> lista = gerenciador.listar();
        for (ContratoDao c : lista) {
            System.out.println(c);
        }
    }
}
