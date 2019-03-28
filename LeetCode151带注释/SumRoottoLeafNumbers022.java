package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ�����������Ӹ��ڵ㵽���е�Ҷ�ӽڵ���ַ�����������һ���ַ�����ʾ�����֣������е���Щ���ֶ���������
 * For example,

	    1
	   / \
	  2   3
	The root-to-leaf path 1->2 represents the number 12.
	The root-to-leaf path 1->3 represents the number 13.

	Return the sum = 12 + 13 = 25. 
	
	����˼·��ͨ��������ȱ�������ȡÿһ��·����Ȼ��洢������С�
	
	������ĿҪ��¼ס·�������ʱ�����Ҫһ�������results����ʱ�������temp����������飻
	�����������������Ҫ��סǰ���·����������α����涨˳��ĵ�
 *
 */
public class SumRoottoLeafNumbers022 {
	 
	//���ڵ�����ݽṹ
	 public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	 
	 public int sumNumbers(TreeNode root) {
		 //���ڼ�¼���еĵĸ���Ҷ�ӽڵ��·��
	     ArrayList<String> results = new ArrayList<String>();
	     String temp = "";
	     dfsGetRests(results,temp,root);
	     //����sum���
	     return calculateResult(results);
	 }
	    
	    
	    public void dfsGetRests(ArrayList<String> results, String temp,TreeNode root){
	        
	    	//�߽�����
	    	if(root == null){
	            return;
	        }
	        
	    	//�����ڵ���뵽temp��
	        temp += root.val;

	        //����Ҷ�ӽڵ㣬��ѽ�����뵽���ս������
	        if(root != null && root.left == null && root.right == null){
	            results.add(temp);
	        }
	        
	        //��ʼ������������
	        if(root.left != null){
	            dfsGetRests(results, temp,root.left);
	        }
	        
	        //��ʼ������������
	        if(root.right != null){
	            dfsGetRests(results, temp,root.right);
	        }
	    }
	    
	    public int calculateResult(ArrayList<String> results){
	        int resultSize = results.size();
	        int result = 0;
	        for(int i = 0; i < resultSize; i++){
	            if(!results.get(i).equals("")){
	                int tempResult = 0;
	                int currentSize = results.get(i).length();
	                for(int j = 0; j < currentSize; j++){
	                    tempResult  = tempResult * 10 + Integer.parseInt(results.get(i).substring(j,j+1));
	                }
	                result += tempResult;
	                
	            }
	                
	        }
	        return result;
	    }
}
