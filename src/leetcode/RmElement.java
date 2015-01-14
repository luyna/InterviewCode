package leetcode;



/**
 * @author Luyna
 *
 * 2014年12月17日
 *  Given an array and a value, remove all instances of that value in place
 *  and return the new length.
	The order of elements can be changed. It doesn't matter what you leave 
	beyond the new length.
	思路：从前向后找与指定元素相等的元素，用元组最后一个与elem不等的元素代替前面找到的元素
 */
public class RmElement {
    public int removeElement(int[] A, int elem) {
        int len=A.length;
        for(int i=0;i<len;i++){
        	if(A[i]==elem){
        		while(len>i && A[len-1]==elem){
        			len--;
        		}
        		if(len-1>i){
        			A[i]=A[len-1];
        			len--;
        		}else return len;    		
        	}
        }
        return len;
    }
}
