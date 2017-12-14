package com.skygon.simpleTask;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class CalcAndSave {
	
	public static void main(String[] args){
		System.out.println("===========");
		String s = "save me into file";
		FileOutputStream fo = null;
		File f = new File("E:/sparktask.txt");
		
		try{
		fo = new FileOutputStream(f);
		if (!f.exists()){
			f.createNewFile();
		}
		byte[] br = s.getBytes();
		fo.write(br);
		fo.flush();
		System.out.println("write to file successfully");
		}catch (IOException e){
			e.printStackTrace();
		}
		finally{
			try {
				fo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
}
