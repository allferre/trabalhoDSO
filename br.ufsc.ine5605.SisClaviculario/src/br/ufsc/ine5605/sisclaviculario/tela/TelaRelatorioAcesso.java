/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sisclaviculario.tela;
import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorRelatorioAcesso;

/**
 *
 * @author Graciela Banegas
 */
public class TelaRelatorioAcesso {
  
    private Scanner teclado;
    private ControladorRelatorioAcesso ctrlR;

    public TelaRelatorioAcesso(ControladorRelatorioAcesso ctrlR) {
       this.ctrlR = ctrlR;
       teclado = new Scanner(System.in);
    }
    
    public void exibeMenuRelatorio() {
        int opcao = 0;

        do {
            ctrlR.cabecalhoTelaRelatorioAcesso();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    listaTodosAcessos();
                    break;
                case 2:
                    listaAcessosNegados();
                    break;
                case 3:
                    listaAcessosPermitidos();
                    break;
                case 4:
                    filtrarPorMotivoNegacao();
                    break;
                case 5:
                    filtrarPorMotivoNegacao();
                    break;
                case 6:
                    filtrarPorNumMatricula();
                    break;
                case 7:
                    filtrarPorPlaca();
                    break;
                case 8:
                    ctrlR.voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }


 

    private void listaTodosAcessos() {
        ctrlR.pedirListaEmprestimos();
    }

    private void listaAcessosNegados() {
        
    }

    private void listaAcessosPermitidos() {
    }

    private void filtrarPorMotivoNegacao() {
    }

    private void filtrarPorNumMatricula() {
    }

    private void filtrarPorPlaca() {
    }

    public void mostraRelatorioAcesso() {

    }

    
}


