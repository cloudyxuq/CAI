/**
 * 
 */
package com.tinker.cai.remote.snmpFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.snmp4j.PDU;
import org.snmp4j.smi.VariableBinding;
import org.snmp4j.util.TableEvent;

import com.tinker.cai.remote.util.MibConstant;

/**
 * @author tinker
 *
 */
public class GenerateSnmpTable {

	/**
	 * 将snmp获取的list进行转义获取map对象
	 * 
	 * @param list
	 * @param mibMap
	 * @return
	 */
	public static Map<String, String> generateSnmpList(List list, Map<String, String> mibMap) {
		Map<String, String> getSnmpMap = null;
		Map<String, String> returnMap = mibMap;
		try {

			if (null != list && list.size() > 0) {
				getSnmpMap = new HashMap<String, String>();
				for (int i = 0; i < list.size(); i++) {
					TableEvent te = (TableEvent) list.get(i);
					VariableBinding[] vb = te.getColumns();
					if (null != vb && vb.length > 1) {
						for (int j = 0; j < vb.length; j++) {
							if (null != vb[j]) {
								getSnmpMap.put(String.valueOf(vb[j].getOid()), String.valueOf(vb[j].getVariable()));
							}
						}
					}
				}
			}
			if (!getSnmpMap.isEmpty()) {
				// 对returnMap进行再次封装
				for (Map.Entry<String, String> entry : returnMap.entrySet()) {
					if (getSnmpMap.containsKey(entry.getValue())) {
						returnMap.put(entry.getKey(), getSnmpMap.get(entry.getValue()));
					} 
					//处理如果返回值为多个，需要将属于该节点的进行拼接（不进行计算）以,分割
					// if(entry.getValue().s){}
						
					else {
						StringBuffer sb  = new StringBuffer();
						for(Map.Entry<String, String> gMap : getSnmpMap.entrySet()){
							if(gMap.getKey().startsWith(entry.getValue())){
								sb.append(gMap.getValue()).append(MibConstant.SPILT_FIX);
							}
						}
						returnMap.put(entry.getKey(), sb.toString());	
						sb = null;
					}
						//returnMap.put(entry.getKey(), "");
					}
				//将无获取值的map的value设置为空
				for (Map.Entry<String, String> entry1 : returnMap.entrySet()) {
					if (getSnmpMap.containsKey(entry1.getValue())) {
						returnMap.put(entry1.getKey(), "");
					}
					
				}

			} else {
				// 对returnMap进行再次封装
				for (Map.Entry<String, String> entry : returnMap.entrySet()) {

					returnMap.put(entry.getKey(), "");
				}
			}

			return returnMap;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
