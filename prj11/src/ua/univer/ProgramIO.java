package ua.univer;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class ProgramIO {
	
	public static void read(InputStream is) throws IOException {
		int c;
		System.out.println("available byte = " + is.available());
		while((c = is.read()) != -1) {
			System.out.println("available byte = " + is.available());
			System.out.println(c);
		}
	}
	
	public static void readBuffer(InputStream is) throws IOException {
		int c;
		System.out.println("available byte = " + is.available());
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader bis = new BufferedReader(isr);
		String str;
		while((str = bis.readLine()) != null) {
			System.out.println("available byte = " + is.available());
			System.out.println(str);
		}
	}
	
	public static void write(OutputStream os, String str) throws IOException {
		OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		osw.write(str);
	}
	
	public static void main(String[] args) throws IOException {
//		InputStream isFake = new ByteArrayInputStream(new byte[] {49, 50, 51});  //коды символов (1, 2, 3)
		
		OutputStream os = new FileOutputStream("source" + File.separator + "data.txt");
		write(os, "Hello");
		os.close();
		
		//byte [] dataFake = new byte[3];
		
		OutputStream osFake = new ByteArrayOutputStream();
		write(osFake, "Hello");
		//osFake.close();
		
//		try (InputStream is = new FileInputStream("source" + File.separator + "data.txt");) {
		try (InputStream isFake = new ByteArrayInputStream(new byte[] {'1', '2', '3'}) {//для тестирования работы метода без подключения реального файла с данными
//			readBuffer(is);
			readBuffer(isFake);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
