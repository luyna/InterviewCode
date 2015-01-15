package leetcode;
/**
 * ���ڶ�����������������
 * 1����ָoffer P140 �������������жϸ������ǲ���ĳ���������������������Ч����
 * 
 * @author luyna
 * 2015��1��15��
 */
public class BinarySearchTree {
	/**
	 * 1����ָoffer P140 �������������жϸ������ǲ���ĳ���������������������Ч����
	 * ��������������и�Ԫ�ػ�����ͬ
	 * ˼·�����һ��Ԫ���Ǹ��ڵ㣬ǰ�벿��С�ڸ��ڵ��Ԫ��������������벿�ִ��ڸ��ڵ��Ԫ����������
	 * �������������Ԫ��С�ڸ��ڵ㣬�����������Ч��
	 * ����������
	 * [5,7,6,9,11,10,8] ��ȫ����������
	 * [1,2,3] ֻ��������
	 * [4,3,2] ֻ��������
	 * [1] ֻ��һ���ڵ�
	 * [7,4,6,5] û�ж�Ӧ�Ķ���������
	 * [] ��
	 * @param postorder 
	 * @return
	 */
	public boolean validSeq(int [] postorder){
		if(postorder.length==0 || postorder==null) return false;
		return verifySeqOfBST(postorder,0,postorder.length-1);
	}
	/**
	 * 
	 * @param postorder
	 * @param start  �����еĿ�ʼ�±�
	 * @param end	   �����еĽ����±�
	 * @return
	 */
	public boolean verifySeqOfBST(int [] postorder,int start,int end){	
		if(start==end) return true;  //ֻ��һ���ڵ�ʱ����
		int root=postorder[end];
		//�ҳ���������Ԫ�ظ���
		int i=start;
		for(;i<end;i++){
			if(postorder[i]>root)
				break;
		}
		//�������������Ԫ��С��root��Ϊfalse
		int j=i;
		for(;j<end;j++){
			if(postorder[j]<root)
				return false;
		}
		
		boolean leftresult=true,rightresult=true;
		if(i>0)
			leftresult=verifySeqOfBST(postorder,start,i-1);//ע���±��ָ�룬�˴�end=i-1,������start+i-1
		if(i<end)
			rightresult=verifySeqOfBST(postorder,i,end-1);
		return leftresult&&rightresult;
	}
	
	public static void main(String[] args){
		int [] seq1={5,7,6,9,11,10,8};
		int [] seq2={1,2,3};
		int [] seq3={4,3,2};
		int [] seq4={1};
		int [] seq5={7,4,6,5};
		int [] seq6={};
		BinarySearchTree tree=new BinarySearchTree();
		System.out.println("seq1:"+tree.validSeq(seq1));
		System.out.println("seq2:"+tree.validSeq(seq2));
		System.out.println("seq3:"+tree.validSeq(seq3));
		System.out.println("seq4:"+tree.validSeq(seq4));
		System.out.println("seq5:"+tree.validSeq(seq5));
		System.out.println("seq6:"+tree.validSeq(seq6));
	}
	
	
}
