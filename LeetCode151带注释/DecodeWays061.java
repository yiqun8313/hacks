package leetcode151withexplain;

/**
 * 
 *  �������⣺�������µı��뷽ʽ   �ʣ�����һ�����֣����ܹ��ֽ�������ַ����ж��٣�
 *  'A' -> 1
	'B' -> 2
	...
	'Z' -> 26
	Given an encoded message containing digits, determine the total number of ways to decode it.
	
	For example,
	Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
	
	The number of ways decoding "12" is 2.
 *
 *   ����˼·������dp��˼�롣�ͺ�쳲��������в�࣬d[i] = d[i-1] + d[i-2]�����滹��̨�׵����⣬��������һ���ġ�
 *   
 *   ע��㣺��ʼ����ʱ��Ҫע��d[0] = 1;
 *   ���⣬�ж���λ���Ƿ�����ʱ��Ҫ�ж��ǲ��ǵ�һλ��0
 */
public class DecodeWays061 {
	
	    public int numDecodings(String s) {
	        //f[i] = f[i-1] + f[i-2](if s[i-1] and s[i] can be a number)
	        if(s == null) return 0;
	        s = s.toUpperCase();
	        //���s�ĳ���Ϊ0,��ô�ͷ���0
	        int sLength = s.length();
	        if(sLength == 0) return 0;
	        
	        //��ȡ��һ���ַ�
	        String firstchar = s.substring(0,1);
	        //�����һ���ַ�����0,���ҽ�����ôһ���ַ�  ����1
	        if(sLength == 1 && !firstchar.equals("0")) return 1;
	        
	        if(firstchar.equals("0")) return 0;
	        
	        //����f,���ҽ��г�ʼ��
	        int[] f = new int[sLength+1];
	        f[0] = 1;
	        if(!firstchar.equals("0")){
	            f[1] = 1;
	        }
	        
	        int first = 0;
	        int second = 0;
	        //����˼·��쳲��������в��  �����жϵ�ǰԪ�غ��Լ�ǰ���Ԫ���ܷ񹹳�һ����
	        for(int i = 2; i <= sLength; i++){
	        	//��ȡ��ǰ����ǰ���һ����
	            first = Integer.parseInt(s.substring(i-2,i-1));
	            second = Integer.parseInt(s.substring(i-1,i));
	            
	            //�жϵ�ǰ������ǰ������ܹ�����һ���������  �������  ��ô  suffix = f[i-2]
	            int suffix = 0;
	            int tempResult = 10 * first + second;
	            if(tempResult <= 26 && tempResult > 0 && first != 0){
	            	suffix = f[i-2];
	            }
	            
	            //����ǰ�����Լ��ܹ�����һ������������ԣ���ôprefix = f[i-1]
	            int prefix = 0;
	            if(second != 0){
	                prefix = f[i-1];
	            }
	            
	            
	            f[i] = prefix+suffix;
	        }
	        
	        return f[sLength];
	    }
}
