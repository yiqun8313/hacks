package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * ���⣺��һ�仰�е��ַ������з�ת
 * Given s = "the sky is blue",
   return "blue is sky the".
 * 
 * ����Ľ���˼·����ͨ����ȡ�ַ��������еı仯λ�ã�Ȼ������֮����ŵı����ַ�����
 *
 * ʱ�临�Ӷ� O(n)
 * �ռ临�Ӷ� O(n)
 * 
 * ע��㣺�տ�ʼ��s������Ͽո���Ϊ�˷��Ϻ�������㷽�����ַ�������ش���������ı�ԭ�е��ַ���
 */
public class ReverseWordsinaString001 {

	
	public String reverseWords(String s) {
        //���ַ���������Ͽո����Ϊ����Ӧ������㷨
		s += "  ";
   	 	int sLength = s.length();
        
        List<Integer> resultPositions = new ArrayList<Integer>();
        
        //�ж��Ƿ��ַ���Ϊֻ�пո���ַ���
        if(s.replaceAll(" ","").equals("")){
            return "";
        }
        
        //�ҵ���һ��Ϊ�ǿյ��ַ���   ����Ҳ����ʹ��string.trim()��ֱ��ȥ�����˵Ŀո�
        int beginPosition = 0;
        for(int i = 0; i < sLength; i++){
            String currentS = s.substring(i,i+1);
            if(currentS.equals(" ")){
                beginPosition++;
            }else{
                break;
            }
        }
        
        //��λ����Ϣ���뵽�����
        resultPositions.add(beginPosition);
        
        //ѭ�������ַ����е�ÿһ���ַ���Ȼ���ҵ��仯��λ�� 
        for(int j = beginPosition; j < sLength-1;j++){
            String currentS = s.substring(j,j+1);
            String nextS = s.substring(j+1,j+2);
            if(nextS.equals(" ") && !currentS.equals(" ")){
                resultPositions.add(j+1);
            }
            
            if(!nextS.equals(" ") && currentS.equals(" ")){
                resultPositions.add(j+1);
            }
        }
        
        String results = "";
        //�����������꣬��������֮����������ŵ��ַ���
        for(int k = resultPositions.size(); k > 1; k = k-2){
            if(k == 2){
                results += s.substring(resultPositions.get(k-2),resultPositions.get(k-1));
            }else{
                results += s.substring(resultPositions.get(k-2),resultPositions.get(k-1))+" ";
            }
        }
          
        return results;
   }
	
	
}
