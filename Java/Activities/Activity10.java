package activities;

import java.util.HashSet;

public class Activity10 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Naruto");
		hs.add("Boruto");
		hs.add("Sanji");
		hs.add("Zoro");
		hs.add("Goku");
		hs.add("Saitama");
		
		System.out.println("Size of hashset: "+hs.size());
		
		hs.remove("Boruto");
		hs.remove("Sakura");
		
		isExist("Goku", hs);
		
		System.out.println("Updated HashSet: "+hs);
	}
	
	public static void isExist(String name, HashSet hs) {
		if(hs.contains(name))
			System.out.println("Name is present in the Set");
		else
			System.out.println("Name is not present in the set");
	}
}
