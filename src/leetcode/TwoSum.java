package leetcode;


import java.util.HashMap;


/**
 * @author Luyna
 *
 * 2014��12��17��
 * 
 *  Given an array of integers, find two numbers such that they add up to a specific target number.
	The function twoSum should return indices of the two numbers such that
	they add up to the target, where index1 must be less than index2. 
	Please note that your returned answers (both index1 and index2) are
	not zero-based.
	You may assume that each input would have exactly one solution.

 	Input: numbers={2, 7, 11, 15}, target=9
	Output: index1=1, index2=2
 */
public class TwoSum {
	/**
	 * ����һ����hash���������е���ֵ�����ж�target-number[i]�Ƿ�����ڹ�ϣ����
	 * @param numbers
	 * @param target
	 * @return
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
	  * ˼·�����������������ģ������������ε���������û�д����������ø÷�����Ҫ������
	  * ������ָ��i,j�ֱ���������˿�ʼ�ֱ�ָ��ǰ��ӵ�������ֵ����������͵���target���򷵻أ�
	  * ���������С��target�������ָ������
	  * �������ֻ�ʹ���target�����ұ�ָ������
	  * 
	  * @param numbers
	  * @param target
	  * @return
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
	 
}
