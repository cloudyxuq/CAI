/**    
* @Title: ZipThread.java  
* @Package com.tinker.log  
* @Description: 日志打包线程
* @author tinker  cloudyxuq@gmail.com   
* @date 2016年1月20日 下午12:49:33  
* @version V1.0    
*/
package com.tinker.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.log4j.helpers.LogLog;

/**
 * @ClassName: ZipThread
 * @Description: 日志打包线程
 * @author tinker
 * @date 2016年1月20日 下午12:49:33
 * 
 */
public class ZipThread extends Thread{
	private static final int BUFFEREDSIZE = 1024;
	private String target;
	private SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");

	public void run() {
		File file = new File(this.target);
		String zipName = this.target + ".zip";

		File zipFile = new File(zipName);
		createFile(zipFile);

		FileOutputStream fout = null;
		ZipOutputStream zos = null;
		FileInputStream in = null;
		try {
			fout = new FileOutputStream(zipFile);
			zos = new ZipOutputStream(fout);
			String zipEntryName = file.getName().substring(0, file.getName().indexOf(".log.")) + "_"
					+ this.df.format(new Date()) + ".log";

			zos.putNextEntry(new ZipEntry(zipEntryName));

			if (!file.exists()) {
				return;
			}

			in = new FileInputStream(file);

			byte[] by = new byte[1024];
			int c;
			while ((c = in.read(by)) != -1) {
				zos.write(by, 0, c);
			}
			zos.flush();
		} catch (FileNotFoundException e) {
			LogLog.error("new FileOutputStream (" + zipName + ") call failed.", e);
		} catch (IOException e) {
			LogLog.error("putNextEntry(new ZipEntry(" + this.target + ")) call failed.", e);
		} finally {
			closeZipOutputStream(zos);
			closeFileOutputStream(fout);
			closeFileInputStream(in);

			if (!file.delete()) {
				LogLog.error("file.delete() call failed, file: " + file.getAbsolutePath());
			}
		}
	}

	private void closeZipOutputStream(ZipOutputStream zos) {
		try {
			if (null != zos) {
				zos.close();
			}
		} catch (IOException e) {
			LogLog.error("zos.close() call failed.", e);
		}
	}

	private void closeFileOutputStream(FileOutputStream fout) {
		try {
			if (null != fout) {
				fout.close();
			}
		} catch (IOException e) {
			LogLog.error("fout.close() call failed.", e);
		}
	}

	private void closeFileInputStream(FileInputStream in) {
		try {
			if (null != in) {
				in.close();
			}
		} catch (IOException e) {
			LogLog.error("in.close() call failed.", e);
		}
	}

	private void createFile(File zipFile) {
		if (!zipFile.exists()) {
			try {
				if (zipFile.createNewFile()) {
					LogLog.debug("createNewFile success, zipFile: " + zipFile.getAbsolutePath());
				}

			} catch (IOException e) {
				LogLog.error("createNewFile call failed.", e);
			}
		}
	}

	public void setTarget(String target) {
		this.target = target;
	}
}
