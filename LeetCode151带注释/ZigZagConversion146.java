package leetcode151withexplain;

/**
 * �������⣺����һ���ַ��������ַ�����ͨ��Z�������У�Ȼ�����Z�������е�˳���ȡ�����
 * 
 *  P   A   H   N
	A P L S I I G
	Y   I   R
    And then read line by line: "PAHNAPLSIIGYIR"
    
          ����˼·��һ��һ�еĶ�ȡ������ǵ�һ�л������һ�У���ôԪ��֮��Ĳ�����һ���̶��������м��У���ô��Ҫ֪����������һ�У���������ֵ��μ��㣬ż������μ��㶼���й̶����ɵġ�
 * 
 *
 */
public class ZigZagConversion146 {
	
	public String convert(String s, int nRows) {
		//�����������
		if (nRows <= 1 || s.length() == 0)  
	           return s;  
	  
        String res = "";  
        int len = s.length();
        //һ��һ�еĶ�ȡ�������ַ���  ע��i��������С�ڳ��ȣ�С������
        for (int i = 0; i < len && i < nRows; ++i)  
        {  
        	//һ��һ�еĶ�ȡ     �ؼ�������μ������һ��λ�õ��±�
            int indx = i;  
            res += s.substring(indx,indx+1);  
  
            for (int k = 1; indx < len; ++k)  
            {  
                //deal with the first and last row
            	//�����ǰ������ǵ�һ�л������һ��  ��ôԪ��֮�����ľ������ 2 * nRows - 2
                if (i == 0 || i == nRows - 1)  
                {  
                    indx += 2 * nRows - 2;  
                }  
                //middle rows
                //������м���   ��ô��Ҫ����λ����һ������
                else  
                {  
                    if ((k & 1) > 0) 
                        indx += 2 * (nRows - 1 - i);  
                    else indx += 2 * i;  
                }  
  
                //�����Ԫ�ػ�ûԽ�磬��ô�����ӵ������
                //judge validate
                if (indx < len)  
                {  
                    res += s.substring(indx,indx+1);  
                }     
            }  
        }  
        return res;  
    }
}
