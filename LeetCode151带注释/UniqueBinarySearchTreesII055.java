package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺����n���������еı�ʾ0-n�����еĶ���������
 *  
 *  ����˼·��
 *  Ҳ�Ǳ���ÿһ��λ�ã���ÿһ��λ����Ϊ���ڵ㣬Ȼ������������������п��ܺ������������п��ܣ�Ȼ�������ϡ�������յĽ����
 *  
 *  ע��㣺�ݹ���õı߽�����Ҫ����
 *
 */
public class UniqueBinarySearchTreesII055 {
	//���ڵ�  ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; left = null; right = null; }
	}
	
	public ArrayList<TreeNode> generateTrees(int n) {
        return generateNodes(1,n,n);
    }
    
	//�ݹ鹹��   ��������  ��ʼ�ͽ���λ��   n�����ֵ
    public ArrayList<TreeNode> generateNodes(int start, int end,int n){
        ArrayList<TreeNode> currentResults = new ArrayList<TreeNode>();
        
        //�߽�����xinglong
        if(start > end){
            currentResults.add(null);
            return currentResults;
        }
        
        //�߽�����
        if(start == end){
            currentResults.add(new TreeNode(start));
            return currentResults;
        }
        
        //��ǰ�������  һ����Ϊ���ڵ� 
        for(int i = start; i <= end; i++){
        	//��ȡ�����������п���
            ArrayList<TreeNode> leftResults =  generateNodes(start,i-1,n);
            //��ȡ�����������п���
            ArrayList<TreeNode> rightResults =  generateNodes(i+1,end,n);
            //�����������  ���ӵ������
            for(int j = 0; j < leftResults.size(); j++){
                for(int k = 0; k < rightResults.size(); k++){
                    TreeNode newNode = new TreeNode(i);
                    newNode.left = leftResults.get(j);
                    newNode.right = rightResults.get(k);
                    currentResults.add(newNode);
                }
            }
        }

        return currentResults;
        
    }
	
}
