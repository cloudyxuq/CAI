/**    
* @Title: ZipRollingFileAppender.java  
* @Package com.tinker.log  
* @Description: 日志文件打包  
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月20日 下午12:43:26  
* @version V1.0    
*/
package com.tinker.log;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.helpers.CountingQuietWriter;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;


/**  
* @ClassName: ZipRollingFileAppender  
* @Description: 日志文件打包 
* @author tinker 
* @date 2016年1月20日 下午12:43:26  
*    
*/
public class ZipRollingFileAppender extends RollingFileAppender {
	private long nextRollover = 0L;

	  public ZipRollingFileAppender()
	  {
	    LogUtil.cacheAppender(this);
	  }

	  public ZipRollingFileAppender(String filename) throws IOException
	  {
	    setFile(LogUtil.getLogFile(filename), LogUtil.isAppend(), this.bufferedIO, this.bufferSize);

	    super.setLayout(LogUtil.getDefaultLayout());
	    super.setMaximumFileSize(LogUtil.getDefaultFileSize());
	    super.setMaxBackupIndex(LogUtil.getDefaultFileNum());
	  }

	  public void rollOver()
	  {
	    if (null != this.qw)
	    {
	      long size = ((CountingQuietWriter)this.qw).getCount();
	      LogLog.debug("rolling over count=" + size);
	      this.nextRollover = (size + this.maxFileSize);
	    }

	    boolean renameSucceeded = true;
	    String zipFilePath = "";
	    if (this.maxBackupIndex > 0)
	    {
	      File file = new File(this.fileName + '.' + this.maxBackupIndex + ".zip");
	      if (file.exists())
	      {
	        renameSucceeded = file.delete();
	      }
	      for (int i = this.maxBackupIndex - 1; (i >= 1) && (renameSucceeded); i--)
	      {
	        file = new File(this.fileName + "." + i + ".zip");
	        if (file.exists())
	        {
	          File target = new File(this.fileName + '.' + (i + 1) + ".zip");

	          LogLog.debug("Renaming file " + file + " to " + target);
	          renameSucceeded = file.renameTo(target);
	        }
	      }

	      if (renameSucceeded)
	      {
	        File target = new File(this.fileName + "." + 1);
	        if (target.exists())
	        {
	          deleteFileAndDirectory(target);
	        }
	        target = new File(this.fileName + "." + 1);
	        zipFilePath = target.getAbsolutePath();
	        closeFile();
	        file = new File(this.fileName);
	        LogLog.debug("Renaming file " + file + " to " + target);
	        renameSucceeded = file.renameTo(target);
	        if (!renameSucceeded)
	        {
	          setFileWithoutException(this.fileName, true, this.bufferedIO, this.bufferSize);
	        }

	      }

	    }

	    if (renameSucceeded)
	    {
	      setFileWithoutException(this.fileName, false, this.bufferedIO, this.bufferSize);

	      this.nextRollover = 0L;

	      ZipThread thread = new ZipThread();
	      thread.setTarget(zipFilePath);
	      thread.start();
	    }
	  }

	  private void deleteFileAndDirectory(File target)
	  {
	    if (target.isFile())
	    {
	      Boolean result = Boolean.valueOf(target.delete());
	      if (!result.booleanValue())
	      {
	        LogLog.debug("delete file error");
	      }
	    }

	    if (target.isDirectory())
	    {
	      File[] fileList = target.listFiles();
	      for (int i = 0; i < fileList.length; i++)
	      {
	        deleteFileAndDirectory(fileList[i]);
	      }
	    }

	    Boolean result = Boolean.valueOf(target.delete());

	    if (!result.booleanValue())
	    {
	      LogLog.debug("delete file error");
	    }
	  }

	  private void setFileWithoutException(String filename, boolean isAppend, boolean bufferedio, int buffersize)
	  {
	    try
	    {
	      setFile(filename, isAppend, bufferedio, buffersize);
	    }
	    catch (IOException e)
	    {
	      LogLog.error("setFile(" + this.fileName + ", false) call failed.", e);
	    }
	  }

	  public synchronized void setFile(String fileName, boolean append, boolean bufferedIO, int bufferSize)
	    throws IOException
	  {
	    super.setFile(fileName, append, this.bufferedIO, this.bufferSize);
	    if (append)
	    {
	      File f = new File(fileName);
	      ((CountingQuietWriter)this.qw).setCount(f.length());
	    }
	  }

	  protected void setQWForFiles(Writer writer)
	  {
	    this.qw = new CountingQuietWriter(writer, this.errorHandler);
	  }

	  protected void subAppend(LoggingEvent event)
	  {
	    super.subAppend(event);
	    if ((null != this.fileName) && (null != this.qw))
	    {
	      long size = ((CountingQuietWriter)this.qw).getCount();
	      if ((size >= this.maxFileSize) && (size >= this.nextRollover))
	      {
	        rollOver();
	      }
	    }
	  }
}
