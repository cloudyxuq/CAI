/**    
* @Title: CaiException.java  
* @Package com.tinker.cai.exception  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:34:27  
* @version V1.0    
*/
package com.tinker.cai.exception;

/**  
* @ClassName: CaiException  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author tinker 
* @date 2016年1月21日 下午3:34:27  
*    
*/
public class CaiException extends RuntimeException{

	private static final long serialVersionUID = 9223257323548528435L;
	  private long errorCode;
	  private String[] parameters;
	  private Object accessoryResult;

	  public CaiException(String message, Throwable cause)
	  {
	    super(message, cause);
	  }

	  public CaiException(String message)
	  {
	    super(message);
	  }

	  public CaiException(long errorCode)
	  {
	    super("Code: " + errorCode);
	    this.errorCode = errorCode;
	  }

	  public CaiException(long errorCode, String[] parameter)
	  {
	    super("Code: " + errorCode);
	    this.errorCode = errorCode;
	    this.parameters = parameter;
	  }

	  public CaiException(long errorCode, Throwable e)
	  {
	    super("Code: " + errorCode, e);
	    this.errorCode = errorCode;
	  }

	  public CaiException(long errorCode, String info)
	  {
	    super("Code: " + errorCode + "\t" + info);
	    this.errorCode = errorCode;
	  }

	  public Object getAccessoryResult()
	  {
	    return this.accessoryResult;
	  }

	  public void setAccessoryResult(Object result)
	  {
	    this.accessoryResult = result;
	  }

	  public long getErrorCode()
	  {
	    return this.errorCode;
	  }

	  public String[] getParameters()
	  {
	    return this.parameters;
	  }
}
