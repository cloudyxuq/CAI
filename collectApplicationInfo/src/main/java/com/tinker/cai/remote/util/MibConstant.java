/**
 * 
 */
package com.tinker.cai.remote.util;

import org.snmp4j.Snmp;
import org.snmp4j.mp.SnmpConstants;

/**
 * @author tinker
 *
 */
public class MibConstant {
	
	public static final String CPU="CPU_";
	public static final String MEMORY="MEM_";
	public static final String STORAGE="STORAGE_";
	public static final String HOST="HOST_";
	
	//访问
	public static final String COMMUNITY ="public";
	public static final int SNMPVERSION = SnmpConstants.version2c;
	public static final long TIMEOUT = 1000;
	public static final int RETRIES = 1;
	public static final String PUDPREFIX = "/";
	//返回树拼接字符串分隔符
	public static final String SPILT_FIX="##";
	

}
