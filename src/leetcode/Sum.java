package leetcode;

import java.util.*;

import base.Sort;

/**
 * 关于数组中多个数之和的问题
 * 1、两个数之和：找出数组中和为target的两个数值下标 Leetcode NO.1
 * 2、找出有序数组中和为s的连续整数序列 剑指offer P214 面试题41
 * 3、Leetcode NO.40 找出无序数组中所有和为指定target的序列（结果必须是升序排列）
 * 
 * 
 * @author luyna
 * 2015年1月28日
 */
public class Sum {
	/**
	 * 1、两个数之和：找出数组中和为target的两个数值下标
	 * Input: numbers={2, 7, 11, 15}, target=9
	 * Output: index1=1, index2=2
	 * 方法一：适用于数组有序和无序：用hash表保存数组中的数值，并判断target-number[i]是否存在于哈希表中
	 * @param numbers 假设每个输入数组中只有一个结果
	 * @param target
	 * @return 返回两个下标的数组，前者大于后者
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
	  * 1、两个数之和：找出数组中和为target的两个数值下标
	  * 思路二：前提数组是有序的，从左至右依次递增（该题没有此条件，如用该方法需要先排序）
	  * 用两个指针i,j分别从数组两端开始分别指向当前相加的两个数值，如果两数和等于target，则返回；
	  * 如果两数和小于target，则左边指针右移
	  * 如果两数只和大于target，则右边指针左移
	  * 
	  * @param numbers
	  * @param target
	  * @return 返回两个下标的数组，前者大于后者
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
	  * 2、剑指offer P214 面试题41 打印出所有和为target的连续正数序列（至少含两个数）
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
		 while(start<mid){ //两个指针都从前面开始
			 if(sum==target){
				 System.out.println(start+"——"+end);
			 }
			 while(sum>target && start<mid){
				 sum -= start;
				 start++;
				 if(sum==target){   //sum每次变化都要判断是否与目标值相等
					 System.out.println(start+"——"+end);
				 }
			 }
			 end++;
			 sum+=end;
			 
		 }
	 }
	 /**
	  * 3、Leetcode NO.40 找出无序数组中所有和为指定target的序列（结果必须是升序排列）
	  * 
	  * @param num 所有数值都为正数
	  * @param target 
	  * @return
	  */
	 public List<List<Integer>> combinationSum2(int[] num, int target) {
		 List<List<Integer>> result=new LinkedList<List<Integer>>();
		 List<Integer> list=new LinkedList<Integer>();
		 if(num.length<=1 || num==null || target<=0) return result;
	     /**
	      * 待续
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
