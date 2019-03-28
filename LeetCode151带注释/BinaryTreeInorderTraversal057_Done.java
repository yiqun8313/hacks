package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * �������⣺���÷ǵݹ�ķ�ʽ�Զ����������������
 * 
 * �ǵݹ��ǰ���������������ͺ�������
 * 
 * ���������ǰ�������࣬��������ѹ�����ӣ�ֻ����������Ǳ�ѹ���ʱ��ߴ�ӡ��ֵ������������ǵ�����ʱ���ӡ����ֵ��
 * post��������ͨ��һ��ջ����ѹ���Һ��ӣ���ѹ������
 *
 */
public class BinaryTreeInorderTraversal057_Done {
	
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	//ͨ���ݹ�ķ�ʽʵ���������
	public ArrayList<Integer> inorderTraversal(TreeNode root) {
        
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        
        if(root.left != null){
            result.addAll(inorderTraversal(root.left));
        }
        
        result.add(root.val);
        
        if(root.right != null){
            result.addAll(inorderTraversal(root.right));
        }
        
        return result;
    }
	
	
	//ͨ���ǵݹ�ķ�ʽ
	public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> answer = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode currentNode = root;
        while(currentNode != null || !stack.isEmpty()){
        	//���ϵ�ѹ�����ӽڵ�
            while(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            
            //��ͷ�ڵ���뵽�����
            if(!stack.isEmpty()){
                currentNode = stack.peek();
                answer.add(currentNode.val);
                stack.pop();
                if(currentNode != null){
                    currentNode = currentNode.right;
                }
            }
            
            
        }
        
        return answer;
    }
	
	
}
