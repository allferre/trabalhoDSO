<<<<<<< HEAD
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5605.sisclaviculario.tela;

/**
 *
 * @author Allan
 */
public class TelaRelatorioAcesso {
    
}
=======
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

        for (int i = 0; i < ctrlR.pedirListaEmprestimos().size(); i++) {
           // Funcionario funcionario = ctrlR.getListaFuncionarios().get(i);
        }

        for (Funcionario funcionario : ctrlF.getListaFuncionarios()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Dados de  " + funcionario.getNome());
            System.out.println("Número de Matrícula: " + funcionario.getNumMatricula());
            System.out.println("Data de nascimento: " + funcionario.getDataNascimento());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Cargo do funcionário: " + funcionario.getCargo());
            System.out.println("-------------------------------------------------------");
        }
    }   
    }

    private void listaAcessosNegados() {
       
    }

    private void listaAcessosPermitidos() {
    }

    private void filtrarPorNumMatricula() {
    }

    private void filtrarPorPlaca() {
    }

    public void mostraRelatorioAcesso() {

    }
    private void filtrarPorMotivoNegacao() {
    
    
    }
    
}


>>>>>>> origin/master
