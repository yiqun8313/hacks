package leetcode151withexplain;

/**
 * �������⣺�ж�һ�����Ƿ���ƽ���������ƽ������������������ĸ߶����ᳬ��1
 * 
 * ����˼·����ʵ���ǻ�ȡ���������ĸ߶�  ��������1����ô�ͷ���false
 * 
 * �����뷨��ֻҪ��ȡ�������߶Ⱥ��������߶Ƚ����жϡ���Ϊÿ���������ܲ���ƽ��ģ��߶Ⱥ�ƽ��ƽû�й�ϵ��ֻ����ÿ���ڵ㶼��ƽ��Ĳ�����ƽ���������
 *
 */
public class BalancedBinaryTree041 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isBalanced(TreeNode root) {
	    if(root == null){
	    	return true;
	    }
	    
	    //�жϱ����ǲ���
	    int leftHeight = getTreeHeight(root.left);
	    int rightHeight = getTreeHeight(root.right);
	    if(Math.abs(leftHeight - rightHeight) > 1){
	    	return false;
	    }
		
	    //�ж��������ǲ���
	    if(root.left != null){
	    	boolean leftResult = isBalanced(root.left);
	    	if(leftResult == false){
	    		return false;
	    	}
	    }
	    
	    //�ж��������ǲ���
	    if(root.right != null){
	    	boolean rightResult = isBalanced(root.right);
	    	if(rightResult == false){
	    		return false;
	    	}
	    }

		return true;
	}
	
	//�����ڵ�  �����߶�  �����ĸ߶�����ߵ���ֵ��
	public int getTreeHeight(TreeNode node){
		if(node == null){
			return 0;
		}
		
		if(node.left == null && node.right == null){
			return 1;
		}
		
		int leftHeight = getTreeHeight(node.left);
		int rightHeight = getTreeHeight(node.right);
		return  leftHeight >= rightHeight? leftHeight+1 : rightHeight+1;
	}
}
