package leetcode151withexplain;

/**
 * �������⣺Ѱ�Ҷ������е����·���ͣ���ʼ�ڵ�������κνڵ� 
 *
 *  ������ѵ����ڿ�ʼ�ڵ�ͽ����ڵ�������⡣ͨ��һ��ȫ�ֱ���max��¼ס����·���͡�
 *  
 *  maxSum�������ص��ǵ�ǰ�ڵ�ֵ���Լ���ǰ�ڵ�������������ֵ���Լ���ǰ�ڵ�������������ֵ��
 *  Ȼ�����ֵ��ͨ����¼��ǰ�ڵ���������ֵ�������ֵ֮��ͼ�¼�е����ֵ���Ƚϡ�
 *  
 *  
 *  �����뷨�������Ŀ���Դ���ײ����𣬱���������ڵ㣬һ���Ǹ��ڵ㣬һ������һ���Һ��ӣ�maxSum�����ص��Ǹ��ڵ㣬���ڵ�+���ӣ����ڵ�+�Һ�����������ֵ�������ֵ���ṩ���ϲ���õ�ʱ���ϲ���Ҫ֪��
 *  �Լ��������Ӻ��Һ�������������ӵ����ֵ�Ƕ��٣��������ӵĸ�����ָ��һ���ߡ���maxsum�����ʱ�̵�ǰ�ڵ���Ϊ���ڵ�������ڵ����·������ʲô�����ʱ���ֵ���Ǹ��ڵ���ϷǸ������ӣ����ϷǸ����Һ��ӡ�
 *  
 */
public class BinaryTreeMaximumPathSum027_Hard {

	//�������ڵ�
	class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	
	int max = Integer.MIN_VALUE;  
    
    public int maxSum(TreeNode root) {  
        if(root==null) {  
            return 0;  
        }  
          
        int  value  = root.val;  
        int  lmax = 0;  
        int  rmax = 0;  
        
        if(root.left != null) {  
            lmax = maxSum(root.left);  
            if(lmax>0) {  
                value  += lmax;  
            }  
        }  
          
        if(root.right != null) {  
            rmax = maxSum(root.right);  
            if(rmax > 0) {  
                value  += rmax;  
            }  
        }  
        //�������ֵ  
        //max is the max of {root.val,root.val+lmax,root.val+rmax, root.val + lmax + rmax}  
        if (value > max) {  
            max = value;  
        }  
        //����ֵ  
        //return max of (root.val, root.val + lmax, root.val + rmax)  
        return  Math.max(root.val,Math.max(root.val + lmax, root.val + rmax));  
    }  
      
    
    public int maxPathSum(TreeNode root) {  
        if(root==null) {  
            return 0;  
        }  
        maxSum(root);  
        return max;  
    } 
}
