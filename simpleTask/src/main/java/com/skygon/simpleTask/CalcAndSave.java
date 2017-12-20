package com.skygon.simpleTask;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class CalcAndSave {
	
	public static void main(String[] args) throws IOException, URISyntaxException{
		System.out.println("===========");
		String s = "save me into file";
		
		Configuration conf = new Configuration();
		System.out.println("Connecting to -- "+conf.get("fs.defaultFS"));
		
		FileSystem hdfs = FileSystem.get( new URI( "hdfs://10.197.121.198:9000" ), conf );
		System.out.println(hdfs.getHomeDirectory());
		
		Path file = new Path("hdfs://10.197.121.198:9000/user/yuncui/test.csv");
		OutputStream os = hdfs.create(file);
		BufferedWriter br = new BufferedWriter( new OutputStreamWriter( os, "UTF-8" ) );
		
		br.write("this is test csv file");
		br.write("this is line 2");
		br.close();
		hdfs.close();

	}	
}
