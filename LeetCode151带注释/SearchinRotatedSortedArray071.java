package leetcode151withexplain;

/**
 * �������⣺����һ���������飬������û���ظ�����ĳһλ�ý����˷�ת���ڷ�ת����������ж��Ƿ����target���� 
 *
 *	Suppose a sorted array is rotated at some pivot unknown to you beforehand.

	(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
	
	You are given a target value to search. If found in the array return its index, otherwise return -1.
	
	�������˼·���ݹ����  ��ʵ�Ͷ���˼��Ҳ���  ֻ�Ƿֿ��������Ϊ���֣�һ�־��ǰ������еģ���ô�Ͱ����ֲ��ҷ�ʹ�ã�һ���Ǻ�ԭ�����鹹���࣬��ô�Ͷ��ֺ󣬵ݹ�����жϺ�����
 */
public class SearchinRotatedSortedArray071 {
	
   public int search(int[] A, int target) {
        if(A.length == 0){
            return -1;
        }else if(A.length == 1 && A[0] == target){
            return 0;
        }
        
        return searchPosition(A, target,0,A.length-1);
  }
  
  public int searchPosition(int[] A, int target,int startPosition, int endPosition){
      if(startPosition > endPosition){
         return -1;              
      }
      
      int result = -1;
      
      int left = startPosition;
      int right = endPosition;
      //�����һ������Χ��
      if(A[left] <= A[right]){
          
    	  //��ô�Ͱ��ն��ֲ��ҷ�����
          while(left <= right && A[left] <= A[right]){
              int mid = (left+right) >> 1;
              if(A[mid] == target){
                  return mid;
              }
              
              if(A[mid] > target){
                  right = mid - 1;
              }else{
                  left = mid + 1;
              }
          }
      }else{
          
    	  //�м�λ���ж�
          int mid = (startPosition+endPosition) >> 1;
          if(A[mid] ==  target){
              return mid;
          }
          
          //�ݹ���ã��ж���벿�ֺ��Ұ벿��
          result = searchPosition(A, target,startPosition,mid-1);
          if(result != -1){
              return result;
          }else{
              result = searchPosition(A, target,mid+1,endPosition);
          }
          
          
      }
      return result;
  }
}
