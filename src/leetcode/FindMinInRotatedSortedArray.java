package leetcode;


/**
 * Leetcode 153,154 找出旋转后的有序数组中的最小值，154题允许元组重复
 * @author Luyna
 * 2015年1月13日
 */
public class FindMinInRotatedSortedArray {
	/**
	 * 找出旋转后的有序数组中的最小值
	 * 测试用例：
	 * [3,4,5,1,2]
	 * [4,5,1,2,3]
	 * [5,1,2,3,4]
	 * [1]
	 * [1,2,3]
	 * [1,0,1,1,1]
	 * [1,1,1,0,1]
	 * 
	 * @param num 数组中元素不可以重复
	 * @return 返回最小值所在的下标
	 */
	public static int findMin(int [] num){
		if(num.length<=0) return -1;
		if(num.length==1) return 0;
		
		int left=0,right=num.length-1;
		int mid=left;
		while(num[left]>=num[right]){
			if(right-left==1) {
				mid=right;
				break;
			}
			mid= left+(right-left)/2;
			if(num[mid]>=num[left]) left=mid;
			else if(num[mid]<=num[right]) right=mid;	
		}
		
		/*while(left<=right){
			mid=left+(right-left)/2;
			if(num[mid]>=num[left]) left=mid+1;
			else if(num[mid]<=num[right]) right=mid;
		}*/
		return mid;
	}
	/**
	 * 数组中的元素允许重复
	 * @param num
	 * @return
	 */
	public static int findMin2(int [] num){
		int min=num[0];
		for(int i=1;i<num.length;i++){
			if(num[i]<min) min=num[i];
		}
		return min;
	}
	
	public static void main(String[] args){
		System.out.println();
		int [] test1={3,4,5,1,2};
		int [] test2={5,1,2,3,4};
		int [] test3={1};
		int [] test4={1,2,3};
		System.out.println("test1"+findMin(test1));
		System.out.println("test2"+findMin(test2));
		System.out.println("test3"+findMin(test3));
		System.out.println("test4"+findMin(test4));
	
	}
}
