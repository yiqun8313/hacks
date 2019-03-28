package leetcode151withexplain;

import java.util.ArrayList;

/**
 * ����˼·����������n  ����������n������n�������ɵ����е����Ŷԡ�
 * 
 * 	For example, given n = 3, a solution set is:
	"((()))", "(()())", "(())()", "()(())", "()()()"
 * 
 *	����˼·����¼ס�����ŵ���Ŀ�������ŵ���Ŀ����������ŵ���n������ô�Ϳ�ʼ���������š������������Ŀ������������Ŀ��ʱ�򣬿��Լ��������š�
 */
public class GenerateParentheses130 {
	
	public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> results = new ArrayList<String>();
        //�ݹ����  results�����  temp��ʱ���  �Լ�nֵ  ���е�(��Ŀ�ͣ���Ŀ
        getResult(results,"",0,0,n);
        return results;
    }
    
	/**
	 * �ݹ���÷���
	 * @param results  �����
	 * @param temp  ��ʱ���
	 * @param lpSize �����ŵ���Ŀ
	 * @param rpSize �����ŵ���Ŀ
	 * @param n ���Ŷ���
	 */
    public void getResult(ArrayList<String> results,String temp,int lpSize, int rpSize,int n){
        //when has n left parenthesis
    	//�������ŵ���Ŀ����n��ʱ��
        if(lpSize == n){
        	//��ô��temp������ϻ����Լ���ģ���Ŀ
            for(int i = 0; i < n - rpSize;i++){
                temp = temp+")";
            }
            //��������
            results.add(temp);
            return;
        }
        
        //����������
        getResult(results,temp+"(",lpSize+1,rpSize,n);
        //�������ŵ���Ŀ���������ŵ���Ŀ����ô�Ϳ�ʼ����������
        if(lpSize > rpSize){
            getResult(results,temp+")",lpSize,rpSize+1,n);
        }
        
    }
}
