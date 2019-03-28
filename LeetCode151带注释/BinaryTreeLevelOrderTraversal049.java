package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺����һ�ö�����  ����η��ض��������
 *  
 *   Given binary tree {3,9,20,#,#,15,7},
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its level order traversal as:
	[
	  [3],
	  [9,20],
	  [15,7]
	]
	
	�������˼·��ͨ��������ȱ����ķ�ʽ��һ��һ��Ļ�ȡ���еĽڵ㣬��һ������������һ��εĽڵ����Ŀ��
	
	�Ժ�Ҳ���õ���ģ����У�������ȱ�������������¼סÿһ����νڵ����Ŀ������ȡ�ڵ����ݵ�ʱ��֪��ȡ��ʲôλ��
 *
 */
public class BinaryTreeLevelOrderTraversal049 {
	
	//���ڵ� ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<ArrayList<Integer>>();
        }
        
        //���ڴ洢���
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        //���ڼ�¼ÿһ��Ľ��
        ArrayList<Integer> levelNumbers = new ArrayList<Integer>();
        //����ģ�¶���
        ArrayList<TreeNode> likeQueue = new ArrayList<TreeNode>();
        likeQueue.add(root);
        
        int circleNum = 1;
        while(likeQueue.size() > 0){
            levelNumbers = new ArrayList<Integer>();
            //��likequue�л�ȡ����   ���뵽��ǰ��ν���� 
            int i = 0;
            while(i < circleNum){
                levelNumbers.add(likeQueue.get(i).val);
                i++;
            }
            //���ӵ������
            results.add(levelNumbers);
            
            
            i = 0;
            //���ڼ�¼��һ����ж��ٽڵ�
            int newcircleNum = 0;
            while(i < circleNum){
            	//��ȡ���е�ͷ��㣬Ȼ�������Һ��Ӷ�ѹ�뵽������
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
            
            //�����µ���ֵ���Ƹ�circle��������һ��ѭ��ʹ��
            circleNum = newcircleNum;
        }
        
        return results;
    }
}
