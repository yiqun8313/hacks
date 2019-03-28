package leetcode151withexplain;

import java.util.Arrays;

/**
 * �������⣺����һ�������һ��Ŀ��ֵ�����������ҵ�����ֵ���ǵ�����ֵ�ĺ���ӽ�target��Ȼ������͡�
 * 
 * For example, given array S = {-1 2 1 -4}, and target = 1. The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 *
 */
public class ThreeSumClosest136 {
	
	public int threeSumClosest(int[] num, int target) {
        int result = 0;
        Arrays.sort(num);
        int numLength = num.length-1;
        
        //��ʼ��һ�����
        result = num[0]+num[numLength-1]+num[numLength];
        //����ÿһ��Ԫ����Ϊ��ʼԪ��
        for(int i = 0; i <= numLength; i++){
            int j = i+1;
            int k = numLength;
            //�Ӻ����Ԫ�����ҵ�����Ԫ��  ���ܷ��ҵ����
            while(j < k){
                int tempSum = num[i]+num[j]+num[k];
                if(tempSum == target){
                    return tempSum;
                }
                
                if(tempSum > target){
                    k--;
                }
                if(tempSum < target){
                    j++;
                }
                //�ҵ���ӽ���
                if(Math.abs(tempSum-target) < Math.abs(result-target)){
                    result = tempSum;
                }
                
            }
            
        }
        
        return result;
    }
}
