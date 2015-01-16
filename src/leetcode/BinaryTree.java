package leetcode;


/**
 * BinaryTree�ĸ��ֲ�����������߶ȡ�����������ȱ�����ʽ��ǰ�����򡢺����ĵݹ�ͷǵݹ飩����α�����������ȱ�����
 * Leetcode��Ŀ��
 * 1��144 �������������
 * 2�� 94  �������������
 * 3��145 �������������
 * 4��102 107 ��α���������
 * 5��105 �������к����������ع�������
 * 6��106 �������к����������ع�������
 * 
 * ��ָoffer��Ŀ��
 * 7���Ƿ����������
 * 8���������ľ���
 * 
 * 9��Leetcode NO.113�ҳ������������к�Ϊָ��sum��·�����Ӹ��ڵ㵽Ҷ�ӽڵ��������ֵ�ͣ�
 * 10��Leetcode NO.112 �ж϶��������Ƿ���ں�Ϊָ��sum��·��
 * 
 * 
 * @author luyna 2015��1��12��
 * 
 */
import java.util.*;
/**
 * BinaryTree�Ľڵ㶨��
 * 
 */
class TreeNode {
	int val;
	TreeNode left, right;

	public TreeNode(int val) {
		this.val = val;
	}
}

/**
 * 
 */
public class BinaryTree {
	private TreeNode root;

	public BinaryTree(TreeNode root) {
		this.root = root;
	}


	/**
	 * leetcode NO.144
	 * ������������ݹ�汾
	 * 
	 * @param root
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root != null) {
			// visit(root);
			list.add(root.val);
			list.addAll(preorderTraversal(root.left));
			list.addAll(preorderTraversal(root.right));
		}
		return list;
	}
	/**
	 * ����������������汾
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){  					//���α������������е���ڵ㣬ֱ����ڵ�Ϊ�գ�
				list.add(visit.val);
				stack.push(visit);				//��������ÿһ���ڵ�洢��ջ��
				visit=visit.left;
			}else{                    			//����ջ���ڵ���ҽڵ�
				visit=stack.pop();
				visit=visit.right;
			}			
		}
		return list;
	}
	/**
	 * leetcode NO.94
	 * ������������ݹ�汾
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		if(root!=null){
			list.addAll(inorderTraversal(root.left));
			list.add(root.val);
			list.addAll(inorderTraversal(root.right));
		}
		return list;
	}
	/**
	 * ����������������汾;
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversalIterative(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){		//�ȱ���������ڵ㣬����ڵ����ջ�У�ֱ����ڵ�Ϊ��
				stack.push(visit);       
				visit=visit.left;
			}else{					//����ջ��Ԫ�أ�������ջ��Ԫ�ص��ҽڵ�
				visit=stack.pop();
				list.add(visit.val); //��ǰ������������Ǹýڵ���ʵ�λ��,����ջ�ٷ���
				visit=visit.right;
			}
		}
		return list;
	}

	/**
	 * leetcode NO.145
	 * �������������ݹ�汾
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversal(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		if(root!=null){
			list.addAll(postorderTraversal(root.left));
			list.addAll(postorderTraversal(root.right));	
			list.add(root.val);
		}
		return list;
	}
	/**
	 * 
	 * �����������������汾
	 * ����������˳����left->right->root,ǰ�������˳����root->left->right
	 * ��ǰ�����˳�������root->right->left��Ȼ�����������Ϊ���������˳��
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversalIterative(TreeNode root){
		LinkedList<Integer> list=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){
				list.addFirst(visit.val);   //��ÿһ��������ͷ����ӣ��൱�ڵ����Ч��
				stack.push(visit);
				visit=visit.right;
			}else {
				visit=stack.pop();
				visit=visit.left;
			}
		}
		return list;
	}
	/**
	 * leetcode NO.102
	 * ��α������������Ϣ��ӵ���ά�б���
	 * [ [3],[9,20],[15,7]]
	 * ˼·�����������д洢��ǰ��Ľڵ����һ��Ľڵ㣬ֱ����ǰ��ڵ����Ϊ0
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list=new LinkedList<List<Integer>>();
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //��ǰ��Ľڵ����
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //��ǰ��ڵ��ֵ
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//��һ��Ľڵ����
        	for(TreeNode node:currentQueue){
        		currentList.add(node.val);
        		if(node.left!=null) nextQueue.add(node.left);
        		if(node.right!=null) nextQueue.add(node.right);
        	}
        	list.add(currentList);
        	currentQueue=nextQueue;
        }
        return list;
    }
	/**
	 * leetcode NO.107
	 * For example:
	Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
	return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		LinkedList<List<Integer>> list=new LinkedList<List<Integer>>();
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //��ǰ��Ľڵ����
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //��ǰ��ڵ��ֵ
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//��һ��Ľڵ����
        	for(TreeNode node:currentQueue){
        		currentList.add(node.val);
        		if(node.left!=null) nextQueue.add(node.left);
        		if(node.right!=null) nextQueue.add(node.right);
        	}
        	list.addFirst(currentList); //��levelOrder()����������ڴˣ�ÿ��������ͷ����ӣ������˵������
        	currentQueue=nextQueue;
        }
        return list;
    }

	/**
	 * 5��105 �������к����������ع�������
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTreePreIn(int[] preorder, int[] inorder) {
        if(preorder.length!=inorder.length ||  preorder.length==0 || inorder.length==0 )
        	return null;
        return buildTreeProcessor(preorder,0,inorder,0,preorder.length);
    }
	/**
	 * 
	 * @param preorder ���������������
	 * @param prestart ����������п�ʼ�±�
	 * @param inorder  ���������������
	 * @param instart	����������п�ʼ�±�
	 * @param len		���г���
	 * @return
	 */
	public TreeNode buildTreeProcessor
	(int[] preorder,int prestart,int[] inorder,int instart,int len){
		if(prestart>preorder.length) return null;
		TreeNode root=new TreeNode(preorder[prestart]);
		int i=0;
		while(i<len){		//�ҵ����ڵ���������������е�λ��
			if(preorder[prestart]!=inorder[i+instart]){
				i++;
			}else break;
		}
		if(i>0){		//������������ڣ��ݹ鹹��������
			root.left=buildTreeProcessor(preorder, prestart+1,inorder,instart,i);
		}
		if(i<len-1){	//������������ڣ��ݹ鹹��������
			root.right=buildTreeProcessor(preorder,prestart+1+i,inorder,instart+i+1,len-i-1);
		}

		return root;
	}
	
	
	/** 
	 * 6��106 �������к����������ع�������
	 */
	
