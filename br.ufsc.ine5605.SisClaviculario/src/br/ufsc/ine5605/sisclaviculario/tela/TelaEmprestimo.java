package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.Cargo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class TelaEmprestimo {

    private Scanner teclado;
    private ControladorEmprestimo ctrlE;
    private ArrayList<Funcionario> listaFuncionarios;
    private ControladorVeiculo ctrlV;

    public TelaEmprestimo(ControladorEmprestimo ctrlE, ControladorVeiculo ctrlV) {
        teclado = new Scanner(System.in);
        this.ctrlE = ctrlE;
        listaFuncionarios = new ArrayList<>();
        this.ctrlV = ctrlV;
    }

    public void exibeMenuEmprestimo() {
        int opcao = 0;

        do {
            ctrlE.telaEmprestimo();
            opcao = teclado.nextInt();

        } while (opcao != 0);

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

    }

    public void solicitarVeiculo() {

        Funcionario funcEncontrado = verificaNumMatricula();
        ArrayList<Veiculo> verificaVeiculo = ctrlE.solicitaListaVeiculos();

        if (funcEncontrado == null) {
            System.out.println("Esse número de matrícula não consta no banco de dados");
        } else if (funcEncontrado.getCargo() == Cargo.DIRETOR) {
            System.out.println("Digite a placa do carro: ");
            String placaSolicitada = teclado.next();
            verificaNumPlaca(placaSolicitada);

        } else {
            System.out.println("Veículo indisponível");

        }

    }

    public void devolverVeiculo() {

    }

    public Funcionario verificaNumMatricula() { // Verificar se existe esse número de matrícula
        System.out.println("Digite o número de matrícula do funcionário: ");
        int numeroMatricula = teclado.nextInt();

        for (Funcionario verificaFuncionario : ctrlE.solicitarListaFuncionarios()) {
            if (verificaFuncionario.getNumMatricula() == numeroMatricula) {
                return verificaFuncionario;
            }
        }
        return null;
    }

    public Veiculo verificaNumPlaca(String PlacaSolicitada) {
        System.out.println("Digite o número da placa do Veículo: ");
        String numeroPlaca = teclado.next();

        for (Veiculo verificaVeiculo : ctrlV.solicitarListaVeiculos()) {
            if (verificaVeiculo.getPlaca().equals(numeroPlaca)) {
                return verificaVeiculo;
            }
        }
        return null;
    }
}

