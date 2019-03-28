package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺�������ױ��룬��ν�ĸ��ױ���������ڵ����������Ʊ���ֻ�����һλ��
 *  
 *   For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

		00 - 0
		01 - 1
		11 - 3
		10 - 2
		
	�������⣺���ױ����ʵ�ַ�ʽ����   i xor i/2
	
	ע��nSize����  1 << n�͵��� 1 * 2^n
 *
 */
public class GrayCode062 {
	
	public ArrayList<Integer> grayCode(int n) {
        
		ArrayList<Integer> result = new ArrayList<Integer>();
   	
   	    //left move to know n has how many binary results 3 -> 8    0001 << 3  1000 = 8
   	    //�������͵���1 * 2^n�η�
		int nSize = 1 << n;  
   	    
        for (int i = 0; i < nSize; ++i)  
        {  
       	 	//convert binary to gray code i xor (i >> 1)
        	int a = i >> 1;
        	int b = a ^ i;
       	 
            result.add(b);  
        }  
        return result;  
   }
}
