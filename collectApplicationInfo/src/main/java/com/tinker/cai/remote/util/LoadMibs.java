/**
 * Mibs库加载
 */
package com.tinker.cai.remote.util;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author tinker
 *
 */

	public class LoadMibs {
		private static Logger sLogger = Logger.getLogger(LoadMibs.class);
	    static private Map<String,String> mibMap = new HashMap<String, String>();
	    static{
	        loads();
	    }
	    synchronized static public void loads(){
	        if(null==mibMap||mibMap.isEmpty()){
	            InputStream is = LoadMibs.class.getResourceAsStream("/DefaultMibs.properties");
	            Properties mibproperties = new Properties();
	            try {
	            	mibproperties.load(is);
	            	Iterator it=mibproperties.entrySet().iterator();
	            	while(it.hasNext()){
	            	    Map.Entry entry=(Map.Entry)it.next();
	            	    String key = (String) entry.getKey();
	            	    String value =  (String)entry.getValue();
	            	    mibMap.put(key, value);
	            	}
	                    
	            }
	            catch (Exception e) {
	            	e.printStackTrace();
	            } 
	        }
	    }
	    
	     /**
	      * 根据properties配置获取所有mibs信息
	      * @return
	      */
	    public static Map<String, String> getMibMap() {
	    	if(null==mibMap||mibMap.isEmpty()){
	    		loads();
	    	}
			return mibMap;
		}
	    /**
	     * 获取以Name开头的配置的mib信息，eg：获取CPU信息，参数为CPU
	     * @param name
	     * @return
	     */
	    public static Map<String,String> getMapMibsObject(String name){
	    	
	    	Map<String,String> map = getMibMap();
	    	Map<String,String> returnMap = null;
	    	if(null==map||map.isEmpty()){
	    		sLogger.error("配置文件无法正常加载！！");
	    		return null;
	    	}
	    	returnMap = new HashMap<String,String>();
	    	for (String key : map.keySet()) {  
	    		  
	    	    if(key.startsWith(name)){
	    	    	returnMap.put(key, map.get(key));
	    	    }
	    	  
	    	}  
	    	return returnMap;
	    	
	    }
	}
