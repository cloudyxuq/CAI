/**
 * cpu实现类
 */
package com.tinker.cai.remote.cpu;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.snmp4j.PDU;

import com.adventnet.nms.util.CaiPing;
import com.tinker.cai.remote.snmpFactory.GenerateSnmpTable;
import com.tinker.cai.remote.snmpFactory.SnmpFactoryUtil;
import com.tinker.cai.remote.util.CpuUseUtil;
import com.tinker.cai.remote.util.LoadMibs;
import com.tinker.cai.remote.util.MibConstant;
import com.tinker.cai.sdk.CpuUse;

/**
 * @author tinker
 *
 */
public class CpuServiceImpl implements ICpuService {

	
	public Map<String, String> getCpuMapInfo(String ip, String port, String save_path, Map<String, String> oidMaps) {
		// 测试连通性
		if (!CaiPing.ping_ip(ip)) {
			return null;
		}
		// 如果没有指定oidmap，那采用默认的
		Map<String, String> mibMap = oidMaps;
		if (null == mibMap || mibMap.isEmpty()) {
			// 获取cpu基础map对象
			mibMap = LoadMibs.getMapMibsObject(MibConstant.CPU);
		}
		List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GET);

		// 进行snmp连接访问
		return  GenerateSnmpTable.generateSnmpList(list, mibMap);
	}
	public String getCpuInfo(String ip, String port, String save_path, Map<String, String> oidMaps) {
	// 测试连通性
	if (!CaiPing.ping_ip(ip)) {
		return null;
	}
	// 如果没有指定oidmap，那采用默认的
	Map<String, String> mibMap = oidMaps;
	if (null == mibMap || mibMap.isEmpty()) {
		// 获取cpu基础map对象
		mibMap = LoadMibs.getMapMibsObject(MibConstant.CPU);
	}
	List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GET);

	// 进行snmp连接访问
	Map<String, String> map= GenerateSnmpTable.generateSnmpList(list, mibMap);
	CpuUseUtil util=new CpuUseUtil();
	CpuUse cpu=util.getCpuMapInfo(map);
	StringBuffer sb=new StringBuffer();
	sb.append("{\"CpuRawSystemTime\":\""+cpu.getSsCpuRawSystemTime()+"\"");
	sb.append(",\"IOSent\":\""+cpu.getSsIOSent()+"\"");
	sb.append(",\"RawContexts\":\""+cpu.getSsRawContexts()+"\"");
	sb.append(",\"CpuRawInterrupt\":\""+cpu.getSsCpuRawInterrupt()+"\"");
	sb.append(",\"CpuRawIdleTime\":\""+cpu.getSsCpuRawIdleTime()+"\"");
	sb.append(",\"RawSwapIn\":\""+cpu.getSsRawSwapIn()+"\"");
	sb.append(",\"SwapIn\":\""+cpu.getSsSwapIn()+"\"");
	sb.append(",\"CpuSystem\":\""+cpu.getSsCpuSystem()+"\"");
	sb.append(",\"RawSwapOut\":\""+cpu.getSsRawSwapOut()+"\"");
	sb.append(",\"SysContext\":\""+cpu.getSsSysContext()+"\"");
	sb.append(",\"CpuIdle\":\""+cpu.getSsCpuIdle()+"\"");
	sb.append(",\"CpuRawNiceTime\":\""+cpu.getSsCpuRawNiceTime()+"\"");
	sb.append(",\"IOReceive\":\""+cpu.getSsIOReceive()+"\"");
	sb.append(",\"SysInterrupts\":\""+cpu.getSsSysInterrupts()+"\"");
	sb.append(",\"CpuRawWait\":\""+cpu.getSsCpuRawWait()+"\"");
	sb.append(",\"CpuUser\":\""+cpu.getSsCpuUser()+"\"");
	sb.append(",\"SwapOut\":\""+cpu.getSsSwapOut()+"\"");
	sb.append(",\"IORawReceived\":\""+cpu.getSsIORawReceived()+"\"");
	sb.append(",\"RawInterrupts\":\""+cpu.getSsRawInterrupts()+"\"");
	sb.append(",\"hrProcessorLoad\":\""+cpu.getHrProcessorLoad().replace("##", ",")+"\"");
	sb.append(",\"CpuRawSoftIRQ\":"+cpu.getSsCpuRawSoftIRQ()+"\"");
	sb.append(",\"IORawSent\":\""+cpu.getSsIORawSent()+"\"");
	sb.append(",\"CpuRawUserTime\":\""+cpu.getSsCpuRawUserTime()+"\"");
	sb.append("}");
    return sb.toString();
}
//public static void main(String[] args) {
//	CpuServiceImpl c=new CpuServiceImpl();
//	System.out.println(c.getCpuMapInfo("192.168.0.110", "161", "",null));
//	System.out.println(c.getCpuInfo("192.168.0.110", "161", "",null));
//}
}
