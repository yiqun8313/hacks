package leetcode151withexplain;

/**
 *	 �������⣺����һ����ά����Ȼ������Ͻǵ�startλ�ÿ�ʼ�����½ǵ�finishλ�ý���  Ϊһ���ж���·��
 *
 *	����˼·��ͨ��dp�ķ�ʽ��ȡ���
 *
 *	����һЩ����������ܷ�����⣬�ܶ����ͨ��dp�ķ�ʽ��ȡ��
 *  
 */
public class UniquePaths090 {
	//f[i][j] = f[i-1][j] + f[i][j-1]
    public int uniquePaths(int m, int n) {
        
    	 //����һ����ά����
         int[][] f = new int[m][n];
        
         //��ʼ����һ�к͵�һ��  ��Ϊֻ�������ߺ�������   ���Զ���ʼ��Ϊ1
         for(int i = 0; i < n; i++)
            f[0][i] = 1;
             
         for(int i = 0; i < m; i++)
             f[i][0] = 1;
             
         //�����ط�����ֵ�͵�������Ľ��������ߵĽ��
         for(int i = 1; i < m; i++)
             for(int j = 1; j < n; j++)
                 f[i][j] = f[i-1][j] + f[i][j-1];
                 
        return f[m-1][n-1];
    }
}
