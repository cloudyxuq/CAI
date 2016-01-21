package com.tinker.cai;

import java.util.Date;

import org.apache.log4j.Logger;

import com.tinker.cai.remote.RemoteCollect;
import com.tinker.cai.remote.util.IRemoteSession;
import com.tinker.cai.remote.util.MibConstant;
import com.tinker.cai.remote.util.RemoteSessionServiceImpl;

public class Test {

	public static void main(String[] args) {
		Logger l = Logger.getLogger(Test.class);
//		IRemoteSession r = new RemoteSessionServiceImpl();
//		System.out.println(r.getCpuInfo("192.168.4.12", "161", ""));
//		System.out.println(r.getMemoryInfo("192.168.4.12", "161", ""));
//		System.out.println(r.getHostInfo("192.168.4.12", "161", ""));
//		System.out.println(r.getStorageInfo("192.168.4.254", "161", ""));
	for(int i=0;i<1;i++){
		String date = new Date().toGMTString();
		RemoteCollect c = new RemoteCollect("","192.168.4.12", "161", "",null);
	l.info(c.getRemoteCollect());
	}
	}
	
}
