package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *  �������⣺����һ������  Ȼ����������ҵ��Ӽ�   ���������������ظ���Ԫ��  ����Ƚ�����
 *  
 *  If S = [1,2,2], a solution is:
	[
	  [2],
	  [1],
	  [1,2,2],
	  [2,2],
	  [1,2],
	  []
	]
	
	����Ľ���˼·��������ȱ���   �����ǵ�ǰԪ�ص�ʱ���Լ������ǵ�ǰԪ�ص�ʱ��
	
	�߽��������ǣ��Ѿ�����������λ�ö��ҽ�����в�������ǰԪ��
 *
 */
public class SubsetsII060 {
	
	   public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
	       if(num.length == 0){
	           return new ArrayList<ArrayList<Integer>>();
	       }  
	       
	       //�ȶ������������
	       Arrays.sort(num);
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       return generateResults(results, tempResult,num,0);
	       
	    }
	    
	    //����������������·  �ܽ������ʱ���
	    public ArrayList<ArrayList<Integer>> generateResults(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int[] num,int n){
	        
	    	//�߽�����  �����ǰ�Ѿ�������������λ��   ���ҽ�����в���������ʱ���
	    	//����������  ���������ж�  contains
	        if(n == num.length && !results.contains(tempResult)){
	            ArrayList<Integer> currentResult = new ArrayList(tempResult);
	            results.add(currentResult);
	            return null;
	        }else if(n == num.length){
	            return null;
	        }
	        
	        //����м��ϵ�ǰԪ��
	        tempResult.add(num[n]);
	        generateResults(results, tempResult,num,n+1);
	        //����в�������ǰԪ��
	        tempResult.remove(tempResult.size()-1);
	        generateResults(results, tempResult,num,n+1);

	        //���ؽ��
	        return results;
	    } 
}
