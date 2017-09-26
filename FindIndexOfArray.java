package testing;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class FindIndexOfArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Integer i[] = {5,9,2,0,6};
		int finalvalue =0;
		System.out.println("Index of 6 from given numbers === "+Arrays.asList(i).indexOf(6));
		 Arrays.sort(i, 1, i.length);
		 
		 System.out.println("After sorting 9 index is === "+Arrays.asList(i).indexOf(9));
		 
		 for(int j:i){
			 
			 finalvalue = finalvalue+j;
			 
		 }
		 
		 System.out.println("Total of given numbers === "+finalvalue);
		 

	}

}
