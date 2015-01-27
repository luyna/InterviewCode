package leetcode;
/**
 * leetcode NO.179 将数组中的数字排列连接成最大的数
 * 思路：使用新的排序规则将数组中数字排序，使得两个数按连接成的字符串较大的顺序进行排序，
 * 如3和34，343>334,则34应该排在3的前面
 * @author luyna
 * 2015年1月27日
 */
public class LargestNumber {
	public String largestNumber(int[] num) {
        StringBuffer result=new StringBuffer();
        num=sortNums(num);
        int i=0;
        while(num[i]==0 && i<num.length-1) i++;  //如果数组前若干个数字为0，则不输出
        while(i<num.length){       	
        	result.append(num[i++]);
        }
        return result.toString();
    }
	/**
	 * 建立新的比较规则
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
	 * 冒泡排序
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
