package leetcode;

import java.util.Stack;

/**
 * ��ָoffer P134 ������22�� ������ջ˳��ͳ�ջ�����жϳ�ջ˳���Ƿ��Ǻ����
 * ����������
 * [][]
 * [1][1]
 * [1][2]
 * [1,2,3,4,5] [4,5,3,2,1]
 * [1,2,3,4,5] [4,5,3,1,2]
 * @author luyna
 * 2015��1��15��
 */
public class StackPushPopOrder {
	public static boolean IsPopOrder(int [] pushOrder,int [] popOrder){
		if(pushOrder.length==0 || popOrder.length==0 || pushOrder.length!=popOrder.length)
			return false;
		Stack<Integer> stack=new Stack<Integer>(); //����ջ�����������ջ�ͳ�ջ˳�����ɵĵ�ǰ״̬ջ
		int j=0;//pop���еĵ�ǰλ��
		for(int i=0;i<pushOrder.length;i++){
			stack.push(pushOrder[i]);
			while(!stack.isEmpty() && stack.peek()==popOrder[j]) {//���ջ��Ԫ������һ����Ҫ������Ԫ�أ��򵯳������������Ԫ����ջ
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
