package leetcode151withexplain;

/**
 * �ж�һ�����ǲ��ǶԳƶ�����
 * 
 * For example, this binary tree is symmetric:

	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3
	But the following is not:
	    1
	   / \
	  2   2
	   \   \
	   3    3
	
	һ��˼·��ͨ��������ȱ���   ��ȡÿһ��Ľڵ�   Ȼ���ж���һ��ڵ��Ƿ��ǶԳƵľͿ�����  ����ʱ��ᳬʱ
	
	����˼·��
	
 *
 */
public class SymmetricTree050 {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isSymmetric(TreeNode root) {
        //����Ϊ�����������
		if(root == null){
            return true;
        }
        
        if(root.left == null && root.right == null){
            return true;
        }
        
        return isMirror(root.left,root.right);
    }
    
	//�ݹ����   ͨ�����������е����ʽ��еݹ����
    public boolean isMirror(TreeNode leftson,TreeNode rightson){
    	//�߽������ǳ���Ҫ
        if(leftson == null && rightson == null)  return true;
        if(leftson == null && rightson != null)  return false;
        if(leftson != null && rightson == null)  return false;
        if(leftson.val != rightson.val) return false;
        return isMirror(leftson.left,rightson.right)&&isMirror(leftson.right,rightson.left);
    }
}
