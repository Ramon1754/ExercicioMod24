package br.com.ramon.dao;

import br.com.ramon.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ContratoDao implements IContratoDao<ClienteDao>{
    private List<ClienteDao> clientes;

    public ContratoDao() {
        this.clientes = new ArrayList<>();
    }

    @Override
    public void salvar() {
        throw new UnsupportedOperationException("Não funciona com o banco");
    }

    @Override
    public void adicionar(ClienteDao cliente) {
//    Verificar se a pessoa  já existe na lista (baseado no ID)
        for (ClienteDao add : clientes) {
            if (add.getId() == cliente.getId()) {
                System.out.println("Pessoa com ID" + cliente.getId() + "já existe.");
                return;
            }
        }
        clientes.add(cliente);
    }

    @Override
    public ClienteDao buscarPorId(int id) {
        for (ClienteDao cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; //Retona Null se não encontrar
    }


    @Override
    public boolean excluirPorId(int id) {
        for (ClienteDao cliente : clientes) {
            if (cliente.getId() == id) {
                clientes.remove(cliente);
                return true; //Retorna TRUE se a pessoa foi removida
            }
        }
             return false; // Retorna FALSE se a pessoa não foi encontrada
    }

        @Override
        public List<ClienteDao> listar () {
            return new ArrayList<>(clientes);
        }

    public static void main(String[] args) {
        ContratoDao gerenciador = new ContratoDao();

        //Adicionando clientes
        gerenciador.adicionar(new ClienteDao(1,"Rodrigo", 18l, "RJ"));
        gerenciador.adicionar(new ClienteDao(2,"Mário", 23l, "SP"));
        gerenciador.adicionar(new ClienteDao(3,"Fernanda", 16l, "PR"));
        gerenciador.adicionar(new ClienteDao(1,"Ricardo", 30l, "MT"));
        gerenciador.adicionar(new ClienteDao(4,"Maria", 24l, "RJ"));

        //Listando clientes
        System.out.println("Lista de Clientes: ");
        for (ClienteDao cliente : gerenciador.listar()) {
            System.out.println(cliente);
        }

        //Buscando Cliente por ID
        System.out.println("\nBuscando cliente com ID 1: ");
        ClienteDao encontrada = gerenciador.buscarPorId(1);
        if (encontrada != null) {
            System.out.println(encontrada);
        } else {
            System.out.println("Cliente não encontrada.");
        }

        //Excluindo cliente por ID
        System.out.println("\nExcluindo cliente com ID 2: ");
        boolean excluida = gerenciador.excluirPorId(2);
        if (excluida){
            System.out.println("Cliente excluída com sucesso");
        } else {
            System.out.println("Pessoa não encontrada para exclusão.");
        }

        //Listando Cliente após exclusão
        System.out.println("\nLista de clientes após a exclusão");
        for (ClienteDao cliente : gerenciador.listar()) {
            System.out.println(cliente);
        }

    }
    }

