package leetcode151withexplain;

/**
 *  �������⣺����һ������   �Ѿ�����Ϊ0�����е�Ԫ�ص��к��ж����0 
 *	
 *	����˼·��ͨ��һ�������¼סԭ�������е�0��λ�á�Ȼ������þ�������ı��Ϊ��Ȼ���޸�ԭ��������к��оͿ����ˡ�
 *
 *	����ע�⣺֮������һ���µľ����¼ԭ��������0��λ�ã�������Ϊ����ԭ�����������޸ĵĻ�����Ӱ�������ж�
 */
public class SetMatrixZeroes079 {
	
	
	 public void setZeroes(int[][] matrix) {
	        int m = matrix.length;
	        int n = matrix[0].length;
	        
	        //��һ������  ���ڼ�¼ԭ��Ϊ0��λ��
	        int[][] zeroPlace = new int[m][n];
	        
	        int i;
	        int j;
	        //��ʼ��zeroPlace
	        for(i = 0; i < m; i++){
	            for(j = 0; j < n; j++){
	                if(matrix[i][j] == 0){
	                   zeroPlace[i][j] = 1;
	                }
	            }
	        }
	        
	        //����ԭ�е�����
	        for(i = 0; i < m; i++){
	            for(j = 0; j < n; j++){
	                if(zeroPlace[i][j] == 1){
	                   setZerosDetail(matrix, i, j);
	                }
	            }
	        }
	    }
	    
	 	//�Ѷ�ӦԪ�ص��к�������Ϊ0
	    public void setZerosDetail(int[][] matrix, int x, int y){
	        int m = matrix.length;
	        int n = matrix[0].length;
	        for(int i = 0; i < m; i++){
	            matrix[i][y] = 0;
	        }
	        
	        for(int j = 0; j < n; j++){
	            matrix[x][j] = 0;
	        }
	    }
	    
	    
	    
	    
	    //another function
	    
	    public static void setZeroes1(int[][] matrix) {
	        int m = matrix.length;
	        if(m == 0) return;
	        int n = matrix[0].length;
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(matrix[i][j] == 0){
	                    matrix[0][j] = 0;
	                }
	            }
	        }
	        
	        for(int i = 1; i < m; i++){
	            if(matrix[i][0] == 0){
	                for(int j = 1; j < n; j++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for(int j = 1; j < n; j++){
	            if(matrix[0][j] == 0){
	                for(int i = 1; i < m; i++){
	                    matrix[i][j] = 0;
	                }
	            }
	        }
	        
	        for(int i = 0; i < m; i++){
	            if(matrix[i][0] == 0){
	                for(int j = 0; j < m; j++){
	                    matrix[j][0] = 0;
	                }
	                break;
	            }
	        }
	        
	        for(int j = 0; j < n; j++){
	            if(matrix[0][j] == 0){
	                for(int i = 0; i < n; i++){
	                    matrix[0][i] = 0;
	                }
	            }
	            break;
	        }
	        
	    }
	    
	    public static void main(String[] args){
	    	int[][] matrix = {{1,1,1},{0,1,2}};
	    	SetMatrixZeroes079.setZeroes1(matrix);
	    	
	    }
}
