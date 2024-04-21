/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package br.com.kauane.trabalho1bimestrutura;

import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kauan
 */
public class Trabalho1BimEstrutura {

    public static void main(String[] args) {
        
        
        
        //PEDINDO PARA O USUÁRIO INFORMAR O TAMANHO DO VETOR
        String msg = JOptionPane.showInputDialog("Digite o tamanho do VETOR: ");
        int n = Integer.parseInt(msg);
        int[] vetor = new int[n];
        
        //PEDINDO OS VALORES DENTRO DO VETOR
         for (int i = 0; i < n; i++){
        String nmvtr = JOptionPane.showInputDialog("Digite o numero inteiro " + ( i + 1) + " do VETOR: ");
            vetor [ i ] = Integer.parseInt(nmvtr);
        }
        
        //SALVANDO O VALOR DO VETOR ANTES DA ORDENAÇÃO
        int [ ] vetorAntesDaOrdenacao = Arrays.copyOf(vetor, vetor.length);
        
        //PEDINDO OS TIPOS DE ORDENAÇÃO PARA O USUÁRIO
        //PARA CALCULAR O TEMPO DE EXECUÇÃO
        long inicio = System.currentTimeMillis();
        String opcoes = JOptionPane.showInputDialog("Escolha um método de ordenação: \n1 - INSERÇÃO \n2 - SELEÇÃO \n3 - BOLHA");
        int opcao = Integer.parseInt(opcoes);
        
        switch (opcao){
            case 1 -> ordenacaoPorInsercao(vetor);
            case 2 -> ordenacaoPorSelecao(vetor);
            case 3 -> ordenacaoBolha(vetor);
            default -> {
                JOptionPane.showMessageDialog(null, "Opção inválida! ");
                return;
            }
        }
        
        long fim = System.currentTimeMillis();
        JOptionPane.showMessageDialog(null, "Método escolhido\n(1- Inserção, 2- Seleção, 3- Bolha): "+opcao+
                                                                                            "\nVetor antes da ordenação: " +
                                                                                       Arrays.toString(vetorAntesDaOrdenacao) +
                                                                                       "\nVetor ordenado: "+  Arrays.toString(vetor));
        JOptionPane.showMessageDialog(null, "Tempo de execução: " + (fim - inicio) + " ms");
         }
    
    
    //OS TIPOS DE ORDENAÇÃO EM UMA VARIAVEL
    
    //ORDENAÇÃO POR INSERÇÃO
         public static void ordenacaoPorInsercao(int[] vetor){
             for (int i = 1; i < vetor.length; i++) {
        int chave = vetor[i];
        int j = i - 1;
        while (j >= 0 && vetor[j] > chave) {
            vetor[j + 1] = vetor[j];
            j = j - 1;
        }
        vetor[j + 1] = chave;
         }
         }
         
   //ORDENAÇÃO POR SELEÇÃO
         public static void ordenacaoPorSelecao (int[] vetor){
             for (int i = 0; i < vetor.length - 1; i++) {
        int indiceMenor = i;
        for (int j = i + 1; j < vetor.length; j++) {
            if (vetor[j] < vetor[indiceMenor]) {
                indiceMenor = j;
            }
        }
        int temp = vetor[indiceMenor];
        vetor[indiceMenor] = vetor[i];
        vetor[i] = temp;
    }
         }
         
         
  //ORDENAÇÃO BOLHA
         
         public static void ordenacaoBolha( int[] vetor){
         
             int n = vetor.length;
    for (int i = 0; i < n-1; i++) {
        for (int j = 0; j < n-i-1; j++) {
            if (vetor[j] > vetor[j+1]) {
                // troca vetor[j+1] e vetor[i]
                int temp = vetor[j];
                vetor[j] = vetor[j+1];
                vetor[j+1] = temp;
            }
        }
    }
         
         }
}