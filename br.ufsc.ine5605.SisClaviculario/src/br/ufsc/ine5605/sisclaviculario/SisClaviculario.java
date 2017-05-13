package br.ufsc.ine5605.sisclaviculario;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario.CargoFuncionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo.CargoVeiculo;

/**
 *
 * @author Allan
 */
public class SisClaviculario {

    public static void main(String[] args) {
        
        Funcionario funcionario1 = new Funcionario(123,"Allan","2804",222,CargoFuncionario.DIRETOR);
        Funcionario funcionario2 = new Funcionario(456,"Graci","2804",222,CargoFuncionario.DIRETOR);
        Funcionario funcionario3 = new Funcionario(789,"Hulk","2804",222,CargoFuncionario.FUNCIONARIO);
        Funcionario funcionario4 = new Funcionario(500,"Thor","2804",222,CargoFuncionario.FUNCIONARIO);
        
        Veiculo veiculo1 = new Veiculo("abc123","ka","ford",2012,500000,CargoVeiculo.FUNCIONARIO, false); // veículo disponível
        Veiculo veiculo2 = new Veiculo("abc456","fusion","ford",2017,500,CargoVeiculo.DIRETOR, false);  // veículo disponível
        Veiculo veiculo3 = new Veiculo("abc789","fiesta","ford",2015,5000,CargoVeiculo.FUNCIONARIO, true); // veículo indisponível
        Veiculo veiculo4 = new Veiculo("abc500","A6","Audi",2017,500,CargoVeiculo.DIRETOR, true); // veículo indisponível
    
   ControladorPrincipal.getINSTANCE().incluirFuncionario(funcionario1, funcionario2, funcionario3, funcionario4);
   ControladorPrincipal.getINSTANCE().incluirVeiculo(veiculo1, veiculo2, veiculo3, veiculo4);
   
   ControladorPrincipal.getINSTANCE().inicia();
 
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
