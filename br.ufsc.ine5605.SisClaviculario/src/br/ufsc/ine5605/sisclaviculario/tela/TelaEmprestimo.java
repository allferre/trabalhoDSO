package br.ufsc.ine5605.sisclaviculario.tela;

import Enum.Motivo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorEmprestimo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Emprestimo;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

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
    private String motivo;
    private Date dataDoEvento;
    private static TelaEmprestimo INSTANCE;
    

    public TelaEmprestimo(){ //ControladorEmprestimo ctrlE) {
        //this.ctrlE = ctrlE;
        teclado = new Scanner(System.in);
        listaFuncionarios = new ArrayList<>();
        this.numeroMatricula = numeroMatricula;
        this.motivo = motivo;
        this.dataDoEvento = dataDoEvento;
       
    }
    
     public static TelaEmprestimo getINSTANCE(){
    
        if(INSTANCE == null){
            return INSTANCE = new TelaEmprestimo();
        }
        return INSTANCE;
    }

    public void exibeMenuEmprestimo() {
        int opcao = 0;

        do {
            ctrlE.telaEmprestimo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    ControladorEmprestimo.getINSTANCE().solicitarVeiculo();
                    break;
                case 2:
                    devolverVeiculo();
                    break;
                case 3:
                    exibeListaEprestimos();
                    break;
                case 4:
                    ctrlE.voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
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
                motivo = " ***Essa placa não consta no banco de dados*** ";
                break;
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
                break;
            }
        }
        return null;
    }

    public Veiculo verificaPlacaCargo(String placaSolicitada) {

        for (Veiculo verificaVeiculo : ctrlE.solicitarListaVeiculos()) { // verifica a restrição do acesso pelo Funcionário
            if (verificaVeiculo.getCargoVeiculo() == CargoVeiculo.FUNCIONARIO) {
                return verificaVeiculo;
            } else {
                System.out.println(" ***Vc não possui acesso a esse veículo*** ");
                break;
            }
        }
        return null;
    }

    public void exibeListaEprestimos() {

        System.out.println(" -------------------------------------------------------");
        System.out.println("|                 Lista de Empréstimos                  |");
        System.out.println(" -------------------------------------------------------");

        for (int i = 0; i < ctrlE.getListaEmprestimos().size(); i++) {
            Emprestimo emprestimo = ctrlE.getListaEmprestimos().get(i);
        }

        for (Emprestimo emprestimo : ctrlE.getListaEmprestimos()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Placa:  " + emprestimo.getPlacaUsada());
            System.out.println("Número de Matrícula: " + emprestimo.getNumMatricula());
            System.out.println("Data do empréstimo: " + emprestimo.getData());
            System.out.println("Motivo: " + emprestimo.getMotivo());
            System.out.println("-------------------------------------------------------");
        }
    }

    public void mensagemDoEvento(String tipo) {
        System.out.println(tipo);
        System.out.println("-----------------------------------------------");
        System.out.println("");
    }

    public int recebeMatricula() {
        System.out.println("Digite a Matrícula: ");
        return recebeInteiro();
    }

    public void mensagemDeErro(int i) {
        switch (i) {

            case 1:
                System.out.println("O valor digitado é inválido!");
        }
    }

    public String recebePlaca() {
        System.out.println("Digite a placa: ");
        String placa = teclado.next();
        teclado.nextLine();
        return placa;
    }
    
        public int recebeInteiro() {

        try {
            return teclado.nextInt();
        } catch (InputMismatchException e) {
            mensagemDeErro(1);
            teclado.nextLine();
            return 0;
        }
    }

    public void exibeMensagem(String motivo) {
        System.out.println(motivo);
    }

}
