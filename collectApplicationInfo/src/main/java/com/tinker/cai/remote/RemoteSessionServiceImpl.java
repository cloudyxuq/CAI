/**
 * 远程调用实现类
 */
package com.tinker.cai.remote;

import java.util.Map;

import com.tinker.cai.remote.cpu.CpuServiceImpl;
import com.tinker.cai.remote.cpu.ICpuService;
import com.tinker.cai.remote.mem.IMemoryService;
import com.tinker.cai.remote.mem.MemoryServiceImpl;
import com.tinker.cai.remote.util.ConvertMap2Json;

import net.sf.json.JSONObject;

/**
 * @author tinker
 *
 */
public class RemoteSessionServiceImpl implements IRemoteSession {

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getHostInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getHostInfo(String remoteIp, String port, String save_path) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getCpuInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getCpuInfo(String remoteIp, String port, String save_path) {
		ICpuService cpuservice = new CpuServiceImpl();
		Map cpuInfoMap = cpuservice.getCpuMapInfo(remoteIp, port, save_path, null);
		if(cpuInfoMap!=null&&!cpuInfoMap.isEmpty()){
			
			return ConvertMap2Json.buildJsonBody(cpuInfoMap, 0, false);
		}
		return "";
		
		
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getMemoryInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getMemoryInfo(String remoteIp, String port, String save_path) {
		IMemoryService cpuservice = new MemoryServiceImpl();
		Map MemInfoMap = cpuservice.getMemoryMapInfo(remoteIp, port, save_path, null);
		if(MemInfoMap!=null&&!MemInfoMap.isEmpty()){
			
			return ConvertMap2Json.buildJsonBody(MemInfoMap, 0, false);
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getDiskInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getDiskInfo(String remoteIp, String port, String save_path) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getDBInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getDBInfo(String remoteIp, String port, String save_path) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getAppInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getAppInfo(String remoteIp, String port, String save_path) {
		// TODO Auto-generated method stub
		return null;
	}

}
