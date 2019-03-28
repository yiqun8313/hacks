package leetcode151withexplain;

/**
 * �������⣺����һ�ö�����  ��������ĸ߶�  ��Ŀ40���Ǹ���������С�߶�
 * 
 * ����ͨ���ݹ�ķ�ʽ��ȡ���ĸ߶ȣ�Ȼ����������߶Ⱥ��������߶Ƚ��жԱ�   ѡ��Ƚϴ���Ǹ��Ϳ�����
 *
 */
public class MaximumDepthofBinaryTree047 {
	
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public int maxDepth(TreeNode root) {
        
        if(root == null){
            return 0;
        }
        
        if(root != null &&(root.left == null && root.right == null)){
            return 1;
        }
        
        int result = 0;
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = maxDepth(root.left);
        }
        
        if(root.right != null){
            rightHeight = maxDepth(root.right);
        }
        
        result = leftHeight > rightHeight? leftHeight:rightHeight;
        return 1+result;
    }
	
}
