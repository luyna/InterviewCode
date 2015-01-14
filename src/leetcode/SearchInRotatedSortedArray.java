package leetcode;

/**
 * �ҳ�Ŀ��ֵ����ת�����������е��±�
 * ����������
 * [1,2,3,6,8]
 * [5,7,8,9,1,2]
 * [7,9,1,2,3,4,5]
 * @author Luyna
 * 2015��1��13��
 */
public class SearchInRotatedSortedArray {
	public int search(int[] A, int target) {
		int left=0,right=A.length-1;
		int mid=left;
		while(left<=right){
			mid=left+(right-left)/2;
			if(A[mid]>target){
				if(A[left]>target) left=mid+1;
				else if(A[left]<target) right=mid-1;
				else return left;
			}else if(A[mid]<target){
				if(A[mid]>=A[left]) left=mid+1;
				else right=mid-1;
				
			}else return mid;
		}
		return -1;
		
	}
}
