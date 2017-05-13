
package br.ufsc.ine5605.sisclaviculario.controle;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.tela.TelaRelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;

public class ControladorRelatorioAcesso {
    
    private static ControladorRelatorioAcesso INSTANCE;
    private TelasCabecalho telasCabecalho;
    private Scanner teclado;
    
    public ArrayList<RelatorioAcesso> listaRelatoriosAcesso;
    
    
    private ControladorRelatorioAcesso(){
        this.listaRelatoriosAcesso = new ArrayList<>();
        
    }
    
    public static ControladorRelatorioAcesso getINSTANCE(){
        if (INSTANCE == null){
            return INSTANCE = new ControladorRelatorioAcesso();
        }
        return INSTANCE;
    }

    public void adicionaNovoAcesso(int matriculaAcesso, String placaAcesso, String mensagemAcesso, Date dataAcesso) {
        RelatorioAcesso relatorioAcesso = new RelatorioAcesso(matriculaAcesso, placaAcesso, mensagemAcesso, dataAcesso);
        listaRelatoriosAcesso.add(relatorioAcesso);
    }

    public ArrayList<RelatorioAcesso> getListaRelatoriosAcesso() {
        return listaRelatoriosAcesso;
    }

    public void setListaRelatoriosAcesso(ArrayList<RelatorioAcesso> listaRelatoriosAcesso) {
        this.listaRelatoriosAcesso = listaRelatoriosAcesso;
    }

    public void voltarTelaInicial() {
        ControladorPrincipal.getINSTANCE().inicia();
    }
    
    public void cabecalhoTelaRelatorioAcesso() {
        telasCabecalho.cabecalhoTelaRelatorioAcesso();
    }
   }
       

    

  





