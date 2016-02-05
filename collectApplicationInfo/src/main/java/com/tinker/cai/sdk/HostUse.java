package com.tinker.cai.sdk;

public class HostUse {
	 //机器坐在位置
     private String SysLocation="";
	 //获取系统基本信息
     private String SysDesc="";
	 //系统联系人
     private String SysContact="";
	 //获取机器名
     private String SysName="";
	 //监控时间
     private String SysUptime="";
	 //机器提供的服务
     private String SysService="";
	public String getSysLocation() {
		return SysLocation;
	}
	public void setSysLocation(String sysLocation) {
		SysLocation = sysLocation;
	}
	public String getSysDesc() {
		return SysDesc;
	}
	public void setSysDesc(String sysDesc) {
		SysDesc = sysDesc;
	}
	public String getSysContact() {
		return SysContact;
	}
	public void setSysContact(String sysContact) {
		SysContact = sysContact;
	}
	public String getSysName() {
		return SysName;
	}
	public void setSysName(String sysName) {
		SysName = sysName;
	}
	public String getSysUptime() {
		return SysUptime;
	}
	public void setSysUptime(String sysUptime) {
		SysUptime = sysUptime;
	}
	public String getSysService() {
		return SysService;
	}
	public void setSysService(String sysService) {
		SysService = sysService;
	}
}
