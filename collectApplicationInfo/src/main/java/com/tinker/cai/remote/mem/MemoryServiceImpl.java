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
import com.tinker.cai.remote.util.MibConstant;

/**
 * @author tinker
 *
 */
public class MemoryServiceImpl implements IMemoryService {

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.mem.IMemoryService#getMemoryMapInfo(java.lang.String, java.lang.String, java.lang.String, java.util.Map)
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
		List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GET);
			//进行snmp连接访问
		return GenerateSnmpTable.generateSnmpList(list,mibMap);
	}

}
