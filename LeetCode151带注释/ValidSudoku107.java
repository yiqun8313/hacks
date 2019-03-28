package leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * �������⣺����һ������  ֻ�в�������  �ж�������д�������Ƿ�����
 * 
 * ����˼·��ͨ����������ݽṹ������Կ��ٵ��ҵ��Ƿ����һЩ�ظ���Ԫ�ء��ڼ��������ʱ��(i/3) * 3�� + (j/3)
 *
 */
public class ValidSudoku107 {
	
 	public boolean isValidSudoku(char[][] board) {
 		
 		//���ڼ�¼��  ��  �������ֵ  ���Ƿ����ظ�������
 		//arraylist�д洢�Ķ���hashmap��ÿһ��hashmap��¼����ÿһ�����ֳ������
        ArrayList<HashMap<Integer, Integer>> row_list_map = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> col_list_map = new ArrayList<HashMap<Integer, Integer>>();
        ArrayList<HashMap<Integer, Integer>> grid_list_map = new ArrayList<HashMap<Integer, Integer>>();
        
        //��ʼ���������б�
        for(int i=0 ;i<9; i++){
            HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
            row_list_map.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            col_list_map.add(tmp);
            tmp = new HashMap<Integer, Integer>();
            grid_list_map.add(tmp);
        }   
   
        //�����к��б���
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
            	//����ǡ���ô����Ծ��ȥ
                if(board[i][j] == '.')
                    continue;

                //����������Ѿ����������Ԫ��  ��ô���Ǵ����
                if(row_list_map.get(i).containsKey(board[i][j]-'0')){
                    return false;
                //����ͼ������Ԫ�ؽ�ȥ
                }else{
                    row_list_map.get(i).put(board[i][j]-'0', 1);
                }
               
                if(col_list_map.get(j).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    col_list_map.get(j).put(board[i][j]-'0', 1);
                }
               
                //��������ڵ�����
                int index = ((i/3) * 3) + (j/3);
                if(grid_list_map.get(index).containsKey(board[i][j]-'0')){
                    return false;
                }else{
                    grid_list_map.get(index).put(board[i][j]-'0', 1);
                }
            }
        }
       
        return true;
    }
}
