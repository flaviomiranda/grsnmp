/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author christianfs
 */
public class Monitor extends Thread  {
    
    private String sysUpTime;

    public Monitor(String sysUpTime) {
        this.sysUpTime = sysUpTime;
    }

    public boolean monitorar(){
        if(sysUpTime.equals("noSuchObject")){
            System.out.print("\007");
            System.out.flush();
            System.out.println("***O agente não está ativo!!!***");
            return false;
        }
        return true;
    }

    public boolean monitorarthread() /*throws Exception*/{
        if(sysUpTime.equals("noSuchObject")){
          //  throw new Exception("Sys down");
            System.out.print("\007");
            System.out.flush();
            System.out.println("***O agente não está ativo(from thread)!!!***");
            return false;
        }
        return true;
    }

    @Override
    public void run(){
        //try {
            monitorarthread();
        //} catch (Exception ex) {
        //    Logger.getLogger(Monitor.class.getName()).log(Level.SEVERE, null, ex);
        //}
    }
 }

