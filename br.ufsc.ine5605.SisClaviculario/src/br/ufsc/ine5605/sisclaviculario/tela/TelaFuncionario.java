package br.ufsc.ine5605.sisclaviculario.tela;

import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorFuncionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario.CargoFuncionario;
import java.util.Scanner;

/**
 *
 * @author Allan
 */
public class TelaFuncionario extends TelasCabecalho {

    private Scanner teclado1;
    private CargoFuncionario cargo;
    private static TelaFuncionario INSTANCE;

    private TelaFuncionario() {

        teclado1 = new Scanner(System.in);
    }

    public static TelaFuncionario getINSTANCE() {

        if (INSTANCE == null) {
            return INSTANCE = new TelaFuncionario();
        }
        return INSTANCE;
    }

    public void telaFuncionario() {

        int opcao = 0;
        do {
            cabecalhoTelaFuncionario();
            opcao = teclado1.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    ControladorFuncionario.getINSTANCE().excluirFuncionario();
                    break;
                case 3:
                    alterarFuncionario();
                    break;
                case 4:
                    exibeListaFuncionarios();
                    break;
                case 5:
                    ControladorFuncionario.getINSTANCE().voltaTelaInicial();
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
       
        int numMatricula = teclado1.nextInt();
        teclado1.nextLine();
         //ControladorFuncionario.getINSTANCE().tratandoExcessoes();

        System.out.println("Digite o nome do Funcionario: ");
        String nome = teclado1.nextLine();

        System.out.println("Digite a data de nascimento do Funcionario: ");
        String dataNascimento = teclado1.next();
        teclado1.nextLine();

        System.out.println("Digite o telefone do Funcionario: ");
        long telefone = teclado1.nextLong();
        teclado1.nextLine();

        System.out.println("Defina o cargo do Funcionário: ");
        System.out.println(" Digite (1) para Diretor e (2) para Funcionário: ");
        opcao = teclado1.nextInt();
        teclado1.nextLine();
        switch (opcao) {
            case 1:
                cargo = CargoFuncionario.DIRETOR;
                break;
            case 2:
                cargo = CargoFuncionario.FUNCIONARIO;
                break;
            default:
                System.out.println("Insira apenas uma das opções: (1) ou (2) ");
        }

        System.out.println("");

        ControladorFuncionario.getINSTANCE().incluiFuncionario(numMatricula, nome, dataNascimento, telefone, cargo);
        cadastradoSucesso();
    }

    public void alterarFuncionario() {

        int matriculaParaAlterar = pedeNumMatricula();
        boolean found = false;
        Funcionario f = null;

        for (Funcionario funcionarioAlterar : ControladorFuncionario.getINSTANCE().getListaFuncionarios()) {
            if (funcionarioAlterar.getNumMatricula() == matriculaParaAlterar) {
                f = funcionarioAlterar;
                found = true;
                break;
            }
        }

        if (f != null && found) {
            cabecalhoAlteraFuncionario();
            int aux = teclado1.nextInt();
            switch (aux) {
                case 1:
                    System.out.println("Digite o novo número de matrícula: ");
                    int numMatricula = teclado1.nextInt();
                    teclado1.next();
                    f.setNumMatricula(numMatricula);

                    break;
                case 2:
                    System.out.println("Digite o novo nome: ");
                    String Novonome = teclado1.nextLine();
                    teclado1.nextLine();
                    System.out.println(Novonome);
                    f.setNome(Novonome);

                    break;
                case 3:
                    System.out.println("Digite a nova data de nascimento: ");
                    String dataNascimento = teclado1.nextLine();
                    teclado1.next();
                    f.setDataNascimento(dataNascimento);

                    break;
                case 4:
                    System.out.println("Digite o novo telefone: ");
                    long telefone = teclado1.nextLong();
                    teclado1.next();
                    f.setTelefone(telefone);

                    break;
                case 5:
                    System.out.println("Escolha o novo cargo:  ");
                    System.out.println(" Digite (1) para Diretor e (2) para Funcionário: ");
                    int aux1 = teclado1.nextInt();
                    teclado1.next();
                    switch (aux1) {
                        case 1:
                            f.setCargo(CargoFuncionario.DIRETOR);
                            break;
                        case 2:
                            f.setCargo(CargoFuncionario.FUNCIONARIO);
                            break;
                        default:
                            System.out.println(" *** Insira apenas uma das opções: (1) ou (2) *** ");
                            System.out.println("");
                            break;
                    }
            }
        } else {
            System.out.println("Esse número de matrícula não consta no banco de dados");
        }
    }

    public void exibeListaFuncionarios() {

        for (int i = 0; i < ControladorFuncionario.getINSTANCE().getListaFuncionarios().size(); i++) {
            Funcionario funcionario = ControladorFuncionario.getINSTANCE().getListaFuncionarios().get(i);
        }

        for (Funcionario funcionario : ControladorFuncionario.getINSTANCE().getListaFuncionarios()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Dados de  " + funcionario.getNome());
            System.out.println("Número de Matrícula: " + funcionario.getNumMatricula());
            System.out.println("Data de nascimento: " + funcionario.getDataNascimento());
            System.out.println("Telefone: " + funcionario.getTelefone());
            System.out.println("Cargo do funcionário: " + funcionario.getCargoFuncionario().mensagem);
            System.out.println("-------------------------------------------------------");
        }
    }

    public int pedeNumMatricula() {
        System.out.println("Digite o número de matrícula do funcionário: ");
        int numMatricula = teclado1.nextInt();
        return numMatricula;
    }

    public void excluidoSucesso() {
        System.out.println(" ***Funcionário excluído com sucesso*** ");
    }

    public void matriculaNaoExiste() {
        System.out.println(" ***Matrícula não consta no banco de dados*** ");
    }
}
