package leetcode151withexplain;

/**
 *  �������⣺�������Ŷ�����   �ж����Ŷ������Ƿ����
 *
 *  ����˼·��Ҳ�Ǹ��ݶ������ĵݹ�ṹ�ж��������Ƿ���ͬ
 *  
 *  �߽������Ƚ϶ࡣ���Ҫ�ر�ע�⡣
 */
public class SameTree051 {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	 public boolean isSameTree(TreeNode p, TreeNode q) {
		 
		 
        boolean result = true;
        
        if(p == null && q == null){
            return true;
        }
        
        if(p == null && q != null){
            result = false;
            return result;
        }
        
        if(p != null && q == null){
            result = false;
            return result;
        }
        
        if(p.val != q.val){
            result = false;
            return result;
        }
        
        if((p.left != null && q.left == null) || (p.left == null && q.left != null )){
            result = false;
            return result;
        }
        
        if((p.right != null && q.right == null) ||(p.right == null && q.right != null)){
            result = false;
            return result;
        }
        
        if(p.left != null && q.left != null){
            result = isSameTree(p.left, q.left);
            if(result == false){
                return result;
            }
        }
        
        if(p.right != null && q.right != null){
            result = isSameTree(p.right, q.right);
            if(result == false){
                return result;
            }
        }
        
        return result;
	        
	}
}
