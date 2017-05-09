package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.Cargo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import java.util.Scanner;
import java.util.ArrayList;

//teste git, from neatBeans
/**
 *
 * @author Allan
 */
public class TelaEmprestimo {

    private Scanner teclado;
    private ControladorEmprestimo ctrlE;
    private ArrayList<Funcionario> listaFuncionarios;
    private Veiculo veiculoVerificado;
    private int numeroMatricula;
    //private Funcionario funcEncontrado;

    public TelaEmprestimo(ControladorEmprestimo ctrlE) {
        this.ctrlE = ctrlE;
        teclado = new Scanner(System.in);
        listaFuncionarios = new ArrayList<>();
        this.numeroMatricula = numeroMatricula;
        //this.funcEncontrado = funcEncontrado;

    }

    public void exibeMenuEmprestimo() {
        int opcao = 0;

        do {
            ctrlE.telaEmprestimo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    solicitarVeiculo();
                    break;
                case 2:
                    devolverVeiculo();
                    break;
                case 3:
                    ctrlE.voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }

    public void solicitarVeiculo() {
      ArrayList<Veiculo> verificaVeiculo = ctrlE.solicitaListaVeiculos();
      ArrayList<Funcionario> funcEncontrado = ctrlE.solicitarListaFuncionarios();
        Funcionario funcEncontradoo = verificaNumMatricula();

        if (funcEncontradoo.getCargo() == Cargo.DIRETOR) {
            System.out.println("Olá Sr(a) " + funcEncontradoo.getNome() + ", por favor digite a placa do veículo: ");
            String placaSolicitada = teclado.next();
            if (verificaPlacaExiste(placaSolicitada) != null && verificaPlacaDisponivel(placaSolicitada) != null) {
                System.out.println(" **** Veículo liberado com Sucesso, obrigado Sr(a) " + funcEncontradoo.getNome() + " ****");
                // registrar o acesso com as informações do empréstimo
            }
        } else if (funcEncontradoo.getCargo() == Cargo.FUNCIONARIO) {
            System.out.println("Digite a placa do carro: ");
            String placaSolicitada = teclado.next();
            if (verificaPlacaExiste(placaSolicitada) != null && verificaPlacaDisponivel(placaSolicitada) != null && verificaPlacaCargo(placaSolicitada) != null) {
                System.out.println(" **** Veículo liberado com Sucesso **** ");
                // registrar o acesso com as informações do empréstimo
            }
        }
    }

    public void devolverVeiculo() {

    }

    public Funcionario verificaNumMatricula() { // Verificar se existe esse número de matrícula

        System.out.println("Digite o número de matrícula do funcionário: ");
        numeroMatricula = teclado.nextInt();

        for (Funcionario verificaFuncionario : ctrlE.solicitarListaFuncionarios()) { // verifica se o número de matrícula consta no banco de dados
            if (verificaFuncionario.getNumMatricula() == numeroMatricula) {
                return verificaFuncionario;
            }
        }
        System.out.println(" ***Esse número de matrícula não consta no banco de dados*** ");
        return null;
    }

    public Veiculo verificaPlacaExiste(String placaSolicitada) {

        for (Veiculo verificaVeiculo : ctrlE.solicitarListaVeiculos()) {  //verifica se a placa existe 
            if (verificaVeiculo.getPlaca().equals(placaSolicitada)) {
                return verificaVeiculo;
            } else {
                System.out.println(" ***Essa placa não consta no banco de dados*** ");
            }
        }
        return null;
    }

    public Veiculo verificaPlacaDisponivel(String placaSolicitada) {
        
        for (Veiculo verificaVeiculo : ctrlE.solicitarListaVeiculos()) {  //verifica se o veículo está disponível 
            if (verificaVeiculo.getEmprestado() == null) {
               
                return verificaVeiculo;
                
            } else {
                System.out.println(" ***Esse veículo não está disponível*** ");
            }
        }
        return null;
    }

    public Veiculo verificaPlacaCargo(String placaSolicitada) {

        for (Veiculo verificaVeiculo : ctrlE.solicitarListaVeiculos()) {
            if (verificaVeiculo.getCargo() == Cargo.FUNCIONARIO) {
                return verificaVeiculo;
            } else {
                System.out.println(" ***Vc não possui acesso a esse veículo*** ");
            }
        }
        return null;
    }
}