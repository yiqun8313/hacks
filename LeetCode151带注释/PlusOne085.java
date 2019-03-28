package leetcode151withexplain;

import java.util.ArrayList;

/**
 *  �������⣺����һ�����飬�������һ���Ǹ�������Ȼ��Ϊ���������һ�����ؽ������
 *  
 *  ����˼·: ͨ��һ��Arraylist���洢�����е�ÿһλ�����������Ľ�λ����
 *
 */
public class PlusOne085 {
	
		public int[] plusOne(int[] digits) {
	        ArrayList<Integer> result = new ArrayList<Integer>();
	        //��¼��λ�Ƕ���
	        int plusNum = 0;
	        int digitSize = digits.length;
	        
	        //����������λ�ÿ�ʼ���������������
	        for(int i = 0; i < digitSize; i++){
	            int currentNum = digits[digitSize-1-i];
	            if(i == 0){
	                currentNum += 1;
	            }
	            
	            //���>= 10
	            if((currentNum + plusNum) >= 10){
	            	//ȥ�������ͽ�λ
	                currentNum = (currentNum + plusNum) % 10;
	                plusNum = 1;
	            }else{
	                currentNum = currentNum + plusNum;
	                plusNum = 0;
	            }
	            
	            //���ӵ����
	            result.add(0,currentNum);
	        }
	        
	        //���������һλ
	        if(plusNum == 1){
	            result.add(0,1);
	        }
	        
	        //Ϊ��Խ�����⣬����arraylist���洢���ݣ�Ȼ�����������洢
	        int answerSize = result.size();
	        int[] answer = new int[answerSize];
	        for(int j = 0; j < answerSize; j++){
	            answer[j] = result.get(j);
	        }
	        
	        return answer;
	        
	    }
}
