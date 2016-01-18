package com.adventnet.nms.util;

import java.util.Properties;

public class PingUtil {


	  public static RunCmd execCmd(String cmd)
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

	    return runc;
	  }

	  public static int parseTimeout(Properties p, String osname)
	  {
	    int pingTimeout = 5;
	    String temp = p.getProperty("pingTimeout");
	    try
	    {
	      if (null != temp)
	      {
	        pingTimeout = Integer.parseInt(temp);
	        if ((pingTimeout <= 0) && ((osname.startsWith("Linux")) || (osname.startsWith("Solaris"))))
	        {
	          pingTimeout = 5;
	        }
	      }
	    }
	    catch (NumberFormatException nfe)
	    {
	      pingTimeout = 5;
	    }

	    return pingTimeout;
	  }

	  public static int parseRetries(Properties p)
	  {
	    int pingRetries = 1;
	    String temp = p.getProperty("pingRetries");
	    try
	    {
	      if (null != temp)
	      {
	        pingRetries = Integer.parseInt(temp);
	      }
	    }
	    catch (NumberFormatException nfe)
	    {
	      pingRetries = 1;
	    }

	    if (pingRetries == 0)
	    {
	      pingRetries = 1;
	    }
	    return pingRetries;
	  }
}
