package leetcode151withexplain;

/**
 * �������⣺�ݺ���  X��N���ݺ���
 *
 *  ����˼·�����ȿ���ͨ���ݹ���õķ�ʽ���øú�����Ҫ����n�ĸ��������n����0��ʱ����ô�������1�����n<0��ʱ����ô��Ҫ��תһ�£�С��0��ʱ�򣬻����ڵ���integer��Сֵ�������
 *  Ȼ���ڼ���Ĺ����п�����Ծ���㡣
 *  
 *  
 */
public class PowXN103_ThinkAgain {
	
	public static void main(String[] args){
		PowXN103_ThinkAgain object = new PowXN103_ThinkAgain();
		object.pow(2.0, 15);
	}
	
	public double pow(double x, int n) {
        //nС�����ʱ��
		if(n<0){  
			//���n����������Сֵ
			//2147483647
			//-2147483648
			//��Сֵ�ľ���ֵ�����ֵ�ľ���ֵ��1
            if(n == Integer.MIN_VALUE)  
                return 1.0 / (pow(x,Integer.MAX_VALUE)*x);  
            else  
                return 1.0 / pow(x,-n);  
        }
        
        //�߽�����
        if(n==0)  
            return 1.0;  
        
        //ans���ڼ�¼���
        double ans = 1.0 ;  
        
        
        //ÿ�ζ���x��2�η�   ѭ����i�Σ���ôx�͵���x��2^i�η��� ����n����Բ��ϵĳ���2
        for(;n>0; x *= x, n>>=1)  
        {  
        	//�ж�n����������ż��
            if((n & 1) > 0)  
                ans *= x;  
        }  
        return ans;  
    }
	
	//���ַ�ʽ�����stackover  ͨ���ݹ���õķ�ʽ��ȡ
	public double pow1(double x, int n) {
		//�߽������ж�
        if(n == 0){
            return 1.0;
        }
        
        //���С��0����ô��Ӧ����������
        if(n < 0){
            return 1.0/pow1(x,-n);
        }
        
        //��ȡһ���power
        double half = pow1(x,(n >> 1));
        
        //�����ż��  ��ô����half*half
        if(n % 2 == 0){
            return half * half;
        //�������0  ��ô����half*half*x
        }else{
            return half * half * x;
        }
    }
}
