
package br.ufsc.ine5605.sisclaviculario.tela;
import Enum.Motivo;
import java.util.Scanner;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorRelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;


//@author Graciela Banegas
 
public class TelaRelatorioAcesso extends TelasCabecalho{
  
    private Scanner teclado;
    private static TelaRelatorioAcesso INSTANCE;

    public TelaRelatorioAcesso() {
     this.teclado = new Scanner(System.in);
    }
    
     public static TelaRelatorioAcesso getINSTANCE() {
        if (INSTANCE == null) {
            return INSTANCE = new TelaRelatorioAcesso();
        }
        return INSTANCE;
    }

    public void exibeMenuRelatorio() {
        int opcao = 0;
        do {
            cabecalhoTelaRelatorioAcesso();
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
                    ControladorRelatorioAcesso.getINSTANCE().voltarTelaInicial();
                    break;
                default:
                    System.out.println("Insira apenas o número das opções do Menu");
            }

        } while (opcao != 0);
    }


 

    private void listaTodosAcessos() {

        for (int i = 0; i < ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso.size(); i++) {
            RelatorioAcesso relatorioAcesso = ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso().get(i); 
        }

        for (RelatorioAcesso relatorioAcesso : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()) {
            System.out.println("-------------------------------------------------------");
            System.out.println("Número de Matrícula: " + relatorioAcesso.getMatriculaAcesso());
            System.out.println("Placa do Veículo: " + relatorioAcesso.getPlacaAcesso());
            System.out.println("Status de Acesso: " + relatorioAcesso.getMensagemAcesso());
            System.out.println("Data da Tentativa de Acesso: " + relatorioAcesso.getDataAcesso() );
            System.out.println("-------------------------------------------------------");
        }
    }
     

    private void listaAcessosNegados() {
       
    for (RelatorioAcesso relatorioAcessoNegado : ControladorRelatorioAcesso.getINSTANCE().listaRelatoriosAcesso){
        if (relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.AcessoBloqueado.mensagem) && relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.AcessoNaoPermitido.mensagem) && relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.VeiculoIndisponível.mensagem)&& relatorioAcessoNegado.getMensagemAcesso().equals(Motivo.MatriculaNaoExiste)){
            
        }
    }
      
    for (RelatorioAcesso relatorioAcessoNegado : ControladorRelatorioAcesso.getINSTANCE().getListaRelatoriosAcesso()){
         
            System.out.println("-------------------------------------------------------");
            System.out.println("Número de Matrícula: " + relatorioAcessoNegado.getMatriculaAcesso());
            System.out.println("Placa do Veículo: " + relatorioAcessoNegado.getPlacaAcesso());
            System.out.println("Status de Acesso: " + relatorioAcessoNegado.getMensagemAcesso());
            System.out.println("Data da Tentativa de Acesso: " + relatorioAcessoNegado.getDataAcesso() );
            System.out.println("-------------------------------------------------------");
        }
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



