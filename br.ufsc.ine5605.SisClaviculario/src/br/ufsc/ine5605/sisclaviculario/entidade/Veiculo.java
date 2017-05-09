package br.ufsc.ine5605.sisclaviculario.entidade;

/**
 *
 * @author Allan
 */
public class Veiculo {

    public enum Cargo {DIRETOR, FUNCIONARIO};
    
    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private float quilometragem;
    private Cargo cargo;
    private Funcionario emprestado;
    
    public Veiculo(String placa, String modelo, String marca, int ano, float quilometragem, Cargo cargo) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.cargo = cargo;
        this.emprestado = null;

    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public float getQuilometragem() {
        return quilometragem;
    }

    public void setQuilometragem(float quilometragem) {
        this.quilometragem = quilometragem;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Funcionario getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(Funcionario emprestado) {
        this.emprestado = emprestado;
    }
    
}

