package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �������⣺����һ���ַ���������������ظ������֣����������ҵ���������ʹ���������ĺ�Ϊ0.����е�Ԫ�ذ�����˳�����У�������в������ظ���
 * 
    For example, given array S = {-1 0 1 2 -1 -4},
    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)
 *
 *	����˼·�����������е�ÿһ��Ԫ�أ�������ǵ�һ��Ԫ�أ�Ҳ����ȥ�أ����ں����Ԫ�أ�ͬ�����԰������ͷβ����������Ԫ�أ���������Ԫ�صĹ����п���ȥ�ء���Ϊ���淲�ǿ��ǹ���Ԫ�ؾ�û��Ҫ�ٿ����ˡ�
 */
public class ThreeSum135 {
	
	public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
	  
		//���ڼ�¼���
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
	    //�����������
	    if (num.length == 0) return ret;
	    //�����������
	    Arrays.sort(num);
	    
	    int numLength = num.length;
	    //����֮���ǰ�濪ʼ����
	    for(int i = 0; i < numLength; i++){
	        //������ǵ�һ��Ԫ�أ����ҳ������ظ�����ô������
	        if (i != 0 && num[i] == num[i-1]){
	            continue;
	        }
	        
	        //�ڸ�Ԫ�غ����ҵ��������ֵĺ�Ϊָ��Ԫ��
	        int front = i + 1;
	        int back = numLength - 1;
	        //��frontС��back��ʱ��  �����жϵ�ǰ��Ԫ���Ƿ��Ǻ��ʵ�
	        while (front < back)
	        {
	            int sum = num[i] + num[front] + num[back];
	            
	            //����ʹ���0  ������ǰ��
	            if (sum > 0)
	            {
	                --back;
	            }
	            else if (sum < 0)
	            {
	                ++front;
	            }
	            //������Ǻ���i+1��n����ĵ�һ��Ԫ�أ����Һ�ǰ�����ֵһ������ô��������ȥһ��
	            else if (front != (i + 1) && num[front] == num[front - 1])
	            {
	                ++front;
	            }
	            //������Ǻ���Ԫ���е����һ��Ԫ�أ������Ԫ�غͺ����Ԫ��һ������ô������һ��Ԫ��
	            else if (back != (numLength - 1) && num[back] == num[back + 1])
	            {
	                --back;
	            }
	            
	            else
	            {
	            	ArrayList<Integer> result = new ArrayList<Integer>();
	                
	                // Already sorted.
	                result.add(num[i]);
	                result.add(num[front]);
	                result.add(num[back]);
	                
	                ret.add(result);
	                
	                ++front;
	                --back;
	            }
	        }
	    }
	    
	    return ret;
  }
}
