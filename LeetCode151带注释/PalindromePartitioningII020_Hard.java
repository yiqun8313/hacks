package leetcode151withexplain;

/**
 *  http://blog.csdn.net/doc_sgl/article/details/13418125
 *  �������⣺��һ���������ַ������ÿ���Ӵ����ǻ��ģ�����Ҫ�зֶ��ٴ� 
 *
 */
public class PalindromePartitioningII020_Hard {

	public int minCut(String s) {
	    
	    int n=s.length();
	    
	    //���ö�̬�滮��˼�룺dp[i]��ʾ��i��n����С�зִ���
	    int[] dp=new int[n+1];
	    
	    //�Ƿ��ǻ��ĵĶ�̬�滮���� pos[i][j]�����ַ�����i��j�Ƿ���һλ����
	    boolean[][] pos=new boolean[n][n];
	    
	    //�Ƿ�Ϊ���ĵĳ�ʼ������
	    int i,j;
	    for(i=0; i<n; i++)
	       for(j=0 ; j<n;j++)
	           pos[i][j]=false;
	    
	    for(i = 0; i < n; i++){
		   pos[i][i] = true;
	    }
	    
	    
	    //dp��ʼ��  ��ʼ��Ϊ������ַ����������зֶ��ٴ�
	    //D[i] = ����[i,n]֮����С��cut����nΪ�ַ������ȣ� ��,
	    //D[i] = min(1+D[j+1] )    i<=j <n
	    for(i = 0; i<=n; i++){
	       dp[i]=n-i;
	    }
	    
	    
	    for (i=n-1;i>-1;i--)
	        for(j=i;j < n;j++)
	           if(s.substring(i,i+1).equals(s.substring(j,j+1)) && (j-i<2 || pos[i+1][j-1]))
	           {
	              pos[i][j]=true;
	              dp[i] = dp[j+1]+1 > dp[i] ? dp[i]:(dp[j+1]+1);
	           }
	           
	    
	    int min=dp[0];
	    return min-1;
    }
}
