package leetcode151withexplain;

/**
 *  �������⣺��ƽ����
 *  Implement int sqrt(int x) 
 *  
 *  ����˼·�����ö��ֲ��ҵķ����ҵ������ֵ�Ϳ�����
 *
 */
public class Sqrtx083 {
	
	public int sqrt(int x) {
         if(x < 0) return 0;
	     if(x == 0) return 0;
	     if(x == 1) return 1;
	     //�ó����������������  �ǳ�����Ҫ  ����Խ��
	     long  result = 0;
	     long  left = 0;
	     long   right = x;
	     //���ö��ֵķ����ҵ������Ԫ��
	     while(left < right){
	    	 //���м�Ԫ�ؿ�ʼ
	         long middle = left  + ((right-left) >> 1);
	         long tempresult = middle*middle;
	         if(tempresult == x){
	             return (int)middle;
	         }
	         
	         //һ�±Ƚ�����  ��Ϊ��Щʱ����ܲ����ϸ����  �������ʱ���޷��ٷ�  ��ô��ѡ��left����right�������ֵ
	         if(tempresult > x && middle != right){
	             right = middle;  
	         }else if(tempresult < x && middle != left){
	             left = middle;
	         }else{
	             result = middle == left? left:right;
	             break;
	         }
	         
	     }
	     return (int)result;
   }
}
