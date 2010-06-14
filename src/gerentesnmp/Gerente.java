/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gerentesnmp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.Target;
import org.snmp4j.TransportMapping;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.Address;
import org.snmp4j.smi.GenericAddress;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.OctetString;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;
import org.snmp4j.util.DefaultPDUFactory;
import org.snmp4j.util.TableEvent;
import org.snmp4j.util.TableUtils;

/**
 *
 * @author
 */
public class Gerente {
    private String address;
    private String comunidade;
    private int tempo;
    private Snmp snmp;

    public Gerente(Agente ag) {
        super();
        //this.address = address;
        this.address = ag.getIp();
        this.comunidade = ag.getComunidade();
        this.tempo = ag.getTempo();
        try {
                start();
        } catch (IOException e) {
                throw new RuntimeException(e);
        }
    }

    // Since snmp4j relies on asynch req/resp we need a listener
    // for responses which should be closed
    public void stop() throws IOException {
        snmp.close();
    }

    private void start() throws IOException {
        TransportMapping transport = new DefaultUdpTransportMapping();
        snmp = new Snmp(transport);
        // Do not forget this line!
        transport.listen();
    }

    /*public String getAsString(List<OID> oids) throws IOException {
        ResponseEvent event = get(oids);
        return event.getResponse().get(0).getVariable().toString();
    }*/

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

    /**
     * Normally this would return domain objects or something else than this...
     */
    /*public List<List<String>> getTableAsStrings(OID[] oids) {
        TableUtils tUtils = new TableUtils(snmp, new DefaultPDUFactory());

        @SuppressWarnings("unchecked")
            List<TableEvent> events = tUtils.getTable(getTarget(), oids, null, null);

        List<List<String>> list = new ArrayList<List<String>>();
        for (TableEvent event : events) {
            if(event.isError()) {
                throw new RuntimeException(event.getErrorMessage());
            }
            List<String> strList = new ArrayList<String>();
            list.add(strList);
            for(VariableBinding vb: event.getColumns()) {
                strList.add(vb.getVariable().toString());
            }
        }
        return list;
    }*/
}