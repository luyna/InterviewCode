package leetcode;
/**
 * Leetcode NO.53 连续子数组中的最大和
 *
 * 测试用例：
 * []
 * [-1]
 * [-2,1]
 * [-2,-1]
 * @author luyna
 * 2015年1月27日
 */
public class MaximumSubarray {
	public int maxSubArray(int[] A) {
		if(A.length==1) return A[0];
		int sum=0,largest=Integer.MIN_VALUE;  //数组中可能有负数，此处不能初始化为0
        for(int i=0;i<A.length;i++){
        	if(sum<0) sum=0; // 注意该题中如果前面的sum小于0，则先把sum清零然后加上当前值，不能颠倒  	
        	sum +=A[i];
        	if(sum>largest) largest=sum;
        }
        return largest;
    }
}
