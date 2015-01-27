package base;

import java.util.Arrays;

/**
 * 各种排序算法
 * 1、冒泡排序  O(n) O(n^2) 空间O(1) 
 * 2、归并排序  O(nlgn) 空间O(n)
 * 
 * 测试用例：
 * []
 * [2]
 * [6,3]
 * [9,6,4,3,5]
 * [10,4,8,9]
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
	/**
	 * 2、归并排序  O(nlgn) 空间O(n)
	 * @param arr
	 * @return
	 */
	public int[] mergeSort(int[] arr){
		if(arr.length==0 || arr.length==1) return arr;
		int len=arr.length;
		mergeSortHelper(arr,0,len-1);
		return arr;
	}
	/**
	 * 辅助函数：递归实现数组的分解和并
	 * @param arr
	 * @param p 数组开始下标
	 * @param q 数组结束下标
	 */
	public void mergeSortHelper(int[]arr,int p,int q){
		if(p>=q) return;
		int m=p+((q-p)>>1);    //移位运算优先级较低，所以需要加括号,能用移位的尽量用移位运算
		//System.out.println("test m:"+m+",,"+p+","+q+",,"+(p+((q-p)>>1)));
		mergeSortHelper(arr,p,m);  //排序左边
		mergeSortHelper(arr,m+1,q); //排序右边
		merge(arr,p,m,q);   //合并两个有序子数组
	}
	/**
	 * 将数组的两个字数组合并
	 * @param arr
	 * @param p 第一个子数组开始下标
	 * @param q 第一个子数组结束下标
	 * @param r 第二个子数组结束下标
	 */
	public void merge(int[] arr,int p,int q,int r){
		int i=p,j=q+1;
		int [] tmp=new int [r-p+1];
		int count=0;
		while(i<=q && j<=r){
			if(arr[i]<=arr[j]){
				tmp[count++]=arr[i++];
			}else tmp[count++]=arr[j++];
		}
		while(i<=q){
			tmp[count++]=arr[i++];
		}
		while(j<=r){
			tmp[count++]=arr[j++];
		}
		//将排好序的临时数组拷贝回原始数组
		while(count>0){
			arr[r--]=tmp[count-1];
			count--;
		}
		
	}
	
	
	
	
	public static void main(String [] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		int [] test5={10,4,8,9};
		int [] test6={2,3,4,5,6};
		int [] test7={6,5,4,3,2,1};
		Sort sort=new Sort();
		System.out.println("————————1 bubbleSort test————————");
		System.out.println("test1"+Arrays.toString(sort.bubbleSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.bubbleSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.bubbleSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.bubbleSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.bubbleSort(test5)));
		System.out.println("test6"+Arrays.toString(sort.bubbleSort(test6)));
		System.out.println("test7"+Arrays.toString(sort.bubbleSort(test7)));
		System.out.println("————————2 mergeSort test————————");
		System.out.println("test1"+Arrays.toString(sort.mergeSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.mergeSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.mergeSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.mergeSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.mergeSort(test5)));
		System.out.println("test6"+Arrays.toString(sort.mergeSort(test6)));
		System.out.println("test7"+Arrays.toString(sort.mergeSort(test7)));
	}

}
