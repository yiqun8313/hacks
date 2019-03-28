package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����rowIndex�����ض�Ӧ�е����ݡ� 
 *
 * ����˼·������Ľ���˼·��33�еĲ�ֻ࣬�������ͨ��ά��Ϊ1������ʵ�ֵģ���ʡ�˿ռ�.
 * 
 * ע���:�����˱߽�������
 */
public class PascalsTriangleII032 {
	
	
	public ArrayList<Integer> getRow(int rowIndex) {
        
		//���ڴ洢���
        ArrayList<Integer> answers = new ArrayList<Integer>();
        
        //deal special situation
        if(rowIndex == 0){
            answers.add(1);
            return answers;
        }
        
        if(rowIndex == 1){
            answers.add(1);
            answers.add(1);
            return answers;
        }
        
        //initialize values
        if(rowIndex >= 2){
            answers.add(1);
            answers.add(1);
        }
        
        //use one arry to put all numbers. f[x][y] = f[x-1][y] + f[x-1][y-1]
        //���ұ߽�Ԫ�ض���1
        for(int i = 2; i <= rowIndex; i++){
            for(int j = i; j > 0; j--){
                 if(j == i){
                     answers.add(1);
                 }else{
                     answers.set(j,answers.get(j)+answers.get(j-1));
                 }
            }
        }
        
        return answers;
        
    }
}
