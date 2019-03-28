package leetcode151withexplain;

import java.util.ArrayList;

/**
 *	 �������⣺����n��k����������ϳ���1-n������k��������ϡ�
 *	If n = 4 and k = 2, a solution is:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
 *
 */
public class Combinations075 {
	
	 	public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       //��ͳ�Ľ���˼·  �ɽ��������ʱ�������
	       getCombineResult(results, tempResult,n, 1, 1,k);
	       return results;
	    }
	    
	 	/**
	 	 * ��������
	 	 * @param results  �����
	 	 * @param tempResult  ��ʱ���
	 	 * @param n �������ֵ 
	 	 * @param currentN  ��ǰ���˵ڼ�����
	 	 * @param currentK  ��ǰ���˼�����
	 	 * @param k ���ԷŶ�����
	 	 */
	    public void getCombineResult(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int n, int currentN, int currentK,int k){
	        //��ǰ��Ŀû�дﵽҪ������ֶ���  ���Һ��治������������
	        if(currentK != (k+1) && currentN > n){
	            return;
	        }
	        
	        //��ǰ���ִչ���  ���� �Ѿ���������λ��  ���뵽�������
	        if(currentK == (k+1) || currentN > n){
	            results.add(new ArrayList(tempResult));
	            return;
	        }
	        
	        //���ǵ�ǰ���  �����ǵ�ǰ�ڵ� �Ϳ��ǵ�ǰ�ڵ�
	        tempResult.add(currentN);
	        getCombineResult(results, tempResult,n, currentN+1, currentK+1,k);
	        tempResult.remove(tempResult.size()-1);
	        getCombineResult(results, tempResult,n, currentN+1, currentK,k);
	        
	    }
}
