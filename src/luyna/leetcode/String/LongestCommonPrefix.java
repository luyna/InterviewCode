package luyna.leetcode.String;

public class LongestCommonPrefix {
	/**
	 * �ҳ��������ַ����������ǰ׺
	 * ��ֱ�۵�˼·�����������е�һ���ַ����е��ַ������������������ַ�����
	 * �����ַ��������е��ַ����뵽ǰ׺�ַ�����
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if(strs.length==0) return "";
		if(strs.length==1) return strs[0];
        StringBuffer sb=new StringBuffer("");
        for(int i=0;i<strs[0].length();i++){
        	char tmp=strs[0].charAt(i);
        	int j;
        	for(j=1;j<strs.length;j++){
        		if(i>=strs[j].length() || strs[j].charAt(i)!=tmp)
        			break;
        	}
        	if(j==strs.length) sb.append(tmp);
        	else break;
        }
        return sb.toString();
    }
}
