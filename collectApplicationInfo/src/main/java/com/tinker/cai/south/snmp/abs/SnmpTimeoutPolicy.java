/**    
* @Title: SnmpTimeoutPolicy.java  
* @Package com.tinker.cai.remote.south.snmp.abs  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:47:33  
* @version V1.0    
*/
package com.tinker.cai.south.snmp.abs;

import com.adventnet.snmp.snmp2.TimeoutPolicy;

/**  
* @ClassName: SnmpTimeoutPolicy  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author tinker 
* @date 2016年1月21日 下午3:47:33  
*    
*/
public class SnmpTimeoutPolicy extends TimeoutPolicy {
	public int calculateTimeout(int timeout, int retries)
	  {
	    return timeout;
	  }
}
