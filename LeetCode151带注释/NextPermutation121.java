package leetcode151withexplain;

import java.util.Arrays;

/**
 * �������⣺����һ�����У�������һ�����С�
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
	1,2,3 �� 1,3,2
	3,2,1 �� 1,2,3
	1,1,5 �� 1,5,1
 *
 *	����˼·���Ӻ���ǰ���������Ƿ������ǰ�������С�ں������ֵ�������ҵ����С�ڵ�λ�ã�Ȼ���ҵ�С�ڵ����λ�ú������С�Ĵ���������ֵ����������λ�ã�Ȼ��Ժ����Ԫ������
 */
public class NextPermutation121 {
	
	public void nextPermutation(int[] num) {
        if(num.length == 0) return;
        
        int maxReverse = num[num.length - 1];  
        int index = -1;
        //�Ӻ��濪ʼ���������ܷ��ҵ�����������ҵ���ǰ��������
        for(int i = num.length - 2; i >= 0; --i)   
        {  
        	//��������ҵ��˱�ǰ��������
            if(maxReverse > num[i])  
            {  
            	//��¼ס���ڵ�����Ƚ�С������λ��
                index = i;  
                break;  
            }  
            else maxReverse =  num[i];  
        }  
        //not found
        //��û���ҵ���������ֱ�ǰ�����������ô�����򷵻ؾͿ�����
        if(index == -1)  
        {  
            Arrays.sort(num);  
            return;  
        }  
        else  
        {  
             //find the minimum bigger element  
            int minNum = num[index+1];  
            int minIdx = index+1;  
            for(int i = index+1; i < num.length; ++i)  
            {  
                if(num[i] > num[index] && num[i] < minNum)  
                {  
                    minNum = num[i];  
                    minIdx = i;  
                }  
            }  
            
            int temp = num[index];
            num[index] = num[minIdx];
            num[minIdx] = temp;
              
            sort(num,index+1);  
        }   
    }
    
	//������ָ��λ�ÿ�ʼ����
    public void sort(int[] num, int startPosition){
        for(int i = startPosition; i < num.length; i++){
            for(int j = startPosition; j < num.length-1; j++){
                if(num[j] > num[j+1]){
                    int temp = num[j];
                    num[j] = num[j+1];
                    num[j+1] = temp;
                }
            }
        }
    }
}
