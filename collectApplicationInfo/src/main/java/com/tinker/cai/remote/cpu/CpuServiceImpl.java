/**
 * cpu实现类
 */
package com.tinker.cai.remote.cpu;

import java.util.Map;
import java.util.Properties;

import org.snmp4j.PDU;

import com.adventnet.nms.util.CaiPing;
import com.tinker.cai.remote.snmpFactory.SnmpFactoryUtil;
import com.tinker.cai.remote.util.LoadMibs;
import com.tinker.cai.remote.util.MibConstant;

/**
 * @author tinker
 *
 */
public class CpuServiceImpl implements ICpuService {

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.cpu.ICpuService#getCpuMapInfo(java.lang.String, java.lang.String, java.lang.String, java.lang.String[])
	 */
	public Map<String, Object> getCpuMapInfo(String ip, String port, String save_path, String[] mibs) {
		//测试连通性
		if(CaiPing.ping_ip(ip)){
			//获取cpu基础map对象
			Map mibMap = LoadMibs.getMapMibsObject(MibConstant.CPU);
			//进行snmp连接访问
			System.out.println(new SnmpFactoryUtil().getSNMPTable(ip, port, mibMap, PDU.GET));
			
			
			
		}
		return null;
	}
	
	public static void main(String[] args) {
		
		
		//测试连通性
		
		CaiPing c =new CaiPing();
		Properties p = new Properties();
		
		System.out.println(LoadMibs.getMapMibsObject(MibConstant.CPU));
		String []m ={"1","2"};
		new CpuServiceImpl().getCpuMapInfo("192.168.4.254", "161", "dd",m);
		
	}

}
