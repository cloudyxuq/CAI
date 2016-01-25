/**    
* @Title: RemoteCollectThread.java  
* @Package com.tinker.cai.remote  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午4:34:17  
* @version V1.0    
*/
package com.tinker.cai.remote;

import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import com.tinker.cai.remote.cpu.CpuServiceImpl;
import com.tinker.cai.remote.util.MibConstant;
import com.tinker.cai.remote.util.RemoteSessionServiceImpl;

/**  
* @ClassName: RemoteCollectThread  
* @Description:远程采集线程 
* @author tinker 
* @date 2016年1月21日 下午4:34:17  
*    
*/
public class RemoteCollectThread  implements Callable<String> {
	
	private String ip;
	private String port;
	private String save_path;
	private Map<String,String> oidMaps;
	private String type;
	
	
	/**
	 * 
	* <p>线程</p>  
	* <p>远程采集线程</p>  
	* @param type 采集类型
	* @param remoteIp ip地址
	* @param port 端口
	* @param save_path 数据保存路径
	* @param oidMaps oidmap对象（格式：名称：oid地址）
	 */
	public RemoteCollectThread(String type,String remoteIp, String port, String save_path,Map<String,String> oidMaps){
		this.type=type;
		this.ip=remoteIp;
		this.port=port;
		this.save_path=save_path;
		this.oidMaps = oidMaps;
	}
	public String call() throws Exception {
		if(null==type||"".equals(type)){
			return new RemoteSessionServiceImpl().getAllInfo(ip, port, save_path);
		}
		else if(MibConstant.CPU.equals(type)){
			return new RemoteSessionServiceImpl().getCpuInfo(ip, port, save_path);
		}
		else if(MibConstant.STORAGE.equals(type)){
			return new RemoteSessionServiceImpl().getStorageInfo(ip, port, save_path);
		}
		else if(MibConstant.MEMORY.equals(type)){
			return new RemoteSessionServiceImpl().getMemoryInfo(ip, port, save_path);
		}
		else if(MibConstant.HOST.equals(type)){
			return new RemoteSessionServiceImpl().getHostInfo(ip, port, save_path);
		}
		else
		{
			return new RemoteSessionServiceImpl().getAllInfo(ip, port, save_path);
		}
		
	}

}
