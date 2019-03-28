package leetcode151withexplain;

import java.util.HashMap;

/**
 * �������⣺����һ�������Ŀ��ֵ�����������ҵ�����ֵʹ�����ΪĿ��ֵ�����������±�λ�á�
 * 
 * ����˼·��ͨ��һ��map�����洢ÿһ��λ���������ֵtarget-num[i]�Լ���ǰ������i���������������Ҫ����ֵ����ô����ͳ����ˡ�
 *
 */
public class TwoSum134 {
	
	public int[] twoSum(int[] numbers, int target) {
        int len = numbers.length;  
        
        //���ڼ�¼���
        int[] ret = new int[2];
        
        //hashmap
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();  
          
        for(int i = 0; i < len; i++){
        	//Ҳ��������   ����ÿһ��Ԫ��  �Ѹ�Ԫ�ػ���Ҫ����ֵ�����������ŵ�map��
            if( !map.containsKey(numbers[i]) ){  
                map.put(target - numbers[i], i);        // save another number  
            }  
             
            //���map���Ѿ�������  ���ҵ�������Ҫ��Ԫ��
            if( map.containsKey(numbers[i]) ){
            	//��ô�������˽��  
                int idx = map.get(numbers[i]);  
                if(idx < i){  
                    ret[0] = idx + 1;   // +1 for not zero-based  
                    ret[1] = i + 1;  
                }  
            }  
        }  
          
        return ret;  
    }
}
