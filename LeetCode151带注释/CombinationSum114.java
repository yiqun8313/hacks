package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �������⣺����һ�������һ��Ŀ��ֵ����������е����֣����ҪΪtarget�������ظ�ѡ�������е�����
 * For example, given candidate set 2,3,6,7 and target 7, 
	A solution set is: 
	[7] 
	[2, 2, 3] 
 *
 * ����˼·������������ȱ����ķ�ʽ���ݹ���ã�ֻ�ǵ�ǰԪ�ؿ��Կ��Ǻܶ�Ρ�
 */
public class CombinationSum114 {
	 	
	    public ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
	       ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
	       ArrayList<Integer> tempResult = new ArrayList<Integer>();
	       Arrays.sort(candidates);
	       //�������������  Ȼ����ô�ͳ��dfs˼��  ������ͽ��  Ȼ��ݹ������ȡ���
	       getResults(results,tempResult,candidates,target,0);
	       return results;
	    }
	    
	    /**
	     * DFS����
	     * @param results  �����
	     * @param tempResult  ���
	     * @param candidates ��ѡ��
	     * @param target Ŀ��ֵ
	     * @param currentPosition ��ǰλ��
	     */
	    public void getResults(ArrayList<ArrayList<Integer>> results,ArrayList<Integer> tempResult,int[] candidates,int target, int currentPosition){
	        int cLength = candidates.length;
	        //��ǰλ�ó���
	        if(currentPosition >= cLength){
	            return;
	        }
	        
	        //��ȡ��ǰ����ĺ�  �������Ŀ��ֵ  ��ô����
	        int currentSum = getSum(tempResult);
	        if(currentSum > target){
	            return;
	        }
	        
	        //��ǰ����Ŀ��ֵ���
	        if(currentSum == target){
	            results.add(new ArrayList(tempResult));
	            return;
	        }
	        
	        //���������������
	        tempResult.add(candidates[currentPosition]);
	        //�ݹ���� currentPosition���仯
	        getResults(results,tempResult,candidates,target,currentPosition);
	        //�����ǵ�ǰ����  currentPosition++
	        tempResult.remove(tempResult.size()-1);
	        getResults(results,tempResult,candidates,target,currentPosition+1);
	        
	    }
	    
	    public int getSum(ArrayList<Integer> tempResult){
	        int tR = tempResult.size();
	        int sum = 0;
	        for(int i = 0; i < tR; i++){
	            sum += tempResult.get(i);
	        }
	        return sum;
	    }
}
