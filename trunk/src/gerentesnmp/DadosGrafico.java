/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

/**
 *
 * @author 
 */
public class DadosGrafico {

    private double valor;
    private String cor;
    private String titulo;

    public DadosGrafico(double valor, String cor, String titulo) {
        this.valor = valor;
        this.cor = cor;
        this.titulo = titulo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

}
