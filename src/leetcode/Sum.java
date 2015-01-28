package leetcode;

import java.util.*;

import base.Sort;

/**
 * ���������ж����֮�͵�����
 * 1��������֮�ͣ��ҳ������к�Ϊtarget��������ֵ�±� Leetcode NO.1
 * 2���ҳ����������к�Ϊs�������������� ��ָoffer P214 ������41
 * 3��Leetcode NO.40 �ҳ��������������к�Ϊָ��target�����У�����������������У�
 * 
 * 
 * @author luyna
 * 2015��1��28��
 */
public class Sum {
	/**
	 * 1��������֮�ͣ��ҳ������к�Ϊtarget��������ֵ�±�
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 * ����һ�����������������������hash���������е���ֵ�����ж�target-number[i]�Ƿ�����ڹ�ϣ����
	 * @param numbers ����ÿ������������ֻ��һ�����
	 * @param target
	 * @return ���������±�����飬ǰ�ߴ��ں���
	 */
	 /*public int[] twoSum(int[] numbers, int target) {
	     HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	     int tmp1=0,tmp2=0;
	     for(int i=0;i<numbers.length;i++){
	    	 map.put(numbers[i], i+1);
	     }
	     for(int i=0;i<numbers.length;i++){
	    	 if(map.containsKey(target-numbers[i])){
	    		 tmp1=i+1;
	    		 tmp2=map.get(target-numbers[i]);
	    		 if(tmp1!=tmp2) break;   //����target��ĳһ��Ԫ�ص�2�������
	    	 }
	     }
  		 if(tmp1>=tmp2) return new int[]{tmp2,tmp1};
		 else return new int[]{tmp1,tmp2};
	 }*/
	 /**
	  * 1��������֮�ͣ��ҳ������к�Ϊtarget��������ֵ�±�
	  * ˼·����ǰ������������ģ������������ε���������û�д����������ø÷�����Ҫ������
	  * ������ָ��i,j�ֱ���������˿�ʼ�ֱ�ָ��ǰ��ӵ�������ֵ����������͵���target���򷵻أ�
	  * ���������С��target�������ָ������
	  * �������ֻ�ʹ���target�����ұ�ָ������
	  * 
	  * @param numbers
	  * @param target
	  * @return ���������±�����飬ǰ�ߴ��ں���
	  */
	 public int[] twoSum(int[] numbers, int target) {
		 int i=0,j=numbers.length-1;
		 if(numbers.length<=1) return new int[]{-1,-1}; 
		 while(i<j){
			 if(numbers[i]+numbers[j]==target) return new int[]{i+1,j+1};
			 else if(numbers[i]+numbers[j]<target) i++;
			 else j--;
		 }
		 return new int[]{-1,-1};
	 }
	 /**
	  * 2����ָoffer P214 ������41 ��ӡ�����к�Ϊtarget�������������У����ٺ���������
	  * 
	  * @param numbers
	  * @param target
	  * @return 
	  */
	 public void findAllNumsWithSum(int target){
		 if(target<=1) return;
		 int start=1,end=2;
		 int mid=(target+1)>>1;
		 int sum=start+end;
		 System.out.println("findAllNumsWithSum:"+target);
		 while(start<mid){ //����ָ�붼��ǰ�濪ʼ
			 if(sum==target){
				 System.out.println(start+"����"+end);
			 }
			 while(sum>target && start<mid){
				 sum -= start;
				 start++;
				 if(sum==target){   //sumÿ�α仯��Ҫ�ж��Ƿ���Ŀ��ֵ���
					 System.out.println(start+"����"+end);
				 }
			 }
			 end++;
			 sum+=end;
			 
		 }
	 }
	 /**
	  * 3��Leetcode NO.40 �ҳ��������������к�Ϊָ��target�����У�����������������У�
	  * 
	  * @param num ������ֵ��Ϊ����
	  * @param target 
	  * @return
	  */
	 public List<List<Integer>> combinationSum2(int[] num, int target) {
		 List<List<Integer>> result=new LinkedList<List<Integer>>();
		 List<Integer> list=new LinkedList<Integer>();
		 if(num.length<=1 || num==null || target<=0) return result;
	     /**
	      * ����
	      */
		 return result;
	 }
	 
	 
	 
	 
	 public static void main(String[] args){
		 Sum sum=new Sum();
		 sum.findAllNumsWithSum(9);
		 sum.findAllNumsWithSum(15);
		 sum.findAllNumsWithSum(0);
		 sum.findAllNumsWithSum(4);
		 sum.findAllNumsWithSum(3);
		 
	 }
	
}
