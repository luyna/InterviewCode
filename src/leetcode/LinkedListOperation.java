package leetcode;

import java.util.*;

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
 *1�� ��ָoffer��������������Ԫ�ط�ת
 *2��Leetcode NO.92  ��ת�����в���Ԫ�� ��δ�꣩
 *3��Leetcode NO.21  �����������������ϲ���һ������
 *4��Leetcode NO.2 �����������ĺͣ��������������������ʾ��
 *	�磺Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *5��Leetcode NO.23  �ϲ�K�����������һ����������δ�꣩
 *6��Leetcode NO.25 Reverse Nodes in k-Group
 * @author luyna
 * 2015��1��14��
 */
public class LinkedListOperation {
	/**
	 * ��ָoffer��������������Ԫ�ط�ת
	 * ����������
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
	 * Leetcode NO.92  ��ת�����в���Ԫ�أ�m,n��֮��
	 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
	 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * return 1->4->3->2->5->NULL.
	 * Given m, n satisfy the following condition:
	 * 1 �� m �� n �� length of list.
	 * ˼·���ȷ�תm��n֮��Ľڵ㣬������mǰ��n��Ľڵ�:1->2<-3<-4->5->NULL
	 * Ȼ�������������ǰ�ͺ���Ľڵ㣺1->4->3->2->5->NULL.
	 * @param head
	 * @param m
	 * @param n
	 * @return
	 */
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if(head==null || head.next==null || m>=n) return head;
		ListNode top=head,//��m=1����top����head,���򱣴�mǰ��һ���ڵ�
				node=head;
		ListNode preNode=null;
		ListNode nextNode=null;
		int i=1;
		while(i<m){  //��д��i++<m�����ж��ټӼӣ������ж�������񣬶�ִ��++���㣩�Ǵ���ģ���Ϊ����Ҫ�õ�i��ֵ����i<m������ʱ��i++<m�Ի����i++
			top=node;
			node=node.next;	
			i++;
		}
		preNode=node;
		node=node.next;
		while(i<n){
			nextNode=node.next;
			node.next=preNode;
			preNode=node;
			node=nextNode;
			i++;
		}
		if(m==1) {
			head.next=node;
			return preNode;
		}
		ListNode tmp=top.next;
		top.next=preNode;
		tmp.next=nextNode;
		return head;
	}
	/**
	 * Leetcode NO.21  �����������������ϲ���һ������
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
	
	
	 /**
	  *4��Leetcode NO.2 �����������ĺͣ��������������������ʾ��
	  *	�磺Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	  * @param l1
	  * @param l2
	  * @return
	  */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	    if(l1==null) return l2;
	    if(l2==null) return l1;
	    return addTwoNumbersHelper(l1,l2,0);
	}
	
	public ListNode addTwoNumbersHelper(ListNode l1,ListNode l2,int carry){
		if(l1==null){
			return carry==0?l2:addTwoNumbersHelper(new ListNode(carry),l2,0);
		}
		if(l2==null){
			return carry==0?l1:addTwoNumbersHelper(l1,new ListNode(carry),0);
		}
		
		int sum=l1.val+l2.val+carry;
		ListNode newnode=new ListNode(sum%10);
		newnode.next=addTwoNumbersHelper(l1.next,l2.next,sum/10);
		return newnode;
	}
	/**
	 * 5��Leetcode NO.23  �ϲ�K�����������һ����������
	 * ������TreeSet�������ݣ���Ϊ�����ܺ����ظ����֣�TreeSet�б�������ݱ���ʵ��Comparator�ӿڻ���ΪTreeSet���ñȽ���
	 * java.util.ConcurrentModificationException�쳣��
	 * 		��lists.remove(ListNode)�������׳����쳣������һ���õ�������remove����
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(List<ListNode> lists) {
		ListNode head=null;
		//��lists��Ϊ�յ�����ȥ����
		/*for(ListNode node:lists){
			if(node==null ) lists.remove(node);//java.util.ConcurrentModificationException�쳣 
		}*/
		/*Iterator<ListNode> itr=lists.iterator();
		while(itr.hasNext()){
			if(itr.next()==null) 
				itr.remove();
		}
		if(lists==null || lists.size()==0) return head;	
		Comparator comparator=new ListNodeComparator(); //treeSet��Ҫ���ñȽ���
        TreeSet<ListNode> set=new TreeSet<ListNode>(comparator);
        set.addAll(lists);
        head=set.pollFirst();
        if(head.next!=null) set.add(head.next);
        ListNode tmp=head;
        while(!set.isEmpty()){
        	ListNode smallest=set.pollFirst();
        	tmp.next=smallest;
        	if(smallest.next!=null){
        		set.add(smallest.next);	
        	}
        	tmp=tmp.next;       	
        }
        System.out.println("test");*/
        return head;
    }
	/**
	 * 6��Leetcode NO.25 Reverse Nodes in k-Group
	 * For example,
	 * Given this linked list: 1->2->3->4->5
	 * 	For k = 2, you should return: 2->1->4->3->5
	 * 	For k = 3, you should return: 3->2->1->4->5
	 * @param head
	 * @param k
	 * @return
	 */
	public ListNode reverseKGroup(ListNode head, int k) {
		if(head==null || head.next==null || k<=1) return head;
	    ListNode node1=head,node2=head;
	    int i=k;
	    while(i-- >0){
	    	if(node2==null) return head;
	    	node2=node2.next;
	    }
	    //�ݹ鷴ת
	    ListNode nextnode=null,prenode=reverseKGroup(node2,k);
	    while(k-- >0){
	    	nextnode=node1.next;
	    	node1.next=prenode;
	    	prenode=node1;
	    	node1=nextnode;
	    	
	    }
	    return prenode;
	}
	
	public static void main(String[] args){
		/*List<ListNode> list=new LinkedList<ListNode>();
		ListNode head1=new ListNode(1);
		head1.next=new ListNode(2);
		head1.next.next=new ListNode(2);
		ListNode head2=new ListNode(1);
		head2.next=new ListNode(1);
		head2.next.next=new ListNode(2);
		list.add(head1);
		list.add(head2);
		LinkedListOperation ope=new LinkedListOperation();
		ListNode result=ope.mergeKLists(list);
		while(result!=null){
			System.out.println(result.val);
			result=result.next;
		}*/
		int i=1;
		while(i++ <10){
			System.out.println("test:"+i);
		}
		
	}
}
/**
 * TreeSet�ıȽ���
 * @author luyna
 * 2015��1��30��
 */
class ListNodeComparator implements Comparator{

	@Override
	public int compare(Object arg0, Object arg1) {
		// TODO Auto-generated method stub
		ListNode node1=(ListNode) arg0;
		ListNode node2=(ListNode) arg1;
		if(node1.val>node2.val) return 1;
		else if(node1.val<node2.val) return -1;
		else return 0;
	}
	
}