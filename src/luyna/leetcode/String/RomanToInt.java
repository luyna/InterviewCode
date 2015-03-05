package luyna.leetcode.String;

import java.util.HashMap;
/**
 * ����������ת��������
 * ����������������ַ��������赱ǰ����iλ�ַ������i-1λ������С��iλ�������֣�������ȥi-1λ���֣�
 * ������ϵ�iλ���֡�
 * @author luyna
 *
 */
public class RomanToInt {
	public int romanToInt(String s) {
		if(s.length()==0) return 0;
        HashMap<Character,Integer> base=new HashMap<Character,Integer>();
        base.put('I', 1);
        base.put('V', 5);
        base.put('X', 10);
        base.put('L', 50);
        base.put('C', 100);
        base.put('D', 500);
        base.put('M', 1000);
        int result=base.get(s.charAt(s.length()-1));
        for(int i=s.length()-2;i>=0;i--){
        	if(base.get(s.charAt(i))<base.get(s.charAt(i+1))){
        		result -= base.get(s.charAt(i));
        	}else result +=base.get(s.charAt(i));
        }
        return result;
    }
	
	public static void main(String[] args){
		System.out.println(new RomanToInt().romanToInt("XIII"));
	}
}
