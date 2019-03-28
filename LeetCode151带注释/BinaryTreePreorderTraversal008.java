package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �ȸ�������������ȱ�������Ȼ���ٱ��������Һ���  
 *
 */
public class BinaryTreePreorderTraversal008 {
	//���Ľڵ����ݽṹ
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	}
		
		
	/*
	 * �ǵݹ���ȸ����������ͨ��һ��ջ��ģ�¶�ȡ˳�򣬾���һֱ���������ߣ�ֱ��������Ϊ�գ�Ȼ����ýڵ���Һ��ӡ� 
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null) return result;
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null || !stack.isEmpty()){
            while(p != null){
                result.add(p.val);
                stack.push(p);
                p = p.left;
            }
            
            if(!stack.isEmpty()){
                p = stack.peek();
                p = p.right;
                stack.pop();
            }
            
        }
        
        return result;
    }
}
