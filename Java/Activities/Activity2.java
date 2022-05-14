package activities;

public class Activity2 {
    public static void main(String[] args) {
        int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Result: "+result(numArr, 10, 30));
    }
    
    public static boolean result(int[] numArr, int searchValue, int ExpectedSum) {
    	 int ActualSum = 0;
         boolean result = false;
         for(int i = 0; i < numArr.length; i++) {
         	if(numArr[i] == searchValue)
         		ActualSum = ActualSum + numArr[i];
         		
         }
         if(ActualSum == ExpectedSum)
        	 result = true;
         return result;
    }

}