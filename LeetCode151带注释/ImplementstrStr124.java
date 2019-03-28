package leetcode151withexplain;

/**
 * �������⣺ʵ���ַ������ҡ������ַ���haystack��needle���ж�needle��haystack��һ�γ��ֵ�λ�ã�����i֮��������ַ�����
 * 
 * ����˼·������ÿһ��haystack��ÿһ��λ�á����ٲ����Ǻ�����ַ�������Ȼ���ܷ��ҵ�needle��������ҵ������ؽ����
 *
 */
public class ImplementstrStr124 {
	
	public String strStr(String haystack, String needle) {
		//��ȡ�����ַ����ĳ���
		int length_a = haystack.length();
        int length_b = needle.length();
        //�������С�ڵ�ʱ�򣬱��ǿգ������ȵ�ʱ����ô���ж��ַ����Ƿ����
        if(length_a < length_b)
            return null;
        if(length_a == length_b){
            if(haystack.equals(needle))
                return haystack;
            return null;
        }
        
        int i,j;
        //ע���������  �������ʣ��ĳ��Ȳ�����  ��ôhaystack����Ͳ����ܰ���needle��
        for(i=0; i<=length_a-length_b; ++i){
		    boolean flag = true;
		    //��ÿһ��λ�ÿ�ʼ��������ַ���   ������ҵ�  ���ؽ��
            for(j=0; j<length_b; ++j){
                if(!haystack.substring(i+j,i+j+1).equals(needle.substring(j, j+1))){
                    flag = false;
                    break;
                }
            }
            if(flag)
                return haystack.substring(i);
	      
	    }
        
        return null;	
    }
}
