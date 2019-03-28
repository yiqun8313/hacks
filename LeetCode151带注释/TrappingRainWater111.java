package leetcode151withexplain;

/**
 * �������⣺����һ�����֣�����һ��bar�ĸ߶ȣ���Ϊ�β�룬���Ժܶ�ط����Դ�סˮ�����ܹ���ס����ˮ��
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
	
	For example, 
	Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
	
	https://oj.leetcode.com/problems/trapping-rain-water/
	
	һ��˼·���ҵ�ÿһ��λ���������߱��Լ��ߵ���Сֵ��Ȼ��Ϳ���֪����ǰλ�ÿ��Դ�ס����ˮ��
	
	����˼·��ͨ�����α������Ϳ����ҵ�ÿһ��λ��ǰ����ֵ�����bar��Ȼ������ÿһ��λ�õĴ�ˮ���Ϳ����ˡ�
 * 
 *
 */
public class TrappingRainWater111 {
	
 	public int trap(int[] A) {
        int result = 0;
        //�����������
        int aLength = A.length;
        if(aLength == 1 || aLength == 0){
        	return result;
        }
        
        
        int[] leftHeight = new int[aLength];
        int[] rightHeight = new int[aLength];
        
        //��������ɨ�裬��¼ס֮ǰ���ֵ�����bar
        int maxHeight = 0;
        for(int i = 0; i < aLength; i++){
            if(A[i] > maxHeight){
                maxHeight = A[i];
            }
            leftHeight[i] = maxHeight;
        }
        
        //��������ɨ�裬��¼ס֮ǰ���ֵ�����bar
        maxHeight = 0;
        for(int j = 0; j < aLength; j++){
            if(A[aLength - 1 - j] > maxHeight){
                maxHeight = A[aLength - 1 - j];
            }
            rightHeight[aLength - 1 - j] = maxHeight;
        }
        
        //Ȼ������ÿһ��λ�ÿ��Դ洢��ˮ���Ϳ�����
        int temp = 0;
        for(int k = 0; k < aLength; k++){
            temp = minNum(leftHeight[k],rightHeight[k]) - A[k];
            //���뱣֤����0
            if(temp > 0){
                result += temp;
            }
        }
       
        return result;
    }
    
    public int minNum(int a, int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
}
