package leetcode151withexplain;

/**
 * �������⣺����������������  ��B�е�Ԫ�غϲ���A��  ��������
 * 
 * �������˼·����ʹ����B�е�Ԫ�أ�Ȼ�����β��뵽A�оͿ��ԡ�
 * 
 * ע��㣺���ƶ�Ԫ�ص�ʱ��Ҫע��߽�ı仯�������ƶ�Ԫ�ص�ʱ����������⴦��
 */
public class MergeSortedArray063 {
	
	public void merge(int A[], int m, int B[], int n) { 
        int startPosition = 0;
        int bIndex = 0;
        while(bIndex < n){
            int bNumber = B[bIndex];
            int i;
            for(i = startPosition; i < m; i++){
                
                //judge the first element whether > bNumber
                if(A[i] > bNumber){
                    int j = m;
                    for(; j > i;j--){
                        A[j] = A[j-1];
                    }
                    A[i] = bNumber;
                    m++;
                    break; 
                }
                
            }
            
            //deal with special situation �������⴦��
            if(i == m){
                A[m] = bNumber;
                m++;
            }
            
            //��һ����ʼλ�þͿ��Բ���0��ʼ��
            startPosition = i+1;
            bIndex++;
        }
     }
}
