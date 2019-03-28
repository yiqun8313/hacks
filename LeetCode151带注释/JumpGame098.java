package leetcode151withexplain;

/**
 *  �������⣺����һ�����飬�����е����ִ�������λ���Ͽ���������������룬���ܷ��������ĵط���
 *  
 *  For example:
	A = [2,3,1,1,4], return true.
	A = [3,2,1,0,4], return false.
 *
 *	����˼·��ͨ���ҵ�ÿһ��λ���ܹ����쵽����Զ�ط�������ж��ܷ�����λ�þͿ�����
 */
public class JumpGame098 {
	
	public boolean canJump(int[] A) {
        int aLength = A.length;
        //��ʼ��maxTouch�����ڼ�¼������Զ�ܹ�����ĵط�
        int maxTouch = A[0];
        //�������  ����һ��Ԫ��  ���ҳ��ȴ���1��ʱ��
        if(maxTouch == 0 && A.length != 1) return false;
        
        //�ӿ�ʼλ�ñ�����֪�����tempTouch
        for(int i = 0; i <= maxTouch && i < aLength; i++){
            int tempTouch  = i + A[i];
            if(maxTouch < tempTouch){
                maxTouch = tempTouch;
            }
        }
        
        //�ж�maxTouch��������Դﵽ���λ�ã��ͷ���true
        if(maxTouch >= (aLength-1)){
            return true;
        }else{
            return false;
        }
    }
}
