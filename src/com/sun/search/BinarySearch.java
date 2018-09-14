package com.sun.search;

/***
 * ���ַ������㷨��ʵ����
 * @author swh
 *
 */
public class BinarySearch {

	/***
	 * ����һ�����������һ��һ����Ҫ��ѯ������
	 * ���������������д����򷵻ض�Ӧ�����������򷵻�-1.
	 * @param key ��Ҫ���ҵ�����
	 * @param array ��������
	 * @return ���������������е�λ������	
	 */
	public static int rank(int key,int[] array) {
		int start = 0;
		int end = array.length-1;
		while(start<end) {
			int mid = start + (end -start)/2;
			if (key<array[mid]) {
				end = mid-1;
			}else if (key>array[mid]) {
				start = mid+1;
			}else {
				return mid;
			}
		}
		return -1;
	}
	
	public static void main(String args[]) {
		int [] array = {1,4,5,8,10,14,16,18,19};
		int index = rank(20,array);
		System.out.println(index);
	}
}
