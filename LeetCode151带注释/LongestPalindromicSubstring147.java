package leetcode151withexplain;

/**
 * �������⣺��������ַ��������������Ӵ�
 * 
 * ����˼·�����ȳ�ʼ��������һ��Ԫ�ص�ʱ����ô���ǻ��ģ�Ȼ�������������ַ����жϣ�Ȼ�������������жϣ���ʵ�ͺ;��������Ͻ��ƶ��ĸо���һ���ġ�
 * 
 * Ȼ��ͨ��һ����Χ������¼ס�𰸵ķ�Χ�����ؽ�������ˡ�
 *
 */
public class LongestPalindromicSubstring147 {
	
	
	//ͨ��dp�ķ�ʽ��ȡ
	boolean[][] dp;  
    
    public String longestPalindrome(String s){
    	
    	//�����������  �������Ϊ0����1  ��ôֱ�ӷ��ؾͿ�����
        if(s.length() == 0)  
        {  
            return "";  
        }  
        if(s.length() == 1)  
        {  
            return s;  
        }  
  
        dp = new boolean[s.length()][s.length()];  
          
        int i,j;  
         
        //��ʼ�����Ѿ�������½Ƕ�����ΪTrue
        for( i = 0; i < s.length(); i++)  
        {  
            for( j = 0; j < s.length(); j++)  
            {  
                if(i >= j)  
                {  
                    dp[i][j] = true;  
  
                }  
                else  
                {  
                    dp[i][j] = false;
                }  
            }  
        }  
         
        
        int k;  
        int maxLen = 1;
        //��¼ס�߽�
        int rf = 0, rt = 0;
        //������ʽ�Ǿ�������Ͻ�б�������½Ǳ���   �������ѭ����1��s.length
        for( k = 1; k < s.length(); k++)  
        {  
        	//�ڲ��Ǵ�0��ʼ������������һ��  ���Ǳ����ķ�Χ�Ǳ�С��  ����������k+i < s.length
        	//i�����ַ����Ŀ�ʼλ��  j����Ԫ�صĽ���λ��
            for( i = 0;  k + i < s.length(); i++)  
            {  
                j = i + k;  
                if(s.charAt(i) != s.charAt(j))  
                {  
                    dp[i][j] = false;  
                }  
                else 
                {  
                    dp[i][j] = dp[i+1][j-1];  
                    if(dp[i][j])  
                    {  
                        if(k + 1 > maxLen)  
                        {  
                            maxLen = k + 1;  
                            rf = i;  
                            rt = j;  
                        }  
                    }  
                }  
            }  
        }  
        return s.substring(rf, rt+1);  
    }
}
