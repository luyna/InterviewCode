package leetcode;



/**
 * @author Luyna
 *
 * 2014��12��12��
 * 
 *A peak element is an element that is greater than its neighbors.
Given an input array where num[i] �� num[i+1], find a peak element and return its index.
The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
You may imagine that num[-1] = num[n] = -��.
For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
Note:
Your solution should be in logarithmic complexity.
˼·��
���num[i-1] < num[i] > num[i+1], �� num[i]�Ƿ�ֵ
���num[i-1] < num[i] < num[i+1], ��ô num[i+1...n-1]һ������һ����ֵ
���num[i-1] > num[i] > num[i+1], ��ônum[0...i-1]һ������һ����ֵ
���num[i-1] > num[i] < num[i+1], ��ôi�����˶����ܰ�����ֵ
���iѡ���е�λ�ã���ôһ��������logN��ʱ�����ҵ�һ����ֵ������������˼�룩
 */
public class FindPeakElement {
	public int findPeakElement(int[] num) {
        int n=num.length;
        int left=0,right=n-1,mid=0;
        int num_left,num_right;
        while(left<=right){
        	mid=(left+right)/2;
        	if(mid==0) num_left=Integer.MIN_VALUE;
        	else num_left=num[mid-1];
        	if(mid==n-1) num_right=Integer.MIN_VALUE;
        	else num_right=num[mid+1];
        	
        	if(num[mid]>num_left && num[mid]>num_right)
             	return mid;
            else if(num[mid]<num_left)
            	right=mid-1;
            else 
            	left=mid+1;
        }
        return mid;
       
        
    }
}
