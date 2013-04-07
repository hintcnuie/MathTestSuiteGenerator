package com.blueray.test.math.suite.service;

import java.io.File;
import java.io.IOException;

public class FileService {

	public static void cleanFolder(File folder) {
		File[] filesUnderFolder=folder.listFiles();
		for(File file: filesUnderFolder){
			file.delete();
		}
	}

	public static File createNewFile(String fileName) {
		File file=new File(fileName);
		if(!file.exists()){
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

}
