package com.tinker.cai.remote.cpu;

import java.util.Map;

/**
 * CPU获取实现类
 * @author tinker
 *
 */
public abstract interface ICpuService {

	/**
	 * 获取cpu基础信息map对象
	 * @param ip ip值
	 * @param port 端口
	 * @param save_path 生成文件保存路径
	 * @param mibs mibs值数据
	 * @return
	 */
	public abstract Map<String,String> getCpuMapInfo(String ip,String port,String save_path, Map<String,String> oidMaps);
	
	public abstract String getCpuInfo(String ip,String port,String save_path, Map<String,String> oidMaps);

}
