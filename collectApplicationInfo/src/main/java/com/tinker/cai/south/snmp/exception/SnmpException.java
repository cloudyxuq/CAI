/**    
* @Title: SnmpException.java  
* @Package com.tinker.cai.remote.south.snmp.exception  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:32:59  
* @version V1.0    
*/
package com.tinker.cai.south.snmp.exception;

import com.tinker.cai.exception.CaiException;

/**  
* @ClassName: SnmpException  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author tinker 
* @date 2016年1月21日 下午3:32:59  
*    
*/
public class SnmpException extends CaiException {
	public SnmpException(String message)
	  {
	    super(message);
	  }

	  public SnmpException(String message, Throwable cause)
	  {
	    super(message, cause);
	  }

	  public SnmpException(long errorCode, String message)
	  {
	    super(errorCode, message);
	  }
}
