package com.sun.calculation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/***
 * 中缀表达式计算例如1+((2+3)*4)-5
 * 实现思路就是先把中缀表达式转换为逆波兰表达式
 * 然后再对逆波兰表达式表达式进行计算
 * @author swh
 *
 */
public class ExpressionComputation {

	/***
	 * 先把中缀表达式转换为后缀表达式
	 * 再对后缀表达式进行计算
	 * @param expression 中缀表达式
	 * @return
	 */
	public static int computation(String expression) {
		
		return getRpnValue(getRpn(expression));
	}

	/***
	 * 中缀表达式转换为后缀表达式
	 * @param expression
	 * @return
	 */
	private static Queue<Object> getRpn(String expression) {
		Queue<Object> valueQueue = new LinkedList<>();
		Stack<String> optStack = new Stack<>();
		String munStr = ""; 
	    for(int i=0;i<expression.length();i++) {
	    	char ch = expression.charAt(i);
	    	String str = String.valueOf(ch);
	    	if(ch>='0'&&ch<='9') {
	    		munStr +=str;
	    	}else {
	    		if(!munStr.equals("")) {
	    			valueQueue.add(Integer.valueOf(munStr));
	    			munStr="";
	    		}
	    		if (ch=='(') {
	    			optStack.push(str);
	    		}else if (ch==')')  {
	    			  while (optStack.size()!=0&&!optStack.peek().equals("(")) {
	    				  valueQueue.add(optStack.pop());
	                  }
	    			  optStack.pop();
	    		}else {
	    			 while (optStack.size() != 0&&getOptionLevel(optStack.peek())>=getOptionLevel(str)) {
	    				 valueQueue.add(optStack.pop());
	                  }
	    			 optStack.push(str);
	    		}
	    	}
	    }
	    valueQueue.add(Integer.valueOf(munStr));
	    while (optStack.size()!=0) {
			 valueQueue.add(optStack.pop());
         }
	    return valueQueue;
	}
	
	/***
	 * 对后缀表达式进行计算
	 * @param valueQueue
	 * @return
	 */
	public static int getRpnValue(Queue<Object> valueQueue) {
		Stack<Integer> numStack = new Stack<>();
		while(!valueQueue.isEmpty()) {
			if(valueQueue.peek() instanceof Integer) {
				numStack.push((Integer)valueQueue.poll());
			}else {
				String operation = (String)valueQueue.poll();
				numStack.push(getOptionValue(operation, numStack.pop(), numStack.pop()));
			}
		}
		return numStack.pop();
	}
	/***
	 * 得到运算符的优先级
	 * @param opt
	 */
	public static int getOptionLevel(String operation) {
		 int result = 0;
	        switch (operation){
	            case "+":
	                result=1;
	                break;
	            case "-":
	                result=1;
	                break;
	            case "*":
	                result=2;
	                break;
	            case "/":
	                result=2;
	                break;
	        }
	        return result;
	}
	
	public static int getOptionValue(String operation,int b,int a) {
		 int result = 0;
	        switch (operation){
	            case "+":
	                result=a+b;
	                break;
	            case "-":
	                result=a-b;
	                break;
	            case "*":
	                result=a*b;
	                break;
	            case "/":
	                result=a/b;
	                break;
	        }
	        return result;
	}
	public static void main(String args[]) {
		computation("1+((2+3)*4)-5");
	}
}
