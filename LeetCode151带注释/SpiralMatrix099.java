package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺��94���ֻ࣬��94�����ڹ���һ����ά��������ֻ�����ڶ�ȡһ������
 * 
 * ���ⷽʽ������ͨ���߽�����Ȼ������˳��������
 * 
 *
 */
public class SpiralMatrix099 {
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> ivec = new ArrayList<Integer>();
        
        if(matrix.length == 0) return ivec;
        int begin_rows = 0, end_rows = matrix.length - 1;
        int begin_cols = 0, end_cols = matrix[0].length - 1;
        while(true)
        {
            //up border: left -> right
            for(int i = begin_cols; i <= end_cols; ++i)
                ivec.add(matrix[begin_rows][i]);
         
            //right border: up -> down, 
            if(++begin_rows > end_rows)//can't go down anymore
            break;
            for(int j = begin_rows; j <= end_rows; ++j)
                ivec.add(matrix[j][end_cols]);
            //down border: right -> left
            if(--end_cols < begin_cols)
            break;
            for(int i = end_cols; i >= begin_cols; --i)
                ivec.add(matrix[end_rows][i]);
            //left border: down -> up
            if(--end_rows < begin_rows)
            break;
            for(int j = end_rows; j >= begin_rows; --j)
                ivec.add(matrix[j][begin_cols]);
            if(++begin_cols > end_cols)
            break;
        }
        return ivec;
    }
}
