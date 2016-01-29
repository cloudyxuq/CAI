package com.tinker.cai.sdk;

import java.io.Serializable;

public class MemoryUse implements Serializable{
	private static final long serialVersionUID = -4112913248932192554L;
	//内存大小
	private String hrMemorySize="";
	//物理总内存
	private String memTotalReal="";
	//可用物理内存
	private String memAvailReal="";
	//已用物理内存
	private String memUsedReal="";
	//物理内存利用率
	private String memPercent="";
	//共享内存
	private String memShared="";
	//缓冲
	private String memBuffer="";
	//缓存
	private String memCached="";
	public String getHrMemorySize() {
		return hrMemorySize;
	}
	public void setHrMemorySize(String hrMemorySize) {
		this.hrMemorySize = hrMemorySize;
	}
	public String getMemTotalReal() {
		return memTotalReal;
	}
	public void setMemTotalReal(String memTotalReal) {
		this.memTotalReal = memTotalReal;
	}
	public String getMemAvailReal() {
		return memAvailReal;
	}
	public void setMemAvailReal(String memAvailReal) {
		this.memAvailReal = memAvailReal;
	}
	public String getMemPercent() {
		return memPercent;
	}
	public void setMemPercent(String memPercent) {
		this.memPercent = memPercent;
	}
	public String getMemShared() {
		return memShared;
	}
	public void setMemShared(String memShared) {
		this.memShared = memShared;
	}
	public String getMemBuffer() {
		return memBuffer;
	}
	public void setMemBuffer(String memBuffer) {
		this.memBuffer = memBuffer;
	}
	public String getMemCached() {
		return memCached;
	}
	public void setMemCached(String memCached) {
		this.memCached = memCached;
	}
	public String getMemUsedReal() {
		return memUsedReal;
	}
	public void setMemUsedReal(String memUsedReal) {
		this.memUsedReal = memUsedReal;
	}
}
