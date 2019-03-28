package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺����һ�ö�����  Ȼ��ӵ�����һ��һ��ĸ������  �͵�49�������෴   һ���Ǵ�������  һ���Ǵ�������
 *  
 *  �������˼·��ֻ�ǰѴ洢�����ʱ��洢�ڵ�һ��λ��
 *  
 *
 */
public class BinaryTreeLevelOrderTraversalII044 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	 public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
	        if(root == null){
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        ArrayList<ArrayList<Integer>> realresults = new ArrayList<ArrayList<Integer>>();
	        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	        ArrayList<TreeNode> likeQueue = new ArrayList<TreeNode>();
	        likeQueue.add(root);
	        int circleSize = 1;
	        while(likeQueue.size() != 0){
	            ArrayList<Integer> currentResult = new ArrayList<Integer>();
	            
	            int i = 0;
	            while(i < circleSize){
	                currentResult.add(likeQueue.get(i).val);
	                i++;
	            }
	            results.add(currentResult);
	            
	            i = 0;
	            int newCircleSize = 0;
	            while(i < circleSize){
	                if(likeQueue.get(0).left != null){
	                    newCircleSize++;
	                    likeQueue.add(likeQueue.get(0).left);
	                }
	                
	                if(likeQueue.get(0).right != null){
	                    newCircleSize++;
	                    likeQueue.add(likeQueue.get(0).right);
	                }
	                i++;
	                likeQueue.remove(0);
	            }
	            
	            circleSize = newCircleSize;
	        }
	        
	        for(int k = 0; k < results.size(); k++){
	            realresults.add(results.get(results.size()-k-1));
	        }
	        
	        return realresults;
	    }
}
