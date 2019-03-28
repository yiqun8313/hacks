package leetcode151withexplain;

/**
 * �������⣺����һ����άn*n���󣬴���һ��ͼ�񣬷��������ҷ�ת90��֮���ͼ�����
 * 
 *	����˼·��ͨ��һ����ʱ�����סԭ���ľ���Ȼ���ڸ�ֵһ��Ϳ�����
 */
public class RotateImage105_Done {
	
	public void rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] tempmatrix = new int[n][n];
        
        //��һ��temp����洢ԭ�������е�����ֵ
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                tempmatrix[i][j] = matrix[i][j];
            }
        }
        
        //����һ�����¸�ֵ������
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[j][n-1-i] = tempmatrix[i][j];
            }
        }
        
    }
	
	//ͨ���ȶԽ��߽�����Ȼ�������½����Ϳ����ˡ�
	public void rotate1(int[][] matrix) {
        int n = matrix.length;
        if(n <= 1) return;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - i; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][n-1-i];
                matrix[n-1-j][n-1-i] = temp;
            }
        }
        
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        
        
    }
}
