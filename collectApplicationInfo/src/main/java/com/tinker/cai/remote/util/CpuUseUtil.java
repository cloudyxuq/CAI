package com.tinker.cai.remote.util;

import java.util.Map;

import com.tinker.cai.sdk.CpuUse;

public class CpuUseUtil {
	   /**
	    * 获取计算机cpu总体使用情况
	    * map为通过getCpuMapInfo获取的信息
	    */
	   public static CpuUse getCpuMapInfo(Map<String,String> map){
            CpuUse cu=new CpuUse();
            cu.setSsCpuRawSystemTime(map.get("CPU_ssCpuRawSystemTime"));
            cu.setSsIOSent(map.get("CPU_ssIOSent"));
            cu.setSsRawContexts(map.get("CPU_ssRawContexts"));
            cu.setSsCpuRawInterrupt(map.get("CPU_ssCpuRawInterrupt"));
            cu.setSsCpuRawIdleTime(map.get("CPU_ssCpuRawIdleTime"));
            cu.setSsRawSwapIn(map.get("CPU_ssRawSwapIn"));
            cu.setSsSwapIn(map.get("CPU_ssSwapIn"));
            cu.setSsCpuSystem(map.get("CPU_ssCpuSystem"));
            cu.setSsRawSwapOut(map.get("CPU_ssRawSwapOut"));
            cu.setSsSysContext(map.get("CPU_ssSysContext"));
            cu.setSsCpuIdle(map.get("CPU_ssCpuIdle"));
            cu.setSsCpuRawNiceTime(map.get("CPU_ssCpuRawNiceTime"));
            cu.setSsIOReceive(map.get("CPU_ssIOReceive"));
            cu.setSsSysInterrupts(map.get("CPU_ssSysInterrupts"));
            cu.setSsCpuRawWait(map.get("CPU_ssCpuRawWait"));
            cu.setSsCpuUser(map.get("CPU_ssCpuUser"));
            cu.setSsRawSwapOut(map.get("CPU_SsSwapOut"));
            cu.setSsIORawReceived(map.get("CPU_ssIORawReceived"));
            cu.setSsRawInterrupts(map.get("CPU_ssRawInterrupts"));
            cu.setHrProcessorLoad(map.get("CPU_hrProcessorLoad"));
            cu.setSsCpuRawSoftIRQ(map.get("CPU_ssCpuRawSoftIRQ"));
            cu.setSsIORawSent(map.get("CPU_ssIORawSent"));
            cu.setSsCpuRawUserTime(map.get("CPU_ssCpuRawUserTime"));
            return cu;
	   }
}
