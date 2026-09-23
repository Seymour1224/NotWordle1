package notWordle;

import java.util.Random;

public class NotWordle {

	
	public NotWordle() {
		
	}
	
	public int[] randomize() {
		int[] sort = {1,2,3,4,5};
		int temp;
		int index;
		Random rand = new Random();
		int index1;
		int index2;
		
		
		for(index = 0; index < rand.nextInt(10)+20; index++) {
			index1 = rand.nextInt(5);
			index2 = rand.nextInt(5);
			
			temp = sort[index1];
			sort[index1] = sort[index2];
			sort[index2] = temp;
			
		}
		return sort;
	}
	
	public void show(int[] theArray) {
		int index;
		
		for(index = 0; index < theArray.length; index++) {
			System.out.printf("[%d]  ", theArray[index]);
		}
	}
}
