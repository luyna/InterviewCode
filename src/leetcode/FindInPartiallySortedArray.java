package leetcode;

/**
 * @author luyna
 * 2015��1��4��
 * 
 * һ����ά�����У������ҵ��������ϵ��µ������жϸ��������Ƿ���ָ������
 * 
 * ˼·�������Ͻǻ������½ǿ�ʼ����
 */
public class FindInPartiallySortedArray {
	public static void main(String[] args){
		//int [][]test=new int[10][5];
		int [][] test={{1,2,8,9},{2,4,9,2},{4,7,10,13},{6,8,11,15}};
		FindInPartiallySortedArray hah=new FindInPartiallySortedArray();
		System.out.println(hah.find(test, 5));
		System.out.println(hah.find(test, 7));		
	}
	public boolean find(int [][] arr,int val){
		if(arr!=null){
			int rows=arr.length;
			int cols=arr[0].length;
			int row=0,col=cols-1;
			while(row<rows && col>=0){
				if(val== arr[row][col]) return true;
				else if(val<arr[row][col]) col--;
				else row++;
			}
			return false;
		}
		return false;
		
	}
}
