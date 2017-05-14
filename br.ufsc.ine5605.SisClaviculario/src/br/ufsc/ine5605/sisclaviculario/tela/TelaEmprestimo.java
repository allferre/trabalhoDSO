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
public class TelaEmprestimo extends TelasCabecalho {

    private Scanner teclado;
    private ArrayList<Funcionario> listaFuncionarios;
    private Veiculo veiculoVerificado;
    private int numeroMatricula;
    private String motivo;
    private Date dataDoEvento;
    private static TelaEmprestimo INSTANCE;
    

    public TelaEmprestimo(){ 
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

    /*public void exibeMenuEmprestimo() {
        int opcao = 0;

        do {
            ControladorEmprestimo.getINSTANCE().telaEmprestimo();
            opcao = teclado.nextInt();

            switch (opcao) {
                case 1:
                    ControladorEmprestimo.getINSTANCE().solicitarVeiculo();
                    break;
                case 2:
                    ControladorEmprestimo.getINSTANCE().devolverVeiculo();
                    break;
                case 3:
                    exibeListaEprestimos();
                    break;
                case 4:
                    ControladorEmprestimo.getINSTANCE().voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }*/


    public void exibeListaEprestimos() {

        System.out.println(" -------------------------------------------------------");
        System.out.println("|                 Lista de Empréstimos                  |");
        System.out.println(" -------------------------------------------------------");

        for (int i = 0; i < ControladorEmprestimo.getINSTANCE().getListaEmprestimos().size(); i++) {
            Emprestimo emprestimo = ControladorEmprestimo.getINSTANCE().getListaEmprestimos().get(i);
        }

        for (Emprestimo emprestimo : ControladorEmprestimo.getINSTANCE().getListaEmprestimos()) {
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
        System.out.println("");
        System.out.println(motivo);
        System.out.println("");
    }

    public int receberNovaQuilometragem() {
        System.out.println("Digite a quilometragem movimentada pelo veículo");
        int km = teclado.nextInt();
        return km;
    }

}
