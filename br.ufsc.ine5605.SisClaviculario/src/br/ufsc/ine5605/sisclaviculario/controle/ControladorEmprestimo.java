package br.ufsc.ine5605.sisclaviculario.controle;



import br.ufsc.ine5605.sisclaviculario.entidade.Emprestimo;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.tela.TelaEmprestimo;
import br.ufsc.ine5605.sisclaviculario.tela.TelasCabecalho;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import java.util.ArrayList;

/**
 *
 * @author Allan
 */
public class ControladorEmprestimo {

    private TelaEmprestimo telaEmprestimo;
    private ControladorPrincipal ctrlP;
    private TelasCabecalho telasCabecalho;
    private ArrayList<Emprestimo> listaEmprestimos;
    public static ControladorEmprestimo INSTANCE = new ControladorEmprestimo();
    
    private ControladorEmprestimo(){
        this.telaEmprestimo = new TelaEmprestimo(this);
        this.telasCabecalho = new TelasCabecalho();
        this.listaEmprestimos = new ArrayList<>();
        
    }
    
    public void setControladorP(ControladorPrincipal CtrlP){
        this.ctrlP = CtrlP;
    }

    public void exibeTelaEmprestimo() {
        telaEmprestimo.exibeMenuEmprestimo();
    }
    
    public void voltarTelaInicial(){
        ctrlP.inicia();
    }

    public void telaEmprestimo() {
        telasCabecalho.cabecalhoTelaEmprestimo();
    }

    public  ArrayList<Funcionario> solicitarListaFuncionarios() {
        return ctrlP.pedirListaFuncionarios();
    }

    public ArrayList<Veiculo> solicitaListaVeiculos() {
         return ctrlP.pedirListaVeiculos();
    }
    
     public ArrayList<Veiculo> solicitarListaVeiculos() {
        return ctrlP.pedirListaVeiculos();
    }

    public void incluirEmprestimo(Emprestimo emprestimo) {
        listaEmprestimos.add(emprestimo);
    }

    public ArrayList<Emprestimo> getListaEmprestimos() {
        return listaEmprestimos;
    }

    public void setListaEmprestimos(ArrayList<Emprestimo> listaEmprestimos) {
        this.listaEmprestimos = listaEmprestimos;
    }

}