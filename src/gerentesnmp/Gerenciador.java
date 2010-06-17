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
    private VariableBinding[] respostaGetIps;
    private VariableBinding[] respostaGetBulkIfTable;
    static final String nroEthernet = "2";

    public Gerenciador(Agente agente) {
        this.agente = agente;
    }

//    public void run() {
//        gerenciar();
//    }
    public Agente gerenciar() {
        int index;
        List<OID> oidsGet = new ArrayList<OID>();
        OID sysDescr = new OID("1.3.6.1.2.1.1.1.0");
        OID sysUpTime = new OID("1.3.6.1.2.1.1.3.0");
        oidsGet.add(sysDescr);
        oidsGet.add(sysUpTime);
        List<OID> oidsGetIps = new ArrayList<OID>();
        OID ipInReceives = new OID("1.3.6.1.2.1.4.3.0");
        OID ipInHdrErrors = new OID("1.3.6.1.2.1.4.4.0");
        OID ipInAddrErrors = new OID("1.3.6.1.2.1.4.5.0");
        OID ipForwDatagrams = new OID("1.3.6.1.2.1.4.6.0");
        OID ipInUnknownProtos = new OID("1.3.6.1.2.1.4.7.0");
        OID ipInDiscards = new OID("1.3.6.1.2.1.4.8.0");
        oidsGetIps.add(ipInReceives);
        oidsGetIps.add(ipInHdrErrors);
        oidsGetIps.add(ipInAddrErrors);
        oidsGetIps.add(ipForwDatagrams);
        oidsGetIps.add(ipInUnknownProtos);
        oidsGetIps.add(ipInDiscards);

        List<OID> oidsGetBulkIfTable = new ArrayList<OID>();
        OID ifTable = new OID("1.3.6.1.2.1.2.2");
        oidsGetBulkIfTable.add(ifTable);

        Gerente ger = new Gerente(this.agente);
        try {
            respostaGet = ger.get(oidsGet);
            respostaGetIps = ger.get(oidsGetIps);
            Monitor mon = new Monitor(respostaGet[1].toString());
            mon.start();
            if (mon.monitorar()) {
                for (VariableBinding var1 : respostaGetIps) {
                    index = var1.toString().indexOf("=");
                    System.out.println(var1.toString());
//                    System.out.println(var.toString().substring(index-4, index-3));
//                    System.out.println((var.toString()).substring(16));
                    switch (Integer.parseInt(var1.toString().substring(index - 4, index - 3))) {
                        case 3:
                            this.agente.setIpInReceives((var1.toString()).substring(index + 1).trim());
                            break;
                        case 4:
                            this.agente.setIpInHdrErrors((var1.toString()).substring(index + 1).trim());
                            break;
                        case 5:
                            this.agente.setIpInAddrErrors((var1.toString()).substring(index + 1).trim());
                            break;
                        case 6:
                            this.agente.setIpForwDatagrams((var1.toString()).substring(index + 1).trim());
                            break;
                        case 7:
                            this.agente.setIpInUnknownProtos((var1.toString()).substring(index + 1).trim());
                            break;
                        case 8:
                            this.agente.setIpInDiscards((var1.toString()).substring(index + 1).trim());
                            break;
                    }
                    for (VariableBinding var2 : respostaGet) {
                        System.out.println(var2.toString());
                        index = var2.toString().indexOf("=");
                        if(var2.toString().contains("1.3.6.1.2.1.1.1")){
                            this.agente.setSysDescr(var2.toString().substring(index + 1).trim());
                        }
                        if(var2.toString().contains("1.3.6.1.2.1.1.3")){
                            this.agente.setSysUpTime(var2.toString().substring(index + 1).trim());
                        }
                    }

                    respostaGetBulkIfTable = ger.getBulk(oidsGetBulkIfTable, 0, 44);
                    for (VariableBinding var : respostaGetBulkIfTable) {
                    System.out.println(var.toString());
                        index = var.toString().indexOf("=");
//                    System.out.println(var.toString().substring(index-4, index-3));
//                    System.out.println(var.toString().substring(index+1).trim());
//                    System.out.println(var.toString().substring(index-2, index-1));
//                    System.out.println(var.toString().substring(index-5, index-3).replace('.', ' ').trim());
                        switch (Integer.parseInt(var.toString().substring(index - 5, index - 3).replace('.', ' ').trim())) {
                            case 1:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfIndex((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 2:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfDescr((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 3:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfType((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 4:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfMtu((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 5:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfSpeed((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 6:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfPhysAddress((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 7:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfAdminStatus((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 8:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOperStatus((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 9:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfLastChange((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 10:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInOctets((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 11:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInUcastPkts((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 12:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInNUcastPkts((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 13:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInDiscards((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 14:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInErrors((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 15:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfInUnknownProtos((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 16:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutOctets((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 17:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutUcastPkts((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 18:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutNUcastPkts((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 19:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutDiscards((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 20:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutErrors((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 21:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfOutQLen((var.toString()).substring(index + 1).trim());
                                }
                                break;
                            case 22:
                                if (var.toString().substring(index - 2, index - 1).equals(nroEthernet)) {
                                    this.agente.setIfSpecific((var.toString()).substring(index + 1).trim());
                                }
                                break;
                        }
                    }
                }
                ger.stop();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return this.agente;
    }

    //metodo porcentagem de pacotes recebidos com erro
    public Double porcPktsInErr(Double ifInErrors, Double ifInUcastPkts, Double ifInNUCastPkts, Double ifInDiscards, Double ifInUnknownProtos) {
        Double a = ifInErrors / (ifInUcastPkts + ifInNUCastPkts + ifInErrors + ifInDiscards + ifInUnknownProtos);
        System.out.println("Porcentagem de pacotes recebidos com erro " + a + "%");
        return a;
    }

    //metodos taxa de bytes/por segundos
    public Double taxBytePerSec(Double ifInOctetsT1, Double ifInOctetsT2, Double ifOutOctetsT2, Double ifOutOctetsT1, Double tempo) {
        Double a = ((ifInOctetsT2 - ifInOctetsT1) + (ifOutOctetsT2 - ifOutOctetsT1)) / tempo/*(t2 – t1)*/;
        System.out.println("Taxa de bytes/por segundos " + a + "bytes/s");
        return a;
    }

    /***/
    //metodo utilizacao do link
    public Double utilLink(Double ifInOctetsT1, Double ifInOctetsT2, Double ifOutOctetsT1, Double ifOutOctetsT2, Double ifSpeed, Double tempo) {
        Double a = ((ifInOctetsT2 - ifInOctetsT1) + (ifOutOctetsT2 - ifOutOctetsT1)) * 8 / ifSpeed * tempo/*(t2-t1)*/;
        System.out.println("Utilizacao do link " + a);
        return a;
    }

    //porcentagem  de datagramas recebidos com erro
    public Double porcDatagramsInErr(Double ipInDiscards, Double ipInHdrErrors, Double ipInAddrErrors, Double ipInUnknownProtos, Double ipInReceives) {
        Double a = (ipInDiscards + ipInHdrErrors + ipInAddrErrors + ipInUnknownProtos) / ipInReceives;
        System.out.println("Porcentagem de datagramas recebidos com erro " + a + "%");
        return a;
    }

    //taxa de  forwarding/segundo
    public Double taxForwSec(Double ipForwDatagramsT2, Double ipForwDatagramsT1, Double tempo) {
        Double a = (ipForwDatagramsT2 - ipForwDatagramsT1) / tempo/*(t2 - t1)*/;
        System.out.println("Taxa de  forwarding/segundo " + a + "forwarding/s");
        return a;
    }

    public void geraGrafico(Double porcPktsInErr, Double taxBytePerSec, Double utilLink, Double porcDatagramsInErr, Double taxForwSec) {
        List<DadosGrafico> lstDadosG = new ArrayList<DadosGrafico>();
        DadosGrafico d1 = new DadosGrafico(porcPktsInErr, "vermelho", "% Pacotes recebidos c/ erro");
        DadosGrafico d2 = new DadosGrafico(taxBytePerSec, "azul", "Taxa Bytes p/seg");
        DadosGrafico d3 = new DadosGrafico(utilLink, "amarelo", "Utilização de link");
        DadosGrafico d4 = new DadosGrafico(porcDatagramsInErr, "preto", "% datagramas IPs rec/erro");
        DadosGrafico d5 = new DadosGrafico(taxForwSec, "roxo", "Taxa forwarding");
        lstDadosG.add(d1);
        lstDadosG.add(d2);
        lstDadosG.add(d3);
        lstDadosG.add(d4);
        lstDadosG.add(d5);
        Grafico chart = new Grafico("Gráfico teste", lstDadosG);
        chart.pack();
        chart.setVisible(true);
    }
    //metodo  que verifica o SysUptime  dos objetos "deve estar dentro de uma Thread" gera um alarm
}
