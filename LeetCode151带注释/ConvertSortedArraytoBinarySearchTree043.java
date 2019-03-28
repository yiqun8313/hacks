package leetcode151withexplain;

/**
 *  �������⣺����������ת��Ϊ����������
 *  
 *  ����˼·���ͽ�����ת��Ϊ�������������   �����м�λ����Ϊ���ڵ㣬�����Ϊ���������ұ���Ϊ���������ݹ���þͿ����ˡ�
 *
 */
public class ConvertSortedArraytoBinarySearchTree043 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode sortedArrayToBST(int[] num) {
        TreeNode answer = getBST(num,0,num.length-1);
        return answer;
	 }
	    
	 public TreeNode getBST(int[] num, int startPosition,int endPosition){
        if(num.length == 0){
            return null;
        }
        
        //�߽����� 
        if(startPosition == endPosition){
            return new TreeNode(num[startPosition]);
        }
        
        //��ȡ�м�ڵ���Ϊ���ڵ�
        int middlePosition = (endPosition + startPosition)/2;
        TreeNode root = new TreeNode(num[middlePosition]);
        
        //������
        if(startPosition <= middlePosition -1){
        	root.left = getBST(num, startPosition,middlePosition-1);
        }
        
        //������
        if(middlePosition < endPosition){
        	root.right = getBST(num, middlePosition+1,endPosition);
        }

        return root;
   }
}
