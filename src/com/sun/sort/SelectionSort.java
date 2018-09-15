package com.sun.sort;

/***
 * 实现选择排序
 * @author swh
 *
 */
public class SelectionSort {

	public static void sort(int [] array) {
		
		for(int i =0;i<array.length-1;i++) {
			for(int j=i+1;j<array.length;j++) {
				int temp = array[i];
				if(array[i]>array[j]) {
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
	}

	public static void main(String args[]) {
		int [] array = {1,9,15,3,10,54,36,18,2};
		sort(array);
		for(int a:array) {
			System.out.println(a);
		}
	}
}
