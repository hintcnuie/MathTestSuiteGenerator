package com.blueray.test.math.suite.utils;

import java.io.IOException;
import java.util.Properties;

public class FileEncodingUtil {
	public static void setUtf8Setting(){
		String cmdLine="cmd /c set JAVA_TOOL_OPTIONS=-Dfile.encoding=utf-8 ";
		Properties prop=new Properties();
		String OS = System.getProperty("os.name").toLowerCase();
		Process p=null;
		System.out.println(OS);
		if(OS.indexOf("windows")>-1)
		{
		try {
			p=Runtime.getRuntime().exec(cmdLine);
			
		} catch (IOException e) {
			e.printStackTrace();
		} //其它的操作系统可以自行处理， 我这里是win2k
		} 
		//prop.setProperty("JAVA_TOOL_OPTIONS","file.encoding=utf-8");
	}
	
	public static void main(String[] args) {
		FileEncodingUtil.setUtf8Setting();
	}
}
