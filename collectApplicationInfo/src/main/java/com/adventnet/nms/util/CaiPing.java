/**
 * ping工具类
 */
package com.adventnet.nms.util;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * @author tinker
 *
 */
public class CaiPing {
	
	private static Logger sLogger = Logger.getLogger(CaiPing.class);

	 private String osname = System.getProperty("os.name");

	  private String pingPath = NmsUtil.getParameter("PING_PATH");

	  private String pingCmd = "ping -w 0 -n 1";

	  private String localip = SocketUtil.getServerHost();

	  private int numTry = 1;


	  public  boolean ping(String host)
	  {
	    return ping(host, 1);
	  }

	  private String getSolarisPing(String host, int retries)
	  {
	    if (null == this.localip)
	    {
	      if (null == this.pingPath)
	      {
	        this.pingCmd = "/usr/sbin/ping ";
	      }
	      else
	      {
	        this.pingCmd = this.pingPath;
	      }
	    }
	    else if (null == this.pingPath)
	    {
	      this.pingCmd = ("/usr/sbin/ping -i " + this.localip);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -i" + " " + this.localip);
	    }

	    return new String(this.pingCmd + " " + host + " " + this.numTry);
	  }

	  private String getLinuxPing(String host, int retries)
	  {
	    if (null == this.localip)
	    {
	      if (null == this.pingPath)
	      {
	        this.pingCmd = ("/bin/ping -c " + retries + " -w " + this.numTry);
	      }
	      else
	      {
	        this.pingCmd = (this.pingPath + " -c " + retries + " -w" + " " + this.numTry);
	      }

	    }
	    else if (null == this.pingPath)
	    {
	      this.pingCmd = ("/bin/ping -c " + retries + " -w " + this.numTry + " " + "-I" + " " + this.localip);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + retries + " -w" + " " + this.numTry + " " + "-I" + " " + this.localip);
	    }

