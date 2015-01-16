package leetcode;

import java.util.*;

/**
 * Definition for singly-linked list with a random pointer.
 */
class RandomListNode {
	int label;
	RandomListNode next, random; //randomָ������ڵ�

	RandomListNode(int x) {
		this.label = x;
	}
};

public class RandomList {
	/**
	 * Leetcode NO.138 Copy List with Random Pointer
	 * ��ָoffer P147 ������26 ����ȸ��Ƹ�������
	 * ˼·һ����ϣ��ʵ�֣��ռ�O(n) ʱ��O(n)
	 * ˼·�����ռ�O(1) ʱ��O(n)
	  * Step 1: duplicate each nodes, 1->2->3 becomes 1->`1->2->`2->3->`3;
	  * Step 2: copy node's random according the previous node;
	  * Step 3: split the list into two
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		//hashMap��ţ��Ͻڵ㣬�½ڵ㣩��ӳ��
		HashMap<RandomListNode,RandomListNode> map=new HashMap<RandomListNode,RandomListNode>();
		RandomListNode tmp=head;
		//��һ�˽����������нڵ㸴�ƣ��������hash����
		while(tmp!=null){
			//��������ֵ��ͬ�����ǲ���ͬһ������
			RandomListNode newNode=new RandomListNode(tmp.label);//��ȸ��ƣ�����ֱ����=
			map.put(tmp, newNode);
			tmp=tmp.next;
		}
		//�ڶ��˸��������е�next��randomָ��
		tmp=head;
		while(tmp!=null){
			map.get(tmp).next=map.get(tmp.next);
			map.get(tmp).random=map.get(tmp.random);
			tmp=tmp.next;
		}		
        return map.get(head);
    }
	
	public static void main(String [] args){
		//����map�б���Ķ��������������ֵ��ͬ��������ָ��ͬһ��ָ�룬����map���������ǲ�ͬ��
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
