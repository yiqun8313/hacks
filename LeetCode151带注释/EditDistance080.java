package leetcode151withexplain;

/**
 * �������⣺������������  �����༭���� 
 *
 */
public class EditDistance080 {
	
	public int minDistance(String word1, String word2) {
		
		//�༭����
		int word1Length = word1.length();
        int word2Length = word2.length();
        
        //���⴦��
        if(word1Length == 0){
            return word2Length;
        }
        
        if(word2Length == 0){
            return word1Length;
        }
        
        //����һ����ά����   dp����
        int[][] f = new int[word1Length+1][word2Length+1];
        
        //��ʼ����ά����  ��ʼ���к���
        for(int i = 0; i <= word1Length; i++){
            f[i][0] = i;
        }
        
        for(int j = 0; j <= word2Length; j++){
            f[0][j] = j;
        }
        
        //�༭����dp
        //dp[i][j] = min(dp[i-1][j-1]+f(i,j)[�滻ĳ��Ԫ��],dp[i-1][j]+1������Ԫ�ء�, dp[i][j-1]+1��ɾ��Ԫ�ء�);
        for(int p = 1; p <= word1Length; p++){
            for(int q = 1; q <= word2Length; q++){
                int cost = 1;
                if(word1.substring(p-1,p).equals(word2.substring(q-1,q))){
                    cost = 0;
                }
                    
                f[p][q] = min(f[p-1][q-1]+cost,min(f[p-1][q]+1,f[p][q-1]+1)); 
                    
            }
        }
        
        return f[word1Length][word2Length];
        
    }
    
    
    public int min(int a, int b){
        if(a > b){
            return b;
        }else{
            return a;
        }
    }
}
