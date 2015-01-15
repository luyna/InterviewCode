package leetcode;

import java.util.Stack;

/**
 * 剑指offer P134 面试题22： 给定入栈顺序和出栈数序，判断出栈顺序是否是合理的
 * 测试用例：
 * [][]
 * [1][1]
 * [1][2]
 * [1,2,3,4,5] [4,5,3,2,1]
 * [1,2,3,4,5] [4,5,3,1,2]
 * @author luyna
 * 2015年1月15日
 */
public class StackPushPopOrder {
	public static boolean IsPopOrder(int [] pushOrder,int [] popOrder){
		if(pushOrder.length==0 || popOrder.length==0 || pushOrder.length!=popOrder.length)
			return false;
		Stack<Integer> stack=new Stack<Integer>(); //辅助栈，保存根据入栈和出栈顺序生成的当前状态栈
		int j=0;//pop序列的当前位置
		for(int i=0;i<pushOrder.length;i++){
			stack.push(pushOrder[i]);
			while(!stack.isEmpty() && stack.peek()==popOrder[j]) {//如果栈顶元素是下一个将要弹出的元素，则弹出，否则继续将元素入栈
				stack.pop();
				j++;
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
	
	public static void main(String[] args){
		int [] push={1};
		int [] pop={1};
		int [] push1={1};
		int [] pop1={2};
		int [] push2={1,2,3,4,5};
		int [] pop2={4,5,3,2,1};
		int [] pop21={4,5,3,1,2};
		int [] push3={};
		int [] pop3={};
		System.out.println("test1:"+IsPopOrder(push,pop));
		System.out.println("test2:"+IsPopOrder(push1,pop1));
		System.out.println("test3:"+IsPopOrder(push2,pop2));
		System.out.println("test4:"+IsPopOrder(push2,pop21));
		System.out.println("test5:"+IsPopOrder(push3,pop3));
	}
}
