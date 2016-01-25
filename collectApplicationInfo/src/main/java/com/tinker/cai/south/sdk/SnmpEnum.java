/**    
* @Title: SnmpEnum.java  
* @Package com.tinker.cai.remote.south.sdk  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:38:44  
* @version V1.0    
*/
package com.tinker.cai.south.sdk;

/**  
* @ClassName: SnmpEnum  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author tinker 
* @date 2016年1月21日 下午3:38:44  
*    
*/

public class SnmpEnum {
	public static enum SnmpType
	  {
	    UNKNOWN(-1), INTEGER(2), BITSTRING(3), STRING(4), NULLOBJ(5), OBJID(6), IPADDRESS(64), 
	    COUNTER(65), GAUGE(66), TIMETICKS(67), OPAQUE(68), NSAP(69), COUNTER64(70), 
	    UINTEGER32(71), NOSUCHOBJECT(128), NOSUCHINSTANCE(129), ENDOFMIBVIEW(130);

	    private int value;
	    public static final int TYPE_UNKNOWN = -1;
	    public static final int TYPE_INTEGER = 2;
	    public static final int TYPE_BITSTRING = 3;
	    public static final int TYPE_STRING = 4;
	    public static final int TYPE_NULLOBJ = 5;
	    public static final int TYPE_OBJID = 6;
	    public static final int TYPE_IPADDRESS = 64;
	    public static final int TYPE_COUNTER = 65;
	    public static final int TYPE_GAUGE = 66;
	    public static final int TYPE_TIMETICKS = 67;
	    public static final int TYPE_OPAQUE = 68;
	    public static final int TYPE_NSAP = 69;
	    public static final int TYPE_COUNTER64 = 70;
	    public static final int TYPE_UINTEGER32 = 71;
	    public static final int TYPE_NOSUCHOBJECT = 128;
	    public static final int TYPE_NOSUCHINSTANCE = 129;
	    public static final int TYPE_ENDOFMIBVIEW = 130;

	    private SnmpType(int value) { this.value = value; }


	    public static SnmpType getSnmpType(byte value)
	    {
	      for (SnmpType type : values())
	      {
	        if (value == type.value)
	        {
	          return type;
	        }
	      }

	      return UNKNOWN;
	    }

	    public static SnmpType getSnmpType(int value)
	    {
	      for (SnmpType type : values())
	      {
	        if (value == type.value)
	        {
	          return type;
	        }
	      }

	      return UNKNOWN;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum TransportProtocol
	  {
	    ILLEGAL(-1), TCP(0), UDP(1);

	    private int value;

	    private TransportProtocol(int value) { this.value = value; }


	    public static TransportProtocol getTransportProtocol(int value)
	    {
	      for (TransportProtocol type : values())
	      {
	        if (value == type.value)
	        {
	          return type;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum SecurityModel
	  {
	    ILLEGAL(-1), USM_SECURITY_MODEL(3);

	    private int value;

	    private SecurityModel(int value) { this.value = value; }


	    public static SecurityModel getSecurityModel(int value)
	    {
	      for (SecurityModel level : values())
	      {
	        if (value == level.value)
	        {
	          return level;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum SecurityLevel
	  {
	    ILLEGAL(-1), NOAUTH_NOPRIV(0), AUTH_NOPRIV(1), AUTH_PRIV(3);

	    private int value;

	    private SecurityLevel(int value) { this.value = value; }


	    public static SecurityLevel getSecurityLevel(int value)
	    {
	      for (SecurityLevel level : values())
	      {
	        if (value == level.value)
	        {
	          return level;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum PrivProtocol
	  {
	    ILLEGAL(-1), NO_PRIV(51), CBC_DES(50), CFB_AES_128(49), CFB_AES(48), CFB_AES_192(47), 
	    CFB_AES_256(46), CBC_3DES(45), DESEDE(44);

	    private int value;

	    private PrivProtocol(int value) { this.value = value; }


	    public static PrivProtocol getPrivProtocol(int value)
	    {
	      for (PrivProtocol protocol : values())
	      {
	        if (value == protocol.value)
	        {
	          return protocol;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum AuthProtocol
	  {
	    ILLEGAL(-1), NO_AUTH(20), MD5_AUTH(21), SHA_AUTH(22);

	    private int value;

	    private AuthProtocol(int value) { this.value = value; }


	    public static AuthProtocol getAuthProtocol(int value)
	    {
	      for (AuthProtocol protocol : values())
	      {
	        if (value == protocol.value)
	        {
	          return protocol;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }

	  public static enum SnmpVersion
	  {
	    ILLEGAL(-1), VERSION1(0), VERSION2C(1), VERSION3(3);

	    private int value;

	    private SnmpVersion(int value) { this.value = value; }


	    public static SnmpVersion getSnmpVersion(int value)
	    {
	      for (SnmpVersion version : values())
	      {
	        if (value == version.value)
	        {
	          return version;
	        }
	      }

	      return ILLEGAL;
	    }

	    public int getValue()
	    {
	      return this.value;
	    }
	  }
}
