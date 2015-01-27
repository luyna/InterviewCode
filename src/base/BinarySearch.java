package base;

/**
 * 二分检索：注意right=array.length-1、while(left<=right) left=mid+1 right=mid-1 三处的一致性
 * 如果while(left<right) 则相应的应该写成left=mid,right=mid
 * @author Luyna
 * 2015年1月13日
 */
public class BinarySearch {
	public static int Search(int [] array,int val){
		if(array.length==0) return -1;
		int left=0,right=array.length-1;
		int mid=left;
		while(left<=right){
			mid=left+(right-left)/2;
			if(array[mid]<val) left=mid+1;
			else if(array[mid]>val) right=mid-1;
			else return mid;
		}
		return -1;
	}
	
	public static void main(String [] args){
		int [] test1={1};
		int [] test2={1,3,4,5};
		int [] test3={};
		System.out.println("1:"+Search(test1,0));
		System.out.println("2:"+Search(test1,1));
		System.out.println("3:"+Search(test2,4));
		System.out.println("4:"+Search(test3,0));
	}
}
