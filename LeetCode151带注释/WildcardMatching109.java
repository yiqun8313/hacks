package leetcode151withexplain;

/**
 * �������⣺ͨ���ƥ��   �ַ������У���*,�ж������ַ����Ƿ����
 * 
 *  '?' Matches any single character.
	'*' Matches any sequence of characters (including the empty sequence).
 *	Some examples:
	isMatch("aa","a") �� false
	isMatch("aa","aa") �� true
	isMatch("aaa","aa") �� false
	isMatch("aa", "*") �� true
	isMatch("aa", "a*") �� true
	isMatch("ab", "?*") �� true
	isMatch("aab", "c*a*b") �� false
	
	����˼·��ͨ����̬�滮�ķ�ʽ���жϣ�
	��p�е��ַ���*��ʱ�� d[i][j] = dp[i-1][j] || dp[i][j-1]
	��p�е��ַ��ǣ���ʱ����������ַ������ַ���ȵ�ʱ��  d[i][j] = dp[i-1][j-1]
	�����˳�ʼ����������sΪ�յ�ʱ��p����ȫ��*�ſ���
 */
public class WildcardMatching109 {
	
	public static void main(String[] args){
		WildcardMatching109 object = new WildcardMatching109();
		object.isMatch("rabbit", "ra?b*");
	}
	
	public boolean isMatch(String s, String p){
        int len_s = s.length();  
        int len_p = p.length();  
  
        //if the characters not equals * is more than s.length it will be wrong
        int pPosition = 0;
        int cnt = 0;
        //�ҳ�p�еķ�*����Ŀ������Ѿ�����s�ĳ��ȣ���ô�ʹ��ˡ�
        while (pPosition < len_p){
            if (p.charAt(pPosition++) != '*'){
                cnt++;
            }
        }
        if (cnt > len_s) return false;  
          
          
        boolean[][] dp = new boolean[len_s+1][len_p+1];  
  
        dp[0][0] = true;  
        for (int i = 1; i <= len_p; i++) {  
            //deal with the first row: if the pre several chars is * in p
        	//��ʼ����һ������  �����ʵ�����ж��ǲ���ǰ��һֱ��*,����sΪ�յ�ʱ��p���ƥ���
            if (dp[0][i-1] && p.charAt(i-1) == '*') dp[0][i] = true;  
            
            for (int j = 1; j <= len_s; ++j)  
            {  
            	//�������pΪ* ��ô���Կ���ȥ��*��ʱ��ǰ���Ƿ����  �Լ����ǲ���*��ʱ���Ƿ�һ����
                if (p.charAt(i-1) == '*') dp[j][i] = (dp[j-1][i] || dp[j][i-1]);
                //����ǣ���  ����  ���������ַ������ַ����  ��ô�����ȡ���������ַ���ǰ��Ĳ���
                else if (p.charAt(i-1) == '?' || p.charAt(i-1) == s.charAt(j-1)) dp[j][i] = dp[j-1][i-1];  
                else dp[j][i] = false;  
            }  
        }  
        return dp[len_s][len_p];  
    }
}
