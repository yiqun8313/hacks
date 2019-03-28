package leetcode151withexplain;

/**
 * �������⣺�����ַ���s1,s2,s3���ж�s3�Ƿ������s1��s2��������
 * 
 * For example,
	Given:
	s1 = "aabcc",
	s2 = "dbbca",
	
	When s3 = "aadbbcbcac", return true.
	When s3 = "aadbbbaccc", return false.
	
	dp�ķ�ʽ����
	dp[i][j]��ʾ����s1�е�0-i��s2�е�0-j�ܹ�����s3��0-��i+j��
	
	��ʼ�����߽��ϵ�ֵ
 *
 */
public class InterleavingString054 {

	/**
     * dp:
     * f[i][j] means if s1(0...i) and s2(0...j) can be s3(i+j)
     * if(s1[i] == s3[i+j]) f[i][j] = f[i-1][j]
     * if(s2[j] == s3[i+j]) f[i][j] = f[i][j-1];
     * 
     * initialized
     * f[0][0] = true
     * f[i][0] = f[i-1][0] && s1[i-1] == s3[i-1]
     * f[0][j] = f[0][j-1] && s2[j-1] ==  s3[j-1]
     */
    public boolean isInterleave(String s1, String s2, String s3){
        
        int s1Length = s1.length();
        int s2Length = s2.length();
        int s3Length = s3.length();
        if(s1Length + s2Length != s3Length) return false;
        
        boolean[][] f = new boolean[s1Length+1][s2Length+1];
        f[0][0] = true;
        for(int i = 1; i <= s1Length; i++){
            f[i][0] = f[i-1][0] && (s1.substring(i-1,i).equals(s3.substring(i-1,i)));
        }
        
        for(int j = 1; j <= s2Length; j++){
            f[0][j] = f[0][j-1] && (s2.substring(j-1,j).equals(s3.substring(j-1,j)));
        }
        
        for(int i = 1; i <= s1Length; i++){
            for(int j = 1; j <= s2Length; j++){
            	//���ж��������  ֻҪһ����true����ô�ܵĽ������true
                boolean result1 = s1.substring(i-1,i).equals(s3.substring(i+j-1,i+j)) && f[i-1][j];
                boolean result2 = s2.substring(j-1,j).equals(s3.substring(i+j-1,i+j)) && f[i][j-1];
                f[i][j] = result1 || result2;
            }
        }
        
        return f[s1Length][s2Length];
        
    }
}
