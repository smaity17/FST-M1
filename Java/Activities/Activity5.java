package activities;

abstract class Book{
	String title;
	abstract void setTitle(String s);
	String getTitle() {
		return title;
	}
}

class MyBook extends Book{
	@Override
	void setTitle(String s) {
		title = s;		
	}
}

class Activity5{
	public static void main(String args[]) {
		MyBook newNovel = new MyBook();
		newNovel.setTitle("The Perfect Murder");
		System.out.println("Name of Novel: "+newNovel.getTitle());
	}
}