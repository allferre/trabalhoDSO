package br.ufsc.ine5605.sisclaviculario.tela;

import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class TelaVeiculo extends TelasCabecalho {

    private Scanner teclado;
    private CargoVeiculo cargo;
    private boolean emprestado;
    private static TelaVeiculo INSTANCE;

    private TelaVeiculo() {
        teclado = new Scanner(System.in);
    }

    public static TelaVeiculo getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new TelaVeiculo();
        }
        return INSTANCE;
    }

    public void exibeTelaVeiculo() {

        int opcao = 0;
        do {
            ControladorVeiculo.getINSTANCE().cabecalhoTelaVeiculo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarVeiculo();
                    break;
                case 2:
                    excluirVeiculo();
                    break;
                case 3:
                    alterarVeiculo(); 
                    break;
                case 4:
                    exibeListaVeiculos();
                    break;
                case 5:
                    ControladorVeiculo.getINSTANCE().voltaTelaInicial();
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
        int quilometragem = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Defina o cargo que poderá utilizar o veículo: ");
        System.out.println(" Digite (1) exclusivo para Diretor e (2) qualquer Funcionário: ");
        opcao = teclado.nextInt();
        teclado.nextLine();
        switch (opcao) {
            case 1:
                cargo = CargoVeiculo.DIRETOR;
                break;
            case 2:
                cargo = CargoVeiculo.FUNCIONARIO;
                break;
            default:
                System.out.println("Insira apenas uma das opções: (1) ou (2) ");
        }

        emprestado = false;

        ControladorVeiculo.getINSTANCE().incluiVeiculo(placa, modelo, marca, ano, quilometragem, cargo, emprestado);

        System.out.println("|*********************************|");
        System.out.println("|      Cadastrado com sucesso!    |");
        System.out.println("|*********************************|");
        System.out.println("");

    }

    public void excluirVeiculo() {

        String placaParaExcluir = pedeNumPlaca();

        if (ControladorVeiculo.getINSTANCE().excluiVeiculoPelaPlaca(placaParaExcluir)) {
            System.out.println("Veículo excluido com sucesso! ");
        } else {
            System.out.println("Não foi possível excluir o veículo! ");
        }
    }

    public void exibeListaVeiculos() {

        for (int i = 0; i < ControladorVeiculo.getINSTANCE().getListaVeiculos().size(); i++) {
            Veiculo veiculo = ControladorVeiculo.getINSTANCE().getListaVeiculos().get(i);
        }
        for (Veiculo veiculo : ControladorVeiculo.getINSTANCE().getListaVeiculos()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Dados de  " + veiculo.getPlaca());
            System.out.println("Modelo: " + veiculo.getModelo());
            System.out.println("Marca: " + veiculo.getMarca());
            System.out.println("Ano: " + veiculo.getAno());
            System.out.println("Categoria do usuário: " + veiculo.getCargoVeiculo().mensagem);
            System.out.println("Disponível: "+veiculo.getEmprestado());
            System.out.println("-------------------------------------------------------");
        }
    }

    public String pedeNumPlaca() {

        System.out.println("Digite o número da placa do veículo: ");
        String placa = teclado.next();
        return placa;
    }

    public void alterarVeiculo() {
        String placa = pedeNumPlaca();
        
        boolean found = false;
        Veiculo v = null;
        
        for ( Veiculo veiculoAlterar : ControladorVeiculo.getINSTANCE().getListaVeiculos()){
            if (veiculoAlterar.getPlaca().equals(placa)){
                v = veiculoAlterar;
                found = true;
                break;
            }
        }
        
        if (v != null && found) {
        
        
        }
        
        
        
        
        
        
        
    }

}
