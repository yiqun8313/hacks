package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * �������⣺����һ�����飬����һ��Ŀ��ֵ���ҳ����������е���������ʹ����͵���Ŀ��ֵ
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
	A solution set is: 
	[1, 7] 
	[1, 2, 5] 
	[2, 6] 
	[1, 1, 6] 
	
	����˼·��ͨ��������ȱ����Ϳ����ˡ������п��ǵ����ظ���������ǳ�������
 *
 *
 */
public class CombinationSumII113 {
	
	 public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target){
		//��������
	    Arrays.sort(num);
	    //���������ʱ���   ��ȱ���
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();  
	    ArrayList<Integer> path = new ArrayList<Integer>();  
        comb(num,0,0,target,res,path);  
        return res;  
	 }

	 /**
	  * �ݹ���ù���
	  * @param candidates ����������
	  * @param index Ŀǰ������index
	  * @param sum  ��ǰ��
	  * @param target Ŀ��ֵ
	  * @param res �����
	  * @param path  һ�����
	  */
	 public void comb(int[] candidates, int index, int sum, int target, ArrayList<ArrayList<Integer>> res, ArrayList<Integer> path){  
	     //�������
		 if(sum > target) return;  
	     
		 //�������
	     if(sum == target){
	    	//��������new
	     	res.add(new ArrayList(path));
	     	return;
	     }  
	     
	     //�ӵ�ǰλ�ÿ�ʼ����������
	     for(int i= index; i < candidates.length;i++){  
	    	 //���ϵ�ǰֵ
	         path.add(candidates[i]);
	         //��һ��ѭ��
	         comb(candidates,i+1,sum+candidates[i],target,res,path);
	         //�����ǵ�ǰ�ڵ�
	         path.remove(path.size()-1);
	         //���������ͬ��Ԫ�أ�ֱ��������ȥ�ؿ��ǣ�
	         while(i < candidates.length-1 && candidates[i]==candidates[i+1])i++;  
	     }  
	  } 
}
