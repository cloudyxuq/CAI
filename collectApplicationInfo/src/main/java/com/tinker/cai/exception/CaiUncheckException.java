/**    
* @Title: CaiUncheckException.java  
* @Package com.tinker.cai.exception  
* @Description: TODO(用一句话描述该文件做什么)  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月21日 下午3:56:16  
* @version V1.0    
*/
package com.tinker.cai.exception;

/**  
* @ClassName: CaiUncheckException  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author tinker 
* @date 2016年1月21日 下午3:56:16  
*    
*/
public class CaiUncheckException extends RuntimeException
{
	  private static final long serialVersionUID = 5625178995893882625L;
	  private long errorCode;

	  public CaiUncheckException(String message, Throwable cause)
	  {
	    super(message, cause);
	  }

	  public CaiUncheckException(String message)
	  {
	    super(message);
	  }

	  public CaiUncheckException(long errorCode)
	  {
	    this.errorCode = errorCode;
	  }

	  public CaiUncheckException(Throwable cause)
	  {
	    super(cause);
	  }

	  public long getErrorCode()
	  {
	    return this.errorCode;
	  }
	}
