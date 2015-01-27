package leetcode;
/**
 * leetcode NO.179 �������е������������ӳ�������
 * ˼·��ʹ���µ����������������������ʹ�������������ӳɵ��ַ����ϴ��˳���������
 * ��3��34��343>334,��34Ӧ������3��ǰ��
 * @author luyna
 * 2015��1��27��
 */
public class LargestNumber {
	public String largestNumber(int[] num) {
        StringBuffer result=new StringBuffer();
        num=sortNums(num);
        int i=0;
        while(num[i]==0 && i<num.length-1) i++;  //�������ǰ���ɸ�����Ϊ0�������
        while(i<num.length){       	
        	result.append(num[i++]);
        }
        return result.toString();
    }
	/**
	 * �����µıȽϹ���
	 * @param num1
	 * @param num2
	 * @return
	 */
	public int compare(int num1,int num2){
		String n1=new String(Integer.toString(num1));
		String n2=new String(Integer.toString(num2));
		n1=n1+n2;
		n2=n2+n1;
		return n1.compareTo(n2);		
	}
	/**
	 * ð������
	 * @param num
	 */
	public int[] sortNums(int[] num){
		for(int i=0;i<num.length;i++){
			for(int j=num.length-1;j>i;j--){
				if(compare(num[j-1],num[j])<0){
					int tmp=num[j];
					num[j]=num[j-1];
					num[j-1]=tmp;
				}
			}
		}
		return num;
	}
	
	public static void main(String []args){
		int []num={1,2};
		LargestNumber test=new LargestNumber();
		System.out.println(test.largestNumber(num));
	}
}
