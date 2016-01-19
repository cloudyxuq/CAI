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
					} else {
						returnMap.put(entry.getKey(), "");
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
