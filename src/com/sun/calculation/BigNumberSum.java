package com.sun.calculation;

import java.util.Stack;
/***
 * 求两个超大数的合
 * @author swh
 *
 */
public class BigNumberSum {

	public static String sum(String a,String b) {
		Stack<Integer> aStack = getIntStack(a);
		Stack<Integer> bStack = getIntStack(b);
		Stack<String> sumStack = new Stack<>();
		int length = aStack.size()>bStack.size()?bStack.size():bStack.size();
		int num =0;
		for(int i =0;i<length;i++) {
			int x = aStack.pop();
			int y = bStack.pop();
			sumStack.push((x+y+num)%10+"");
			num = (x+y+num)/10;
		}
		aStack = aStack.size()==0?bStack:aStack;
		length =aStack.size();
		for(int i =0;i<length;i++) {
			int x = aStack.pop();
			sumStack.push((x+num)%10+"");
			num = (x+num)/10;
		}
		StringBuilder sumB = new StringBuilder();
		length =sumStack.size();
		for(int i =0;i<length;i++) {
			sumB.append(sumStack.pop());
		}
		return sumB.toString();
	}
	
	public static Stack<Integer> getIntStack(String s){
		Stack<Integer> sStack = new Stack<>();
		for(int i =0;i<s.length();i++) {
			sStack.push(Integer.valueOf(s.substring(i, i+1)));
		}
		return sStack;
	}
	
	public static void main(String args[]) {
		String a = "11211111114111111119";
		   String b = "11111119111111111";
		String sum = sum(a,b);
		System.out.println(sum);
	}
}
