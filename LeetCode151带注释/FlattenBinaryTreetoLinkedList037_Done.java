package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺��һ�����������һ������ ��right���nextʹ��
 *
 * �������˼·����ͨ���������������еĽڵ㣬Ȼ����������rightָ�룬���һ������
 * ע��ĵط�����������ȱ�������������⣬ÿ���ڵ����ڵ�����Ϊnull���ҽڵ�����Ϊ��һ���ڵ㡣
 * 
 * 
 */
public class FlattenBinaryTreetoLinkedList037_Done {
	//���ڵ�  ���ݽṹ 
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return;
        }
        
        ArrayList<TreeNode> results = new ArrayList<TreeNode>();
        getRootFirstList(results,root);
        
        //��ȡ���ȱ����Ľ��  Ȼ����������ÿһ���ڵ��rightָ��Ϊ��һ��
        int resultSize = results.size();
        for(int i = 0; i < (resultSize - 1); i++){
            results.get(i).left = null;
            results.get(i).right = results.get(i+1);
        }
        
        //���������Ҷ�ӽڵ������
        results.get(resultSize-1).left = null;
        results.get(resultSize-1).right = null;
    }
    
    //�������
    public static void getRootFirstList(ArrayList<TreeNode> results, TreeNode root){

    	//�߽�����  �� �����һ��Ҷ�ӽڵ�  Ȼ����뵽results��
        if(root != null && (root.left == null && root.right == null)){
            results.add(root);
            return;
        }
        
        //�Ƚ�root����results
        results.add(root);
        //��������
        if(root.left != null){
           getRootFirstList(results, root.left); 
        }
        
        //�����Һ���
        if(root.right != null){
            getRootFirstList(results, root.right);
        }
        
    }
    
    
    public void flatten2(TreeNode root) {
        toList(root);
    }
    
    //ͨ���ݹ���õķ�ʽ  �������Ľṹ�ص�
    public void toList(TreeNode root){
        if(null == root) return;
        
        //�ж������Ƿ�Ϊ��
        if(root.left != null){
            toList(root.left);
            
            //�ҵ�������ӵ�ʱ������һ���ڵ�
            TreeNode cur = root.left;
            while(cur.right != null){
                cur = cur.right;
            }
            
            //�޸�����
            cur.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        
        if(root.right != null){
            toList(root.right);
        }
    }
}
