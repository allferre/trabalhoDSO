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

    public TelaPrincipal() {
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
                    ControladorPrincipal.getINSTANCE().iniciarCadastroFuncionario();
                    break;
                case 2:
                    ControladorPrincipal.getINSTANCE().iniciarCadastroVeiculo();
                    break;
                case 3:
                    ControladorPrincipal.getINSTANCE().iniciarEmprestimo();
                    break;
                case 4:
                    ControladorPrincipal.getINSTANCE().iniciarRelatorio();
                    break;
                default:
                    System.out.println(" *** Insira apenas o número das opções do Menu *** ");
                    System.out.println("");
            }
        } while (opcao != 0);
    }
}
