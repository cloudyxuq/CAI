/**    
* @Title: StorageResourceUse.java  
* @Package com.tinker.cai.sdk  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午6:47:34  
* @version V1.0    
*/
package com.tinker.cai.sdk;

/**
 * @ClassName: StorageResourceUse
 * @Description: 磁盘使用对象
 * @author tinker
 * @date 2016年1月21日 下午6:47:34
 * 
 */
public class StorageResourceUse {
	private static final long serialVersionUID = -4928498859030508005L;
	/**
	 * 磁盘（分区）名称
	 */
	private String diskName = "";
	/**
	 * 单位
	 */
	private String unit = "";
	/**
	 * 总量
	 */
	private String total = "";
	/**
	 * 已使用
	 */
	private String used = "";
	/**
	 * 可用
	 */
	private String avail = "";
	/**
	 * %(利用率）
	 */
	private String percent = "";
	/**
	 * mib  ID
	 */
	private String type = "";
	public String getDiskName() {
		return this.diskName;
	}

	public void setDiskName(String diskName) {
		this.diskName = diskName;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getTotal() {
		return this.total;
	}

	public void setTotal(String total) {
		this.total = total;
	}

	public String getUsed() {
		return this.used;
	}

	public void setUsed(String used) {
		this.used = used;
	}

	public String getPercent() {
		return this.percent;
	}

	public void setPercent(String percent) {
		this.percent = percent;
	}

	public String getAvail() {
		return this.avail;
	}

	public void setAvail(String avail) {
		this.avail = avail;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
