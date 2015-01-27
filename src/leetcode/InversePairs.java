package leetcode;

import java.util.Arrays;

import base.Sort;

/**
 * 剑指offer P190 面试题36 求数组中的逆序对个数
 * 思路：归并排序思想（分治法），求出子数组中的逆序对个数
 * @author luyna
 * 2015年1月27日
 */
public class InversePairs {
	public int inversePairs(int[] arr){
		if(arr.length==0 || arr.length==1 || arr==null) return 0;
		int len=arr.length;
		return inversePairsHelper(arr,0,len-1);
	}
	
	public int inversePairsHelper(int [] arr,int p,int q){
		if(p>=q) return 0;
		int m=p+((q-p)>>1); 
		int left=inversePairsHelper(arr,p,m);  //左半边的逆序对，并将左半边排好序，避免重复计算
		int right=inversePairsHelper(arr,m+1,q);
		//合并过程中的逆序对个数
		int i=m,j=q;
		int count=0;  //逆序对个数
		int[] tmp=new int[q-p+1];
		int index= q-p;  //临时数组下标
		//从后向前遍历
		while(i>=p && j>=m+1){
			if(arr[i]>arr[j]){
				tmp[index--]=arr[i--];
				count += j-m;
			}else{
				tmp[index--]=arr[j--];
			}
		}
		while(i>=p) tmp[index--]=arr[i--];
		while(j>=m+1) tmp[index--]=arr[j--];

		index=0;
		while(index<tmp.length){
			arr[p++]=tmp[index++];
		}
		return count+left+right;
	}
	
	public static void main(String[] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={2,3,4,5,6};
		int [] test5={10,9,8,7};
		int [] test6={10,5,3,7};
		InversePairs sort=new InversePairs();
		System.out.println("————————1 InversePairs test————————");
		System.out.println("test1 "+sort.inversePairs(test1));
		System.out.println("test2 "+sort.inversePairs(test2));
		System.out.println("test3 "+sort.inversePairs(test3));
		System.out.println("test4 "+sort.inversePairs(test4));
		System.out.println("test5 "+sort.inversePairs(test5));
		System.out.println("test6 "+sort.inversePairs(test6));
	}
}
