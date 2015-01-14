package leetcode;



/**
 * @author Luyna
 *
 * 2014��12��17��
 *  Given an array and a value, remove all instances of that value in place
 *  and return the new length.
	The order of elements can be changed. It doesn't matter what you leave 
	beyond the new length.
	˼·����ǰ�������ָ��Ԫ����ȵ�Ԫ�أ���Ԫ�����һ����elem���ȵ�Ԫ�ش���ǰ���ҵ���Ԫ��
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
