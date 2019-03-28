package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺Pascals�����Ρ�����numRows�����Ƴ�������
 * 
 * Given numRows, generate the first numRows of Pascal's triangle.

	For example, given numRows = 5,
	Return
	
	[
	     [1],
	    [1,1],
	   [1,2,1],
	  [1,3,3,1],
	 [1,4,6,4,1]
	]
	
	�������˼·��
	һ��һ�еı�������һ�������һ��Ԫ�ض���1.Ȼ��ÿһ��Ԫ�ض�����һ������ӦԪ�صĺ͡�
	
 *
 */
public class PascalsTriangle033 {

	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		
		//���ڴ洢��� 
        ArrayList<ArrayList<Integer>> answers = new ArrayList<ArrayList<Integer>>();
        
        if(numRows == 0){
            return answers;
        }
        
        //һ��һ�еı���    ÿһ�е�������������i  Ȼ��ÿһ�еĵ�һ�������һ��Ԫ�ض���1  Ȼ������λ�õ�Ԫ�ض�������һ������������Ԫ�صĺ͡�
        for(int i = 0; i < numRows; i++){
            ArrayList<Integer> currentAnswer = new ArrayList<Integer>();
            if(i == 0){
                currentAnswer.add(1);
                answers.add(currentAnswer);
            }else{
                currentAnswer.add(1);
                ArrayList<Integer> preAnswer = answers.get(i-1);
                for(int j = 0; j < (preAnswer.size()-1); j++){
                    int tempAdd = preAnswer.get(j)+preAnswer.get(j+1);
                    currentAnswer.add(tempAdd);
                }
                currentAnswer.add(1);
                answers.add(currentAnswer);
            }
        }
        
        return answers;
    
    }
}
