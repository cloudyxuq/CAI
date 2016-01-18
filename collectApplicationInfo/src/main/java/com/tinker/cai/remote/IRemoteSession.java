/**
 * IRemoteTool 远程获取设备基础信息
 * cloudyxuq
 * 2016年1月14日 下午4:48:25
 * @version 1.0.0
 */
package com.tinker.cai.remote;

/**
 * @author tinker
 *
 */
public abstract interface IRemoteSession {
	/**
	 * 获取远程主机基础信息
	 * @param remoteIp 远程机器ip地址eg：192.1.1.1
	 * @param port  端口eg：161
	 * @param save_path 端口eg：161
	 * @return Json字符串
	 */
	public abstract String getHostInfo(String remoteIp,String port,String save_path);
	
	/**
	 * 获取CPU基础信息
	 * @param remoteIp 远程机器ip地址eg：192.1.1.1
	 * @param port     端口eg：161
	 * @param save_path 端口eg：161
	 * @return Json字符串
	 */
   public abstract String getCpuInfo(String remoteIp,String port,String save_path);
	/**
	 * 获取内存基础信息
	 * @param remoteIp 远程机器ip地址eg：192.1.1.1
	 * @param port     端口eg：161
	 * @param save_path 保存地址
	 * @return Json字符串
	 */
   public abstract String getMemoryInfo(String remoteIp,String port,String save_path);
   /**
    * 获取磁盘基础信息
    * @param remoteIp 远程机器ip地址eg：192.1.1.1
	* @param port     端口eg：161
	* @param save_path 保存地址
    * @return Json字符串
    */
   public abstract String getDiskInfo(String remoteIp,String port,String save_path);
   /**
    * 获取数据库基础信息
    * @param remoteIp 远程机器ip地址eg：192.1.1.1
	* @param port     端口eg：161
	* @param save_path 保存地址
    * @return Json字符串
    */
   public abstract String getDBInfo(String remoteIp,String port,String save_path);
   /**
    * 获取web应用服务器基础信息
    * @param remoteIp 远程机器ip地址eg：192.1.1.1
	* @param port     端口eg：161
	* @param save_path 保存地址
    * @return Json字符串
    */
   public abstract String getAppInfo(String remoteIp,String port,String save_path);
}
