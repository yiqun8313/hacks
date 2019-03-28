package leetcode151withexplain;

/**
 * �������⣺����һ������������һ��Ŀ��ֵ���ҵ��������и�Ŀ��ֵ���ֵķ�Χ
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
   return [3, 4].
 *
 *	����˼·�����ö��ֲ��ҵķ�ʽ������м�λ�õ���Ŀ��ֵ����ô�����������ҵ���Χ��������ڣ���ô������߲��ֵݹ���ã����С�ڣ���ô�����ұ߲��֡�
 */
public class SearchforaRange119 {
	
	public int[] searchRange(int[] A, int target) {
        return searchRangeDetail(A, 0, A.length-1,target);
    }
    
	/**
	 * ���ط�Χ
	 * @param A ����������
	 * @param startPosition ����Ŀ�ʼλ�� 
	 * @param endPosition ����Ľ���λ��
	 * @param target Ŀ��ֵ
	 * @return
	 */
    public int[] searchRangeDetail(int[] A, int startPosition, int endPosition, int target){
        int[] result = new int[2];
        
        //�����ʼλ�ô��ڽ���λ��  ��ô����û���ҵ�
        if(startPosition > endPosition){
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        
        //�����ʼλ�úͽ���λ��һ��   ���ҿ�ʼ�ͽ������
        if(startPosition == endPosition){
            if(A[startPosition] == target){
                result[0] = startPosition;
                result[1] = endPosition;
            }else{
                result[0] = -1;
                result[1] = -1;
            }
            return result;
        }
        
        //�ҵ��м�λ��
        int midPosition = (startPosition + endPosition) >> 1;
        //����Ŀ��ֵ��ʱ����ô�������ҵĲ���  Ȼ��ϲ�����Ϳ�����
        if(A[midPosition] == target){
        	//�ֱ��ҵ���ߵķ�Χ���ұߵķ�Χ
            int[] leftR = searchRangeDetail(A, startPosition, midPosition,target);
            int[] rightR = searchRangeDetail(A, midPosition+1, endPosition,target);
            //������߶���-1
            if(leftR[0] == -1 && rightR[0] == -1){
                return leftR;
            }
            //���û�ҵ����ұ��ҵ���
            if(leftR[0] == -1 && rightR[0] != -1){
                return rightR;
            }
            
            //����ҵ��ˣ��ұ�û���ҵ�
            if(leftR[0] != -1 && rightR[0] == -1){
                return leftR;
            }
            
            //���ҵ���
            if(leftR[0] != -1 && rightR[0] != -1){
                if(leftR[0] > rightR[0]){
                    leftR[0] = rightR[0];
                }
                
                if(leftR[1] < rightR[1]){
                    leftR[1] = rightR[1];
                }
                
                return leftR;
            }
            
        }
        
        
        //����м�ֵ����Ŀ��ֵ
        if(A[midPosition] > target){
            return searchRangeDetail(A, startPosition, midPosition,target);
        }
        
        //����м�ֵС��Ŀ��ֵ
        if(A[midPosition] < target){
            return searchRangeDetail(A, midPosition+1, endPosition,target);
        }
        
        return result;
    }
}
