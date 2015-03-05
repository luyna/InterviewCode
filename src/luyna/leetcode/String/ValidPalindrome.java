package luyna.leetcode.String;
/**
 * �ж��ַ����Ƿ�����Ч�Ļ��Ĵ���������ĸ������
 * @author luyna
 *
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        if(s==null || s.isEmpty()) return true;
        int i=0,j=s.length()-1;
        while(i<j){
        	if(!Character.isAlphabetic(s.charAt(i)) && !Character.isDigit(s.charAt(i))){
        		i++;
        		continue;
        	}
        	if(!Character.isAlphabetic(s.charAt(j)) && !Character.isDigit(s.charAt(j))) {
        		j--;
        		continue;
        	}
        	if(Character.toUpperCase(s.charAt(i))!=Character.toUpperCase(s.charAt(j)))
        		return false;
        	i++;
        	j--;
        }
        return true;
    }
	
	public static void main(String [] args){
		System.out.println(new ValidPalindrome().isPalindrome("race a car"));
	}
}
