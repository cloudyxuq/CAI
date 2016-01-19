/**
 * 远程主机基础信息
 */
package com.tinker.cai.remote.host;

import java.util.Map;

/**
 * 远程主机基础信息
 * @author tinker
 *
 */
public abstract interface IHostService {
	/**
	 * 获取远程主机基础信息map对象
	 * @param ip ip值
	 * @param port 端口
	 * @param save_path 生成文件保存路径
	 * @param mibs mibs值数据
	 * @return
	 */
	public abstract Map<String,String> getHostMapInfo(String ip,String port,String save_path, Map<String,String> oidMaps);

}
