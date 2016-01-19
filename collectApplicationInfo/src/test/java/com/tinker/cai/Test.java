package com.tinker.cai;

import com.tinker.cai.remote.IRemoteSession;
import com.tinker.cai.remote.RemoteSessionServiceImpl;

public class Test {

	public static void main(String[] args) {
		IRemoteSession r = new RemoteSessionServiceImpl();
		System.out.println(r.getCpuInfo("192.168.4.13", "161", ""));
		System.out.println(r.getMemoryInfo("192.168.4.13", "161", ""));
	}
	
}
