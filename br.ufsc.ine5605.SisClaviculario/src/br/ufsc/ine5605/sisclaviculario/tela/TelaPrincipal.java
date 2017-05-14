package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class TelaPrincipal extends TelasCabecalho {

    private Scanner teclado;
    private static TelaPrincipal INSTANCE;

    private TelaPrincipal() {
        this.teclado = new Scanner(System.in);
    }
    
     public static TelaPrincipal getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new TelaPrincipal();
        }
        return INSTANCE;
    }


    public void exibeMenuInicial() {
        int opcao = 0;
        do {
            ControladorPrincipal.getINSTANCE().cabecalhoTelaPrincipal();
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
        ControladorPrincipal.getINSTANCE().iniciarCadastroFuncionario();
    }

    public void telaVeiculo() {
        ControladorPrincipal.getINSTANCE().iniciarCadastroVeiculo();
    }

    public void telaEmprestimo() {
        ControladorPrincipal.getINSTANCE().iniciarEmprestimo();
    }

    public void telaRelatorioAcessos(){
        ControladorPrincipal.getINSTANCE().iniciarRelatorio();
    }
}

