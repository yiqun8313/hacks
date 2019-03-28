package leetcode151withexplain;

import java.util.ArrayList;

/**
 * �������⣺����һ���ַ������ַ����е��ַ��������ţ��ʸ��ַ����Ƿ���ƥ��ġ�
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 *
 * ����˼·�������ַ�����ÿһ��Ԫ�أ���������Ԫ�أ���ô��Ҫ��ջ��Ԫ�������ܷ��ҵ�ƥ������������У���ô�͵�������������ƥ�����е������
 */
public class ValidParentheses131 {
	
		public boolean isValid(String s) {
           
			//ģ��ջ  ��������ƥ�����⾭���õ�ջ
		    ArrayList<String> likeStack = new ArrayList<String>();
	        
		    //�����������
	        int sLength = s.length();
	        if(sLength == 1) return false;
	        
	        //��ѹ��һ��
	        likeStack.add(s.substring(0,1));
	        
	        //��ʼ���������
	        for(int i = 1; i < sLength; i++){
	            String tempS = s.substring(i,i+1);
	            
	            //��ȡջ��Ԫ��  ���Ƿ�ƥ��
	            int currentSize = likeStack.size();
	            
	            if(currentSize > 0){
	            
	   	            String topS = likeStack.get(currentSize-1);
	   	            
	   	            //������ڵ��ǣ�,��ô��Ҫ��ջ���Ƿ���(Ԫ��
	   	            if(tempS.equals(")")){
	   	                if(!topS.equals("(")) return false;
	   	                else{
	   	                	//���ƥ��͵���
	   	                	likeStack.remove(currentSize-1);
	   	                	//������continue
	   	                	continue;
	   	                }
	   	            }
	   	            
	   	            //ͬ���ĵ���  �ж�����ƥ�����
	   	            if(tempS.equals("}")){
	   	                if(!topS.equals("{")) return false;
	   	                else{ 
	   	                	likeStack.remove(currentSize-1);
	   	                	continue;
	   	                }
	   	            }
	   	            
	   	            if(tempS.equals("]")){
	   	                if(!topS.equals("[")) return false;
	   	                else{ 
	   	                	likeStack.remove(currentSize-1);
	   	                	continue;
	   	                }
	   	            }
	            }
	            
	            //�����ѹ�뵽ջ��
	            likeStack.add(tempS);
	        }
	        
	        //�ж�ջ���滹��Ԫ�����
	        if(likeStack.size() > 0) return false;
	        
	        return true;
		}
}
