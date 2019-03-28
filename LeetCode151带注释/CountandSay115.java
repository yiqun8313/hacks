package leetcode151withexplain;

/**
 * �������⣺����һ���ַ�����Ȼ���ȡ����ַ������������Լ����ֵĴ�����ȡ������
 * 
 * The count-and-say sequence is the sequence of integers beginning as follows:
	1, 11, 21, 1211, 111221, ...
	
	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
 * 
 *  ����n,�����n���ַ����Ƕ��١�
 *
 *	����˼·��ͨ���ݹ���õķ�ʽ����ȡ��һ�ֵĽ����Ȼ���ȡ����һ����Ϊ��ǰ�Ľ��
 */
public class CountandSay115 {
	
	public String countAndSay(int n) {       
        //�߽�����
		if(n == 1){
            return "1";
        }
        
		//��¼���ֽ��
        String result = "";
        String preS = countAndSay(n-1);
        //��ʼ������ֵ����¼ס��һ���ַ��Լ����ִ���
        String pre = preS.substring(0,1);
        int count = 1;
        for(int i = 1; i < preS.length(); i++){
        	//ѭ�������ַ���   �жϵ�ǰ�ַ��Ƿ��ǰ����ַ����
            String current = preS.substring(i,i+1);
            if(current.equals(pre)){
                count++;
            }else{
            	//����ȵ�ʱ�򣬼�������ַ�
                result += String.valueOf(count)+pre;
                pre = current;
                count = 1;
            }
        }
        result += String.valueOf(count)+pre;    
        return result;  
    }
}
