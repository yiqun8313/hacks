package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ�����飬����û���ظ���Ԫ�أ�Ȼ���������Ԫ�ص���ϡ�
 * 
 *  If S = [1,2,3], a solution is:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
	
	�����60���˼·����һ���ģ�ͨ����ȱ����ķ�ʽ��ȡ�����������Ԫ�غͲ�����Ԫ�ء�
 *
 */
public class Subsets074 {
	
	
	public ArrayList<ArrayList<Integer>> subsets(int[] S) {
		//���⴦��
        if(S.length == 0){
            return new ArrayList<ArrayList<Integer>>();
        }
 
        //����
        sSort(S);
        
        //��ͳ��˼·  ���������ʱ���   Ȼ��ݹ����
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tempResult = new ArrayList<Integer>();
        return generateResults(results,tempResult,S,0);
    }
    
    
	//������������� 
    public void sSort(int[] S){
        int length = S.length;
        for(int i = 0; i < length-1; i++){
            for(int j = i+1; j < length ; j++){
                if(S[j] < S[i]){
                    int temp = S[i];
                    S[i] = S[j];
                    S[j] = temp;
                }
            }
        }
        
        
    }
    
 
    public ArrayList<ArrayList<Integer>> generateResults(ArrayList<ArrayList<Integer>> results, ArrayList<Integer> tempResult,int[] num,int n){
        //�߽�����
        if(n == num.length){
            ArrayList<Integer> currentResult = new ArrayList(tempResult);
            results.add(0,currentResult);
            return null;
        }
        
        //�����Ԫ��
        tempResult.add(num[n]);
        generateResults(results, tempResult,num,n+1);
        //��Ҫ��Ԫ��
        tempResult.remove(tempResult.size()-1);
        generateResults(results, tempResult,num,n+1);

        return results;
    } 
}
