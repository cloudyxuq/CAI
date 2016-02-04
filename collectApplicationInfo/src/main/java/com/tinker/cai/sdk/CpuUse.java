package com.tinker.cai.sdk;

public class CpuUse {
	//原始系统CPU使用时间
	private String ssCpuRawSystemTime="";
	//IO发送次数
	private String ssIOSent="";
	//
	private String ssRawContexts="";
	//原始cpu被打断次数
	private String ssCpuRawInterrupt="";
	//原始用户CPU使用时间
	private String ssCpuRawIdleTime="";
	//
	private String ssRawSwapIn="";
	//
	private String ssSwapIn="";
	//系统CPU百分比
	private String ssCpuSystem="";
	//
	private String ssRawSwapOut="";
	//
	private String ssSysContext="";
	//空闲CPU百分比
	private String ssCpuIdle="";
	//原始nice占用时间
	private String ssCpuRawNiceTime="";
	//用户CPU百分比
	private String ssIOReceive="";
	//系统cpu被打断时间
	private String ssSysInterrupts="";
	//原始cpu等待时间
	private String ssCpuRawWait="";
	//用户CPU百分比
	private String ssCpuUser="";
	//
	private String SsSwapOut="";
	//
	private String ssIORawReceived="";
	//
	private String ssRawInterrupts="";
	//CPU的当前负载，N个核就有N个负载
	private String hrProcessorLoad="";
	//
	private String ssCpuRawSoftIRQ="";
	//
	private String ssIORawSent="";
	//原始用户CPU使用时间
	private String ssCpuRawUserTime="";
	public String getSsCpuRawSystemTime() {
		return ssCpuRawSystemTime;
	}
	public void setSsCpuRawSystemTime(String ssCpuRawSystemTime) {
		this.ssCpuRawSystemTime = ssCpuRawSystemTime;
	}
	public String getSsIOSent() {
		return ssIOSent;
	}
	public void setSsIOSent(String ssIOSent) {
		this.ssIOSent = ssIOSent;
	}
	public String getSsRawContexts() {
		return ssRawContexts;
	}
	public void setSsRawContexts(String ssRawContexts) {
		this.ssRawContexts = ssRawContexts;
	}
	public String getSsCpuRawInterrupt() {
		return ssCpuRawInterrupt;
	}
	public void setSsCpuRawInterrupt(String ssCpuRawInterrupt) {
		this.ssCpuRawInterrupt = ssCpuRawInterrupt;
	}
	public String getSsCpuRawIdleTime() {
		return ssCpuRawIdleTime;
	}
	public void setSsCpuRawIdleTime(String ssCpuRawIdleTime) {
		this.ssCpuRawIdleTime = ssCpuRawIdleTime;
	}
	public String getSsRawSwapIn() {
		return ssRawSwapIn;
	}
	public void setSsRawSwapIn(String ssRawSwapIn) {
		this.ssRawSwapIn = ssRawSwapIn;
	}
	public String getSsCpuSystem() {
		return ssCpuSystem;
	}
	public void setSsCpuSystem(String ssCpuSystem) {
		this.ssCpuSystem = ssCpuSystem;
	}
	public String getSsRawSwapOut() {
		return ssRawSwapOut;
	}
	public void setSsRawSwapOut(String ssRawSwapOut) {
		this.ssRawSwapOut = ssRawSwapOut;
	}
	public String getSsSysContext() {
		return ssSysContext;
	}
	public void setSsSysContext(String ssSysContext) {
		this.ssSysContext = ssSysContext;
	}
	public String getSsCpuIdle() {
		return ssCpuIdle;
	}
	public void setSsCpuIdle(String ssCpuIdle) {
		this.ssCpuIdle = ssCpuIdle;
	}
	public String getSsCpuRawNiceTime() {
		return ssCpuRawNiceTime;
	}
	public void setSsCpuRawNiceTime(String ssCpuRawNiceTime) {
		this.ssCpuRawNiceTime = ssCpuRawNiceTime;
	}
	public String getSsIOReceive() {
		return ssIOReceive;
	}
	public void setSsIOReceive(String ssIOReceive) {
		this.ssIOReceive = ssIOReceive;
	}
	public String getSsSysInterrupts() {
		return ssSysInterrupts;
	}
	public void setSsSysInterrupts(String ssSysInterrupts) {
		this.ssSysInterrupts = ssSysInterrupts;
	}
	public String getSsCpuRawWait() {
		return ssCpuRawWait;
	}
	public void setSsCpuRawWait(String ssCpuRawWait) {
		this.ssCpuRawWait = ssCpuRawWait;
	}
	public String getSsCpuUser() {
		return ssCpuUser;
	}
	public void setSsCpuUser(String ssCpuUser) {
		this.ssCpuUser = ssCpuUser;
	}
	public String getSsSwapOut() {
		return SsSwapOut;
	}
	public void setSsSwapOut(String ssSwapOut) {
		SsSwapOut = ssSwapOut;
	}
	public String getSsIORawReceived() {
		return ssIORawReceived;
	}
	public void setSsIORawReceived(String ssIORawReceived) {
		this.ssIORawReceived = ssIORawReceived;
	}
	public String getSsRawInterrupts() {
		return ssRawInterrupts;
	}
	public void setSsRawInterrupts(String ssRawInterrupts) {
		this.ssRawInterrupts = ssRawInterrupts;
	}
	public String getHrProcessorLoad() {
		return hrProcessorLoad;
	}
	public void setHrProcessorLoad(String hrProcessorLoad) {
		this.hrProcessorLoad = hrProcessorLoad;
	}
	public String getSsCpuRawSoftIRQ() {
		return ssCpuRawSoftIRQ;
	}
	public void setSsCpuRawSoftIRQ(String ssCpuRawSoftIRQ) {
		this.ssCpuRawSoftIRQ = ssCpuRawSoftIRQ;
	}
	public String getSsIORawSent() {
		return ssIORawSent;
	}
	public void setSsIORawSent(String ssIORawSent) {
		this.ssIORawSent = ssIORawSent;
	}
	public String getSsCpuRawUserTime() {
		return ssCpuRawUserTime;
	}
	public void setSsCpuRawUserTime(String ssCpuRawUserTime) {
		this.ssCpuRawUserTime = ssCpuRawUserTime;
	}
	public String getSsSwapIn() {
		return ssSwapIn;
	}
	public void setSsSwapIn(String ssSwapIn) {
		this.ssSwapIn = ssSwapIn;
	}
	
}
