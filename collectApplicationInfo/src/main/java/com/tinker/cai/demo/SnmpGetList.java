/**    
* @Title: SnmpGetList.java  
* @Package com.tinker.cai.demo  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月20日 下午3:47:05  
* @version V1.0    
*/
package com.tinker.cai.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.snmp4j.CommunityTarget;
import org.snmp4j.PDU;
import org.snmp4j.Snmp;
import org.snmp4j.event.ResponseEvent;
import org.snmp4j.mp.SnmpConstants;
import org.snmp4j.smi.OID;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.transport.DefaultUdpTransportMapping;

/**  
* @ClassName: SnmpGetList  
* @Description: snmp get 同步方式获取多个OID的值 
* @author tinker 
* @date 2016年1月20日 下午3:47:05  
*    
*/
public class SnmpGetList {

    private static int version = SnmpConstants.version1;
    private static String protocol = "udp";
    private static int port = 161;

    /**
     * 
     * @param args
     */
    public static void main(String[] args) {

        String ip = "192.168.8.254";
        String community = "public";
        SnmpGetList tester = new SnmpGetList();
        List<String> oidList = new ArrayList<String>();
        oidList.add(".1.3.6.1.2.1.1.1.0");
        oidList.add(".1.3.6.1.2.1.1.3.0");
        oidList.add(".1.3.6.1.2.1.1.5.0");
        // synchronous
        tester.snmpGet(ip, community, oidList);

    }

    /**
     * 
     * @param ipAddress
     * @param community
     * @param oid
     */
    private void snmpGet(String ipAddress, String community,
            List<String> oidList) {
        String address = protocol + ":" + ipAddress + "/" + port;
        CommunityTarget target = SnmpUtil.createCommunityTarget(address,
                community, version, 2 * 1000L, 3);
        DefaultUdpTransportMapping transport = null;
        Snmp snmp = null;
        try {
            PDU pdu = new PDU();
            pdu.setType(PDU.GET);
            for (String oid : oidList) {
                pdu.add(new VariableBinding(new OID(oid)));
            }

            transport = new DefaultUdpTransportMapping();
            transport.listen();
            snmp = new Snmp(transport);

            ResponseEvent response = snmp.send(pdu, target);
            PDU resPdu = response.getResponse();
            if (resPdu == null) {
                System.out.println(ipAddress + ":Request time out");
            } else {
                System.out.println(" response pdu vb size is " + resPdu.size());
                for (int i = 0; i < resPdu.size(); i++) {
                    VariableBinding vb = resPdu.get(i);
                    System.out.println(vb.getOid() + "=" + vb.getVariable());
                }
            }
        } catch (Exception e) {
            System.out.println("SNMP GetNext Exception:" + e);
        } finally {
            if (snmp != null) {
                try {
                    snmp.close();
                } catch (IOException ex1) {
                    snmp = null;
                }
            }
            if (transport != null) {
                try {
                    transport.close();
                } catch (IOException ex2) {
                    transport = null;
                }
            }
        }

    }

}
