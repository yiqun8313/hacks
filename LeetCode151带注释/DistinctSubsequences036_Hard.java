package leetcode151withexplain;

/**
 * �������⣺���������ַ���S��T���ж�S��������T�ĸ���
 * 
 * http://blog.csdn.net/worldwindjp/article/details/19770281
 * 
 *  Here is an example:
	S = "rabbbit", T = "rabbit"
	Return 3.
	
	һ��˼·��ͨ��������ȱ�������һ���ַ�һ���ַ�����Ϊһ����Σ�Ȼ��ÿһ���������һ���ַ����ֵĴ�������ÿһ��Ŀ��ܽ�����١�
	
	����Ľ���˼·��
	ͨ��dp�ķ�ʽʵ�֡�����S��i�� = T[j]��ȣ���ôdp[i][j] = ���Ͻ�һ�еļӺ͡��������ȣ���ô�͵����㡣
	
	������Ҫ���Ǻ�f[i][j]���������ʲô��
 *
 */
public class DistinctSubsequences036_Hard {

	public int numDistinct(String S, String T) {
		 int sLength = S.length();
		 int tLength = T.length();
		 if(sLength == 0 || tLength == 0){
			 return 0;
		 }
		 
		 int[][] f = new int[sLength+1][tLength+1];
		 f[0][0] = 1;
		 for(int i = 1; i <= sLength; i++){
			 f[i][0] = 0; 
		 }
		 
		 for(int j = 1; j <= tLength; j++){
			 f[0][j] = 0;
		 }
		 
		 for(int q = 1; q <= sLength; q++){
			 for(int p = 1; p <= tLength; p++){
				 if(S.substring(q-1,q).equals(T.substring(p-1,p))){
					 f[q][p] = 0;
					 for(int k = 0; k < q; k++){
						 f[q][p] += f[k][p-1];
					 }
					 
				 }else{
					 f[q][p] = 0;
				 }
			 }
		 }
		 
		 int sum = 0;
		 for(int w = 0; w <= sLength; w++){
			 sum += f[w][tLength];
		 }
		 
		 return sum;
	}
}
