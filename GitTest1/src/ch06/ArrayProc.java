package ch06;

import java.util.*;
public class ArrayProc {

	
	public void getValues(int[] array) {
		Scanner input = new Scanner(System.in);
		
		for (int i = 0 ; i <array.length; i ++) {
			System.out.println("¼º¢H");
			array[i] = input.nextInt();
		}
	}
	public double getAverage(int[] array) {
		double total = 0;
		for (int i = 0 ; i <array.length; i ++) 
			total += array[i];
		return total;
	}
	public static void main(String[] args) {
		int [] scores = new int [5];
		
		ArrayProc ap = new ArrayProc();
		ap.getValues(scores);
		System.out.println("vudrbs :  " + ap.getAverage(scores));
	}
}
