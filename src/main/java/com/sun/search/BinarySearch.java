package com.sun.search;

/***
 * 二分法查找算法的实现类
 * @author swh
 *
 */
public class BinarySearch {

	/***
	 * 传人一个有序数组和一个一个需要查询的数，
	 * 如果这个数在数组中存在则返回对应的索引，否则返回-1.
	 * @param key 需要查找的数字
	 * @param array 有序数组
	 * @return 查找数字在数组中的位置索引	
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
