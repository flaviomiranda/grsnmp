/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

/**
 *
 * @author christianfs
 */
public class Monitor {
    
    private String sysUpTime;

    public Monitor(String sysUpTime) {
        this.sysUpTime = sysUpTime;
    }

    public boolean monitorar(){
        if(sysUpTime.equals("noSuchObject")){
            System.out.println("***O agente não está ativo!!!***");
            return false;
        }
        return true;
    }
}
