package activities;

import java.util.HashMap;
import java.util.Map;

public class Activity11 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Red");
		map.put(2, "Blue");
		map.put(3, "Violet");
		map.put(4, "Green");
		map.put(5, "Pink");
		
		System.out.println("Map: "+map);
		
		map.remove(5);
		
		if(map.containsValue("Green"))
			System.out.println("Green Exist");
		else
			System.out.println("Green does not exist");
		
		System.out.println("Size of the map: "+map.size());
	}	
}
