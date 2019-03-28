package leetcode151withexplain;

import java.util.Arrays;

/**
 *  �������⣺����һ���ַ���   ��ô���ַ�������ͨ��һ��������ʾ   �����������������Եݹ����������ʾ  Ȼ����Խ������е����Һ���  ��ô�Ϳ��Ա������һ���ַ���
 *  ���ڸ��������ַ������ж�S2�Ƿ���ǿ���ͨ��S1�任���á�
 *  
 *  http://www.blogjava.net/sandy/archive/2013/05/22/399605.html
 *
 */
public class ScrambleString064 {
	
	//����ͨ���ݹ�ķ�ʽʵ��
	public boolean isScramble(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();
        
        //�߽���������
        if(l1!=l2){
            return false;
        }
        if(l1==0){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        if(l1==1){
            return c1[0]==c2[0];
        }
        
        //�������ת��  ��ô���������ַ�������������ĸ��һ����
        Arrays.sort(c1);
        Arrays.sort(c2);
        for(int i=0;i<l1;++i){
            if(c1[i]!=c2[i]){
                return false;
            }
        }
        
        //ÿһ�㶼ѭ������   �Ƚ�ǰ����Ƿ����  �Լ��Ƚ�ǰ��ͺ�����Ƿ���Ի���ת��
        boolean result = false;
        //ע������  �о��ر�ı���
        for(int i=1;i<l1 && !result;++i){
            String s11 = s1.substring(0,i);
            String s12 = s1.substring(i);
            String s21 = s2.substring(0,i);
            String s22 = s2.substring(i);
            result = isScramble(s11,s21) && isScramble(s12,s22);
            if(!result){
                String s31 = s2.substring(0,l1-i);
                String s32 = s2.substring(l1-i);
                result = isScramble(s11,s32) && isScramble(s12,s31);
            }
        }
        
        return result;
    }
	
	/**
	 * ����dp��˼��
	 * ������һ����ά������   ��һά�ȱ�ʾ�ַ����ĳ���   �ڶ���ά�Ⱥ͵�����ά�ȱ�ʾ�������ַ�����ʼ��λ�á�
	 * 
	 * ������ʹ����һ����ά����boolean result[len][len][len],���е�һάΪ�Ӵ��ĳ��ȣ��ڶ�άΪs1����ʼ����������άΪs2����ʼ������
		result[k][i][j]��ʾs1[i...i+k]�Ƿ������s2[j...j+k]�仯������
	 */
	public boolean isScrambledp(String s1, String s2){
        int len = s1.length();
        
        //�߽���������
        if(len!=s2.length()){
            return false;
        }
        if(len==0){
            return true;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        //��ʼ����ά����
        boolean[][][] result = new boolean[len][len][len];
        for(int i=0;i<len;++i){
            for(int j=0;j<len;++j){
                result[0][i][j] = (c1[i]==c2[j]);
            }
        }
        
        //����ѭ��  ��Ϊ����Ϊ1���Ѿ���ʼ����  �ӳ���Ϊ2�Ŀ�ʼ����
        for(int k=2;k<=len;++k){
        	//����ѭ������ʼλ�ö���len-k
            for(int i=len-k;i>=0;--i){
              for(int j=len-k;j>=0;--j){
            	  //���������ʵ���ǽ��ַ�����Ϊ���ˣ�ǰ��ıȽϣ��ͺ���ıȽϣ�ǰ��ͺ���ıȽ�
                  boolean r = false;
                  for(int m=1;m<k && !r;++m){
                      r = (result[m-1][i][j] && result[k-m-1][i+m][j+m]) || (result[m-1][i][j+k-m] && result[k-m-1][i+m][j]);
                  }
                  result[k-1][i][j] = r;
              }
            }
        }
        
        return result[len-1][0][0];
    }
}
