package leetcode;


import java.util.HashMap;


/**
 * @author Luyna
 *
 * 2014年12月17日
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
	 * 方法一：用hash表保存数组中的数值，并判断target-number[i]是否存在于哈希表中
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
	    		 if(tmp1!=tmp2) break;   //处理target是某一个元素的2倍的情况
	    	 }
	     }
  		 if(tmp1>=tmp2) return new int[]{tmp2,tmp1};
		 else return new int[]{tmp1,tmp2};
	 }*/
	 /**
	  * 思路二：如果数组是有序的，从左至右依次递增（该题没有此条件，如用该方法需要先排序）
	  * 用两个指针i,j分别从数组两端开始分别指向当前相加的两个数值，如果两数和等于target，则返回；
	  * 如果两数和小于target，则左边指针右移
	  * 如果两数只和大于target，则右边指针左移
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
