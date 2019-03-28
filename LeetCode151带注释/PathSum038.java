package leetcode151withexplain;

/**
 * �������飺����һ�����������ж������Ƿ����һ��·���͵��ڸ�����ֵ
 * 
 * ����˼·����ʵ�������ı�����ֻ���ܹ���¼ס��ǰ·�����Ƕ��١�
 * 
 * �ٴ����飺��Щ��Ŀ��Ҫ��¼·���ϵ�ÿһ��ֵ���е���Ŀֻ��Ҫ֪�����Ľڵ㡣
 * 
 * �����������̻��Ǻ͸��ֱ�����ʽһ�£����������ʽ��
 *
 */
public class PathSum038 {
	
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	 public boolean hasPathSum(TreeNode root, int sum) {
	        
	        //deal special situation
	        if(root == null){
	            return false;
	        }
	        
	        //judge if current situation satisfy the conditions
			if(root.left == null && root.right == null && sum == root.val){
				return true;
			}
			
			
			if(root.left != null){
				boolean leftResult = hasPathSum(root.left,(sum-root.val));
				if(leftResult == true){
					return true;
				}
			}
			
			if(root.right != null){
				boolean rightResult = hasPathSum(root.right, (sum-root.val));
				if(rightResult == true){
					return true;
				}
			}
			
			return false;        
	    }
}
