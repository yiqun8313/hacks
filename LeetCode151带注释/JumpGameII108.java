package leetcode151withexplain;

/**
 * �������⣺����һ�����飬ÿһλ�����Ԫ�ش���ǰԪ�ؿ�����ǰ���Ĳ����������ٶ��ٲ��ܹ�������Ԫ�ء�
 * 
 * ����˼·��ͨ��start��end��ʶһ������Ŀ�ʼ�ͽ���������ǰ���������ķ�Χ��Ȼ���ҵ��ɸ����������������Զλ�á�����ѭ��������ҵ�һ���µ����䣬end+1���ղ�������Ŀɴ�λ�á�
 * û���һ���ռ䣬��ôk++,��������֮�����Ծ�������Դﵽ�����ˡ�
 * 
 * ע��㣺���������ȥ��ʱ�򣬷���-1
 */
public class JumpGameII108 {
	
	public int jump(int[] A) {
        int n = A.length;
        int  k = 0;  
        int start = 0;  
        int end = 0;
        //��end��δ��������ʱ��
        while(end < n-1)  
        {   
        	
            int newEnd = Integer.MIN_VALUE;
            //�������ڿɱ����Ľڵ�   �ҵ������Ը��ǵ��ĵط�
            for(int i = start; i <= end; ++i)  
                newEnd = max(newEnd, A[i]+i);
            
            //����޷���ǰ��
            if(newEnd == end) return -1;
            
            start = end+1;  
            end = newEnd;  
            ++k;  
        }  
        return k;  
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}
