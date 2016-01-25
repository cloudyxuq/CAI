/**
 * 远程调用实现类
 */
package com.tinker.cai.remote.util;

import java.util.Date;
import java.util.Map;

import com.tinker.cai.remote.cpu.CpuServiceImpl;
import com.tinker.cai.remote.cpu.ICpuService;
import com.tinker.cai.remote.host.HostServiceImpl;
import com.tinker.cai.remote.host.IHostService;
import com.tinker.cai.remote.mem.IMemoryService;
import com.tinker.cai.remote.mem.MemoryServiceImpl;
import com.tinker.cai.remote.storage.IStorageService;
import com.tinker.cai.remote.storage.StorageServiceImpl;

/**
 * @author tinker
 *
 */
public class RemoteSessionServiceImpl implements IRemoteSession {

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getHostInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getHostInfo(String remoteIp, String port, String save_path) {
		IHostService cpuservice = new HostServiceImpl();
		Map hostInfoMap = cpuservice.getHostMapInfo(remoteIp, port, save_path, null);
		if(hostInfoMap!=null&&!hostInfoMap.isEmpty()){
			
			return ConvertMap2Json.buildJsonBody(MibConstant.HOST,hostInfoMap, 0, false);
		}
		return "";
		
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getCpuInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getCpuInfo(String remoteIp, String port, String save_path) {
		ICpuService cpuservice = new CpuServiceImpl();
		Map cpuInfoMap = cpuservice.getCpuMapInfo(remoteIp, port, save_path, null);
		if(cpuInfoMap!=null&&!cpuInfoMap.isEmpty()){
			
			 return ConvertMap2Json.buildJsonBody(MibConstant.CPU,cpuInfoMap, 0, false);
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
			
			return ConvertMap2Json.buildJsonBody(MibConstant.MEMORY,MemInfoMap, 0, false);
		}
		return "";
	}

	/* (non-Javadoc)
	 * @see com.tinker.cai.remote.IRemoteSession#getDiskInfo(java.lang.String, java.lang.String, java.lang.String)
	 */
	public String getStorageInfo(String remoteIp, String port, String save_path) {
		IStorageService cpuservice = new StorageServiceImpl();
		Map storageInfoMap = cpuservice.getStorageMapInfo(remoteIp, port, save_path, null);
		if(storageInfoMap!=null&&!storageInfoMap.isEmpty()){
			
			return ConvertMap2Json.buildJsonBody(MibConstant.STORAGE,storageInfoMap, 0, false);
		}
		return "";
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

	public String getAllInfo(String remoteIp, String port, String save_path) {
		StringBuffer sb = new StringBuffer();
		sb.append("{\n\"").append(MibConstant.ALL+ConvertMap2Json.formatDate(new Date())).append("\":[").append(getCpuInfo(remoteIp, port, save_path)).append(",").append(getMemoryInfo(remoteIp, port, save_path))
		.append(",").append(getHostInfo(remoteIp, port, save_path)).append(",").append(getStorageInfo(remoteIp, port, save_path)).append("]\n}");
		return sb.toString();
	}

}