	public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
        if(inorder.length!=postorder.length || inorder.length==0 || postorder.length==0)
        	return null;
        return buildTreePostInProcessor(inorder,inorder.length-1,postorder,postorder.length-1,inorder.length);
    }
	/**
	 * 
	 * @param inorder 
	 * @param instart
	 * @param postorder �����������
	 * @param postend  �����������β���±�
	 * @param len
	 * @return
	 */
	public static TreeNode buildTreePostInProcessor
	(int[] inorder,int inend,int[] postorder,int postend,int len){
		if(postend<0) return null;
		TreeNode root=new TreeNode(postorder[postend]);
		int i=0;
		//�ҳ����������и��ڵ��λ���±꣬�˴��Ӻ���ǰ����(����ͺ��򶼴Ӻ���ǰ����)
		/*while(i<len ){    
			if(inorder[i+instart]!=postorder[postend]){
				i++;
			}else break;
		}*/
		while(inend-i>=0){
			if(inorder[inend-i]!=postorder[postend]){
				i++;
			}else break;
		}
		if(i<len-1) root.left=buildTreePostInProcessor(inorder,inend-i-1,postorder,postend-i-1,len-i-1);
		if(i>0) root.right=buildTreePostInProcessor(inorder,inend,postorder,postend-1,i);
		return root;
	}
	
	/**
	 * 8���������ľ���
	 * ˼·���������һ����������������Ľڵ����ӽڵ㣬�ͽ������������ӽڵ㣬��
	 * ���������з�Ҷ�ӽڵ�����ҽڵ�󣬾͵õ������ľ���
	 * @param args
	 */
	public void mirrorRecursively(TreeNode root){
		if(root==null || (root.left==null && root.right==null))
			return ;
		TreeNode tmp=root.left;
		root.left=root.right;
		root.right=tmp;
		if(root.left!=null) mirrorRecursively(root.left);
		if(root.right!=null) mirrorRecursively(root.right);
	}
	
	/**
	 * 9��Leetcode NO.113�ҳ������������к�Ϊָ��sum��·�����Ӹ��ڵ㵽Ҷ�ӽڵ��������ֵ�ͣ�
	 * @param root
	 * @param sum
	 * @return
	 */
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
	    List<List<Integer>> result=new ArrayList<List<Integer>>();
	    List<Integer> curpath=new ArrayList<Integer>();
	    int [] sumval={sum,0}; //��������ֵ�͵�ǰֵ
	    if(root==null) return result;
	    result=pathSumProcessor(root,result,curpath,sumval);
	    return result;
	}
	public List<List<Integer>> pathSumProcessor
	(TreeNode root, List<List<Integer>> result,List<Integer> curpath,int[] sumval) {
	    sumval[1]=sumval[1]+root.val;
	    curpath.add(root.val);
	    //��ǰ�ڵ�Ϊ�ӽڵ�
		if(root.left==null && root.right==null){
			//��Ϊ�����������ͣ������Ե�ǰ·����������޸ģ����Լ���result�еĵ�ǰ·��Ҫ����һ������
			List<Integer> list=new ArrayList<Integer>(curpath);
	    	if(sumval[0]==sumval[1]) result.add(list);	 
	    	
	    }
		if(root.left!=null){
			pathSumProcessor(root.left,result,curpath,sumval);
		}
		if(root.right!=null){
			pathSumProcessor(root.right,result,curpath,sumval);
		}
		//��ǰ�ڵ���ʽ����󣬵ݹ麯���Զ��ص����ĸ��ڵ㣬�����ں�������֮ǰҪ�Ե�ǰ·������ֵ�����޸�
		sumval[1]=sumval[1]-root.val;
		curpath.remove(curpath.size()-1);
		return result;
	    
	}
	
	/**
	 * 10��Leetcode NO.112 �ж϶��������Ƿ���ں�Ϊָ��sum��·��
	 * 
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if(root==null) return false;
		if(root.left==null && root.right==null){
			return root.val==sum;
		}
		return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
		//�ǵݹ���������������ջ�ĵ����ڵ���ܲ��������ĸ��ӽڵ�˳�������޷��ں��ʵ�λ�øı�cursumֵ
		/*Stack<TreeNode> stack=new Stack<TreeNode>();
		int cursum=0;
		if(root==null) return false;
		while(root!=null || !stack.isEmpty()){
			if(root!=null){
				cursum +=root.val;
				stack.push(root);
				if(root.left==null && root.right==null){
					if(cursum==sum) return true;
					else cursum -=root.val;
				}
				root=root.left;
			}else{
				root=stack.pop();
				root=root.right;
			}			
		}
        return false;*/
    }

	
	public static void main(String [] args){
		int[] inorder={1,2,3,4};
		int[] postorder={1,3,4,2};
		buildTreePostIn(inorder,postorder);
	}
	
}




