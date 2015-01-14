package leetcode;

/**
 * Definition for singly-linked list.
 */
class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}	
}

/**
 * 反转链表
 * @author luyna
 * 2015年1月14日
 */
public class LinkedListOperation {
	/**
	 * 剑指offer：将链表中所有元素反转
	 * 测试用例：
	 * []
	 * [1]
	 * [1,2]
	 * [1,2,3]
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head){
		if(head==null || head.next==null) return head;
		
		ListNode node=head;
		ListNode prevNode=null;
		ListNode nextNode=null;
		while(node!=null){
			nextNode=node.next;
			node.next=prevNode;
			prevNode=node;
			node=nextNode;		
		}
		return prevNode;
		
	}
	/**
	 * Leetcode NO.92  反转链表中部分元素
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * Given m, n satisfy the following condition:
	 * 1 ≤ m ≤ n ≤ length of list.
	 * 
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null || m>=n) return head;
/*		ListNode node=head;
		ListNode prevNode=null;
		ListNode nextNode=null;
		
		for(int i=1;i<m;i++){
			prevNode=node;
			node=node.next;
		}
		nextNode=node.next;*/
	
		return head;
	}
	/**
	 * Leetcode NO.21  将两个已排序的链表合并成一个链表
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if(l1==null) return l2;
		if(l2==null) return l1;
		ListNode head=null;
        if(l1.val<=l2.val) {
        	head=l1;
        	l1=l1.next;
        }else{
        	head=l2;
        	l2=l2.next;
        }
        ListNode p=head;
        while(l1!=null && l2!=null){
        	if(l1.val<=l2.val){
        		p.next=l1;
        		l1=l1.next;
        	}else{
        		p.next=l2;
        		l2=l2.next;
        	}
        	p=p.next;
        }
        if(l1!=null) p.next=l1;
        if(l2!=null) p.next=l2;
        return head;
    }
	
	public static void main(String[] args){
	
	
	}
}
