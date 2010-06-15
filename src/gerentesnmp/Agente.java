/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

/**
 *
 * @author 
 */
public class Agente {

    private String ip;
    private String comunidade;

    public Agente(String ip, String comunidade) {
        this.ip = ip;
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
}
