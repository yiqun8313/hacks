package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺���������������ַ�����������
 * 
 *  For example,
	a = "11"
	b = "1"
	Return "100".
	
	����˼·��ͨ������arraylist���洢�ַ�����ÿһλ��Ȼ�����ν��м���Ϳ����ˡ������˽�λ�������85�����һ��
 *
 */
public class AddBinary087 {
	
	 	public String addBinary(String a, String b) {
	 		
	        int aLength = a.length();
	        int bLength = b.length();
	        ArrayList<Integer> alist = new ArrayList<Integer>();
	        ArrayList<Integer> blist = new ArrayList<Integer>();
	        //ͨ������arraylist���洢a��b�ַ�����ÿһλ  ������õ��ǵ���洢  �������㰴λ���м���
	        String result = "";
	        for(int i = 0; i < aLength; i++){
	            alist.add(0,Integer.parseInt(a.substring(i,i+1)));
	        }
	        
	        for(int j = 0; j < bLength; j++){
	            blist.add(0,Integer.parseInt(b.substring(j,j+1)));
	        }
	        
	        //��ס��λ
	        int k = 0;
	        int pluseNum = 0;
	        //�������   �������Ƶļ��㷽ʽ����
	        while(k < aLength && k < bLength){
	            int a1 = alist.get(k);
	            int b1 = blist.get(k);
	            
	            int sum = a1 + b1 + pluseNum;
	            if(sum >= 2){
	                sum = sum % 2;
	                result = String.valueOf(sum)+result;
	                pluseNum = 1;
	            }else{
	            	result = String.valueOf(sum)+result;
	                pluseNum = 0;
	            }
	            k++;
	        }
	        
	        //����aʣ��Ĳ���   ���μ���
	        if(k < aLength){
	            int i = k;
	            while(i < aLength){
	                int a2 = alist.get(i);
	                int sum = a2 + pluseNum;
	                if(sum >= 2){
	                    sum = sum % 2;
	                    result = String.valueOf(sum)+result;
	                    pluseNum = 1;
	                }else{
	                	result = String.valueOf(sum)+result;
	                    pluseNum = 0;
	                }
	                i++;
	                
	            }
	        }
	        
	        //����bʣ��Ĳ���  ���μ���
	        if(k < bLength){
	            int i = k;
	            while(i < bLength){
	                int b3 = blist.get(i);
	                int sum = b3 + pluseNum;
	                if(sum >= 2){
	                    sum = sum % 2;
	                    result = String.valueOf(sum)+result;
	                    pluseNum = 1;
	                }else{
	                	result = String.valueOf(sum)+result;
	                    pluseNum = 0;
	                }
	                i++;
	            }
	        }
	        
	        //���������Ľ�λ
	        if(pluseNum == 1){
	            result = String.valueOf(pluseNum)+result;
	        }
	        
	        
	        return result;
	    }
}
