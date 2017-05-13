package br.ufsc.ine5605.sisclaviculario.entidade;

/**
 *
 * @author Allan
 */
public class Veiculo {


    public enum CargoVeiculo {

        DIRETOR("Diretor"),
        FUNCIONARIO("Funcionario");
        public String mensagem;

        CargoVeiculo(String mensagem) {

            this.mensagem = mensagem;
        }

    }

    private String placa;
    private String modelo;
    private String marca;
    private int ano;
    private float quilometragem;
    private CargoVeiculo cargo;
    private boolean emprestado;

    public Veiculo(String placa, String modelo, String marca, int ano, float quilometragem, CargoVeiculo cargo, boolean emprestado) {
        this.placa = placa;
        this.modelo = modelo;
        this.marca = marca;
        this.ano = ano;
        this.quilometragem = quilometragem;
        this.cargo = cargo;
        this.emprestado = emprestado;

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

    public CargoVeiculo getCargoVeiculo() {
        return cargo;
    }

    public void setCargoVeiculo(CargoVeiculo cargo) {
        this.cargo = cargo;
    }

    public boolean getEmprestado() {
        return emprestado;
    }

    public void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }

 

}
