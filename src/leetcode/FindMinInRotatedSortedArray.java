package leetcode;


/**
 * Leetcode 153,154 �ҳ���ת������������е���Сֵ��154������Ԫ���ظ�
 * @author Luyna
 * 2015��1��13��
 */
public class FindMinInRotatedSortedArray {
	/**
	 * �ҳ���ת������������е���Сֵ
	 * ����������
	 * [3,4,5,1,2]
	 * [4,5,1,2,3]
	 * [5,1,2,3,4]
	 * [1]
	 * [1,2,3]
	 * [1,0,1,1,1]
	 * [1,1,1,0,1]
	 * 
	 * @param num ������Ԫ�ز������ظ�
	 * @return ������Сֵ���ڵ��±�
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
	 * �����е�Ԫ�������ظ�
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
