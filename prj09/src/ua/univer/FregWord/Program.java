package ua.univer.FregWord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map.Entry;



public class Program {
	
	public static void testStringSpeed() {
		long beginTime = System.nanoTime();
		{
			StringBuilder sb = new StringBuilder(20000);
			for (int i = 0; i < 10300; i++) {
				sb.append(i);
			//	System.out.println(sb.length() + "/" + sb.capacity());
				
			}
			
			long endTime = System.nanoTime();
			System.out.println("StringBuilder time = " + (endTime - beginTime));
			sb.toString();
		}
		
		{
			StringBuffer sb = new StringBuffer(20000);
			for (int i = 0; i < 10300; i++) {
				sb.append(i);
			//	System.out.println(sb.length() + "/" + sb.capacity());
				
			}
			
			long endTime = System.nanoTime();
			System.out.println("StringBuffer time = " + (endTime - beginTime));
			sb.toString();
		}
		
		{
			String s = new String();
			//StringBuffer sb = new StringBuffer();
			for (int i = 0; i < 10300; i++) {
				s += i;
			//	System.out.println(sb.length() + "/" + sb.capacity());
				
			}
			
			long endTime = System.nanoTime();
			System.out.println("String time = " + (endTime - beginTime));
		}
		
		
	}

	public static void main(String[] args) throws Exception {
	//	String str = "mama mila ramu ramu mila mama ramu mama";
	//	FileReader fr = new FileReader("/Users/kuzmavladislavvladimirovic/Desktop/Java/prj09/src/ua/univer/FregWord/in.txt");
		String url = "https://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code";
		URL website = new URL(url);
        URLConnection connection = website.openConnection();
        InputStream fr = connection.getInputStream();
        InputStreamReader rd = new InputStreamReader(fr, "CP1251");
        
		BufferedReader br = new BufferedReader(rd);
		StringBuilder sb = new StringBuilder();
		while (br.ready()) {
			sb.append(br.readLine());
		}
		String str = sb.toString();
		String[] words = str.split("\\s");
		for (String word : words) {
			System.out.println(word);
		}
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer freq = map.get(word);
			if (freq != null) map.put(word, freq + 1);
			else map.put(word, 1);
		}
		for (Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry);
		}
		
	}

}
