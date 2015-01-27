package base;

import java.util.Arrays;

/**
 * ���������㷨
 * 1��ð������  O(n) O(n^2) �ռ�O(1) 
 * 2���鲢����  
 * 
 * ����������
 * []
 * [2]
 * [6,3]
 * [9,6,4,3,5]
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
	
	
	
	
	public static void main(String [] args){
		int [] test1={};
		int [] test2={2};
		int [] test3={6,3};
		int [] test4={9,6,4,3,5};
		Sort sort=new Sort();
		System.out.println("����������������bubbleSort test����������������");
		System.out.println("test1"+Arrays.toString(sort.bubbleSort(test1)));
		System.out.println("test2"+Arrays.toString(sort.bubbleSort(test2)));
		System.out.println("test3"+Arrays.toString(sort.bubbleSort(test3)));
		System.out.println("test4"+Arrays.toString(sort.bubbleSort(test4)));
	}

}
