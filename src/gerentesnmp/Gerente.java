/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.io.IOException;
import java.util.List;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**
 *
 * @author
 */
public class Gerente {
    private String address;
    private String comunidade;
    private Snmp snmp;

    public Gerente(Agente ag) {
        super();
        this.address = ag.getIp();
        this.comunidade = ag.getComunidade();
        try {
                start();
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

    public void stop() throws IOException {
        snmp.close();
    }

    private void start() throws IOException {
        TransportMapping transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        transport.listen();
    }

    public VariableBinding[] get(List<OID> oids) throws IOException {
        PDU pdu = new PDU();
        for (OID oid : oids) {
               pdu.addOID(new VariableBinding(oid));
        }

        pdu.setType(PDU.GET);

        VariableBinding[] retorno = snmp.send(pdu, getTarget()).getResponse().toArray();

        if(retorno != null)
            return retorno;

        throw new RuntimeException("GET timed out: " + pdu.getErrorStatusText());
    }

    public VariableBinding[] getBulk(List<OID> oids, int nr, int mr) throws IOException {
        PDU pdu = new PDU();
        for (OID oid : oids) {
               pdu.addOID(new VariableBinding(oid));
        }

        pdu.setType(PDU.GETBULK);
        pdu.setNonRepeaters(nr);
        pdu.setMaxRepetitions(mr);

        VariableBinding[] retorno = snmp.send(pdu, getTarget()).getResponse().toArray();

        if(retorno != null)
            return retorno;

        throw new RuntimeException("GET timed out: " + pdu.getErrorStatusText());
    }

    private Target getTarget() {
        Address targetAddress = GenericAddress.parse("udp:" + address + "/161");
        CommunityTarget target = new CommunityTarget();
        target.setCommunity(new OctetString(comunidade));
        target.setAddress(targetAddress);
        target.setRetries(2);
        target.setTimeout(1500);
        target.setVersion(SnmpConstants.version2c);
        return target;
    }
}