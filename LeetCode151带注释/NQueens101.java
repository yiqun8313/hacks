package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * �������⣺ n�ʺ����⣬�������п��ܵĽ��
 *
 * ����˼·��ͨ��������ȱ����ķ�ʽ���������ͨ��һ������position[]��������¼ÿһ���ʺ��λ�á����ݹ�ı߽����������ʱ�򣬻�ȡ�����
 */
public class NQueens101 {
	
	//��¼ס��n���ʺ�ŵ�����  position[1] = 2����˼���ǵ�һ���ʺ���ڵڶ���
	public int[] position;
	
    public List<String[]> solveNQueens(int n) {
    	//���ڴ洢���
        List<String[]> answer = new ArrayList<String[]>();
        if(n == 0) return answer;
        //��ʼ������
        position = new int[n+1];
        queen(answer,1,n);
        return answer;
    }
    
    public void queen(List<String[]> answer, int ith,int n){
    	//�߽���������  ��ȡ���
        if(ith > n && n > 0){
            getAnswer(answer);
            return;
        }
        
        //����dfs�ķ�ʽ��ÿһ��ζ���n�ֿ���
        for(int i = 1; i <= n; i++){
            position[ith] = i;
            if(place(ith)){
                queen(answer,ith+1,n);
            }
        }
    }
    
    //�б���  �ж��Ƿ���Է��õ���λ��  ����ͬһ��   ����ͬһ������
    public boolean place(int ith){
        for(int i = 1; i < ith; i++){
            if(position[ith] == position[i] || Math.abs(position[ith] - position[i]) ==  Math.abs(ith - i)){
                return false;
            }
        }
        return true;
    }
    
    //��ȡ���
    public void getAnswer(List<String[]> answer){
        int n = position.length-1;
        String[] result = new String[n];
        for(int i = 1; i <= n; i++){
           String currentS = "";
           int p = position[i];
           for(int j = 1; j <= n; j++){
               if(j == p){
                   currentS += "Q";
               }else{
                   currentS += ".";
               }
           }
           result[i-1] = currentS;
        }
        answer.add(result);
    }
}
