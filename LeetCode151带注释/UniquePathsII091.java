package leetcode151withexplain;

/**
 *	�������⣺����һ����ά���󣬾����е�1��ʾ�ϰ�  0��ʾ�ո����  �ʴ����Ͻǵ����½�һ���ж�����·�� 
 *	
 *	����˼·��ͨ��dp�ķ�ʽ������ֵ��
 *	
 *	ע��㣺��ʼ����ʱ�򣬱�����ʣ��λ��ҲҪ��ֵΪ-1
 */
public class UniquePathsII091 {
	
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        //��ά����
        int[][] f = new int[m][n];
        
        //��ʼ����һ��   ������ϰ�����1 ��ô����Ŀ϶�����0��
        int i;
        for(i = 0; i < m; i++){
        	//����һ���ϰ�  ��ô����Ķ���0 ֱ��break������
            if(obstacleGrid[i][0] == 1){
                break;
            }else{
                f[i][0] = 1;
            }
        }
        
        //����λ�ó�ʼ��Ϊ-1
        for(;i < m; i++){
            f[i][0] = -1;
        }
        
        //��ʼ����
        for(i = 0; i < n; i++){
            if(obstacleGrid[0][i] == 1){
                break;
            }else{
                f[0][i] = 1;
            }
        }
        
        for(;i < n; i++){
            f[0][i] = -1;
        }
        
        //���ƹ�ʽ������ֵ
        for(i = 1; i < m; i++){
        	for(int j = 1; j < n; j++){
        		//������ϰ�  ֱ������
        		if(obstacleGrid[i][j] == 1){
        			continue;
        		}
        		
        		//��ߺ��ϱ߶���-1  ��ֵΪ-1
        		if(f[i-1][j] == -1 && f[i][j-1] == -1){
        			f[i][j] = -1;
        		}
        		
        		//���һ����-1  һ�߲���
        		if(f[i-1][j] == -1 && f[i][j-1] != -1){
        			f[i][j] = f[i][j-1];
        		}
        		
        		if(f[i-1][j] != -1 && f[i][j-1] == -1){
        			f[i][j] = f[i-1][j];
        		}
        		
        		//������߶�����-1
        		if(f[i-1][j] != -1 && f[i][j-1] != -1){
        			f[i][j] = f[i-1][j] + f[i][j-1];
        		}
        		
        	}
        }
        
        if(f[m-1][n-1] == -1){
            return 0;
        }else{
            return f[m-1][n-1];
        }
    }
}
