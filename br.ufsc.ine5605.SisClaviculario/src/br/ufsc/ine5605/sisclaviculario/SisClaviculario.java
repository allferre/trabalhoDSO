package br.ufsc.ine5605.sisclaviculario;

import Enum.Motivo;
import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario.CargoFuncionario;
import br.ufsc.ine5605.sisclaviculario.entidade.RelatorioAcesso;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;

/**
 *
 * @author Allan
 */
public class SisClaviculario {

    public static void main(String[] args) {
        
 //FUNCIONARIOS CADASTRADOS
 
        Funcionario funcionario1 = new Funcionario(123,"Ironman","2804",222,CargoFuncionario.DIRETOR);
        Funcionario funcionario2 = new Funcionario(456,"Capitão América","2804",222,CargoFuncionario.DIRETOR);
        Funcionario funcionario3 = new Funcionario(789,"Hulk","2804",222,CargoFuncionario.FUNCIONARIO);
        Funcionario funcionario4 = new Funcionario(500,"Thor","2804",222,CargoFuncionario.FUNCIONARIO);
 
// VEICULOS CADASTRADOS
        Veiculo veiculo1 = new Veiculo("abc123","ka","ford",2012,500000,CargoVeiculo.FUNCIONARIO, false); // veículo disponível
        Veiculo veiculo2 = new Veiculo("abc456","fusion","ford",2017,500,CargoVeiculo.DIRETOR, false);  // veículo disponível
        Veiculo veiculo3 = new Veiculo("abc789","fiesta","ford",2015,5000,CargoVeiculo.FUNCIONARIO, true); // veículo indisponível
        Veiculo veiculo4 = new Veiculo("abc500","A6","Audi",2017,500,CargoVeiculo.DIRETOR, true); // veículo indisponível
    
//HISTORICO DE EMPRESTIMOS
        RelatorioAcesso relatorioAcesso1 = new RelatorioAcesso(123,"abc456",Motivo.VeiculoLiberado.mensagem,null); 
        RelatorioAcesso relatorioAcesso2 = new RelatorioAcesso(789,"abc500",Motivo.AcessoNaoPermitido.mensagem,null);
        RelatorioAcesso relatorioAcesso3 = new RelatorioAcesso(444,"abc123",Motivo.MatriculaNaoExiste.mensagem,null);
        RelatorioAcesso relatorioAcesso4 = new RelatorioAcesso(456,"abc456",Motivo.VeiculoIndisponível.mensagem,null);
        RelatorioAcesso relatorioAcesso5 = new RelatorioAcesso(456,"abc456",Motivo.AcessoBloqueado.mensagem,null);
        
   ControladorPrincipal.getINSTANCE().incluirFuncionario(funcionario1, funcionario2, funcionario3, funcionario4);
   ControladorPrincipal.getINSTANCE().incluirVeiculo(veiculo1, veiculo2, veiculo3, veiculo4);
   ControladorPrincipal.getINSTANCE().incluirEmprestimo(relatorioAcesso1, relatorioAcesso2, relatorioAcesso3, relatorioAcesso4,relatorioAcesso5);
   
   
   ControladorPrincipal.getINSTANCE().inicia();
 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
