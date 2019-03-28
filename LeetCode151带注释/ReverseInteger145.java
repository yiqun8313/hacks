package leetcode151withexplain;

/**
 * �������⣺����һ����������ת�������
 * 
 *  Example1: x = 123, return 321
	Example2: x = -123, return -321
 * 
 * 	����˼·��ͨ��ȡ��������֪������������ʲô��Ȼ�����γ���10�Ӹջ�ȡ��ĩβԪ�ء�Ȼ��������������Ĵ���
 *
 */
public class ReverseInteger145 {
	
   	public int reverse(int x) {
   		//�������0-10֮�����0--10֮��  ��λ�� ֱ�ӷ���
        if(x > 0 && (x/10) < 1){
            return x;
        }else if(x < 0 && (x/10) > -1){
        	return x;
        }
        
        //���������ȽϷ���   ������y���洢
        int y = 0;
        if(x > 0){
        	y = x;
        }else{
        	y = -x;
        }
        
        //��ȡ���һλ  Ȼ�����μ���
        int result = 0;
        while(y / 10 >= 1){
            int lastNum = y % 10;
            result = result*10 + lastNum;
            y = y/10;
        }
        
        //���������ʣ�����ݵĴ���
        result = result*10 + y;
        
        if(x > 0){
            return result;
        }else{
            return 0-result;
        }
    }
}
