package activities;

import java.util.ArrayList;
import java.util.List;

public class Activity9 {
	public static void main(String[] args) {
		List<String> myList = new ArrayList<String>();
		myList.add("Tanjiro");
		myList.add("Kira");
		myList.add("Jojo");
		myList.add("Luffy");
		myList.add("Itachi");
		
		System.out.println("Print names:");
		for(int i = 0; i < myList.size(); i++) {
			System.out.println(myList.get(i));
		}
		
		System.out.println("Print 3rd name: "+myList.get(2));
		
		isNameExist("Luffy", myList);
		
		System.out.println("Number of Names: "+myList.size());
		
		myList.remove(3);
		
		System.out.println("Number of Names after removing: "+myList.size());
	}
	
	public static void isNameExist(String name, List myList) {
		if(myList.contains(name))
			System.out.println("Name Exist");
		else
			System.out.println("Name does not exist");
	}
}
