package com.gaoxin.abl.oas.getway.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
* 用于生成properties文件,对properties文件进行修改等
*/
public class PropertiesUtil {
	/**
	 * 获取项目目录
	 *
	 * @description {TODO}
	 * @return
	 */
	public static String getPath(){
		String str = "/updateRecord.properties";
		try {
			File directory = new File(PropertiesUtil.class.getClassLoader().getResource("/").getPath()+str);//
			return directory+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 增加属性文件值
	 * 
	 * @param key
	 * @param value
	 */
	public static void addProperties(String key[], String value[], String file) {
		Properties iniFile = getProperties(file);
		FileOutputStream oFile = null;
		try {
			iniFile.put(key, value);
			oFile = new FileOutputStream(file, true);
			iniFile.store(oFile, "modify properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oFile != null) {
					oFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 读取配置文件
	 * 
	 * @return
	 */
	public static Properties getProperties(String file) {
		Properties pro = null;
		FileInputStream in = null;
		File file2 = null;
		try {
			file2 = new File(file);
			if(!file2.exists()){
				file2.createNewFile();
			}
			in = new FileInputStream(file);
			pro = new Properties();
			pro.load(in);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pro;
	}

	/**
	 * 保存属性到文件中
	 * 
	 * @param pro
	 * @param file
	 */
	public static void saveProperties(Properties pro, String file) {
		if (pro == null) {
			return;
		}
		FileOutputStream oFile = null;
		try {
			oFile = new FileOutputStream(file, false);
			pro.store(oFile, "modify properties file");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oFile != null) {
					oFile.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 修改属性文件
	 * 
	 * @param key
	 * @param value
	 */
	public static void updateProperties(String key, String value, String file) {
		// key为空则返回
		if (key == null || "".equalsIgnoreCase(key)) {
			return;
		}
		Properties pro = getProperties(file);
		if (pro == null) {
			pro = new Properties();
		}
		pro.put(key, value);

		// 保存属性到文件中
		saveProperties(pro, file);
	}
}
