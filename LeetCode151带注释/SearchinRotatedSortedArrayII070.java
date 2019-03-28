package leetcode151withexplain;

/**
 * �������⣺��71����  ������ԭ�����������������ظ���Ԫ�� 
 *
 */
public class SearchinRotatedSortedArrayII070 {
	public boolean search(int[] A, int target) {
        if(A.length == 0){
            return false;
        }
        
        return searchDetail(A, target ,0, A.length-1);
    }
    
    public boolean searchDetail(int[] A, int target ,int startPosition, int endPosition){
        if(startPosition > endPosition){
            return false;
        }
        
        boolean result = false;
        
        //�ҵ���ֵ��ͬ�ĵ�  ȥ���ظ��ĵ�    ȥ����ͷ���ظ�Ԫ��
        while(startPosition <= endPosition && A[startPosition] == A[endPosition]){
        	//����ҵ������  ����true
            if(A[startPosition] == target){
                return true;
            }else{
                startPosition++;
            }
        }
        
        if(startPosition <= endPosition){
        
            if(A[startPosition] < A[endPosition]){
                while(startPosition <= endPosition){
                    int mid  = (startPosition + endPosition) >> 1;
            
                    if(A[mid] == target){
                        return true;
                    }
                    if(A[mid] > target){
                        endPosition  = mid -1;
                    }else{
                        startPosition = mid + 1;
                    }
                }
                
            }else{
                
                int mid = (startPosition + endPosition) >> 1;
                if(A[mid] ==  target){
                    return true;
                }
                
                result = searchDetail(A, target ,startPosition, mid-1);
                if(result == true){
                    return true;
                }else{
                    result = searchDetail(A, target ,mid+1, endPosition);
                }
                
            }
        
        }
        return result;
    }
}
