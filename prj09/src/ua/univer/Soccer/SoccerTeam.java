package ua.univer.Soccer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SoccerTeam {
	private LinkedHashMap<Integer, String> map;

	public SoccerTeam() {
		map = new LinkedHashMap();
	}
	
	public String get(Integer k) {
		return map.get(k);
	}
	
	public void put(Integer k, String v) {
		map.put(k, v);
	}
	
	public void print() {
		for (Integer k : map.keySet()) {
			System.out.print(k + " : ");
			System.out.println(map.get(k));
		}
	}
	
}
