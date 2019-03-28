package leetcode151withexplain;

/**
 *  �������⣺����һ����ά����ÿһ�������ǷǸ��ġ������Ͻǵ����½���̵�·�����Ƕ��٣� ֻ�������Զ��������ƶ��� 
 *	
 *	����˼·����ΪֻҪ��ȡ��С�;Ϳ���  ���Կ���ͨ��dp�ķ�ʽ��ȡ
 */
public class MinimumPathSum089 {
	
	public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;
        
        //��ʼ����һ��
        int tempSum = grid[0][0];
        for(int i = 1; i < rows; i++){
            tempSum += grid[i][0];
            grid[i][0] = tempSum;
        }
        
        //��ʼ����һ��
        tempSum = grid[0][0];
        for(int j = 1; j < columns; j++){
            tempSum += grid[0][j];
            grid[0][j] = tempSum;
        }
        
        //dp[i][j] = min(dp[i-1][j]+dp[i][j],dp[i][j-1]+dp[i][j])
        for(int p = 1; p < rows; p++){
            for(int q = 1; q < columns; q++){
                grid[p][q] = getMinNum((grid[p-1][q]+grid[p][q]),(grid[p][q-1]+grid[p][q]));
            }
        }
        
        //�������еĽ���Ϳ���
        return grid[rows-1][columns-1];
    }
    
    public int getMinNum(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
