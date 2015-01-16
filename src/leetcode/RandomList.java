package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	int label;
	RandomListNode next, random; //random指向任意节点

	RandomListNode(int x) {
		this.label = x;
	}
};

public class RandomList {
	/**
	 * Leetcode NO.138 Copy List with Random Pointer
	 * 剑指offer P147 面试题26 ：深度复制复杂链表
	 * 思路一：哈希表实现，空间O(n) 时间O(n)
	 * 思路二：空间O(1) 时间O(n)
	  * Step 1: duplicate each nodes, 1->2->3 becomes 1->`1->2->`2->3->`3;
	  * Step 2: copy node's random according the previous node;
	  * Step 3: split the list into two
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		//hashMap存放（老节点，新节点）的映射
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
		RandomListNode tmp=head;
		//第一趟将链表中所有节点复制，并存放在hash表中
		while(tmp!=null){
			//两个对象值相同，但是不是同一个对象
			RandomListNode newNode=new RandomListNode(tmp.label);//深度复制，不能直接用=
			map.put(tmp, newNode);
			tmp=tmp.next;
		}
		//第二趟复制链表中的next和random指针
		tmp=head;
		while(tmp!=null){
			map.get(tmp).next=map.get(tmp.next);
			map.get(tmp).random=map.get(tmp.random);
			tmp=tmp.next;
		}		
        return map.get(head);
    }
	
	public static void main(String [] args){
		//测试map中保存的对象：如果两个对象值相同，但不是指向同一个指针，则在map中两对象是不同的
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
		RandomListNode node=new RandomListNode(2);
		RandomListNode node1=new RandomListNode(node.label);
		RandomListNode node2=node;
		map.put(node,node1);
		System.out.println(map.containsKey(node));
		System.out.println(map.containsKey(node1));
		System.out.println(map.containsKey(node2));
		
		
	}
}
