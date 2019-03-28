package leetcode151withexplain;


/**
 * ��������������������  Ȼ�󹹽���
 * 
 * ��������ص㣺��һ������Ƕ�Ӧ���ĸ��ڵ�
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal046 {
	//���ڵ�����ݽṹ
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0){
            return null;
        }
        
        TreeNode result = buildDetail(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
        return result;
        
    }
    
    //recursive
    public TreeNode buildDetail(int[] preorder, int prebegin, int preend,int[] inorder,int inbegin,int inend){
        if(prebegin > preend){
            return null;
        }
        
        int preorderFirst = preorder[prebegin];
        int inorderPosition = 0;
        for(int i = inbegin; i <= inend; i++){
            if(inorder[i] == preorderFirst){
                inorderPosition = i;
                break;
            }
        }
        
        int len = inorderPosition - inbegin;
        
        TreeNode root = new TreeNode(preorderFirst);
        root.left = buildDetail(preorder, prebegin+1, prebegin+len,inorder,inbegin,inorderPosition-1);
        root.right = buildDetail(preorder, prebegin+len+1, preend,inorder,inorderPosition+1,inend);
        
        return root;
        
        
    }
}
