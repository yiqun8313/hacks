package leetcode151withexplain;

import java.util.ArrayList;

/**
 * ������������ж�һ���������ַ����ǲ���һ�����ģ�����ַ�������������ַ�������
 * 
 *  Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

	For example,
	"A man, a plan, a canal: Panama" is a palindrome.
	"race a car" is not a palindrome.
 *
 *  ����˼·���ȶ��������Ԥ�����������е��ַ�����ȡ������Ȼ��ŵ�һ��arraylist�У�Ȼ�����ж��Ƿ��ǻ��ġ�
 */
public class ValidPalindrome026 {

	public boolean isPalindrome(String s) {
		
		//�����������  ���ַ���Ҳ�ǻ���
        if(s == null) return false;
        if(s.replaceAll(" ","").equals("")) return true;
        
        //ͨ��һ�������б����洢ÿһ�����
        int sLength = s.length();
        ArrayList<String> tempStrings = new ArrayList<String>();
        for(int i = 0; i < sLength; i++){
            int chr = s.charAt(i);
            //assic��ֵ  ����  ��д��ĸ  Сд��ĸ
	        if((chr >= 48 && chr <= 57) ||(chr >= 65 && chr <= 90) ||(chr >= 97 && chr <= 122)){
	    	  tempStrings.add(String.valueOf(s.charAt(i)));
	        }
        }
        
        //ͨ�������б����ж��Ƿ��ǻ��ģ���ʵ����Ԥ������
        int tempStringsSize = tempStrings.size();
        int left = 0;
        int right = tempStringsSize-1;
        while(left <= right){
            if(tempStrings.get(left).toLowerCase().equals(tempStrings.get(right).toLowerCase())){
                left++;
                right--;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
