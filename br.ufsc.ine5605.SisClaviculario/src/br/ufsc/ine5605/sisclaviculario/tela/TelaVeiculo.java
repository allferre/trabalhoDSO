package br.ufsc.ine5605.sisclaviculario.tela;

import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;

/**
 *
 * @author Allan
 */
public class TelaVeiculo extends TelasCabecalho implements ITelaVeiculo {

    private Scanner teclado;
    private CargoVeiculo cargo;
    private boolean emprestado;
    private static TelaVeiculo INSTANCE;
    private TelaVeiculo telaVeiculo;

    private TelaVeiculo() {
        teclado = new Scanner(System.in);
    }

    public static TelaVeiculo getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new TelaVeiculo();
        }
        return INSTANCE;
    }

    @Override
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
                    voltaTelaInicial();
                    break;
                default:
                    System.out.println(" *** Insira apenas o número das opções do Menu *** ");
                    System.out.println("");
            }

        } while (opcao != 0);

    }

    @Override
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

        System.out.println("Defina disponibilidade do veículo: ");
        System.out.println(" Digite (1) para Disponível e (2) para Indiposnível ");
        int aux = teclado.nextInt();
        teclado.nextLine();
        if (aux == 1) {
            emprestado = false;
        } else {
            emprestado = true;
        }

        ControladorVeiculo.getINSTANCE().incluiVeiculo(placa, modelo, marca, ano, quilometragem, cargo, emprestado);

        System.out.println("|*********************************|");
        System.out.println("|      Cadastrado com sucesso!    |");
        System.out.println("|*********************************|");
        System.out.println("");

    }

    @Override
    public void excluirVeiculo() {

        String placaParaExcluir = pedeNumPlaca();

        if (ControladorVeiculo.getINSTANCE().excluiVeiculoPelaPlaca(placaParaExcluir)) {
            System.out.println("Veículo excluido com sucesso! ");
        } else {
            System.out.println("Não foi possível excluir o veículo! ");
        }
    }

    @Override
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
            System.out.println("Quilometragem: " + veiculo.getQuilometragem());
            System.out.println("Categoria do usuário: " + veiculo.getCargoVeiculo().mensagem);
            if (veiculo.getEmprestado() == true) {
                System.out.println("Disponível: Não ");
            } else {
                System.out.println("Disponível: Sim ");
            }
            System.out.println("-------------------------------------------------------");
        }
    }

    @Override
    public String pedeNumPlaca() {
        System.out.println("Digite o número da placa do veículo: ");
        String placa = teclado.next();
        return placa;
    }

    @Override
    public void alterarVeiculo() {
        String placa = pedeNumPlaca();
        if (ControladorVeiculo.getINSTANCE().verificaExistePlaca(placa) == null) {
            System.out.println(" ***Essa placa não consta no banco de dados*** ");
        }

        boolean found = false;
        Veiculo v = null;

        for (Veiculo veiculoAlterar : ControladorVeiculo.getINSTANCE().getListaVeiculos()) {
            if (veiculoAlterar.getPlaca().equals(placa)) {
                v = veiculoAlterar;
                found = true;
                break;
            }
        }

        if (v != null && found) {
            cabecalhoAlteraVeiculo();
            int aux = teclado.nextInt();
            switch (aux) {
                case 1:
                    System.out.println("Digite a nova placa: ");
                    String novaPlaca = teclado.next();
                    teclado.nextLine();
                    v.setPlaca(novaPlaca);
                    alteradoSucesso();
                    break;
                case 2:
                    System.out.println("Digite o novo modelo: ");
                    String novoModelo = teclado.next();
                    teclado.nextLine();
                    v.setModelo(novoModelo);
                    alteradoSucesso();
                    break;
                case 3:
                    System.out.println("Digite a nova marca: ");
                    String novaMarca = teclado.next();
                    teclado.nextLine();
                    v.setMarca(novaMarca);
                    alteradoSucesso();
                    break;
                case 4:
                    System.out.println("Digite o novo ano: ");
                    int novoAno = teclado.nextInt();
                    teclado.nextLine();
                    v.setAno(novoAno);
                    alteradoSucesso();
                    break;
                case 5:
                    System.out.println("Digite a nova quilometragem: ");
                    int novaQuilometragem = teclado.nextInt();
                    teclado.nextLine();
                    v.setQuilometragem(novaQuilometragem);
                    alteradoSucesso();
                    break;
                case 6:
                    System.out.println("Escolha o novo cargo:  ");
                    System.out.println(" Digite (1) para Diretor e (2) para Funcionário: ");
                    int aux1 = teclado.nextInt();
                    teclado.nextLine();
                    switch (aux1) {
                        case 1:
                            v.setCargoVeiculo(CargoVeiculo.DIRETOR);
                            break;
                        case 2:
                            v.setCargoVeiculo(CargoVeiculo.FUNCIONARIO);
                            break;
                        default:
                            System.out.println(" *** Insira apenas uma das opções: (1) ou (2) *** ");
                            System.out.println("");

                    }
                    alteradoSucesso();
                    break;
                case 7:
                    System.out.println("Digite a nova disponibilidade do veículo: ");
                    System.out.println("Digite (1) para Disponível e (2) para indisponível): ");
                    int aux2 = teclado.nextInt();
                    teclado.nextLine();
                    if (aux2 == 1) {
                        v.setEmprestado(false);
                    } else {
                        v.setEmprestado(true);
                    }
                    alteradoSucesso();
                    break;
                default:
                    System.out.println(" *** Insira apenas uma das opções: (1),(2),(3),(4) ou (5) *** ");
            }
        }
    }

    @Override
    public void voltaTelaInicial() {
        ControladorVeiculo.getINSTANCE().voltaTelaInicial();
    }

}
