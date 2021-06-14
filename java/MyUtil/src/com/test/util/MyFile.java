package com.test.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MyFile {

	public boolean copy(String orgPath, String copyPath) {
		
	
		File org = new File(orgPath);
		File copy = new File(copyPath);

		
		try {
			
			FileInputStream fis = new FileInputStream(org);  //원본 파일
			FileOutputStream fos = new FileOutputStream(copy); //복사 파일
			
			// 버퍼(512KB ~1KB 내외)
			byte[] buffer = new byte[512];
			
			int length = 0;
			
			//복사
			while((length = fis.read(buffer)) > 0) {
				//System.out.println(length);
				fos.write(buffer, 0, length);
			}
			return true;
			
		}catch(Exception e) {
			return false;
		}
		
	}//copy
	
}//MyFile
