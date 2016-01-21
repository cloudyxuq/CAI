/**    
* @Title: ResourceUse.java  
* @Package com.tinker.cai.sdk  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午6:43:48  
* @version V1.0    
*/
package com.tinker.cai.sdk;

import java.io.Serializable;

/**
 * @ClassName: ResourceUse
 * @Description: 信息资源使用父类
 * @author tinker
 * @date 2016年1月21日 下午6:43:48
 * 
 */
public class ResourceUse implements Serializable {
	private static final long serialVersionUID = -4112913248932192554L;
	/**
	 * 总量
	 */
	private String total = "";
	/**
	 * 使用
	 */
	private String used = "";
	/**
	 * %
	 */
	private String percent = "";
	/**
	 * 剩余
	 */
	private String remain = "";

	public String getTotal() {
		return total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUsed() {
		return used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getPercent() {
		return percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getRemain() {
		return remain;
	}

	public void setRemain(String remain) {
		this.remain = remain;
	}

}
