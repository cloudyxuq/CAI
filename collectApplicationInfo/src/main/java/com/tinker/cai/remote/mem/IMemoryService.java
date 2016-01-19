/**
 * 内存信息接口
 */
package com.tinker.cai.remote.mem;

import java.util.Map;

/**
 * @author tinker
 *
 */
public abstract interface IMemoryService {
 
	/**
	 * 获取内存基础信息map对象
	 * @param ip ip值
	 * @param port 端口
	 * @param save_path 生成文件保存路径
	 * @param mibs mibs值数据
	 * @return
	 */
	public abstract Map<String,String> getMemoryMapInfo(String ip,String port,String save_path, Map<String,String> oidMaps);

	
}
