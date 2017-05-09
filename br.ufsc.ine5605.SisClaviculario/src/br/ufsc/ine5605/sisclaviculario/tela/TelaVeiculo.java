package br.ufsc.ine5605.sisclaviculario.tela;

import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.Cargo;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class TelaVeiculo {

    private Scanner teclado;
    private ControladorVeiculo ctrlV;
    private Cargo cargo;

    public TelaVeiculo(ControladorVeiculo ctrlV) {
        this.ctrlV = ctrlV;
        teclado = new Scanner(System.in);
    }

    public void exibeTelaVeiculo() {

        int opcao = 0;
        do {
            ctrlV.cabecalhoTelaVeiculo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    excluirVeiculo();
                    break;
                case 3:
                    //alterarVeiculo(); *******************
                    break;
                case 4:
                    exibeListaVeiculos();
                    break;
                case 5:
                    ctrlV.voltaTelaInicial();
                    break;
                default:
                    System.out.println(" *** Insira apenas o número das opções do Menu *** ");
                    System.out.println("");
            }

        } while (opcao != 0);

    }

    public void cadastrarVeiculo() {

        int opcao = 0;

        System.out.println("Digite a placa: ");
        String placa = teclado.next();
        teclado.nextLine();

        System.out.println("Digite o modelo: ");
        String modelo = teclado.next();
        teclado.nextLine();

        System.out.println("Digite a marca: ");
        String marca = teclado.next();
        teclado.nextLine();

        System.out.println("Digite o ano do veiculo: ");
        int ano = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Digite a quilometragem: ");
        float quilometragem = teclado.nextFloat();
        teclado.nextLine();

        System.out.println("Defina o cargo que poderá utilizar o veículo: ");
        System.out.println(" Digite (1) exclusivo para Diretor e (2) qualquer Funcionário: ");
        opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                cargo = Cargo.DIRETOR;
                break;
            case 2:
                cargo = Cargo.FUNCIONARIO;
                break;
            default:
                System.out.println("Insira apenas uma das opções: (1) ou (2) ");
        }

        Veiculo veiculo = new Veiculo(placa, modelo, marca, ano, quilometragem, cargo);
        
         ctrlV.incluiVeiculo(veiculo);

        System.out.println("|*********************************|");
        System.out.println("|      Cadastrado com sucesso!    |");
        System.out.println("|*********************************|");
        System.out.println("");

    }

    public void excluirVeiculo() {

        String placaParaExcluir = pedeNumPlaca();

        if (ctrlV.excluiVeiculoPelaPlaca(placaParaExcluir)) {
            System.out.println("Veículo excluido com sucesso! ");
        } else {
            System.out.println("Não foi possível excluir o veículo! ");
        }
    }

    public void exibeListaVeiculos() {

        for (int i = 0; i < ctrlV.getListaVeiculos().size(); i++) {
            Veiculo veiculo = ctrlV.getListaVeiculos().get(i);
        }
        for (Veiculo veiculo : ctrlV.getListaVeiculos()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Dados de  " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Ano: " + veiculo.getAno());
            System.out.println("Categoria do usuário: " + veiculo.getCargo());
            System.out.println("-------------------------------------------------------");
        }
    }

    public String pedeNumPlaca() {

        System.out.println("Digite o número da placa do veículo: ");
        String placa = teclado.next();
        return placa;
    }

}

