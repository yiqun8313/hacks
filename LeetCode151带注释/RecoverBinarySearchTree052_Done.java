package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺��һ�ö����������е�ĳ�����ڵ㽻����˳�򣬾���ָ�������  ��Ҫ�ı�ԭ�е����ݽṹ
 *  Two elements of a binary search tree (BST) are swapped by mistake.ecover the tree without changing its structure.
 *
 *	һ��˼·��ͨ��������ȱ����ķ�ʽ��ȡ�����������Ľڵ㡣��Ϊ�����������������������һ������˳��Ȼ���ҵ��������ڵ㣬Ȼ�󽻻����ݡ�
 *
 *	�����Ҫ���Ǿ���ʹ�ñȽ��ٵĿռ䡣ʹ�ó����ռ䡣
 *  
 */
public class RecoverBinarySearchTree052_Done {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public void recoverTree(TreeNode root) {
        if(root == null) return;
        ArrayList<TreeNode> inorderSequence = inorder(root);
        int inorderSize = inorderSequence.size();
        TreeNode firstWrongNode = null;
        TreeNode secondWrongNode = null;
        int i;
        for(i = 0; i < inorderSize-1; i++){
            if(inorderSequence.get(i).val > inorderSequence.get(i+1).val){
                firstWrongNode = inorderSequence.get(i);
                break;
            }
        }
        
        int j;
        for(j = inorderSize-1; j >= 1; j--){
            if(inorderSequence.get(j).val < inorderSequence.get(j-1).val){
                secondWrongNode = inorderSequence.get(j);
                break;
            }
        }
        
        int temp = firstWrongNode.val;
        firstWrongNode.val = secondWrongNode.val;
        secondWrongNode.val = temp;
        
    }
    
    public ArrayList<TreeNode> inorder(TreeNode root){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(root == null){
            return result;
        }
        
        if(root.left != null){
            result.addAll(inorder(root.left));
        }
        
        result.add(root);
        
        if(root.right != null){
            result.addAll(inorder(root.right));
        }
        
        return result;
    }
    
    
    //�����ǳ����ռ�ķ���
    TreeNode pre = null;
    TreeNode mistake1 = null;
    TreeNode mistake2 = null;
    
    public void recoverTree1(TreeNode root) {
        recursiveTree(root);
        if(mistake1 != null && mistake2 != null){
            int temp = mistake1.val;
            mistake1.val = mistake2.val;
            mistake2.val = temp;
        }
    }
    
    //ͨ���ݹ���õķ�ʽ��ȡ  preָ�����ڼ�¼ǰ�������
    public void recursiveTree(TreeNode root){
        if(root == null) return;
        
        if(root.left != null){
            recursiveTree(root.left);
        }
        
        if(pre != null && root.val < pre.val){
            if(mistake1 == null){
                mistake1 = pre;
                mistake2 = root;
            }else{
                mistake2 = root;
            }
        }
        
        pre = root;
        if(root.right != null){
            recursiveTree(root.right);
        }
        
    } 
    
}
