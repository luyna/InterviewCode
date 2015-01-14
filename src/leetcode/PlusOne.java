package leetcode;



/**
 * @author Luyna
 *
 * 2014年12月17日
 * 
 *  Given a non-negative number represented as an array of digits, 
 *  plus one to the number.
	The digits are stored such that the most significant digit is 
	at the head of the list.
	
 */
public class PlusOne {
	
	public int[] plusOne(int[] digits) {
		int i=digits.length-1;
		while(i>=0 && digits[i]==9){
			digits[i]=0;
			i--;
		}
		if(i>=0) digits[i]++;
		else{//最前面的一位进位的情况
			int [] tmp=new int[digits.length+1];
			tmp[0]=1;
			for(int j=1;j<tmp.length;j++){
				tmp[j]=0;
			}
			digits=tmp;
		}
		return digits;
	}
}
