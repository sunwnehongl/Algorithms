package com.sun.sort;

/***
 * ���������ʵ��
 * @author swh
 *
 */
public class InsertSort {

public static void sort(int [] array) {
		
	for(int i =1;i<array.length;i++) {
		    // �ѵ�i�����ҵ�j-1��0��λ��
			for(int j=i;j>0&&array[j]<array[j-1];j--) {
				int temp = array[j-1];
				array[j-1] = array[j];
				array[j] = temp;
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
