package leetcode151withexplain;

/**
 * �������⣺����һ��Ǹ����֣�a1�ʹ����ڵ�1�������߸߶�Ϊa1,����n���������ݣ����������֮����ݻ����
 * 
 * 
 * ����˼·���ʹ�ͳ�Ĵ��������ҵ�����Ԫ�صķ�����࣬���Ǵ����˿�ʼ���м�����������Ĵ�С���㷽ʽ�����������бȽ϶̵ĳ���������֮��ļ���� 
 *
 */
public class ContainerWithMostWater141 {
	
	 public int maxArea(int[] height) {    
        //A new function
        int totalSize = height.length;
        
        //�����������
        if(totalSize == 1){
            return height[0];
        }
        
        int mostWater = 0;
        int tempWater = 0;
        int left = 0;
        int right = totalSize-1;
        //�������������м�ѹ��
        while(left < right){
            
        	//�����ߴ����ұ�  ��ô�����ݻ��Ͱ��ұߵĸ߶�Ϊ׼
            if(height[left] > height[right]){
                tempWater = height[right] * (right-left);
            }else{
                tempWater = height[left] * (right-left);
            }
            
            //�ҵ���ǰ�����ֵ
            if(mostWater < tempWater){
                mostWater = tempWater;
            }
            
            //����ͷ���м�ѹ����Χ
            if(height[left] > height[right]){
                right--;
            }else{
                left++;
            }
            
        }
        return mostWater;
    }
	 
}
