package leetcode;

/**
 * �ҳ�Ŀ��ֵ����ת�����������е��±�
 * Leetcode 33 ����������Ԫ�ز��ظ�
 * Leetcode 81 ����������Ԫ���ظ�
 * @author Luyna
 * 2015��1��13��
 */

public class SearchInRotatedSortedArray {
	/**
	 * ����������Ԫ�ز��ظ�
	 * ����������
	 * [1,2,3,6,8]
	 * [5,7,8,9,1,2]
	 * [7,9,1,2,3,4,5]
	 * @param A
	 * @param target
	 * @return �����ڷ��������±꣬�������ڷ���-1
	 */
	public int search(int[] A, int target) {
		int left=0,right=A.length-1;
		int mid=left;
		while(left<=right){
			mid=left+(right-left)/2;
			if(A[mid]==target) return mid;
			else if(A[mid]>=A[left]){     //��mid��leftָ��ͬһ�±�ʱ���ܳ��ֵȺ�
				if(A[mid]>target && target>=A[left]) right=mid-1; //ǰ�벿�ֵ�����Ŀ��ֵ�ڸ�������
				else left=mid+1;  //ǰ�벿�ֵ�����Ŀ��ֵ���ڸ�������
			}else { 	//��벿�ֵ���
				if(A[mid]<target && target<=A[right]) left=mid+1;//Ŀ��ֵ�����ں�벿��������
				else right=mid-1;
			}
		}
		return -1;
		
	}
	/**
	 * �����д����ظ�Ԫ��
	 * [1,3,1,1,1]
	 * [1,1,1,3,1]
	 * @param A
	 * @param target
	 * @return �����ڷ���true�����򷵻�false
	 * ˼·��������Ԫ���ظ�ʱ�������ж�ĳһ�����Ƿ������������Search()�Ļ������޸ģ����A[m]==A[L]����L++;
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
        	}else left++; //if(A[mid]==A[left]) ����ָ�����       	
        }
        return false;
    }
}
