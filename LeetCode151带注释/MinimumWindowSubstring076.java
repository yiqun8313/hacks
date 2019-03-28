package leetcode151withexplain;

/**
 * �������⣺���������ַ���S��T����S���ҳ�����T�������ַ�������Ӵ�
 * For example,
	S = "ADOBECODEBANC"
	T = "ABC"
	Minimum window is "BANC".
	
	����˼·��ͨ���������飬һ�����ڼ�¼��Ҫ�ҵ����ַ��ж��٣�һ�����ڴ洢�Ѿ��ҵ����ַ��ж��٣�
	��һ�������洢��ǰ�Ѿ��ҵ��Ŀ����ַ���Ŀ�����Ѿ��ﵽ�˿����ַ���ʱ�򣬱����ѭ�����Ѷ�����ַ�ȥ����ֱ�����ÿ��Դﵽ������ַ���
	Ȼ�������̴��ڵĿ�ʼλ�úͽ���λ�á�Ȼ��ѭ��������
	
	���ǵ�ÿһ���ַ������ֵ�ʱ����ô�Ҿ���Ϊ�����ҵ���ôһ����Χ�ˣ������ַ����ظ��ģ���ôԽ������ֵ�ʱ�򣬿��ܴ��ھ�ԽС������Ҫ���ϵ���С���ڡ�
 *
 */
public class MinimumWindowSubstring076 {
	
	public static void main(String[] args){
		String S = "aabcedfsgabced";
		String T = "abc";
		MinimumWindowSubstring076 object = new MinimumWindowSubstring076();
		object.minWindow(S, T);
	}
	
	public String minWindow(String S, String T) {
		//�����������
		int sLen=S.length();  
        int tLen=T.length();  
        if(tLen==0 || sLen < tLen) return "";  
          
        //�����������ڼ�¼  ��Ҫ�ҵ����ַ����Ѿ��ҵ����ַ�
        //assic֮������0-127����Ϊ��1byte��8λ�����Ա�ʾ256����������û����ô���ַ���ֻ�õ�����λ����һλΪ0.������128������0-128
        int[] needFind = new int[256]; 
        int[] hasFind = new int[256];  
          
        //��ʼ����Ҫ���ַ�����
        for(int i = 0; i < tLen; i++)  
        {  
            needFind[T.charAt(i)]++;  
        }  
          
        //��С�Ĵ��ڳ���
        int minWindowLength=Integer.MAX_VALUE;
        //��С���ڵĿ�ʼλ�úͽ���λ��
        int minBegin = 0;  
        int minEnd = sLen - 1;
        //��ʼλ�úͽ���λ��
        int begin=0;  
        int end=0;
        
        
        for(int count=0;end<sLen;end++){  
            //����ַ���������T�У���ô��continue
            if(needFind[S.charAt(end)]== 0) continue;  
              
            //���������T�У���ô�ҵ�һ���������ҵ�������λ��++
            hasFind[S.charAt(end)]++;
            
            //update the total number of characters found(aaa only counts 2 for aa in T)
            //ֻҪ��������ַ�δ�õ�����  ��ôcount��++
            if(hasFind[S.charAt(end)] <= needFind[S.charAt(end)])  
                count++;  
                  
            //a window exists from begin to end
            //���Ѿ��ҵ�������������ַ�
            if(count == tLen){  
                //move begin pointer to find the minimum window
            	//end��¼���ǵ�ǰ�Ѿ����ʵ���λ��
                while(begin < end){
                	//����������ַ�����Ҫ����ô�Ϳ��ȥ
                    if(needFind[S.charAt(begin)]==0){  
                        begin++;  
                        continue;  
                    }  
                    //�Ѿ��ҵ��Ĵ�������Ҫ��
                    if(hasFind[S.charAt(begin)] > needFind[S.charAt(begin)]){  
                        //�Ѿ��ҵ��ľ�--
                    	hasFind[S.charAt(begin)]--;
                    	//��ǰ�ƶ�
                        begin++;  
                        continue;  
                    }  
                    else  
                        break;  
                }  
                  
                int tmpWindowLength=end-begin+1;  
                  
                if(tmpWindowLength < minWindowLength)  
                {  
                    minBegin=begin;  
                    minEnd=end;  
                    minWindowLength=tmpWindowLength;  
                }  
            }  
        }  
          
        if(minWindowLength == Integer.MAX_VALUE)  
            return "";  
        
        return S.substring(minBegin,minBegin+minWindowLength);  
		      
	}
}
