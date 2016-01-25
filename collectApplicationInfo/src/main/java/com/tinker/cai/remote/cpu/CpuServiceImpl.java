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
import com.tinker.cai.remote.util.LoadMibs;
import com.tinker.cai.remote.util.MibConstant;

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
		return GenerateSnmpTable.generateSnmpList(list, mibMap);

	}


}
