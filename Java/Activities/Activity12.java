package activities;

interface Addable{
	public int add(int num1, int num2);
}
public class Activity12 {
	public static void main(String[] args) {
		Addable ad1 = (a,b) -> (a+b);
		Addable ad2 = (int a,int b) -> {
			return (a+b);
		};
		System.out.println(ad2.add(20, 30));
	}
}
