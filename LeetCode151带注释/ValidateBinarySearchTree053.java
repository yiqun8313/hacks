package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺�ж�һ�����ǲ��Ƕ����������� 
 *	һ��˼·��ͨ�����������ȡ����Ȼ���ж����Ƿ��ǵ���˳��
 */
public class ValidateBinarySearchTree053 {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        ArrayList<Integer> result = inorder(root);
        int resultSize = result.size();
        for(int i = 0; i < resultSize-1; i++){
            if(result.get(i) >= result.get(i+1)){
                return false;
            }
        }
        
        return true;
    }
    
    public ArrayList<Integer> inorder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root.left != null){
            result.addAll(inorder(root.left));
        }
        
        result.add(root.val);
        
        if(root.right != null){
            result.addAll(inorder(root.right));
        }
        
        return result;
    }
    
    
    /**
     *  �����Ŀ������ʵʹ���и���������Ƿǳ��������жϵġ�����Ӧ�����뵽��������������������������ص����ÿ���ڵ��������Ľڵ�ֵ��С�ڵ�ǰ�ڵ�֮�����������нڵ㶼���ڵ�ǰ�ڵ�ֵ����ô������ȫ�ֱ�����¼�����Сֵ������Ӧ���ܼ�¼סÿ���ڵ㵱ǰ�������
     *  ���Ǻ����������ַ������������������ݵ�ǰ�Ƚϵ����ֵ��Сֵ��
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null) return true;
        return helper(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, int min, int max){
        if(root.val <= min || root.val >= max) return false;
        
        if(root.left != null){
            if(root.left.val >= root.val) return false;
            if(!helper(root.left,min,root.val)) return false;
        }
        
        if(root.right != null){
            if(root.right.val <= root.val) return false;
            if(!helper(root.right,root.val,max)) return false;
        }
        
        return true;
    }
}
