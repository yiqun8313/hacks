package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 *  �������⣺����һ�������νṹ�����ݣ�Ȼ���ҵ��Ӷ���Ԫ�ص��ײ�Ԫ�غ���С��·��
 *  For example, given the following triangle
	[
	     [2],
	    [3,4],
	   [6,5,7],
	  [4,1,8,3]
	]
	The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11). 
	
	һ��˼·���о�����һ������Ķ��������ҵ��Ӹ��ڵ㵽Ҷ�ӽڵ����С·����
	
	����˼·��ͨ��dp��˼��
	dp[i] = a[i][j] + max(a[i+1][j],a[i+1][j+1]);
 *
 */
public class Triangle031 {

	 public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
	        if(triangle == null || triangle.size() == 0){
	            return 0;
	        }
	        
	        int rows = triangle.size();
	        //dp��ʽ��a[]��ʾ�ľ���a[i]��ʱ����Сֵ
	        int[] a = new int[rows];
	        
	        //��ʼ�������Գ�ʼ�����������
	        for(int i = 0; i < rows; i++){
	            a[i] = triangle.get(rows-1).get(i);
	        }
	        
	        //�ӵ����ڶ�����������һ�б���
	        for(int i = rows-2; i >= 0; i--){
	            for(int j = 0; j < triangle.get(i).size(); j++){
	                int belowLeft = a[j];
	                int belowRight = a[j+1];
	                //������ֵ a[i] = a[i][j] + min(a[i+1][j],a[i+1][j+1])
	                a[j] = triangle.get(i).get(j) + (belowLeft < belowRight ? belowLeft:belowRight);
	            }
	        }
	        
	        return a[0];
	    }
	 
	 
	    public static int minimumTotal2(ArrayList<ArrayList<Integer>> triangle) {
	        int m = triangle.size();
	        if(m == 0) return 0;
	        int n = triangle.get(m-1).size();
	        
	        int[] answer = new int[n];
	        for(int i = m-1; i >= 0; i--){
	            for(int j = i; j >= 0; j--){
	                if(i == (m-1)){
	                    answer[j] = triangle.get(i).get(j);
	                }else{
	                    answer[j] = Math.min(answer[j],answer[j+1])+triangle.get(i).get(j);   
	                }
	            }
	        }
	        
	        return answer[0];
	    }
	    
	    public static void main(String[] args){
	    	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	    	ArrayList<Integer> a = new ArrayList<Integer>();
	    	a.add(-1);
	    	ArrayList<Integer> b = new ArrayList<Integer>();
	    	b.add(2);
	    	b.add(3);
	    	ArrayList<Integer> c = new ArrayList<Integer>();
	    	c.add(1);
	    	c.add(-1);
	    	c.add(-1);
	    	
	    	temp.add(a);
	    	temp.add(b);
	    	temp.add(c);
	    	
	    	Triangle031.minimumTotal2(temp);
	    }
}
