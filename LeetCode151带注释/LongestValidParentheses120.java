package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * �������⣺����һ����Ҫ�ɣ�����ɵ��ַ�����������������Ч�Ӵ���ʲô��
 * example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 * 
 * ����˼·��ͨ��һ��arraylist����ʾÿһ��λ���Ƿ���Բ���ƴ�գ���,�����ǳ�ʼ����ͨ��һ��list<integer>��ģ��ջ��֪����ЩԪ�ؿ���ƴ�ճ�������Ȼ��������1�ĸ���
 *
 */
public class LongestValidParentheses120 {
	public int longestValidParentheses(String s) {
		 //ģ�����飬��ʾÿһ��λ���Ƿ����ƴ�ճ�����
	     List<Integer> items = new ArrayList<Integer>();//recorded as 0 or 1
	     int sLength = s.length();
	     //initailize
	     for(int i = 0; i < sLength; i++){
	         items.add(0);
	     }
	     
	     //ջ���ڴ洢�±�λ�� 
	     List<Integer> parentheses = new ArrayList<Integer>(); // regared as a stack
	     
	     //һ�α���ÿһ��Ԫ��
	     for(int j = 0; j < sLength; j++){
	         String currentParentheses = s.substring(j,j+1);
	         //����ǣ� ѹ��ջ��
	         if(currentParentheses.equals("(")){
	             parentheses.add(j);
	         }else if(currentParentheses.equals(")")){
	             int parenthesesSize = parentheses.size();
	             //�ж�ջ�Ƿ�Ϊ��
	             if(parentheses.size() > 0){
	            	 //��ȡջ��Ԫ��
	                 int element = parentheses.get(parenthesesSize - 1);
	                 //���ջ��Ԫ��Ϊ��
	                 if(s.substring(element,element+1).equals("(")){
	                	 //��ô�����  ���ñ�־λΪ1
	                     items.set(element, 1);
	                     items.set(j, 1);
	                     parentheses.remove(parenthesesSize - 1);
	                 }
	             //Ϊ��  ��ô��ѹ�뵽ջ��
	             }else{
	            	 parentheses.add(j);
	             }
	         }
	         
	     }
	     
	     //��ǰ�������arraylist ������1����ô��++
	     int maxNum = 0;
	     int tempMax = 0;
	     for(int k = 0; k < sLength; k++){
	    	 if(items.get(k) == 0){
	    		 if(maxNum < tempMax){
	    			 maxNum = tempMax;
	    		 }
	    		 tempMax = 0;
	    	 }else{
	    		 tempMax++;
	    	 }
	     }
	     if(maxNum < tempMax){
	    	 maxNum = tempMax;
	     }
	     
	     return maxNum;
       
	}
}
