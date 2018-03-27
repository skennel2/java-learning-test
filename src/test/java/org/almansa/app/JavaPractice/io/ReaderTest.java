package org.almansa.app.JavaPractice.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class ReaderTest {

	@Test
	public void inputStreamReaderTest() throws IOException {
		// InputStreamReader는 스트림을 던져주면, 대상을 바이트단위로 읽어온다. 
		// Reader - InputStreamReader
		InputStreamReader isr = new InputStreamReader(new FileInputStream(new File("D:\\Temp\\test.txt")));
		int b = 0;
		
		while(b > -1) {
			b = isr.read();
			System.out.println(b);
		}
		
		isr.close();
	}
	
	@Test
	public void fileReaderTest() throws Exception {
		// Reader - InputStreamReader - FileReader
		// InputStreamReader에서 파일에 특화된 고수준 API이다. 
		FileReader reader = new FileReader(new File("D:\\Temp\\test.txt"));
		int b = 0;
		
		while(b > -1) {
			b = reader.read();
			System.out.println(b);
		}
		
		reader.close();
	}
	
	@Test
	public void bufferdReadertest() throws IOException {
		
		// Reader - BufferedReader
		// Reader - InputStreamReader, FileReader
		BufferedReader br = new BufferedReader(new FileReader(new File("D:\\Temp\\test.txt")));
		
		String s = "";
	    while ((s = br.readLine()) != null) {
	    	System.out.println(s);
	    }	   
	}
}
