package leetcode151withexplain;

/**
 * �������⣺������������  ������  ���������еĳ˷�   ���������ຯ��
 * 
 *
 */
public class DivideTwoIntegers123 {
	
	public int divide(int dividend, int divisor) {
        long a = (long)Math.abs((long)dividend);  
        long b = (long)Math.abs((long)divisor);  
        long res = 0;
        
        while(a >= b)  
        {  
            long c = b;
            //through << to accelate the caluation
            //cÿһ������һλ �ʹ������2,��ô������Ͱ�����1<<i��b
            for(int i = 0; a >= c; i++, c <<=1)  
            {  
                a -= c;  
                res += 1<<i;  
            }  
        } 
        
        //����������
        boolean positiveOrNot = true;
        if(dividend > 0 && divisor < 0) positiveOrNot = false;
        if(dividend < 0 && divisor > 0) positiveOrNot = false;
        
        return positiveOrNot == true ? (int)(res) : (int)(-res);  
    }
}
