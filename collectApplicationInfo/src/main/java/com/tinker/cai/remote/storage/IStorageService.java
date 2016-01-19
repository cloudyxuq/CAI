/**
 * 远程主机基础信息
 */
package com.tinker.cai.remote.storage;

import java.util.Map;

/**
 * 远程主机存储基础信息
 * @author tinker
 *
 */
public abstract interface IStorageService {
	/**
	 * 获取远程设备存储基础信息map对象
	 * @param ip ip值
	 * @param port 端口
	 * @param save_path 生成文件保存路径
	 * @param mibs mibs值数据
	 * @return
	 */
	public abstract Map<String,String> getStorageMapInfo(String ip,String port,String save_path, Map<String,String> oidMaps);

}
