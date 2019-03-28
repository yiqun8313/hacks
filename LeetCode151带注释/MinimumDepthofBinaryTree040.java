package leetcode151withexplain;

/**
 *  �������⣺�ҳ�����������С�߶�
 *  
 *  ����˼·���������ֵݹ�ṹ�����ġ������Ҷ�ӽڵ㣬��ô�߶�Ϊ1.Ȼ��ݹ�����������߶Ⱥ��������߶ȡ�
 *
 */
public class MinimumDepthofBinaryTree040 {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        //Ҷ�ӽڵ㴦����1
        if(root != null && (root.left == null && root.right == null)){
            return 1;
        }
        
        //��ȡ�������߶�
        //��ȡ�������߶�
        int leftHeight = 0;
        int rightHeight = 0;
        if(root.left != null){
            leftHeight = minDepth(root.left);
        }
        
        if(root.right != null){
            rightHeight = minDepth(root.right);
        }
        
        
        //��ȡ���  �ж������������
        int result = 0;
        if(root.left != null && root.right != null){
        	result = leftHeight < rightHeight? leftHeight:rightHeight;
        }else if(root.left != null && root.right == null){
        	result = leftHeight;
        }else{
        	result = rightHeight;
        }
        
        return 1 + result;
        
    }
}
