/**
 * 
 */
package com.tinker.cai.remote.mem;

import java.util.List;
import java.util.Map;

import org.snmp4j.PDU;

import com.adventnet.nms.util.CaiPing;
import com.tinker.cai.remote.cpu.CpuServiceImpl;
import com.tinker.cai.remote.snmpFactory.GenerateSnmpTable;
import com.tinker.cai.remote.snmpFactory.SnmpFactoryUtil;
import com.tinker.cai.remote.util.LoadMibs;
import com.tinker.cai.remote.util.MemoryUseUtil;
import com.tinker.cai.remote.util.MibConstant;
import com.tinker.cai.sdk.MemoryUse;

/**
 * @author tinker
 *
 */
public class MemoryServiceImpl implements IMemoryService {

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.mem.IMemoryService#getMemoryMapInfo(java.lang.String, java.lang.String, java.lang.String, java.util.Map)
	 */
	/**
	 * 通过snmp协议返回内存原始信息的map集合
	 * ip     虚拟机ip地址
	 * port   虚拟机snmp端口号  默认161
	 * save_path 保存路径
	 * oidMaps  设备mib_id号  没有则默认获取defaultmibs.properties里面相关设备mib号 
	 */
	public Map<String, String> getMemoryMapInfo(String ip, String port, String save_path, Map<String, String> oidMaps) {
		//测试连通性
		if(!CaiPing.ping_ip(ip)){
			return null;
		}
		//如果没有指定oidmap，那采用默认的
		Map<String,String> mibMap = oidMaps;
		if(null==mibMap||mibMap.isEmpty()){
			//获取Mem基础map对象
			mibMap = LoadMibs.getMapMibsObject(MibConstant.MEMORY);
		}
		List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GETNEXT);
			//进行snmp连接访问
		return GenerateSnmpTable.generateSnmpList(list,mibMap);
	}
	/**
	 * 封装的内存信息
	 * ip     虚拟机ip地址
	 * port   虚拟机snmp端口号  默认161
	 * save_path 保存路径
	 * oidMaps  设备mib_id号  没有则默认获取defaultmibs.properties里面相关设备mib号 
	 */
	public String getMemoryInfo(String ip, String port, String save_path, Map<String, String> oidMaps) {
		//测试连通性
		if(!CaiPing.ping_ip(ip)){
			return null;
		}
		//如果没有指定oidmap，那采用默认的
		Map<String,String> mibMap = oidMaps;
		if(null==mibMap||mibMap.isEmpty()){
			//获取Mem基础map对象
			mibMap = LoadMibs.getMapMibsObject(MibConstant.MEMORY);
		}
		List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GETNEXT);
			//进行snmp连接访问
		Map<String,String> map=GenerateSnmpTable.generateSnmpList(list,mibMap);
		MemoryUseUtil util=new MemoryUseUtil();
		MemoryUse mem=util.getTotalMemoryInfo(map);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"size\":"+mem.getHrMemorySize()+",\"used\":"+mem.getMemUsedReal()+",\"free\":"+mem.getMemAvailReal()+",\"percent\":"+mem.getMemPercent()+",\"share\":"+mem.getMemShared()+",\"buffer\":"+mem.getMemBuffer()+",\"cached\":"+mem.getMemCached()+"}");
		return sb.toString();
	}
//public static void main(String[] args) {
//	MemoryServiceImpl m=new MemoryServiceImpl();
//	System.out.println(m.getMemoryInfo("192.168.4.16", "161", "",null));
//}
}
