package leetcode151withexplain;

/**
 *  �������⣺����һ��������������ͺ�������  ���������
 *  
 *  ����˼·��
 *  ����������ص��ǣ����ڵ���ߵ����ݱ��������������ڵ㣬���ڵ���ұߵ����ݱ��������������ڵ㡣
 *  ����������ص��ǣ����ڵ������������һ���ڵ㡣
 *  
 *  �ȴӺ�������л�ȡ���һ���ڵ㣬Ҳ���ǻ�����������ĸ��ڵ㣻Ȼ�����������л������ڵ��λ�ã���ô��֪�������������ڵ���������ڵ��ǡ���ô���������ǰ�沿��Ҳ���������ĺ�����������������
 *  �ĺ��沿��Ҳ���������ĺ����������֡�����Ϊ�϶����ȱ�������ٱ������ұߣ�
 *  
 *  ͨ���ݹ���ã��Ϳ��Թ�������ôһ������
 *
 */
public class ConstructBinaryTreefromInorderandPostorderTraversal045 {
	//���ڵ�����ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0){
            return null;
        }
        
        TreeNode result = buildDetail(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
        return result;
    }
    
    //�ݹ鹹����  ָ��һ��������  ���������Ŀ�ʼλ�úͽ���λ��
    public TreeNode buildDetail(int[] inorder, int inbegin,int inend, int[] postorder,int postbegin,int postend){
        
    	//�߽�����
        if(inbegin > inend){
            return null;
        }
        
        int postLast = postorder[postend];
        
        //������������ҵ����ڵ�λ��
        int inorderPosition = 0;
        for(int i = inbegin; i <= inend; i++){
            if(inorder[i] == postLast){
                inorderPosition = i;
                break;
            }
        }
        int len = inorderPosition - inbegin;
        
        //�ݹ����  ������
        TreeNode root = new TreeNode(postLast);
        root.left = buildDetail(inorder, inbegin,inbegin+len-1, postorder,postbegin,postbegin+len-1);
        root.right = buildDetail(inorder, inbegin+len+1,inend, postorder,postbegin+len,postend-1);
        
        return root;
        
    }
}
