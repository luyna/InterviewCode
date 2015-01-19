package leetcode;
/**
 * 
 * @author luyna
 * 2015年1月19日
 */
public class StringOperation {
	/**
	 * 输出字符串中字符的所有排列
	 * 测试用例：
	 * [a]
	 * []
	 * [a,b,c]
	 * @param str
	 */
	public void stringPermutation(char[] str){
		if(str.length==0 || str==null) return;
		int start=0;
		permutationHelper(str,start);
	}
	public void permutationHelper(char[] str,int start){
		if(start==str.length-1){
			System.out.println(str);
		}else{
			for(int i=start;i<str.length;i++){
				//将首字符依次与后面的字符交换，包括首字符跟首字符交换i=start
				char tmp=str[start];
				str[start]=str[i];
				str[i]=tmp;
				//相同方式排列后面的字符
				permutationHelper(str,start+1);
				//将首字符与交换的字符再交换回来
				tmp=str[start];
				str[start]=str[i];
				str[i]=tmp;
			}
		}
	}
	/**
	 * 输出字符串中字符的所有组合
	 * 测试用例：
	 * [a]
	 * []
	 * [a,b,c]
	 * @param str
	 */
	/*public void stringCombination(char[] str){
		if(str==null || str.length==0) return;
		int start=0;
		combinationHelper(str,start);
	}
	public void combinationHelper(char[] str,int start){
		if(start==str.length-1){
			System.out.println(str);
		}else{
			char tmp=str[start];
			str[start]=' ';
			combinationHelper(str,start+1);
			str[start]=tmp;
			combinationHelper(str,start+1);
		}
	}*/
	
	public static void main(String[] args){
		StringOperation ope=new StringOperation();
		
		char[] str={'a','b','c'};
		char[] str1={};
		char[] str2={'a'};
		//字符排列测试
		ope.stringPermutation(str);
		System.out.println("————————————");
		ope.stringPermutation(str1);
		System.out.println("————————————");
		ope.stringPermutation(str2);
		//字符组合测试
		/*System.out.println("字符组合测试");
		ope.stringCombination(str);
		System.out.println("————————————");
		ope.stringCombination(str1);
		System.out.println("————————————");
		ope.stringCombination(str2);*/
	}
}
