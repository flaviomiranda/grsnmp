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
    private String ifIndex;
    private String ifDescr;
    private String ifType;
    private String ifMtu;
    private String ifSpeed;
    private String ifPhysAddress;
    private String ifAdminStatus;
    private String ifOperStatus;
    private String ifLastChange;
    private String ifInOctets;
    private String ifInOctetsT2;
    private String ifInUcastPkts;
    private String ifInNUcastPkts;
    private String ifInDiscards;
    private String ifInErrors;
    private String ifInUnknownProtos;
    private String ifOutOctets;
    private String ifOutOctetsT2;
    private String ifOutUcastPkts;
    private String ifOutNUcastPkts;
    private String ifOutDiscards;
    private String ifOutErrors;
    private String ifOutQLen;
    private String ifSpecific;
    private String ipInReceives;
    private String ipInHdrErrors;
    private String ipInAddrErrors;
    private String ipForwDatagrams;
    private String ipForwDatagramsT2;
    private String ipInUnknownProtos;
    private String ipInDiscards;
    private String sysDescr;
    private String sysUpTime;

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

    public String getIfAdminStatus() {
        return ifAdminStatus;
    }

    public void setIfAdminStatus(String ifAdminStatus) {
        this.ifAdminStatus = ifAdminStatus;
    }

    public String getIfDescr() {
        return ifDescr;
    }

    public void setIfDescr(String ifDescr) {
        this.ifDescr = ifDescr;
    }

    public String getIfInDiscards() {
        return ifInDiscards;
    }

    public void setIfInDiscards(String ifInDiscards) {
        this.ifInDiscards = ifInDiscards;
    }

    public String getIfInErrors() {
        return ifInErrors;
    }

    public void setIfInErrors(String ifInErrors) {
        this.ifInErrors = ifInErrors;
    }

    public String getIfInNUcastPkts() {
        return ifInNUcastPkts;
    }

    public void setIfInNUcastPkts(String ifInNUcastPkts) {
        this.ifInNUcastPkts = ifInNUcastPkts;
    }

    public String getIfInOctets() {
        return ifInOctets;
    }

    public void setIfInOctets(String ifInOctets) {
        this.ifInOctets = ifInOctets;
    }

    public String getIfInUcastPkts() {
        return ifInUcastPkts;
    }

    public void setIfInUcastPkts(String ifInUcastPkts) {
        this.ifInUcastPkts = ifInUcastPkts;
    }

    public String getIfInUnknownProtos() {
        return ifInUnknownProtos;
    }

    public void setIfInUnknownProtos(String ifInUnknownProtos) {
        this.ifInUnknownProtos = ifInUnknownProtos;
    }

    public String getIfIndex() {
        return ifIndex;
    }

    public void setIfIndex(String ifIndex) {
        this.ifIndex = ifIndex;
    }

    public String getIfLastChange() {
        return ifLastChange;
    }

    public void setIfLastChange(String ifLastChange) {
        this.ifLastChange = ifLastChange;
    }

    public String getIfMtu() {
        return ifMtu;
    }

    public void setIfMtu(String ifMtu) {
        this.ifMtu = ifMtu;
    }

    public String getIfOperStatus() {
        return ifOperStatus;
    }

    public void setIfOperStatus(String ifOperStatus) {
        this.ifOperStatus = ifOperStatus;
    }

    public String getIfOutDiscards() {
        return ifOutDiscards;
    }

    public void setIfOutDiscards(String ifOutDiscards) {
        this.ifOutDiscards = ifOutDiscards;
    }

    public String getIfOutErrors() {
        return ifOutErrors;
    }

    public void setIfOutErrors(String ifOutErrors) {
        this.ifOutErrors = ifOutErrors;
    }

    public String getIfOutNUcastPkts() {
        return ifOutNUcastPkts;
    }

    public void setIfOutNUcastPkts(String ifOutNUcastPkts) {
        this.ifOutNUcastPkts = ifOutNUcastPkts;
    }

    public String getIfOutOctets() {
        return ifOutOctets;
    }

    public void setIfOutOctets(String ifOutOctets) {
        this.ifOutOctets = ifOutOctets;
    }

    public String getIfOutQLen() {
        return ifOutQLen;
    }

    public void setIfOutQLen(String ifOutQLen) {
        this.ifOutQLen = ifOutQLen;
    }

    public String getIfOutUcastPkts() {
        return ifOutUcastPkts;
    }

    public void setIfOutUcastPkts(String ifOutUcastPkts) {
        this.ifOutUcastPkts = ifOutUcastPkts;
    }

    public String getIfPhysAddress() {
        return ifPhysAddress;
    }

    public void setIfPhysAddress(String ifPhysAddress) {
        this.ifPhysAddress = ifPhysAddress;
    }

    public String getIfSpecific() {
        return ifSpecific;
    }

    public void setIfSpecific(String ifSpecific) {
        this.ifSpecific = ifSpecific;
    }

    public String getIfSpeed() {
        return ifSpeed;
    }

    public void setIfSpeed(String ifSpeed) {
        this.ifSpeed = ifSpeed;
    }

    public String getIfType() {
        return ifType;
    }

    public void setIfType(String ifType) {
        this.ifType = ifType;
    }

    public String getIfInOctetsT2() {
        return ifInOctetsT2;
    }

    public void setIfInOctetsT2(String ifInOctetsT2) {
        this.ifInOctetsT2 = ifInOctetsT2;
    }

    public String getIfOutOctetsT2() {
        return ifOutOctetsT2;
    }

    public void setIfOutOctetsT2(String ifOutOctetsT2) {
        this.ifOutOctetsT2 = ifOutOctetsT2;
    }

    public String getIpForwDatagrams() {
        return ipForwDatagrams;
    }

    public void setIpForwDatagrams(String ipForwDatagrams) {
        this.ipForwDatagrams = ipForwDatagrams;
    }

    public String getIpForwDatagramsT2() {
        return ipForwDatagramsT2;
    }

    public void setIpForwDatagramsT2(String ipForwDatagramsT2) {
        this.ipForwDatagramsT2 = ipForwDatagramsT2;
    }

    public String getIpInAddrErrors() {
        return ipInAddrErrors;
    }

    public void setIpInAddrErrors(String ipInAddrErrors) {
        this.ipInAddrErrors = ipInAddrErrors;
    }

    public String getIpInDiscards() {
        return ipInDiscards;
    }

    public void setIpInDiscards(String ipInDiscards) {
        this.ipInDiscards = ipInDiscards;
    }

    public String getIpInHdrErrors() {
        return ipInHdrErrors;
    }

    public void setIpInHdrErrors(String ipInHdrErrors) {
        this.ipInHdrErrors = ipInHdrErrors;
    }

    public String getIpInReceives() {
        return ipInReceives;
    }

    public void setIpInReceives(String ipInReceives) {
        this.ipInReceives = ipInReceives;
    }

    public String getIpInUnknownProtos() {
        return ipInUnknownProtos;
    }

    public void setIpInUnknownProtos(String ipInUnknownProtos) {
        this.ipInUnknownProtos = ipInUnknownProtos;
    }

    public String getSysDescr() {
        return sysDescr;
    }

    public void setSysDescr(String sysDescr) {
        this.sysDescr = sysDescr;
    }

    public String getSysUpTime() {
        return sysUpTime;
    }

    public void setSysUpTime(String sysUpTime) {
        this.sysUpTime = sysUpTime;
    }

    public void setIfTable(Agente ag){
        setIfIndex(ag.getIfIndex());
        setIfDescr(ag.getIfDescr());
        setIfType(ag.getIfType());
        setIfMtu(ag.getIfMtu());
        setIfSpeed(ag.getIfSpeed());
        setIfPhysAddress(ag.getIfPhysAddress());
        setIfAdminStatus(ag.getIfAdminStatus());
        setIfOperStatus(ag.getIfOperStatus());
        setIfLastChange(ag.getIfLastChange());
        setIfInOctets(ag.getIfInOctets());
        setIfInUcastPkts(ag.getIfInUcastPkts());
        setIfInNUcastPkts(ag.getIfInNUcastPkts());
        setIfInDiscards(ag.getIfInDiscards());
        setIfInErrors(ag.getIfInErrors());
        setIfInUnknownProtos(ag.getIfInUnknownProtos());
        setIfOutOctets(ag.getIfOutOctets());
        setIfOutUcastPkts((ag.getIfOutUcastPkts()));
        setIfOutNUcastPkts((ag.getIfOutNUcastPkts()));
        setIfOutDiscards(ag.getIfOutDiscards());
        setIfDescr(ag.getIfDescr());
        setIfOutErrors(ag.getIfOutErrors());
        setIfOutQLen(ag.getIfOutQLen());
        setIfSpecific(ag.getIfSpecific());
    }
}
