package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ�ö�����   ��z��·����ȡ����������  һ��һ�еĶ�ȡ
 * Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
 *
 *  ��ʵ�ͺ�֮ǰ44  49���  ���ֻ�Ǹı���һ��ÿһ�еĶ�ȡ˳��
 */
public class BinaryTreeZigzagLevelOrderTraversal048 {
	
	//���ڵ�
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
	        if(root == null){
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	        ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
	        ArrayList<TreeNode> likeQueue = new ArrayList<TreeNode>();
	        likeQueue.add(root);
	        int circleNum = 1;
	        int level = 0;
	        while(likeQueue.size() > 0){
	            levelNumbers = new ArrayList<Integer>();
	            int i = 0;
	            while(i < circleNum){
	                levelNumbers.add(likeQueue.get(i).val);
	                i++;
	            }
	            
	            //ֻ������һ�����⴦��   ��ε�����ż�������˸ò�εĶ�ȡ˳��
	            if((level % 2) == 0){
	                results.add(levelNumbers);
	            }else{
	                reverseNumbers(levelNumbers);
	                results.add(levelNumbers);
	            }
	            level++;
	            
	            i = 0;
	            int newcircleNum = 0;
	            while(i < circleNum){
	                TreeNode currentnode = likeQueue.get(0);
	                likeQueue.remove(0);
	                if(currentnode.left != null){
	                    likeQueue.add(currentnode.left);
	                    newcircleNum++;
	                }
	                
	                if(currentnode.right != null){
	                    likeQueue.add(currentnode.right);
	                    newcircleNum++;
	                }
	                i++;
	            }
	            
	            circleNum = newcircleNum;
	        }
	        
	        return results;
	    }
	    
	    public void reverseNumbers(ArrayList<Integer> levelNumbers){
	        int levelSize = levelNumbers.size();
	        for(int i = 0, j = levelSize-1; i < j;i++,j--){
	            int temp = levelNumbers.get(i);
	            levelNumbers.set(i,levelNumbers.get(j));
	            levelNumbers.set(j,temp);
	        }
	        
	    }
}
