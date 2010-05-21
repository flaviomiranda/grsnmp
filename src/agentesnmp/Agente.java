/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agentesnmp;

/**
 *
 * @author christianfs
 */
public class Agente {

    private String ip;
    private int tempo;
    private String comunidade;

    public Agente(String ip, int tempo, String comunidade) {
        this.ip = ip;
        this.tempo = tempo;
        this.comunidade = comunidade;
    }

    public String getComunidade() {
        return comunidade;
    }

    public void setComunidade(String comunidade) {
        this.comunidade = comunidade;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

}
