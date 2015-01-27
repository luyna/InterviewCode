package base;

import java.util.Arrays;

/**
 * 各种排序算法
 * 1、冒泡排序  O(n) O(n^2) 空间O(1) 
 * 2、归并排序  
 * 
 * 测试用例：
 * []
 * [2]
 * [6,3]
 * [9,6,4,3,5]
 * @author luyna
 * 2015年1月27日
 */
public class Sort {
	/**
	 * 1、冒泡排序  O(n) O(n^2) 空间O(1) 
	 * @param arr
	 * @return
	 */
	/*public int[] bubbleSort(int[] arr){
		if(arr.length==0 ||arr.length==1) return arr;
		boolean flag=true;
		int count=arr.length;
		while(flag){
			flag=false;
			for(int j=1;j<count;j++){
				if(arr[j-1]>arr[j]){
					int tmp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=tmp;
					flag=true;   //如果遍历一遍没有发生交换，说明数组已经有序，可以终止
				}
			}
			count--;
		}
		return arr;
	}*/
	/**
	 * 冒泡排序另一种改进思路：用一个标记flag记录遍历一遍后最后交换的数值下标，表示该flag以后的数值序列有序，
	 * 下次遍历只需遍历到该flag即可
	 * @param arr
	 * @return
	 */
	public int[] bubbleSort(int[] arr){
		if(arr.length==0 ||arr.length==1) return arr;
		int flag=arr.length-1;
		int count;
		while(flag>0){
			count=flag;
			flag=0;
			for(int j=1;j<=count;j++){
				if(arr[j-1]>arr[j]){
					int tmp=arr[j];
					arr[j]=arr[j-1];
					arr[j-1]=tmp;
					flag=j-1;   
				}
			}
		}
		return arr;
	}
	
	
	
	
	public static void main(String [] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		Sort sort=new Sort();
		System.out.println("————————bubbleSort test————————");
		System.out.println("test1"+Arrays.toString(sort.bubbleSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.bubbleSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.bubbleSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.bubbleSort(test4)));
	}

}
