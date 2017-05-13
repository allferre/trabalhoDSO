
package br.ufsc.ine5605.sisclaviculario.controle;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;
import java.util.ArrayList;
import java.util.Date;

public class ControladorRelatorioAcesso {
    
    private static ControladorRelatorioAcesso INSTANCE;
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
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package br.ufsc.ine5605.sisclaviculario.controle;
import br.ufsc.ine5605.sisclaviculario.tela.TelaRelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import java.util.Scanner;


 *
 * @author Graciela Banegas
 
public class ControladorRelatorioAcesso {

    static ControladorRelatorioAcesso INSTANCE;
    
    
    private TelaRelatorioAcesso telaRelatorioAcesso;
    private TelasCabecalho telasCabecalho;
    private ControladorPrincipal ctrlP;
    private Scanner teclado;
    public static ControladorRelatorioAcesso ctrlR = new ControladorRelatorioAcesso();
    
   
   private ControladorRelatorioAcesso(){
       this.telaRelatorioAcesso = new TelaRelatorioAcesso(this);
       this.telasCabecalho = new TelasCabecalho();
      
   }
   public void setControladorP(ControladorPrincipal CtrlP) {
        this.ctrlP = CtrlP;
    
   }   
   
   public void exibeTelaRelatorioAcesso(){
       telaRelatorioAcesso.mostraRelatorioAcesso();
   }
   
    public void cabecalhoTelaRelatorioAcesso() {
        telasCabecalho.cabecalhoTelaRelatorioAcesso();
    }

    public void voltarTelaInicial() {
        ctrlP.inicia();
    }
    
  
    
   // public ArrayList <Acesso> getlistaLogAcesso();
      //  return listaLogAcesso;
    
    //public void setlistaLogAcesso(ArrayList <Acesso> listaAcessos){
        
        //this.listaAcessos = listaAcessos;
   // }

    public void pedirListaEmprestimos() {
        ctrlP.pedirListaEmprestimos();
    }
*/

     

    

  





