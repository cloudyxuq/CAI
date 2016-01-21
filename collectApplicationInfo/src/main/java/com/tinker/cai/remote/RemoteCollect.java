/**    
* @Title: RemoteCollect.java  
* @Package com.tinker.cai.remote  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午5:11:42  
* @version V1.0    
*/
package com.tinker.cai.remote;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @ClassName: RemoteCollect
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tinker
 * @date 2016年1月21日 下午5:11:42
 * 
 */
public class RemoteCollect {

	private String ip;
	private String port;
	private String save_path;
	private Map<String, String> oidMaps;
	private String type;

	/**
	 * 
	 * <p>
	 * 线程
	 * </p>
	 * <p>
	 * 远程采集线程
	 * </p>
	 * 
	 * @param type
	 *            采集类型
	 * @param remoteIp
	 *            ip地址
	 * @param port
	 *            端口
	 * @param save_path
	 *            数据保存路径
	 * @param oidMaps
	 *            oidmap对象（格式：名称：oid地址）
	 */
	public RemoteCollect(String type, String remoteIp, String port, String save_path, Map<String, String> oidMaps) {
		this.type = type;
		this.ip = remoteIp;
		this.port = port;
		this.save_path = save_path;
		this.oidMaps = oidMaps;
	}
/**
 * 
* @Title: getRemoteCollect  
* @Description: 前台返回数据
* @param @return    设定文件  
* @return String    返回类型  json格式
* @throws
 */
	public String getRemoteCollect() {
		try {
			ExecutorService exs = Executors.newCachedThreadPool();
			Future<String> fu = exs.submit(new RemoteCollectThread(type, ip, port, save_path, oidMaps));
			if (null != fu) {
				return fu.get();
			} else {
				return "";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
}