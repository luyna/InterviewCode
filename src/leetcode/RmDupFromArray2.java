package leetcode;



/**
 * @author Luyna
 *
 * 2014年12月17日
 *  Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	Your function should return length = 5, and A is now [1,1,2,2,3].
 * 
 */
public class RmDupFromArray2 {
    public int removeDuplicates(int[] A) {
       if(A.length<=2) return A.length;
       int len=2;
       for(int i=2;i<A.length;i++){
    	   if(A[i]!=A[len-2]){     //注意这里必须是len-2,不是i-2,旧数组和新数组的比较
    		   A[len]=A[i];
    		   len++;
    	   }
       }
       return len;
    }
}
