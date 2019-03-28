package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ�������ַ�����Ȼ������ֻ�����İ������������п���ƴ�ճ������ַ�����
 * 
 * Input:Digit string "23"  Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 
 * ����˼·��ͨ���ݹ���ã��߽���������һ���ַ���ʱ����ô�������Ӧ�������ַ��Ϳ����ˡ���ȡ����������ַ���Ȼ���ȡ��һ���е������ַ���Ȼ����������ƴ�ճ����յĽ��
 *
 */
public class LetterCombinationsofaPhoneNumber133 {
	
	
	   public ArrayList<String> letterCombinations(String digits) {
	        int digitSize = digits.length();
	        //����ַ�������Ϊ0  ���⴦��
	        if(digitSize == 0){
	            ArrayList<String> answer = new ArrayList<String>();
	            answer.add("");
	            return answer;
	        }
	        
	        return getCombinationLetters(digits,digitSize-1);
	    }
	    
	   	/**
	   	 * ��ȡ���
	   	 * @param digits �����������ַ���
	   	 * @param currentPosition ��ǰ���ǵ�λ��
	   	 * @return
	   	 */
	    public ArrayList<String> getCombinationLetters(String digits,int currentPosition){
	        
	    	//�洢�����
	        ArrayList<String> results = new ArrayList<String>();
	        
	        //�洢��ʱ���
	        ArrayList<String> tempResults = new ArrayList<String>();
	        
	        //��ȡ��ǰ�ַ�
	        String currentDigit = digits.substring(currentPosition,currentPosition+1);
	        //��ȡ�ַ���Ӧ���ַ�
	        tempResults = getStringsByNum(currentDigit);
	        //�����ǰλ���ǵ�һ���ַ�����ô�𰸾��ǽ����  Ҳ���ڱ߽�������
	        if(currentPosition == 0){
	            results = tempResults;
	            return results;
	        }
	        
	        //��ȡ��һ�ֵ����н��
	        ArrayList<String> nextResults = getCombinationLetters(digits,currentPosition-1);
	        
	        //ƴ�����εĽ��   ��¼���������
	        for(String tempS : tempResults){
	            for(String nextS : nextResults){
	                results.add(nextS+tempS);   
	            }
	        }
	        
	        return results;
	    }
	    
	    //���ڷ���ÿһ�����ֶ�Ӧ��String
	    public ArrayList<String> getStringsByNum(String number){
	        ArrayList<String> results = new ArrayList<String>();
	        
	         if(number.equals("2")){
	            results.add("a");
	            results.add("b");
	            results.add("c");
	        }
	        
	        if(number.equals("3")){
	            results.add("d");
	            results.add("e");
	            results.add("f");
	        }
	        
	        if(number.equals("4")){
	            results.add("g");
	            results.add("h");
	            results.add("i");
	        }
	        
	        if(number.equals("5")){
	            results.add("j");
	            results.add("k");
	            results.add("l");
	        }
	        
	        if(number.equals("6")){
	            results.add("m");
	            results.add("n");
	            results.add("o");
	        }
	        
	        if(number.equals("7")){
	            results.add("p");
	            results.add("q");
	            results.add("r");
	            results.add("s");
	        }
	        
	        if(number.equals("8")){
	            results.add("t");
	            results.add("u");
	            results.add("v");
	        }
	        
	        if(number.equals("9")){
	            
	            results.add("w");
	            results.add("x");
	            results.add("y");
	            results.add("z");
	        }
	     
	        return results;
	    }
	    
	    public static void main(String[] args){
	    	int a = 97 + 0;
	    	System.out.println(String.valueOf((char)(a)));
	    }
}
