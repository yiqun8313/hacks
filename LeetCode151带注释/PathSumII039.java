package leetcode151withexplain;

import java.util.ArrayList;

/**
 * ������ϣ���������е������ڵ㵽Ҷ�ӽڵ�֮�͵��ڸ���ֵ������·��
 * 
 * ����˼·��ͨ�����ȱ����ķ�ʽ��ȡ����·����Ȼ������߽�������ʱ�򣬼��뵽�ܵĽ���С�
 * 
 * ע��㣺�ݹ���õ�ʱ�򣬴��ݵ���һ�����ƣ�������ԭ���Ĵ��룬��ΪӦ�û������ı䡣
 *
 */
public class PathSumII039 {

	//���ڵ� ���ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public  ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
		//����Ľ���˼·�Ǵ�ͳ��һ����·   ���Ի�ȡ���е�·��
		ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> likeStack = new ArrayList<Integer>();
		answers = getResults(answers, likeStack, root, sum);
		return answers;
    }
	
	public ArrayList<ArrayList<Integer>> getResults(ArrayList<ArrayList<Integer>> answers,ArrayList<Integer> likeStack,TreeNode root,int sum){
		
		if(root == null){
			return answers;
		}
		
		
		likeStack.add(root.val);
		//current node satisfies the condition
		if(root.left == null && root.right == null && root.val == sum){
			answers.add(likeStack);
		}
		
		
		//jude left
		if(root.left != null){
			//��ȫ������һ��  Ȼ�󴫵ݵ���һ�ֵ���
			ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			for(int i = 0; i < likeStack.size(); i++){
				newLikeStack.add(likeStack.get(i));
			}
			getResults(answers,newLikeStack,root.left,sum-root.val);
		}
		
		if(root.right != null){
			ArrayList<Integer> newLikeStack = new ArrayList<Integer>();
			for(int i = 0; i < likeStack.size(); i++){
				newLikeStack.add(likeStack.get(i));
			}
			getResults(answers,newLikeStack,root.right,sum-root.val);
		}
		
		
		return answers;
	}
	
}
