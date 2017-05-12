package br.ufsc.ine5605.sisclaviculario.entidade;
import java.util.Date;

/**
 *
 * @author Allan
 */
public class Emprestimo {
    
    private int numMatricula;
    private String placaUsada;
    private Date data;
    private String motivo;
    
    public Emprestimo(int numMatricula, String placaUsada, Date data, String motivo){
        this.numMatricula = numMatricula;
        this.placaUsada = placaUsada;
        this.data = data;
        this.motivo = motivo;
        
    }

    public int getNumMatricula() {
        return numMatricula;
    }

    public void setNumMatricula(int numMatricula) {
        this.numMatricula = numMatricula;
    }

    public String getPlacaUsada() {
        return placaUsada;
    }

    public void setPlacaUsada(String placaUsada) {
        this.placaUsada = placaUsada;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    
    
    
    
}