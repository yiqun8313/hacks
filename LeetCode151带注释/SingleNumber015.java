package leetcode151withexplain;

/**
 * �����Ǵ�һ���������ҵ��������ֵ�һ����
 * 
 * �������˼·��ͨ���ֻ�ķ�ʽ���ҵ��ر���Ǹ�����������ͬ�����ֻ����0.
 *
 */
public class SingleNumber015 {
	public int singleNumber(int[] A) {
        if(A.length == 1){
            return A[0];
        }
        
       //ѭ�����ֻ����
       int answer = A[0] ^ A[1];
       for(int i = 2; i < A.length; i++){
           answer = answer ^ A[i];
       } 
       
       return answer;
    }
}
