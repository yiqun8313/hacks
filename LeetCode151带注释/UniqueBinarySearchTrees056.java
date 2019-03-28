package leetcode151withexplain;

/**
 *  �������⣺����n���ж��ж��ٸ����صĶ�������������������ʾ1-n
 *  
 *  Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

	For example,
	Given n = 3, there are a total of 5 unique BST's.
	
	   1         3     3      2      1
	    \       /     /      / \      \
	     3     2     1      1   3      2
	    /     /       \                 \
	   2     1         2                 3
	   
	����˼·��
 *	�ݹ���ã�ÿһ������Ϊ���ڵ��ʱ����������������Ȼ����ӾͿ���    �ݹ���õı߽������ǳ���Ҫ 
 */
public class UniqueBinarySearchTrees056 {
	
	public int numTrees(int n) {
		//�ݹ�ı߽�����  
        if(n == 0){
            return 1;
        }
        
        //�����һ���ڵ�  ����1
        if(n == 1){
            return 1;
        }
        
        //����������ڵ�  ����2
        if(n == 2){
            return 2;
        }

        //�����ӿ�ʼ������  �����������������������
        int result = 0;
        for(int i = 1; i <= n; i++){
            result +=  numTrees(i-1) * numTrees(n-i);
        }
        
        return result;
           
    }
}
