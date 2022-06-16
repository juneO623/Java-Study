package kr.hs.dgsw.java.dept23.d0616;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CollectionStudy {

	public void studyMap() {
		Map<String, Integer> map = new HashMap<String, Integer>();	// key, value
		
		map.put("임진왜란", 1592);
		map.put("조선건국", 1392);
		map.put("신대륙발견", 1492);
		map.put("프랑스대혁명", 1789);
		map.put("서로마멸망", 476);
		
		Integer year = map.get("임진왜란");
		System.out.println(year);
		
		year = map.get("공자탄생");
		System.out.println(year);
		
//		String history = map.get(476);	// HashMap에서 key값이 아닌 value값으로는 검색 불거능
//		System.out.println(history);
		
		
		Set<String> keys = map.keySet();
		Collection<Integer> values = map.values();
	}
	
	public void studyQueue() {
		Queue<String> queue = new LinkedList<String>();
		List<String> list = new LinkedList<String>();
		
//		Queue<String> queue2 = new ArrayList<String>();
		
		queue.add("Korea");
		queue.add("Japan");
		queue.add("China");
		queue.add("USA");
		
		while (queue.size() > 0) {
			System.out.println(queue.poll());
		}
	}
	
	public void studySet() {
		Set<String> set = new HashSet<String>();
		
		set.add("Korea");
		set.add("Japan");
		set.add("China");
		set.add("USA");
		set.add("Korea");
		set.add("USA");
		set.add("Japan");
		
		for (String str : set) {
			System.out.println(str);
		}
		
	}
	
	public static void main(String[] args) {
		new CollectionStudy().studySet();
	}
	
}
