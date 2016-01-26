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
import com.tinker.cai.sdk.ResourceUse;
import com.tinker.cai.sdk.ResourceUseUtil;
import com.tinker.cai.sdk.StorageResourceUse;

import net.sf.json.JSONObject;

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
		Map<String, String> map=GenerateSnmpTable.generateSnmpList(list,mibMap);
		 return map;
	}
	public String getTotalStorageInfo(String ip, String port, String save_path,
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
		Map<String, String> map=GenerateSnmpTable.generateSnmpList(list,mibMap);
		ResourceUseUtil util=new ResourceUseUtil();
		ResourceUse resu=util.getTotalStorageInfo(map);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"totalinfo\":["+"{\"total\":\""+resu.getTotal()+"\",\"used\":\""+resu.getUsed()+"\",\"remain\":\""+resu.getRemain()+"\",\"percent\":\""+resu.getPercent()+"\"}],").append("\n");
		sb.append("\"allsingleinfo\":[").append("\n");
		 List<StorageResourceUse> storagelist=util.MapToList(map);
		 for(int i=0;i<storagelist.size();i++){
			 StorageResourceUse sresu=storagelist.get(i);
			 sb.append("{\"name\":\""+sresu.getDiskName()+"\",\"unit\":\""+sresu.getUnit()+"\",\"total\":\""+sresu.getTotal()+"\",\"used\":\""+sresu.getUsed()+"\",\"avail\":\""+sresu.getAvail()+"\",\"percent\":\""+sresu.getPercent()+"\",\"type\":\""+sresu.getType()+"\"},").append("\n");
		 }
		 sb=new StringBuffer(sb.substring(0, sb.length()-3)).append("\n");
		 sb.append("]}");
		 return sb.toString();
	}
	
	public String getSingleStorageInfo(String ip, String port,String mib_id, String save_path,
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
		Map<String, String> map=GenerateSnmpTable.generateSnmpList(list,mibMap);
		ResourceUseUtil util=new ResourceUseUtil();
		StorageResourceUse sresu=util.getSingleStorageInfo(mib_id, map);
		StringBuffer sb=new StringBuffer();
		sb.append("{\"name\":\""+sresu.getDiskName()+"\",\"unit\":\""+sresu.getUnit()+"\",\"total\":\""+sresu.getTotal()+"\",\"used\":\""+sresu.getUsed()+"\",\"avail\":\""+sresu.getAvail()+"\",\"percent\":\""+sresu.getPercent()+"\",\"type\":\""+sresu.getType()+"\"},");
		sb=new StringBuffer(sb.substring(0, sb.length()-1));
		return sb.toString();
	}
}
