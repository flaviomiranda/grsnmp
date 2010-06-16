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
public class Gerenciador /*implements Runnable*/ {

    private Agente agente;
    private VariableBinding[] respostaGet;
    private VariableBinding[] respostaGetBulkIfTable;
    static final String nroEthernet = "2";

    public Gerenciador(Agente agente) {
        this.agente = agente;
    }

//    public void run() {
//        gerenciar();
//    }

    public Agente gerenciar() {
        List<OID> oidsGet = new ArrayList<OID>();
        OID sysDescr = new OID("1.3.6.1.2.1.1.1.0");
        OID sysUpTime = new OID("1.3.6.1.2.1.1.3.0");
        OID ipInReceives = new OID("1.3.6.1.2.1.4.3.0");
        OID ipInHdrErrors = new OID("1.3.6.1.2.1.4.4.0");
        OID ipInAddrErrors = new OID("1.3.6.1.2.1.4.5.0");
        OID ipForwDatagrams = new OID("1.3.6.1.2.1.4.6.0");
        OID ipInUnknownProtos = new OID("1.3.6.1.2.1.4.7.0");
        OID ipInDiscards = new OID("1.3.6.1.2.1.4.8.0");
        oidsGet.add(sysDescr);
        oidsGet.add(sysUpTime);
        oidsGet.add(ipInReceives);
        oidsGet.add(ipInHdrErrors);
        oidsGet.add(ipInAddrErrors);
        oidsGet.add(ipForwDatagrams);
        oidsGet.add(ipInUnknownProtos);
        oidsGet.add(ipInDiscards);

        List<OID> oidsGetBulkIfTable = new ArrayList<OID>();
        OID ifTable = new OID("1.3.6.1.2.1.2.2");
        oidsGetBulkIfTable.add(ifTable);

        Gerente ger = new Gerente(this.agente);
        try {
            respostaGet = ger.get(oidsGet);
            Monitor mon = new Monitor(respostaGet[1].toString());
            mon.start();
            if (mon.monitorar()) {
                   for (VariableBinding var : respostaGet) {
                    System.out.println(var.toString());
                    //TODO: SWITCH CASE
                }

                respostaGetBulkIfTable = ger.getBulk(oidsGetBulkIfTable, 0, 44);
                for (VariableBinding var : respostaGetBulkIfTable) {
                    System.out.println(var.toString());

                    switch (Integer.parseInt(var.toString().substring(18, 19))) {
                        case 1:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfIndex((var.toString()).substring(23));
                            }
                            break;
                        case 2:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfDescr((var.toString()).substring(23));
                            }
                            break;
                        case 3:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfType((var.toString()).substring(23));
                            }
                            break;
                        case 4:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfMtu((var.toString()).substring(23));
                            }
                            break;
                        case 5:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfSpeed((var.toString()).substring(23));
                            }
                            break;
                        case 6:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfPhysAddress((var.toString()).substring(23));
                            }
                            break;
                        case 7:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfAdminStatus((var.toString()).substring(23));
                            }
                            break;
                        case 8:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOperStatus((var.toString()).substring(23));
                            }
                            break;
                        case 9:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfLastChange((var.toString()).substring(23));
                            }
                            break;
                        case 10:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInOctets((var.toString()).substring(23));
                            }
                            break;
                        case 11:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInUcastPkts((var.toString()).substring(23));
                            }
                            break;
                        case 12:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInNUcastPkts((var.toString()).substring(23));
                            }
                            break;
                        case 13:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInDiscards((var.toString()).substring(23));
                            }
                            break;
                        case 14:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInErrors((var.toString()).substring(23));
                            }
                            break;
                        case 15:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfInUnknownProtos((var.toString()).substring(23));
                            }
                            break;
                        case 16:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutOctets((var.toString()).substring(23));
                            }
                            break;
                        case 17:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutUcastPkts((var.toString()).substring(23));
                            }
                            break;
                        case 18:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutNUcastPkts((var.toString()).substring(23));
                            }
                            break;
                        case 19:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutDiscards((var.toString()).substring(23));
                            }
                            break;
                        case 20:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutErrors((var.toString()).substring(23));
                            }
                            break;
                        case 21:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfOutQLen((var.toString()).substring(23));
                            }
                            break;
                        case 22:
                            if (var.toString().substring(20, 21).equals(nroEthernet)) {
                                this.agente.setIfSpecific((var.toString()).substring(23));
                            }
                            break;
                    }
                }
            }
            ger.stop();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return this.agente;
    }
    //metodo porcentagem de pacotes recebidos com erro
    /*ifInErrors/(ifInUcastPkts + ifInNUCastPkts + ifInErrors + ifInDiscards +
    ifInUnknownProtos)**/
    //metodos taxa de bytes/por segundos
    /*[(ifInOctets_t2 - ifInOctets_t1) + (ifOutOctets_t2 - ifOutOctets_t1)] /
    (t2 – t1)**/
    //metodo utilizacao do link
    /*[(ifInOctets_t2 - ifInOctets_t1) + (ifOutOctets_t2 - ifOutOctets_t1)] *
    8 / ifSpeed * (t2-t1)**/
    //porcentagem  de datagramas recebidos com erro
    /*
    (ipInDiscards + ipInHdrErrors + ipInAddrErrors + ipInUnknownProtos) /
    ipInReceives**/
    //taxa de  forwarding/segundo
    /*(ipForwDatagrams_t2 - ipForwDatagrams_t1) / (t2 - t1)**/
    //metodo  que verifica o SysUptime  dos objetos "deve estar dentro de uma Thread" gera um alarm
}
