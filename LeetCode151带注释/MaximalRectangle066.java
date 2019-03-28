package leetcode151withexplain;

import java.util.Stack;

/**
 *  �������⣺����һ����ά����  �����ж���0����1  �ҳ���������������1������������ 
 *
 *	�������˼·��
 *  1�����Ƚ������ǣ���һ�����飬����Ԫ�ص�ֵ������εĸ߶ȣ������Щ���ι��ɵ���������
 *  2������һ����ά�����ܹ���¼סÿһ�д��ϵ��µ�1ֵ�ȶ��١�Ȼ��һ��һ�еļ��� ���������������.
 */
public class MaximalRectangle066 {
	
	public int maximalRectangle(char[][] matrix) {
		//��ȡ����ĳ��Ϳ�
        int m = matrix.length;
        if(m == 0) return 0;
        int n = matrix[0].length;
        if(n == 0) return 0;
        
        //��ʼ����һ������
        int[][] f = new int[m][n];
        for(int i = 0; i < n; i++){
            f[0][i] = matrix[0][i] == '1'? 1 : 0;
        }
        
        //������ά����f,��ά�����е�f[m][n]��¼����m���е�0�д��ϵ�n����1����Ŀ
        for(int i = 0; i < n; i++){
            for(int j = 1; j < m; j++){
                f[j][i] = matrix[j][i] == '1'? f[j-1][i] + 1 : 0;
            }
        }
        
        //һ��һ�еı�������   ÿһ�ж����Ի��һ�����ľ������   ����������
        int maxarea = 0;
        int temparea = 0;
        for(int k = 0; k < m; k++){
            temparea = getlargestRectangle(f[k],n);
            if(temparea > maxarea){
                maxarea = temparea;
            }
        }
        
        return maxarea;
    }
    
	
	//����һ������  ����Ԫ�ش�С�������εĸ߶�  ������ľ���
    public int getlargestRectangle(int[] height,int length){
         int size = length;
         //����ջ�͸߶�ջ
		 Stack<Integer> indexStack = new Stack<Integer>();
		 Stack<Integer> heightStack = new Stack<Integer>();
		 
		 int maxarea = 0;
		 int temparea = 0;
		 for(int i = 0; i < size; i++){
			 
			 //���ջΪ�ջ��ߺ����ĸ߶ȴ���֮ǰѹ��ĸ߶�  ��ô��ѹ��ջ��
			 if(indexStack.isEmpty() == true || height[i] > heightStack.peek()){
				 indexStack.push(i);
				 heightStack.push(height[i]);
			 //��Ҫѹ��ĸ߶�С��ջ���ĸ߶�ʱ
			 }else if(height[i] < heightStack.peek()){
				 //lastindex���ڼ�¼�±�  ������ε�ʱ����Ǿ��εĿ��
				 int lastindex = 0;
				 //����ѭ�������߶�
				 while(indexStack.isEmpty() == false && height[i] < heightStack.peek()){
					 lastindex = indexStack.pop();
					 //�������
					 temparea = heightStack.pop() * (i - lastindex);
					 if(temparea > maxarea){
						 maxarea = temparea;
					 }
				 }
				 //������͸߶�ѹ�����
				 indexStack.push(lastindex);
				 heightStack.push(height[i]);				 
			 }
			 
		 }
		 
		 //���ڵ�����Լ�һֱѹ��������
		 while(!indexStack.isEmpty()){
			 temparea = heightStack.pop() * (size - indexStack.pop());
			 if(temparea > maxarea){
				 maxarea = temparea;
			 }
		 }
		 
		 return maxarea;
    }
}
