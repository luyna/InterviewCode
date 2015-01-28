package leetcode;

public class ReverseString {
	/**
	 * ���ַ����еĵ���˳��ת 
	 * ˼·һ���������ַ����е������ַ���ת��Ȼ��ÿ�������е��ַ���ת
	 * ����δͨ���������޸�
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
	 * ��ת����
	 * @param s ����ת�ַ���
	 * @param begin ����ת�ַ����Ŀ�ʼ�±�
	 * @param end ����ת�ַ����Ľ����±�
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
	 * ˼·������ԭ�ַ����ÿո�ָȻ��Ӻ���ǰ�������һ���µ��ַ���
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
