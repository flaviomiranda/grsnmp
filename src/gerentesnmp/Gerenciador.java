/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;

/**
 *
 * @author christianfs
 */
public class Gerenciador implements Runnable {
    
    private Agente agente;
    private VariableBinding[] respostaGet;
    private VariableBinding[] respostaGetBulk;

    public Gerenciador(Agente agente) {
        this.agente = agente;
    }

    public void run() {
        gerenciar();
    }

    public void gerenciar(){
        List<OID> oidsGet = new ArrayList<OID>();
        OID sysDescr = new OID("1.3.6.1.2.1.1.1.0");
        OID sysUpTime = new OID("1.3.6.1.2.1.1.3.0");
        oidsGet.add(sysDescr);
        oidsGet.add(sysUpTime);

        List<OID> oidsGetBulk = new ArrayList<OID>();
        OID ifTable = new OID("1.3.6.1.2.1.2.2");
        oidsGetBulk.add(ifTable);

        Gerente ger = new Gerente(this.agente);
        try{
            respostaGet = ger.get(oidsGet);
            Monitor mon = new Monitor(respostaGet[1].toString());
            if(mon.monitorar())
            {
                for(VariableBinding var : respostaGet)
                    System.out.println(var.toString());

                respostaGetBulk = ger.getBulk(oidsGetBulk, 0, 44);
                for(VariableBinding var : respostaGetBulk)
                    System.out.println(var.toString());
            }
            ger.stop();
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
