package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;

import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class TelaPrincipal {

    private Scanner teclado;
    private ControladorPrincipal ctrlP;

    public TelaPrincipal(ControladorPrincipal ctrlP) {
        this.teclado = new Scanner(System.in);
        this.ctrlP = ctrlP;

    }

    public void exibeMenuInicial() {

        int opcao = 0;

        do {
            ctrlP.cabecalhoTelaPrincipal();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    telaFuncionario();
                    break;
                case 2:
                    telaVeiculo();
                    break;
                case 3:
                    telaEmprestimo();
                    break;
                case 4:
                    telaRelatorioAcessos();
                    break;
                default:
                    System.out.println(" *** Insira apenas o número das opções do Menu *** ");
                    System.out.println("");
            }

        } while (opcao != 0);

    }

    public void telaFuncionario() {
        ctrlP.iniciarCadastroFuncionario();
    }

    public void telaVeiculo() {
        ctrlP.iniciarCadastroVeiculo();
    }

    public void telaEmprestimo() {
        ctrlP.iniciarEmprestimo();
    }

    public void fazerListaFuncionarios() {
        ctrlP.iniciarListaFuncionarios();
    }

    public void telaRelatorioAcessos(){
        ctrlP.iniciarRelatorio();
    }

 
}

