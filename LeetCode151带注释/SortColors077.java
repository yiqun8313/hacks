package leetcode151withexplain;

/**
 * �������⣺�����в�ͬ����ֵ����ͬ����ɫ  ��Ҫ����ɫ��������
 * 
 * ��ʵ������������������  ��������
 *
 */
public class SortColors077 {
	public void sortColors(int[] A) {
        for(int i = 0; i < A.length; i++){
            for(int j = i+1; j < A.length; j++){
                if(A[j] < A[i]){
                    int temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }
            }
        }   
    }
}
