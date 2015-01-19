package leetcode;
/**
 * 
 * @author luyna
 * 2015��1��19��
 */
public class StringOperation {
	/**
	 * ����ַ������ַ�����������
	 * ����������
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
				//�����ַ������������ַ��������������ַ������ַ�����i=start
				char tmp=str[start];
				str[start]=str[i];
				str[i]=tmp;
				//��ͬ��ʽ���к�����ַ�
				permutationHelper(str,start+1);
				//�����ַ��뽻�����ַ��ٽ�������
				tmp=str[start];
				str[start]=str[i];
				str[i]=tmp;
			}
		}
	}
	/**
	 * ����ַ������ַ����������
	 * ����������
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
		//�ַ����в���
		ope.stringPermutation(str);
		System.out.println("������������������������");
		ope.stringPermutation(str1);
		System.out.println("������������������������");
		ope.stringPermutation(str2);
		//�ַ���ϲ���
		/*System.out.println("�ַ���ϲ���");
		ope.stringCombination(str);
		System.out.println("������������������������");
		ope.stringCombination(str1);
		System.out.println("������������������������");
		ope.stringCombination(str2);*/
	}
}
