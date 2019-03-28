package leetcode151withexplain;

/**
 * �������⣺����һ�����飬�������������Σ�ȥ�أ�Ȼ�󷵻ؽ������Ĵ�С
 * 
 *  For example,
	Given sorted array A = [1,1,1,2,2,3],

	Your function should return length = 5, and A is now [1,1,2,2,3].
	
	
 *
 */
public class RemoveDuplicatesfromSortedArrayII072 {
	
	public int removeDuplicates(int[] A) {
        int n = A.length;
        if(n == 0) return n;
        
        //���ڼ�¼ǰ�������
        int prevNum = A[0];
        //���ڼ�¼��ǰ��������ͬ�������м���
        int prevCnt = 1;
        //��¼��ǰ�±�
        int curIdx = 1;
        //ѭ�����������е�ÿһ��Ԫ��
        for(int i = 1; i < n; ++i)  
        {  
        	//������ڵ�Ԫ�غ�ǰ���Ԫ�����
            if(A[i] == prevNum)  
            {  
            	//�����������   �Ѿ�������������ʱ��
                if(prevCnt == 2) continue;  
                else{ 
                	//����δ��������
                    A[curIdx++] = A[i];
                    prevCnt++;
                }
            }
            //�������� 
            else  
            {  
                A[curIdx++] = A[i];  
                prevNum = A[i];  
                prevCnt = 1;  
            }  
        }  
        return curIdx;  
        
    }
}
