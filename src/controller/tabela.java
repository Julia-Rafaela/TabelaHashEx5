package controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class tabela {
	 private List<List<contabanco>> tabela;
	    private int tamanho;
	    
	    // construtor da class e criação da tabela
	    public tabela(int tamanho) {
	        this.tamanho = tamanho;
	        tabela = new ArrayList<>(tamanho);
	        for (int i = 0; i < tamanho; i++) {
	            tabela.add(new LinkedList<>());
	        }
	    }
	    
	    // Função de hash para obter o índice na tabela
	    private int hash(int numeroConta) {
	        return numeroConta % tamanho;
	    }
	    
	    // Inserir uma conta bancária na tabela
	    public void inserir(contabanco conta) {
	        int indice = hash(conta.getNumeroConta());
	        tabela.get(indice).add(conta); //percorre e preenche
	    }
	    
	    // Consultar uma conta bancária pelo número da conta
	    public contabanco consultar(int numeroConta) {
	        int indice = hash(numeroConta);
	        List<contabanco> listaContas = tabela.get(indice); //percorre consultando
	        for (contabanco conta : listaContas) {
	            if (conta.getNumeroConta() == numeroConta) {
	                return conta;
	            }
	        }
	        return null; // quando a conta não é encontrada
	    }
	    
	    // Remover uma conta bancária pelo número da conta
	    public boolean remover(int numeroConta) {
	        int indice = hash(numeroConta);
	        List<contabanco> listaContas = tabela.get(indice);
	        for (contabanco conta : listaContas) {
	            if (conta.getNumeroConta() == numeroConta) {
	                listaContas.remove(conta);
	                return true; // Remoção bem-sucedida
	            }
	        }
	        return false; // quando a conta não é encontrada
	    }
}
