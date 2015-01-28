package leetcode;

public class ReverseString {
	/**
	 * 将字符串中的单词顺序反转 
	 * 思路一：将整个字符串中的所有字符反转，然后将每个单词中的字符反转
	 * 测试未通过，还需修改
	 * @param s "the sky is blue"
	 * @return "blue is sky the"
	 */
	public String reverseWords(String s) {
		if(s.length()<=1) return s;
		StringBuffer tmp=new StringBuffer(s);
		reverse(tmp,0,tmp.length()-1);
		int begin=0,end=0;
		while(s.charAt(begin)!='\0'){
			if(s.charAt(begin)==' '){
				begin++;
				end++;
			}else if(s.charAt(end)==' ' || s.charAt(end)=='\0'){
				reverse(tmp,begin,end-1);
				begin=end+1;
			}else end++;
		}
		return tmp.toString();
	}
	/**
	 * 反转函数
	 * @param s 待反转字符串
	 * @param begin 待反转字符串的开始下标
	 * @param end 待反转字符串的结束下标
	 */
	public void reverse(StringBuffer s,int begin,int end){
		if(s.length()<=1) return;
		int i=begin,j=end;
		while(i<j){
			char tmp=s.charAt(i);
			s.setCharAt(i, s.charAt(j));
			s.setCharAt(j, tmp);
			i++;
			j--;
		}
	}

	/*
	 * 思路二：将原字符串用空格分割，然后从后往前遍历组成一个新的字符串
	 * public String reverseWords(String s) {
		s = s.trim();
		String[] strs = s.split(" ");
		if (strs.length == 0)
			return "";
		if (strs.length == 1)
			return s;
		StringBuffer str = new StringBuffer();
		for (int i = strs.length - 1; i >= 1; i--) {
			if (!strs[i].isEmpty())
				str = str.append(strs[i] + " ");
		}
		str = str.append(strs[0]);
		return str.toString();
	}*/

}
