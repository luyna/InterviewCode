package leetcode;



/**
 * @author Luyna
 *
 * 2014��12��17��
 *  Given two sorted integer arrays A and B, merge B into A as one sorted array.
	Note:
	You may assume that A has enough space (size that is greater or 
	equal to m + n) to hold additional elements from B. The number 
	of elements initialized in A and B are m and n respectively.
	˼·����ΪA�������Ƚϴ󣬿�����A�Ͻ�����������ѡ��A��B�е����ֵ��A[m+n-1]����ǰ��
	
 */
public class MergeSortedArray {
	public void merge(int A[], int m, int B[], int n) {
	    int index=m+n-1;
	    int i=m-1,j=n-1;
	    while(i>=0 && j>=0){
	    	if(A[i]>=B[j]){
	    		A[index--]=A[i--];
	    	}else A[index--]=B[j--];
	    }
	    if(j>0){
	    	while(j>=0){
	    		A[index--]=B[j--];
	    	}
	    }
	}
}
