/**    
* @Title: StorageServiceImpl.java  
* @Package com.tinker.cai.remote.storage  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月20日 下午6:10:49  
* @version V1.0    
*/
package com.tinker.cai.remote.storage;

import java.util.List;
import java.util.Map;

import org.snmp4j.PDU;

import com.adventnet.nms.util.CaiPing;
import com.tinker.cai.remote.snmpFactory.GenerateSnmpTable;
import com.tinker.cai.remote.snmpFactory.SnmpFactoryUtil;
import com.tinker.cai.remote.util.LoadMibs;
import com.tinker.cai.remote.util.MibConstant;

/**  
* @ClassName: StorageServiceImpl  
* @Description: 存储设备信息采集  
* @author tinker 
* @date 2016年1月20日 下午6:10:49  
*    
*/
public  class StorageServiceImpl implements IStorageService{

	public Map<String, String> getStorageMapInfo(String ip, String port, String save_path,
			Map<String, String> oidMaps) {
		if(!CaiPing.ping_ip(ip)){
			return null;
		}
		//如果没有指定oidmap，那采用默认的
		Map<String,String> mibMap = oidMaps;
		if(null==mibMap||mibMap.isEmpty()){
			//获取Mem基础map对象
			mibMap = LoadMibs.getMapMibsObject(MibConstant.STORAGE);
		}
		List list = SnmpFactoryUtil.getSNMPTable(ip, port, mibMap, PDU.GETNEXT);
			//进行snmp连接访问
		return GenerateSnmpTable.generateSnmpList(list,mibMap);
	}

}
