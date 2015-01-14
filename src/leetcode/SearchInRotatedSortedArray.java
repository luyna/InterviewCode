package leetcode;

/**
 * 找出目标值在旋转的有序数组中的下标
 * Leetcode 33 假设数组中元素不重复
 * Leetcode 81 假设数组中元素重复
 * @author Luyna
 * 2015年1月13日
 */

public class SearchInRotatedSortedArray {
	/**
	 * 假设数组中元素不重复
	 * 测试用例：
	 * [1,2,3,6,8]
	 * [5,7,8,9,1,2]
	 * [7,9,1,2,3,4,5]
	 * @param A
	 * @param target
	 * @return 若存在返回所在下标，若不存在返回-1
	 */
	public int search(int[] A, int target) {
		int left=0,right=A.length-1;
		int mid=left;
		while(left<=right){
			mid=left+(right-left)/2;
			if(A[mid]==target) return mid;
			else if(A[mid]>=A[left]){     //当mid和left指向同一下标时可能出现等号
				if(A[mid]>target && target>=A[left]) right=mid-1; //前半部分递增且目标值在该区间中
				else left=mid+1;  //前半部分递增但目标值不在该区间中
			}else { 	//后半部分递增
				if(A[mid]<target && target<=A[right]) left=mid+1;//目标值出现在后半部分区间中
				else right=mid-1;
			}
		}
		return -1;
		
	}
	/**
	 * 数组中存在重复元素
	 * [1,3,1,1,1]
	 * [1,1,1,3,1]
	 * @param A
	 * @param target
	 * @return 若存在返回true，否则返回false
	 * 思路：数组中元素重复时，不能判断某一部分是否递增，可以在Search()的基础上修改，如果A[m]==A[L]，则将L++;
	 */
	public boolean searchDup(int[] A, int target) {
        int left=0,right=A.length-1;
        int mid=left;
        while(left<=right){
        	mid=left+(right-left)/2;
        	if(A[mid]==target) return true;
        	else if(A[mid]>A[left]){
        		if(A[mid]>target && target>=A[left]) right=mid-1;
        		else left=mid+1;
        	}else if(A[mid]<A[left]){
        		if(A[mid]<target && target<=A[right]) left=mid+1;
        		else right=mid-1;
        	}else left++; //if(A[mid]==A[left]) 则将左指针递增       	
        }
        return false;
    }
}
