package br.ufsc.ine5605.Sisclaviculario;

import br.ufsc.ine5605.sisclaviculario.controle.ControladorPrincipal;
import br.ufsc.ine5605.sisclaviculario.entidade.Funcionario;
import br.ufsc.ine5605.sisclaviculario.entidade.Veiculo;

/**
 *
 * @author Allan
 */
public class SisClaviculario {

    public static void main(String[] args) {
        ControladorPrincipal ctrlP = new ControladorPrincipal();
        
        
        Funcionario funcionario1 = new Funcionario(123,"Allan","2804",222,Veiculo.Cargo.DIRETOR);
        Funcionario funcionario2 = new Funcionario(456,"Graci","2804",222,Veiculo.Cargo.DIRETOR);
        Funcionario funcionario3 = new Funcionario(789,"Hulk","2804",222,Veiculo.Cargo.FUNCIONARIO);
        
        Veiculo veiculo1 = new Veiculo("abc123","ka","ford",2012,500000,Veiculo.Cargo.FUNCIONARIO);
        Veiculo veiculo2 = new Veiculo("abc456","fusion","ford",2017,500,Veiculo.Cargo.DIRETOR);
        Veiculo veiculo3 = new Veiculo("abc789","fiesta","ford",2015,5000,Veiculo.Cargo.FUNCIONARIO);
    
   ctrlP.incluirFuncionario(funcionario1, funcionario2, funcionario3);
   ctrlP.incluirVeiculo(veiculo1, veiculo2, veiculo3);
   ctrlP.inicia();
    
    
    
    
    }

}
