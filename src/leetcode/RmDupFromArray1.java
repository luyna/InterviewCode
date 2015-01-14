package leetcode;



/**
 * @author Luyna
 *
 * 2014Äê12ÔÂ17ÈÕ
 *  Follow up for "Remove Duplicates":
	What if duplicates are allowed at most twice?
	For example,
	Given sorted array A = [1,1,1,2,2,3],
	Your function should return length = 5, and A is now [1,1,2,2,3].
 */
public class RmDupFromArray1 {
	public int removeDuplicates(int[] A) {
        if(A.length<=1) return A.length;
		int len=1;
        for(int i=1;i<A.length;i++){
        	if(A[i]!=A[len-1]){
        		A[len]=A[i];
        		len++;
        	}
        }
        return len;
    }
}
