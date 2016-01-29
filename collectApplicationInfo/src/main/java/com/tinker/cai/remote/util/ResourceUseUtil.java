package com.tinker.cai.remote.util;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.adventnet.snmp.mibs.mibparser.MIBConstants;
import com.tinker.cai.sdk.ResourceUse;
import com.tinker.cai.sdk.StorageResourceUse;

public class ResourceUseUtil {
	   /**
	    * 获取计算机单个磁盘使用情况
	    * type为当前设备（磁盘）的mib id
	    * map为通过getStorageMapInfo获取的信息
	    */
   public static StorageResourceUse getSingleStorageInfo(String STORAGE_Type,Map<String,String> map){
	   List<StorageResourceUse> list=MapToList(map);
	   StorageResourceUse resu=null;
	   if(null!=list){
	     for(int i=0;i<list.size();i++){
	    	 resu=list.get(i);
	    	 if(STORAGE_Type.equals(resu.getType())){
	    		break;
	    	 }
	     }
	   }
	   return resu;
   }
   /**
    * 获取计算机磁盘总体使用情况
    * map为通过getStorageMapInfo获取的信息
    */
   public static ResourceUse getTotalStorageInfo(Map<String,String> map){
	   ResourceUse resu=new ResourceUse();
	   DecimalFormat df = new DecimalFormat("######0.00");
	   String[] type=map.get("STORAGE_Type").split(MibConstant.SPILT_FIX);
	   String[] used=map.get("STORAGE_Used").split(MibConstant.SPILT_FIX);
	   String[] size=map.get("STORAGE_Size").split(MibConstant.SPILT_FIX);
	   String[] unit=map.get("STORAGE_AllocationUnits").split(MibConstant.SPILT_FIX);
	   long total=0;
	   long inuse=0;
	   if(null!=map.get("STORAGE_Type")&&!"".equals(map.get("STORAGE_Type"))&&map.get("STORAGE_Type").length()!=0){
	   for(int i=0;i<type.length;i++){
		   total+=Double.parseDouble(size[i])*Integer.parseInt(unit[i]);
		   inuse+=Double.parseDouble(used[i])*Integer.parseInt(unit[i]);
	    }
	   resu.setTotal(String.valueOf(total));
	   resu.setUsed(String.valueOf(inuse));
	   resu.setPercent(String.valueOf(df.format(inuse*100/total))+"%");
	   resu.setRemain(String.valueOf(total-inuse));
	   }
	   return resu;
   }
   /**
    * 将磁盘信息的map转换为list集合
    * map为通过getStorageMapInfo获取的信息
    */
   public static List<StorageResourceUse> MapToList(Map<String,String> map){
	   List<StorageResourceUse> list=new ArrayList<StorageResourceUse>();
	   String[] type=map.get("STORAGE_Type").split(MibConstant.SPILT_FIX);
	   String[] used=map.get("STORAGE_Used").split(MibConstant.SPILT_FIX);
	   String[] size=map.get("STORAGE_Size").split(MibConstant.SPILT_FIX);
	   String[] unit=map.get("STORAGE_AllocationUnits").split(MibConstant.SPILT_FIX);
	   String[] name=map.get("STORAGE_Descr").split(MibConstant.SPILT_FIX);
	   if(null!=map.get("STORAGE_Type")&&!"".equals(map.get("STORAGE_Type"))&&map.get("STORAGE_Type").length()!=0){
		   for(int i=0;i<type.length;i++){
			   StorageResourceUse resu=new StorageResourceUse();
			   resu.setDiskName(name[i]);
			   resu.setType(type[i]);
			   resu.setUnit(unit[i]);
			   resu.setTotal(String.valueOf(Integer.parseInt(unit[i])*Long.parseLong(size[i])));
			   resu.setUsed(String.valueOf(Long.parseLong(used[i])*Integer.parseInt(unit[i])));
			   resu.setAvail(String.valueOf(Long.parseLong(resu.getTotal())-Long.parseLong(resu.getUsed())));
			   if("0".equals(resu.getTotal())){
				   resu.setPercent("0");
			   }else{
				   DecimalFormat df = new DecimalFormat("######0.00");
			       resu.setPercent(String.valueOf(df.format(Double.parseDouble(resu.getUsed())/Double.parseDouble(resu.getTotal())*100))+"%");
			   }
			   list.add(resu);
		   }
	   }
	   return list;
   }
}
