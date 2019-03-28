package leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 * �������⣺����һ���ַ������ҵ����ַ����а����з��ظ��ַ�����Ӵ����ȡ�
 * 
 *	For example,  "abcabcbb" is "abc", which the length is 3. 
 *	For "bbbbb" the longest substring is "b", with the length of 1.
 *
 *	����˼·��ͨ��һ��map��¼סÿһ���ַ���λ�ã���idx��¼��׼λ�ã�Ҳ���ǵ�ǰλ�ú�idxλ��֮��û���ظ�Ԫ�ء�����ÿһ��Ԫ�أ����֮ǰ�Ѿ����ֹ�һ�Σ�����ϴε�λ�ô���idx����ô��Ҫ����idx��Ȼ�����
 *  ��Χֵ��������µ�answer�Ϳ����ˡ�
 */
public class LongestSubstringWithoutRepeatingCharacters149 {
	
	
	public static void main(String[] args){
		LongestSubstringWithoutRepeatingCharacters149 object = new LongestSubstringWithoutRepeatingCharacters149();
		object.lengthOfLongestSubstring("abcdeba");
	}
	
	
	 
	public int lengthOfLongestSubstring(String s) {
		//��һ��map��¼סÿһ��Ԫ�صĿ�ʼλ��
         Map<String,Integer> strPositionMap = new HashMap<String,Integer>();
         int sLength = s.length();
         //idx��ʼֵ����Ϊ-1
         int idx = -1;
         int answer = 0;
         
         //����ÿһ��Ԫ��  ����Ԫ���Ƿ������map��
         for(int i = 0; i < sLength; i++){
             
        	 //�������  �����ַ���ʼλ�ô�����һ�γ��ֵ�λ��   ��ôidx���¸�ֵ
        	 //˼·��������������һ���ظ���Ԫ�أ���ô��Ҫ֪����һ���ظ����ֵ�λ�����ģ�������λ�ó�����idx,idx��һ����׼����λ�ã���Ϊ����м�������ظ�Ԫ�أ���ô��Ҫ���ȥ��
             if(strPositionMap.get(s.substring(i,i+1)) != null && strPositionMap.get(s.substring(i,i+1)) > idx){
                 idx = strPositionMap.get(s.substring(i,i+1));
                 
             }
             
             
             if((i - idx) > answer){
                 answer = i - idx;
             }
             
             //ÿ���ַ��ĳ���λ�ø����ϴγ��ֵ�λ��
             strPositionMap.put(s.substring(i,i+1),i);
         }
     
         return answer;
     }
}
