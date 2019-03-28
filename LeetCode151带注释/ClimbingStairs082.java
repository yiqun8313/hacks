package leetcode151withexplain;

/**
 *  �������⣺��n�׵�¥�ݣ�ÿ�ο�����һ������������������n��¥���ж����ַ�ʽ��
 *
 *	����˼·����ʵ����쳲���������  ��Ϊ���һ������Ҫ������һ���͵�  Ҫ�����������͵�  ��ô�����϶�������������ĺ� 
 */
public class ClimbingStairs082 {
	
	public int climbStairs(int n){
        
        if(n == 0){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }
        
        if(n == 2){
        	return 2;
        }
        
        int[] num = new int[n+1];
    	num[0] = 0;
    	num[1] = 1;
    	num[2] = 2;
    	for(int i = 3; i <= n; i++){
    		//���ƹ�ʽ
    		num[i] = num[i-1] + num[i-2];
    	}
        
        return num[n];
        
    }
}
