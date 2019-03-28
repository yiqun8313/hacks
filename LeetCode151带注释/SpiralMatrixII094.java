package leetcode151withexplain;

/**
 *	�������⣺����n,����һ����ά�����������С�
 *	For example,
	Given n = 3,
	
	You should return the following matrix:
	[
	 [ 1, 2, 3 ],
	 [ 8, 9, 4 ],
	 [ 7, 6, 5 ]
	]
	
	����˼·��ͨ�����ñ߽磬Ȼ������˳��Ϊ����ֵ��
 *
 */
public class SpiralMatrixII094 {
	
	public int[][] generateMatrix(int n) {
		//�������
        int[][] answer = new int[n][n];
        if(n == 0) return answer;
        
        //��ʼ�кͽ�����
        int startRow = 0;
        int endRow = n-1;
        //��ʼ�кͽ�����
        int startCol = 0;
        int endCol = n-1;
        
        int item = 1;
        while(true){
        	//�������ұ���һ��
            for(int i = startCol; i <= endCol; i++){
                answer[startRow][i] = item;
                item++;
            }
            //startRow++�ж��Ƿ�Խ��
            if(++startRow > endRow) break;
            
            //��������
            for(int j = startRow; j <= endRow; j++){
                answer[j][endCol] = item;
                item++;
            }
            if(--endCol < startCol) break;
            
            //��������
            for(int k = endCol; k >= startCol; k--){
                answer[endRow][k] = item;
                item++;
            }
            
            //��������
            if(--endRow < startRow) break;
            for(int p = endRow; p >= startRow; p--){
                answer[p][startCol] = item;
                item++;
            }
            if(++startCol > endCol) break;
        }
        
        return answer;
    }
}
