package leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * �������⣺���������е�һ�����֣��ҵ�����ȱʡ�ĵ�һ��������
 * 
 *  For example,
	Given [1,2,0] return 3,
	and [3,4,-1,1] return 2.
	Your algorithm should run in O(n) time and uses constant space.
 * 
 * ����˼·:��ͨ��һ�α�����ȡ���ֵ��
 * Ȼ���1��ʼ���������ֵ����map�Ƿ���ھͿ����ˡ�
 *
 */
public class FirstMissingPositive112_Done {
	
	public int firstMissingPositive(int[] A) {
        int minPositiveInt = Integer.MAX_VALUE;
        int maxPositiveInt = Integer.MIN_VALUE;
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        
        //���������е�ÿһ��Ԫ��
        int aLength = A.length;
        for(int i = 0; i < aLength; i++){
            if(A[i] <= 0){
                continue;
            }else{
            	//��ȡ��ǰ���ֵ���Сֵ
                minPositiveInt = min(A[i],minPositiveInt);
                //��ȡ��ǰ���ֵ����ֵ
                maxPositiveInt = max(A[i],maxPositiveInt);
                //ѹ�뵽map��
                map.put(A[i],1);
            }
        }
        
        //��1��ʼ������һֱ�����ֵ���������Ϊ�յģ���ô�������������
        for(int k = 1; k <= maxPositiveInt+1;k++){
            if(map.get(k) == null){
                return k;
            }
        }
        
        return 1;
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
    
    public int min(int a ,int b){
        if(a < b){
            return a;
        }else{
            return b;
        }
    }
    
    
    public int firstMissingPositive1(int[] A) {
    	// Note: The Solution object is instantiated only once and is reused by each test case.  
        int n  = A.length;
    	if(null == A || n < 1)                                                                                                                                     
            return 1;
    	
        int pos=0;  
        while(pos < n){
        	
        	//1��������Ԫ���Ǵ���0��Ԫ�� 2��������Ԫ�ز����Լ���λ����  3��Ԫ��ֵ����û�г�������ĳ��ȣ����н�����λ��  4����Ҫ�����ĵط������ݺ͵�ǰ�����ݲ����  �����ȣ���ô�Ͳ����滻��
            if(A[pos] > 0 && A[pos] != pos+1 && A[pos] - 1 < n && A[pos] != A[A[pos]-1]){                                                                                                                                                  
                swap(A,pos,A[pos]-1);     
            }else{  
                ++pos;
            }
        }     
        
        for(int i=0;i<n;++i)  
        {     
            if(i+1 != A[i])  
                return i+1;                                                                                                                                    
        }
        
        return n+1;  
    }
    
    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
}
