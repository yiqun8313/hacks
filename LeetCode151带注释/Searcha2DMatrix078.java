package leetcode151withexplain;

/**
 *  �������⣺����һ����ά����ÿһ�е����ֶ��ǵ�����ÿһ�еĵ�һ������������һ�е����һ����
 *	
 *	����˼·��ͨ�����ζ��ֲ��ҵķ�ʽ�� �����ҵ�����һ��  �����ҵ�����һ��
 *
 *	����˼·���ܹ��������е�i��jת��Ϊ�����ϵ�ĳһ��ֵ��Ȼ��ͨ�����ַ�����ȡ������ֵ�Ϳ����ˡ�
 */
public class Searcha2DMatrix078 {

	public boolean searchMatrix(int[][] matrix, int target) {
        int rowNum = getColumnPosition(matrix, target);
        if(rowNum == -1) return false;
        
        int columnNum = getRowPosition(matrix,rowNum,target);
        if(columnNum == -1) return false;
        else return true;
    }
    
	public int getRowPosition(int[][] matrix,int rowindex, int target){
        int columns = matrix[rowindex].length;
        
        int left = 0;
        int right = columns-1;
        int middle = -1;
        //���ֲ��ҵķ�ʽ�ҵ�Ԫ��
        while(left <= right){
            middle = (left + right) >> 1;
            if(matrix[rowindex][middle] == target){
                return middle;
            }
            
            if(matrix[rowindex][middle] > target){
                right = middle-1;
            }else{
                left = middle+1;
            }
            
        } 
        

        return -1;
    }
    
	//��ȡ����һ��
    public int getColumnPosition(int[][] matrix, int target){
        int rows = matrix.length;
        //�������һ��  ��ô������һ�е��кžͿ���
    	if(rows == 1){
    		return 0;
    	}
    	
    	//�ж����һ���Ƿ������������������ԣ��򷵻�
        if(matrix[rows-1][0] <= target){
            return rows-1;
        }
        
        //һ�δӿ�ʼ������������������������к�
        for(int i = 0; i < rows-1; i++){
            if(matrix[i][0] <= target && matrix[i+1][0] > target){
                return i;
            }
        }
        
        return -1;
    }
}
