package com.tinker.cai;

import com.tinker.cai.remote.IRemoteSession;
import com.tinker.cai.remote.RemoteSessionServiceImpl;

public class Test {

	public static void main(String[] args) {
		IRemoteSession r = new RemoteSessionServiceImpl();
		System.out.println(r.getCpuInfo("192.168.4.12", "161", ""));
		System.out.println(r.getMemoryInfo("192.168.4.12", "161", ""));
		System.out.println(r.getHostInfo("192.168.4.12", "161", ""));
		System.out.println(r.getStorageInfo("192.168.4.254", "161", ""));
	}
	
}
