package base;

import java.util.Arrays;

/**
 * ���������㷨
 * 1��ð������  O(n) O(n^2) �ռ�O(1) 
 * 2���鲢����  O(nlgn) �ռ�O(n)
 * 
 * ����������
 * []
 * [2]
 * [6,3]
 * [9,6,4,3,5]
 * [10,4,8,9]
 * @author luyna
 * 2015��1��27��
 */
public class Sort {
	/**
	 * 1��ð������  O(n) O(n^2) �ռ�O(1) 
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
					flag=true;   //�������һ��û�з���������˵�������Ѿ����򣬿�����ֹ
				}
			}
			count--;
		}
		return arr;
	}*/
	/**
	 * ð��������һ�ָĽ�˼·����һ�����flag��¼����һ�����󽻻�����ֵ�±꣬��ʾ��flag�Ժ����ֵ��������
	 * �´α���ֻ���������flag����
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
	 * 2���鲢����  O(nlgn) �ռ�O(n)
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
	 * �����������ݹ�ʵ������ķֽ�Ͳ�
	 * @param arr
	 * @param p ���鿪ʼ�±�
	 * @param q ��������±�
	 */
	public void mergeSortHelper(int[]arr,int p,int q){
		if(p>=q) return;
		int m=p+(p-q)>>1;    //���ַֽ⣬������λ�ľ�������λ����
		mergeSortHelper(arr,p,m);
		mergeSortHelper(arr,m+1,q);
		merge(arr,p,m,q);
	}
	/**
	 * �����������������ϲ�
	 * @param arr
	 * @param p ��һ�������鿪ʼ�±�
	 * @param q ��һ������������±�
	 * @param r �ڶ�������������±�
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
		//���ź������ʱ���鿽����ԭʼ����
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
		Sort sort=new Sort();
		System.out.println("����������������1 bubbleSort test����������������");
		System.out.println("test1"+Arrays.toString(sort.bubbleSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.bubbleSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.bubbleSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.bubbleSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.bubbleSort(test5)));
		System.out.println("����������������2 mergeSort test����������������");
		System.out.println("test1"+Arrays.toString(sort.mergeSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.mergeSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.mergeSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.mergeSort(test4)));
		System.out.println("test5"+Arrays.toString(sort.mergeSort(test5)));
	}

}