	    return new String(this.pingCmd + " " + host);
	  }
	  private String getMacPing(String host, int retries)
	  {
	    if (null == this.localip)
	    {
	      if (null == this.pingPath)
	      {
	        this.pingCmd = ("/sbin/ping -c " + retries + " -W " + this.numTry);
	      }
	      else
	      {
	        this.pingCmd = (this.pingPath + " -c " + retries + " -W" + " " + this.numTry);
	      }

	    }
	    else if (null == this.pingPath)
	    {
	      this.pingCmd = ("/sbin/ping -c " + retries + " -W " + this.numTry + " " + "-I" + " " + this.localip);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + retries + " -W" + " " + this.numTry + " " + "-I" + " " + this.localip);
	    }

	    return new String(this.pingCmd + " " + host);
	  }
	  private String getFreeBSDPing(String host, int retries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("/sbin/ping -c " + retries);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + retries);
	    }

	    return new String(this.pingCmd + " " + host);
	  }

	  private String getWindowsPing(String host, int retries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("ping -n " + retries + " -w");
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -n " + retries + " -w");
	    }

	    return new String(this.pingCmd + " " + this.numTry * 1000 + " " + host);
	  }

	  private String getNonWinPing(String host, int retries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("ping -n " + retries);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -n " + retries);
	    }

	    return new String(this.pingCmd + " " + host);
	  }

	  private boolean execPing(String host, int retries)
	  {
	    String cmd = new String(this.pingCmd + " " + host);

	    if ((this.osname.startsWith("SunOS")) || (this.osname.startsWith("Solaris")))
	    {
	      cmd = getSolarisPing(host, retries);
	    }
	    else if (this.osname.startsWith("Linux"))
	    {
	      cmd = getLinuxPing(host, retries);
	    }
	    else if (this.osname.startsWith("Mac"))
	    {
	      cmd = getMacPing(host, retries);
	    }
	    else if (this.osname.startsWith("FreeBSD"))
	    {
	      cmd = getFreeBSDPing(host, retries);
	    }
	    else if (this.osname.startsWith("Windows"))
	    {
	      cmd = getWindowsPing(host, retries);
	    }
	    else if (!this.osname.startsWith("Windows"))
	    {
	      cmd = getNonWinPing(host, retries);
	    }

	    return execCmd(cmd);
	  }

	  private boolean execCmd(String cmd)
	  {
	    RunCmd runc = new RunCmd(cmd);
	    runc.start();
	    do
	    {
	      try
	      {
	        Thread.sleep(25L);
	      }
	      catch (Exception e)
	      {
	      }
	    }
	    while (!runc.finished);

	    if (this.osname.startsWith("Windows"))
	    {
	      if ((!runc.result) || (runc.exitValue != 0))
	      {
	        return false;
	      }
	      String reply = runc.stdout.toString();
	      boolean result = (reply.indexOf("Reply from") != -1) && (reply.indexOf("bytes=") != -1);

	      if (!result)
	      {
	        result = reply.indexOf("s TTL=") != -1;
	      }
	      return result;
	    }
	    if ((this.osname.startsWith("Linux")) || (this.osname.startsWith("FreeBSD")))
	    {
	      if ((!runc.result) || (runc.exitValue != 0))
	      {
	        return false;
	      }
	      String reply = runc.stdout.toString();
	      return reply.indexOf("64 bytes from") != -1;
	    }

	    return (runc.result) && (runc.exitValue == 0);
	  }

	  private String getSolarisCmd(String hostname, int pingTimeout, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = "/usr/sbin/ping ";
	    }
	    else
	    {
	      this.pingCmd = this.pingPath;
	    }
	    return new String(this.pingCmd + " " + hostname + " " + pingTimeout);
	  }

	  private String getLinuxCmd(String hostname, int pingTimeout, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("/bin/ping -c " + pingRetries + " -w");
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + pingRetries + " -w");
	    }

	    return new String(this.pingCmd + " " + pingTimeout + " " + hostname);
	  }
	  private String getMacCmd(String hostname, int pingTimeout, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("/sbin/ping -c " + pingRetries + " -W");
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + pingRetries + " -W");
	    }

	    return new String(this.pingCmd + " " + pingTimeout + " " + hostname);
	  }

	  private String getFreeBSDCmd(String hostname, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("/sbin/ping -c " + pingRetries);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -c " + pingRetries);
	    }

	    return new String(this.pingCmd + " " + hostname);
	  }

	  private String getWindowsCmd(String hostname, int pingTimeout, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("ping -n " + pingRetries + " -w");
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -n " + pingRetries + " -w");
	    }

	    return new String(this.pingCmd + " " + pingTimeout * 1000 + " " + hostname);
	  }

	  private String getNonWinCmd(String hostname, int pingRetries)
	  {
	    if (null == this.pingPath)
	    {
	      this.pingCmd = ("ping -n " + pingRetries);
	    }
	    else
	    {
	      this.pingCmd = (this.pingPath + " -n " + pingRetries);
	    }

	    return new String(this.pingCmd + " " + hostname);
	  }

	  public boolean ping(Properties p)
	  {
	    int pingRetries = PingUtil.parseRetries(p);
	    int pingTimeout = PingUtil.parseTimeout(p, this.osname);
	    String hostname = p.getProperty("hostName");
	    if (null == hostname)
	    {
	      this.sLogger.error("ping host properties is null.");
	      return false;
	    }

	    String cmd = new String(this.pingCmd + " " + hostname);

	    if ((this.osname.startsWith("SunOS")) || (this.osname.startsWith("Solaris")))
	    {
	      cmd = getSolarisCmd(hostname, pingTimeout, pingRetries);
	    }
	    else if (this.osname.startsWith("Linux"))
	    {
	      cmd = getLinuxCmd(hostname, pingTimeout, pingRetries);
	    }
	    else if (this.osname.startsWith("Mac"))
	    {
	      cmd = getMacCmd(hostname, pingTimeout, pingRetries);
	    }
	    else if (this.osname.startsWith("FreeBSD"))
	    {
	      cmd = getFreeBSDCmd(hostname, pingRetries);
	    }
	    else if (this.osname.startsWith("Windows"))
	    {
	      cmd = getWindowsCmd(hostname, pingTimeout, pingRetries);
	    }
	    else if (!this.osname.startsWith("Windows"))
	    {
	      cmd = getNonWinCmd(hostname, pingRetries);
	    }

	    boolean result = execCmd(cmd);
	    if (!result)
	    {
	      this.sLogger.info("Cai ICMP Ping failed for host " + hostname + ", Ping Properties " + p);
	    }

	    return result;
	  }

	  public boolean ping(String host, int retries)
	  {
	    boolean result = execPing(host, retries);
	    if (!result)
	    {
	      this.sLogger.info(NmsUtil.GetString("Cai ICMP Ping failed for host ") + host);
	    }

	    return result;
	  }

	  public void setPingTimeout(int timeout)
	  {
	    if (timeout <= 0)
	    {
	      if ((this.osname.startsWith("Linux")) || (this.osname.startsWith("Solaris")))
	      {
	        this.numTry = 1;
	      }
	    }
	    else
	    {
	      this.numTry = timeout;
	    }
	  }

	  public int getPingTimeout()
	  {
	    return this.numTry;
	  }
	  
	  public static boolean ping_ip(String ip){
		  
		  return new CaiPing().ping(ip);
	  }

}
