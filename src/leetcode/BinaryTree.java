package leetcode;


/**
 * BinaryTree的各种操作，包括求高度、三种深度优先遍历方式（前序、中序、后续的递归和非递归）、层次遍历（宽度优先遍历）
 * Leetcode题目：
 * 1、144 先序遍历二叉树
 * 2、 94  中序遍历二叉树
 * 3、145 后序遍历二叉树
 * 4、102 107 层次遍历二叉树
 * 5、105 先序序列和中序序列重构二叉树
 * 6、106 后序序列和中序序列重构二叉树
 * @author luyna 2015年1月12日
 * 
 */
import java.util.*;
/**
 * BinaryTree的节点定义
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
	 * 先序遍历树，递归版本
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
	 * 先序遍历树，迭代版本
	 *
	 * @param root
	 * @return
	 */
	public List<Integer> preorderTraversalIterative(TreeNode root) {
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){  					//依次遍历并访问所有的左节点，直到左节点为空，
				list.add(visit.val);
				stack.push(visit);				//将遍历的每一个节点存储到栈中
				visit=visit.left;
			}else{                    			//遍历栈订节点的右节点
				visit=stack.pop();
				visit=visit.right;
			}			
		}
		return list;
	}
	/**
	 * leetcode NO.94
	 * 中序遍历树，递归版本
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
	 * 中序遍历树，迭代版本;
	 * @param root
	 * @return
	 */
	public List<Integer> inorderTraversalIterative(TreeNode root){
		List<Integer> list=new ArrayList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){		//先遍历所有左节点，将左节点加入栈中，直到左节点为空
				stack.push(visit);       
				visit=visit.left;
			}else{					//访问栈顶元素，并遍历栈顶元素的右节点
				visit=stack.pop();
				list.add(visit.val); //与前序遍历的区别是该节点访问的位置,先入栈再访问
				visit=visit.right;
			}
		}
		return list;
	}

	/**
	 * leetcode NO.145
	 * 后续遍历树，递归版本
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
	 * 后续遍历树，迭代版本
	 * 后续遍历的顺序是left->right->root,前序遍历的顺序是root->left->right
	 * 将前序遍历顺序调整成root->right->left，然后倒序输出，即为后序遍历的顺序。
	 * @param root
	 * @return
	 */
	public List<Integer> postorderTraversalIterative(TreeNode root){
		LinkedList<Integer> list=new LinkedList<Integer>();
		Stack<TreeNode> stack=new Stack<TreeNode>();
		TreeNode visit=root;
		while(visit!=null || !stack.isEmpty()){
			if(visit!=null){
				list.addFirst(visit.val);   //将每一个数据在头部添加，相当于倒序的效果
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
	 * 层次遍历，按层次信息添加到二维列表中
	 * [ [3],[9,20],[15,7]]
	 * 思路：用两个队列存储当前层的节点和下一层的节点，直到当前层节点个数为0
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list=new LinkedList<List<Integer>>();
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //当前层的节点队列
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //当前层节点的值
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//下一层的节点队列
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
        List<TreeNode> currentQueue=new LinkedList<TreeNode>();  //当前层的节点队列
        if(root==null) return list;
        currentQueue.add(root);
        while(currentQueue.size()!=0){
        	List<Integer> currentList=new LinkedList<Integer>();  //当前层节点的值
        	List<TreeNode> nextQueue=new LinkedList<TreeNode>();	//下一层的节点队列
        	for(TreeNode node:currentQueue){
        		currentList.add(node.val);
        		if(node.left!=null) nextQueue.add(node.left);
        		if(node.right!=null) nextQueue.add(node.right);
        	}
        	list.addFirst(currentList); //与levelOrder()的区别仅在于此，每次在链表头部添加，避免了倒序过程
        	currentQueue=nextQueue;
        }
        return list;
    }

	/**
	 * 5、105 先序序列和中序序列重构二叉树
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
	 * @param preorder 先序遍历序列数组
	 * @param prestart 先序遍历序列开始下标
	 * @param inorder  中序遍历序列数组
	 * @param instart	中序遍历序列开始下标
	 * @param len		序列长度
	 * @return
	 */
	public TreeNode buildTreeProcessor
	(int[] preorder,int prestart,int[] inorder,int instart,int len){
		if(prestart>preorder.length) return null;
		TreeNode root=new TreeNode(preorder[prestart]);
		int i=0;
		while(i<len){		//找到根节点在中序遍历序列中的位置
			if(preorder[prestart]!=inorder[i+instart]){
				i++;
			}else break;
		}
		if(i>0){		//如果左子树存在，递归构建左子树
			root.left=buildTreeProcessor(preorder, prestart+1,inorder,instart,i);
		}
		if(i<len-1){	//如果右子树存在，递归构建右子树
			root.right=buildTreeProcessor(preorder,prestart+1+i,inorder,instart+i+1,len-i-1);
		}

		return root;
	}
	
	
	/** 
	 * 6、106 后序序列和中序序列重构二叉树
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
	 * @param postorder 后序遍历序列
	 * @param postend  后序遍历序列尾部下标
	 * @param len
	 * @return
	 */
	public static TreeNode buildTreePostInProcessor
	(int[] inorder,int inend,int[] postorder,int postend,int len){
		if(postend<0) return null;
		TreeNode root=new TreeNode(postorder[postend]);
		int i=0;
		//找出中序序列中根节点的位置下标，此处从后往前计数(中序和后序都从后往前遍历)
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
	
	public static void main(String [] args){
		int[] inorder={1,2,3,4};
		int[] postorder={1,3,4,2};
		buildTreePostIn(inorder,postorder);
	}
	
}




