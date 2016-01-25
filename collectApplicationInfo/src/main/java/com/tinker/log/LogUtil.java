/**    
* @Title: LogUtil.java  
* @Package com.tinker.log  
* @Description: 日志工具类
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月20日 下午12:39:23  
* @version V1.0    
*/
package com.tinker.log;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Layout;
import org.apache.log4j.PatternLayout;

/**
 * @ClassName: LogUtil
 * @Description: 日志工具类
 * @author tinker
 * @date 2016年1月20日 下午12:39:23
 * 
 */
public class LogUtil {
	private static List<ZipRollingFileAppender> appenderList = new ArrayList();
	/**
	 * 默认大小：10M
	 */
	private static final long DEFAULT_FILE_SIZE = 10485760L;
	/**
	 * 默认数量：10
	 */
	private static final int DEFAULT_FILE_NUM = 10;

	public static void cacheAppender(ZipRollingFileAppender appender) {
		if (null != appender) {
			appenderList.add(appender);
		}
	}

	public static ZipRollingFileAppender getDefaultAppender() {
		for (ZipRollingFileAppender appender : appenderList) {
			if (null != appender.getFile()) {
				if ("LEGO_LOG".equals(appender.getName())) {
					return appender;
				}
			}
		}
		if (appenderList.isEmpty()) {
			return null;
		}

		return (ZipRollingFileAppender) appenderList.get(appenderList.size() - 1);
	}

	public static Layout getDefaultLayout() {
		ZipRollingFileAppender appender = getDefaultAppender();
		if (null != appender) {
			return appender.getLayout();
		}

		return new PatternLayout("%m%n");
	}

	public static String getDefaultFile() {
		ZipRollingFileAppender appender = getDefaultAppender();
		if (null != appender) {
			return appender.getFile();
		}

		return "logs/lego.log";
	}

	public static long getDefaultFileSize() {
		ZipRollingFileAppender appender = getDefaultAppender();
		if (null != appender) {
			return appender.getMaximumFileSize();
		}

		return DEFAULT_FILE_SIZE;
	}

	public static int getDefaultFileNum() {
		ZipRollingFileAppender appender = getDefaultAppender();
		if (null != appender) {
			return appender.getMaxBackupIndex();
		}

		return DEFAULT_FILE_NUM;
	}

	public static String getLogFile(String fileName) {
		String filePath = getDefaultFile();
		return filePath.substring(0, filePath.lastIndexOf("/") + 1) + fileName;
	}

	public static boolean isAppend() {
		ZipRollingFileAppender appender = getDefaultAppender();
		if (null != appender) {
			return appender.getAppend();
		}

		return true;
	}
}
