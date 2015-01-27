package leetcode;
/**
 * Leetcode NO.53 �����������е�����
 *
 * ����������
 * []
 * [-1]
 * [-2,1]
 * [-2,-1]
 * @author luyna
 * 2015��1��27��
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A.length==1) return A[0];
		int sum=0,largest=Integer.MIN_VALUE;  //�����п����и������˴����ܳ�ʼ��Ϊ0
        for(int i=0;i<A.length;i++){
        	if(sum<0) sum=0; // ע����������ǰ���sumС��0�����Ȱ�sum����Ȼ����ϵ�ǰֵ�����ܵߵ�  	
        	sum +=A[i];
        	if(sum>largest) largest=sum;
        }
        return largest;
    }
}
