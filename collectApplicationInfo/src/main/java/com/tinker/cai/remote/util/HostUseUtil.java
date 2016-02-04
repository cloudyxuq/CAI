package com.tinker.cai.remote.util;

import java.util.Map;

import com.tinker.cai.sdk.HostUse;

public class HostUseUtil {
	   /**
	    * 获取计算机系统信息
	    * map为通过getHostMapInfo获取的信息
	    */
	   public static HostUse getHostMapInfo(Map<String,String> map){
		   HostUse hu=new HostUse();
		   hu.setSysLocation(map.get("HOST_SYSLOCATION"));
		   hu.setSysDesc(map.get("HOST_SYSDESC"));
		   hu.setSysContact(map.get("HOST_SYSCONTACT"));
		   hu.setSysName(map.get("HOST_SYSNAME"));
		   hu.setSysUptime(map.get("HOST_SYSUPTIME"));
		   hu.setSysService(map.get("HOST_SYSSERVICE"));
		   return hu;
	   }
}
