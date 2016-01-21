/**    
* @Title: AbstractSnmpAPI.java  
* @Package com.tinker.cai.remote.south.snmp.abs  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:30:54  
* @version V1.0    
*/
package com.tinker.cai.south.snmp.abs;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;

import com.adventnet.snmp.beans.SnmpTarget;
import com.adventnet.snmp.mibs.MibException;
import com.tinker.cai.exception.CaiUncheckException;
import com.tinker.cai.south.sdk.SnmpEnum;
import com.tinker.cai.south.snmp.exception.SnmpException;

/**
 * @ClassName: AbstractSnmpAPI
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author tinker
 * @date 2016年1月21日 下午3:30:54
 * 
 */
public class AbstractSnmpAPI implements Serializable {

	private static final long serialVersionUID = -6503561166038034536L;
	private SnmpTarget snmpTarget = new SnmpTarget();

	protected SnmpTimeoutPolicy timeoutPolicy = new SnmpTimeoutPolicy();

	public SnmpEnum.SnmpVersion getSnmpVersion() {
		return SnmpEnum.SnmpVersion.getSnmpVersion(this.snmpTarget.getSnmpVersion());
	}

	public void setSnmpVersion(SnmpEnum.SnmpVersion snmpVersion) {
		if (snmpVersion == SnmpEnum.SnmpVersion.ILLEGAL) {
			throw new CaiUncheckException("wrong snmp version.");
		}
		this.snmpTarget.setSnmpVersion(snmpVersion.getValue());
	}

	public String getTargetHost() {
		return this.snmpTarget.getTargetHost();
	}

	public void setTargetHost(String targetHost) {
		this.snmpTarget.setTargetHost(targetHost);
	}

	public int getTargetPort() {
		return this.snmpTarget.getTargetPort();
	}

	public void setTargetPort(int port) {
		this.snmpTarget.setTargetPort(port);
	}

	public int getTimeout() {
		return this.snmpTarget.getTimeout();
	}

	public void setTimeout(int timeout) {
		this.snmpTarget.setTimeout(timeout);
	}

	public int getRetries() {
		return this.snmpTarget.getRetries();
	}

	public void setRetries(int retries) {
		this.snmpTarget.setRetries(retries);
	}

	public String getCommunity() {
		return this.snmpTarget.getCommunity();
	}

	public void setCommunity(String community) {
		this.snmpTarget.setCommunity(community);
	}

	public String getWriteCommunity() {
		return this.snmpTarget.getWriteCommunity();
	}

	public void setWriteCommunity(String community) {
		this.snmpTarget.setWriteCommunity(community);
	}

	public String getAuthPassword() {
		return this.snmpTarget.getAuthPassword();
	}

	public void setAuthPassword(String authPwd) {
		this.snmpTarget.setAuthPassword(authPwd);
	}

	public SnmpEnum.AuthProtocol getAuthProtocol() {
		return SnmpEnum.AuthProtocol.getAuthProtocol(this.snmpTarget.getAuthProtocol());
	}

	public void setAuthProtocol(SnmpEnum.AuthProtocol authProtocol) {
		if (authProtocol == SnmpEnum.AuthProtocol.ILLEGAL) {
			throw new CaiUncheckException("wrong auth protocol.");
		}
		this.snmpTarget.setAuthProtocol(authProtocol.getValue());
	}

	public String getPrivPassword() {
		return this.snmpTarget.getPrivPassword();
	}

	public void setPrivPassword(String privPwd) {
		this.snmpTarget.setPrivPassword(privPwd);
	}

	public SnmpEnum.PrivProtocol getPrivProtocol() {
		return SnmpEnum.PrivProtocol.getPrivProtocol(this.snmpTarget.getPrivProtocol());
	}

	public void setPrivProtocol(SnmpEnum.PrivProtocol privProtocol) {
		if (privProtocol == SnmpEnum.PrivProtocol.ILLEGAL) {
			throw new CaiUncheckException("wrong priv protocol.");
		}
		this.snmpTarget.setPrivProtocol(privProtocol.getValue());
	}

	public String getContextID() {
		return this.snmpTarget.getContextID();
	}

	public void setContextID(String contextID) {
		this.snmpTarget.setContextID(contextID);
	}

	public String getContextName() {
		return this.snmpTarget.getContextName();
	}

	public void setContextName(String contextName) {
		this.snmpTarget.setContextName(contextName);
	}

	public byte[] getEngineID() {
		return this.snmpTarget.getEngineID();
	}

	public void setEngineID(byte[] engineID) {
		this.snmpTarget.setEngineID(engineID);
	}

	public String getSecurityName() {
		return this.snmpTarget.getPrincipal();
	}

	public void setSecurityName(String securityName) {
		this.snmpTarget.setPrincipal(securityName);
	}

	public SnmpEnum.SecurityLevel getSecurityLevel() {
		return SnmpEnum.SecurityLevel.getSecurityLevel(Integer.parseInt(this.snmpTarget.getSecurityLevel()));
	}

	public void setSecurityLevel(SnmpEnum.SecurityLevel securityLevel) {
		this.snmpTarget.setSecurityLevel((byte) securityLevel.getValue());
	}

	public SnmpEnum.SecurityModel getSecurityModel() {
		return SnmpEnum.SecurityModel.getSecurityModel(this.snmpTarget.getSecurityModel());
	}

	public void setSecurityModel(SnmpEnum.SecurityModel securityModel) {
		this.snmpTarget.setSecurityModel(securityModel.getValue());
	}

	public int getMaxNumRows() {
		return this.snmpTarget.getMaxNumRows();
	}

	public void setMaxNumRows(int maxNumRows) {
		this.snmpTarget.setMaxNumRows(maxNumRows);
	}

	public int getMaxRepetitions() {
		return this.snmpTarget.getMaxRepetitions();
	}

	public void setMaxRepetitions(int maxRepetitions) {
		this.snmpTarget.setMaxRepetitions(maxRepetitions);
	}

	public int getNonRepeaters() {
		return this.snmpTarget.getNonRepeaters();
	}

	public void setNonRepeaters(int i) {
		this.snmpTarget.setNonRepeaters(i);
	}

	public void loadMibs(String mibFile) {
		try {
			if (mibFile.indexOf(" ") != -1) {
				mibFile = "\"" + mibFile + "\"";
			}
			this.snmpTarget.loadMibs(mibFile);
		} catch (FileNotFoundException e) {
			throw new SnmpException("FileNotFoundException occured when loadMibs, mibFile: " + mibFile, e);
		} catch (MibException e) {
			throw new SnmpException("MibException occured when loadMibs.", e);
		} catch (IOException e) {
			throw new SnmpException("IOException occured when loadMibs.", e);
		}
	}

	protected SnmpTarget getSnmpTarget() {
		return this.snmpTarget;
	}
}
