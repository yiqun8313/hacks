package leetcode151withexplain;

/**
 * �������⣺����һ������  �ж���������ǲ��ǻ��ĸ�ʽ��
 * 
 * ����˼·�����Ȼ�ȡ���������һ���ж���λ��10000000.Ȼ�󲻶ϵı�����ȡ���ֵ�ǰ���������֣�ǰ����������̣������������������Ȼ��ȡ������ߺ����ұߵ�Ԫ�أ���߿��������ұ߿�������
 * Ȼ��Ϳ���֪���Ƿ��ǻ��ĵ��ˡ�
 * 
 *  
 */
public class PalindromeNumber143 {
	
	public boolean isPalindrome(int x) {
        
        if(x < 0){
            return false;
        }
        
        if(x == 0){
            return true;
        }
    
        //base����֪��һ���ж���λ�����ֿ��Ե�����λ��
        int base = 1;
        while(x/base >= 10){
            base *= 10;
        }
        
        //ѭ������
        while(x > 0){
        	//������λ
            int leftval = x/base;
            //������λ
            int rightval = x%10;
            //����Ⱦͷ���false
            if(leftval != rightval){
                return false;
            }
            
            //ȥ����ߵ���ֵ
            x = x - leftval*base;
            //������λ  ��ô��Ҫ����100
            base = base/100;
            //ȥ���ұߵ���ֵ
            x = x/10;
        }
        
        return true;
        
    }
}
