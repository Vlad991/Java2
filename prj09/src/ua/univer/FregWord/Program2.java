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

import ua.univer.DAO.LinkDAO;
import ua.univer.DAO.MapDAO;
import ua.univer.DAO.WordDAO;

public class Program2 {
	public static void TestStringSpeed() {
		{
			StringBuilder sb = new StringBuilder(20000);
			long beginTime = System.nanoTime();
			for (int i = 0; i < 10300; i++) {
				sb.append(i);
				// System.out.println(sb.length()+"/"+sb.capacity());
			}
			sb.toString();
			long endTime = System.nanoTime();
			System.out.println("StringBuilder time = " + (endTime - beginTime));
		}
		{
			StringBuffer sb = new StringBuffer(20000);
			long beginTime = System.nanoTime();
			for (int i = 0; i < 10300; i++) {
				sb.append(i);
				// System.out.println(sb.length()+"/"+sb.capacity());
			}
			sb.toString();
			long endTime = System.nanoTime();
			System.out.println("StringBuffer time = " + (endTime - beginTime));
		}
		{
			String s = new String();
			long beginTime = System.nanoTime();
			for (int i = 0; i < 10300; i++) {
				s += i;
				// System.out.println(sb.length()+"/"+sb.capacity());
			}
			long endTime = System.nanoTime();
			System.out.println("String time = " + (endTime - beginTime));
		}
	}

	public static HashMap<String, Integer> FindFreqWordInStr(String str) {
		String[] words = str.split("\\s");
		// for (String word : words) {
		// System.out.println(word);
		// }
		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			Integer freq = map.get(word);
			if (freq != null)
				map.put(word, freq + 1);
			else
				map.put(word, 1);
		}
		// for (Entry<String, Integer> entry : map.entrySet()) {
		// System.out.println(entry);
		// }
		return map;
	}

	public static String stringFromInputStream(InputStream fr) throws Exception {
		InputStreamReader rd = new InputStreamReader(fr, "CP1251");
		BufferedReader br = new BufferedReader(rd);
		StringBuilder sb = new StringBuilder();
		while (br.ready()) {
			sb.append(br.readLine());
		}
		return sb.toString();
	}

	public static HashMap<String, Integer> FindFreqWordInFile(String fileName) throws Exception {
		FileInputStream fr = new FileInputStream(fileName);
		String str = stringFromInputStream(fr);
		return FindFreqWordInStr(str);
	}

	public static HashMap<String, Integer> FindFreqWordInUrl(String url) throws Exception {
		URL website = new URL(url);
		URLConnection connection = website.openConnection();
		InputStream fr = connection.getInputStream();
		String str = stringFromInputStream(fr);
		return FindFreqWordInStr(str);
	}

	public static void main(String[] args) throws Exception {
		// String str = "mama mila ramu ramu mila mama ramu mama";
		String url = "https://stackoverflow.com/questions/4328711/read-url-to-string-in-few-lines-of-java-code";
		FindFreqWordInUrl(url);
		String fileName=File.separator + "Users" + File.separator + "kuzmavladislavvladimirovic" + File.separator + "Desktop" + File.separator + "Java" + File.separator + "prj09" + File.separator + "src" + File.separator + "ua" + File.separator + "univer" + File.separator + "FregWord" + File.separator + "in.txt";
		FindFreqWordInFile(fileName);
		String urlShek; 
		HashMap<String,HashMap<String,Integer>> mapSearch = new HashMap<>();
		LinkDAO links = new LinkDAO();
		WordDAO words = new WordDAO();
		MapDAO maps = new MapDAO();
		for (int i = 1; i < 10; i++) {
			urlShek = "http://www.stihi-rus.ru/World/Shekspir/"+i+".htm";
			HashMap<String, Integer> mapOneUrl =FindFreqWordInUrl(url);
			for (String word : mapOneUrl.keySet()) {
				HashMap<String,Integer> map = mapSearch.get(word);
				if (map == null) mapSearch.put(word, new HashMap<String,Integer>());
				mapSearch.get(word).put(urlShek, mapOneUrl.get(word));
			}
		}
		for (String word : mapSearch.keySet()) {
			System.out.println("***********************");
			System.out.println(word);
			//words.addWord(word);
			HashMap<String, Integer> mapUrlWithFreq = mapSearch.get(word);
			for (String urlKey : mapUrlWithFreq.keySet()){
				System.out.print(urlKey+" : ");
				System.out.println(mapUrlWithFreq.get(urlKey));
			//	links.addLink(urlKey);
			//	maps.addMap(word, urlKey, mapUrlWithFreq.get(urlKey));
			}
		}
	}

}
