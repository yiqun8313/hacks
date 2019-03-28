package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �����������Ǹ���һ���ַ������������ܹ���ֳɵĻ����Ӵ����ء����磺
 * For example, given s = "aab",
      Return
	  [
	    ["aa","b"],
	    ["a","a","b"]
	  ]
 *
 * ����˼·��������ȱ�����ÿһ�㶼�������ֿ��ܣ�Ȼ������ǻ��ģ���ô�ͽ���������ȱ�����
 * 
 * ע��㣺����������ȱ�����˼����ں������Ŀ�о������õ���ÿһ��ѹ��һ�����֮�󣬺�����Ҫ������������
 *
 */
public class PalindromePartitioning019 {
	
	public  ArrayList<ArrayList<String>> partition(String s) {
		//���ڴ洢���
    	ArrayList<ArrayList<String>> results = new ArrayList<ArrayList<String>>();
    	//��ʱ���  �Ժ󾭳��õ����ֽṹ������˼�����������ȱ���
    	ArrayList<String> temp = new ArrayList<>();
    	generatePalindrome(results, temp, s);
    	return results;
    }
    
    
    public static void generatePalindrome(ArrayList<ArrayList<String>> results,ArrayList<String> temp,String s){
    	//�߽�����   ��������add new ArrayList()
    	if(s.length() == 0){
    		results.add(new ArrayList<>(temp));
    	}
    	//������ȱ���  ĳһ��ĸ����������
    	for(int i = 1; i <= s.length(); i++){
    		String cs = s.substring(0,i);
    		//����ǻ��ģ���ô�ͽ�����ȱ���
    		if(isPalindromeOrNot(cs)){
    			temp.add(cs);
    			generatePalindrome(results, temp, s.substring(i));
    			//������remove
    			temp.remove(temp.size()-1);
    		}
    	}
    }
    
    
    //�ж�һ���ַ����ǲ��ǻ��Ĵ�
    public static boolean isPalindromeOrNot(String s){
    	
    	boolean result = true;
    	int left = 0;
    	int right = s.length()-1;
    	while(left < right){
    		if(!(s.substring(left, left+1).equals(s.substring(right, right+1)))){
    			result = false;
    			return result;
    		}
    		left++;
    		right--;
    	}
    	return result;
    }
}
