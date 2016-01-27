package com.tinker.cai.remote.util;

import java.text.DecimalFormat;
import java.util.Map;

import com.tinker.cai.sdk.MemoryUse;

public class MemoryUseUtil {
	   /**
	    * 获取计算机磁盘总体使用情况
	    * map为通过getStorageMapInfo获取的信息
	    */
	   public static MemoryUse getTotalMemoryInfo(Map<String,String> map){
		   MemoryUse mem=new MemoryUse();
		   DecimalFormat df = new DecimalFormat("######0.00");
		   mem.setHrMemorySize(map.get("MEM_hrMemorySize"));
		   mem.setMemAvailReal(map.get("MEM_memAvailReal"));
		   mem.setMemShared(map.get("MEM_memShared"));
		   mem.setMemTotalReal(map.get("MEM_memTotalReal"));
		   mem.setMemBuffer(map.get("MEM_menBuffere"));
		   mem.setMemUsedReal(String.valueOf(Long.parseLong(mem.getMemTotalReal())-Long.parseLong(mem.getMemAvailReal())));
		   mem.setMemPercent(String.valueOf(df.format(Long.parseLong(mem.getMemUsedReal())*100/Long.parseLong(mem.getMemTotalReal())))+"%");
		   mem.setMemCached(map.get("MEM_memCached"));
		   return mem;
	   }
}
