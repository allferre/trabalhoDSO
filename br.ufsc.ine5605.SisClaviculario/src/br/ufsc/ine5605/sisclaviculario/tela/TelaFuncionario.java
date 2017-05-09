package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorFuncionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.Cargo;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class TelaFuncionario {

    private Scanner teclado;
    private ControladorFuncionario ctrlF;
    private Cargo cargo;

    public TelaFuncionario(ControladorFuncionario ctrlF) {
        this.ctrlF = ctrlF;
        teclado = new Scanner(System.in);

    }

    public void telaFuncionario() {

        int opcao = 0;
        do {
            ctrlF.cabecalhoTelaFuncionario();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    excluirFuncionario();
                    break;
                case 3:
                    alterarFuncionario();
                    break;
                case 4:
                    exibeListaFuncionarios();
                    break;
                case 5:
                    ctrlF.voltaTelaInicial();
                    break;
                default:
                    System.out.println(" *** Insira apenas o número das opções do Menu *** ");
                    System.out.println("");
            }

        } while (opcao != 0);

    }

    public void cadastrarFuncionario() {

        int opcao = 0;

        System.out.println("Digite o numMatricula do Funcionario: ");
        int numMatricula = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Digite o nome do Funcionario: ");
        String nome = teclado.nextLine();

        System.out.println("Digite a data de nascimento do Funcionario: ");
        String dataNascimento = teclado.next();
        teclado.nextLine();

        System.out.println("Digite o telefone do Funcionario: ");
        long telefone = teclado.nextLong();
        teclado.nextLine();

        System.out.println("Defina o cargo do Funcionário: ");
        System.out.println(" Digite (1) para Diretor e (2) para Funcionário: ");
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

        Funcionario funcionario = new Funcionario(numMatricula, nome, dataNascimento, telefone, cargo);
        System.out.println("");

        ctrlF.incluiFuncionario(funcionario);
        ctrlF.cadastradoSucesso();
    }

    public void excluirFuncionario() {

        int matriculaParaExcluir = pedeNumMatricula();
        for (Funcionario funcionarioExcluir : ctrlF.getListaFuncionarios()) {
            if (funcionarioExcluir.getNumMatricula() == matriculaParaExcluir) {
                ctrlF.excluiFuncionarioPelaMatricula(funcionarioExcluir);
                System.out.println("Funcionário excluido com sucesso! ");
                break;
            } else {
                System.out.println("Esse número de matrícula não consta no banco de dados");
            }
        }
    }

    public void alterarFuncionario() {

        int matriculaParaAlterar = pedeNumMatricula();
        boolean found = false;
        Funcionario f = null;

        for (Funcionario funcionarioAlterar : ctrlF.getListaFuncionarios()) {
            if (funcionarioAlterar.getNumMatricula() == matriculaParaAlterar) {
                f = funcionarioAlterar;
                found = true;
                break;
            }
        }

        if (f != null && found) {
            ctrlF.cabecalhoAlteraFuncionario();
            int aux = teclado.nextInt();
            switch (aux) {
                case 1:
                    System.out.println("Digite o novo número de matrícula: ");
                    int numMatricula = teclado.nextInt();
                    teclado.next();
                    f.setNumMatricula(numMatricula);

                    break;
                case 2:
                    System.out.println("Digite o novo nome: ");
                    String Novonome = teclado.nextLine();
                    teclado.nextLine();
                    System.out.println(Novonome);
                    f.setNome(Novonome);

                    break;
                case 3:
                    System.out.println("Digite a nova data de nascimento: ");
                    String dataNascimento = teclado.nextLine();
                    teclado.next();
                    f.setDataNascimento(dataNascimento);

                    break;
                case 4:
                    System.out.println("Digite o novo telefone: ");
                    long telefone = teclado.nextLong();
                    teclado.next();
                    f.setTelefone(telefone);

                    break;
                case 5:
                    System.out.println("Escolha o novo cargo:  ");
                    System.out.println(" Digite (1) para Diretor e (2) para Funcionário: ");
                    int aux1 = teclado.nextInt();
                    teclado.next();
                    switch (aux1) {
                        case 1:
                            f.setCargo(Cargo.DIRETOR);
                            break;
                        case 2:
                            f.setCargo(Cargo.FUNCIONARIO);
                            break;
                        default:
                            System.out.println(" *** Insira apenas uma das opções: (1) ou (2) *** ");
                            System.out.println("");
                            break;
                    }
            }
            //ctrlF.alteraFuncionarioPelaMatricula(f);
        } else {
            System.out.println("Esse número de matrícula não consta no banco de dados");
        }
    }

    public void exibeListaFuncionarios() {

        for (int i = 0; i < ctrlF.getListaFuncionarios().size(); i++) {
            Funcionario funcionario = ctrlF.getListaFuncionarios().get(i);
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

    public int pedeNumMatricula() {
        System.out.println("Digite o número de matrícula do funcionário: ");
        int numMatricula = teclado.nextInt();
        return numMatricula;
    }
}

