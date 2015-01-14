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
	 public int[] twoSum(int[] numbers, int target) {
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
	 }
}
