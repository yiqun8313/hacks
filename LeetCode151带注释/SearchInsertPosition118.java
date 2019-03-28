package leetcode151withexplain;

/**
 * �������⣺����һ�������Ŀ��ֵ  ���������Ŀ��ֵ�Ѿ�����  ��ô�����±�ֵ  ��������ڣ���ô�ͷ���Ӧ�ò����λ��
 *  Here are few examples.
	[1,3,5,6], 5 �� 2
	[1,3,5,6], 2 �� 1
	[1,3,5,6], 7 �� 4
	[1,3,5,6], 0 �� 0
 *
 *	����˼·����ǰ�������  �ҵ�λ��  �������˴����������
 */
public class SearchInsertPosition118 {
	
 	public int searchInsert(int[] A, int target) {
        if(A.length == 0){
            return 0;
        }
        int position = 0;
        //��ǰ�������   �ҵ�λ��
        for(int i = 0; i < A.length; i++){
            if(A[i] == target){
                return i;
            }else if(A[i] < target){
               position++;
            }else if(A[i] >= target){
                return position;
            }
            
        }
        //���������⴦��
        if(position == A.length){
            return position;
        }
        return 0;
    }
}
