package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * ��������:����һ���ַ���   ����ֽ�Ϊ��ȷ��ip��ַ   ���ҷ��ؽ��
 * For example:
	Given "25525511135",
	
	return ["255.255.11.135", "255.255.111.35"]. 
	
	һ��˼·������������ȱ����ķ�ʽ��ÿһ����εĿ���ȡֵ����ȡ1���� 2����  3����
 *
 *	
 */
public class RestoreIPAddresses058 {
	
	
	public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        if(s == null) return result;
        int sLength = s.length();
        //���⴦��
        if(sLength < 4 || sLength > 12) return result;
        getResult(result,"",s,0,0,sLength);
        return result;
    }
    
	/**
	 * �ݹ�ĵ��û�ȡ���   ��ʵ��ʹ������ȱ���
	 * @param result  ��� 
	 * @param temp ��ʱ���
	 * @param s ԭ�ַ���
	 * @param dotNum ��ö���
	 * @param currentPosition  ��ǰλ��
	 * @param sLength s�ַ����ĳ���
	 */
    public void getResult(ArrayList<String> result,String temp,String s,int dotNum,int currentPosition,int sLength){
        //��.λ��
    	if(dotNum > 0 && dotNum < 4){
        	temp = temp+".";
        }
        
    	//��������
        if(currentPosition > sLength){
        	return;
        }
        
        //��ȡ����һ�����
        if(dotNum == 4 && currentPosition == sLength){
            result.add(temp);
            return;
        //��Ȼ��Ϊ���ĶΣ�����û�е��ַ�������λ��
        }else if(dotNum == 4 && currentPosition != sLength){
        	return;
        }
        
        //������ȱ���   ��ȡ 1λ  2λ  3λ
        for(int i = 1; i <=3 && currentPosition + i <= sLength; i++){
        	
            String currentS = s.substring(currentPosition,currentPosition+i);
            //��ȡ�ַ������������ô�͵ݹ����
            if(isVail(currentS)){
            	//����ֵ�ķ�ʽ 
                getResult(result,temp + currentS,s,dotNum+1,currentPosition+i,sLength);
            }
        }
    }
    
    //�ж�һ���ַ����ǲ��ǺϷ���
    public boolean isVail(String s) {
    	//������Ȳ�Ϊ1 ���ҵ�һ������0  �����Ĳ��Ϸ�
        if (s.length() != 1 && s.charAt(0) == '0') 
           return false;
        
        //�����ַ����Ĵ�С  s.charAt(i) - '0'�ܹ��������ֵ  ���ͦ���õ�
        int n = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); ++i) {
            n *= 10;
            n += (s.charAt(i) - '0');
       }
        
       return n <= 255;
   }
    
    
    //another method
    public static List<String> restoreIpAddresses2(String s) {
        List<String> answer = new ArrayList<String>();
        getResult(answer,"",0,s.length(),0,s);
        return answer;
        
    }
    
    public static void getResult(List<String> answer, String temp, int curPos, int n, int potSize, String s){
        if(curPos == n && potSize == 4){
            answer.add(temp.substring(0,temp.length()-1));
            return;
        }
        
        if(potSize > 4) return;
        
        
        for(int i = 1; i <= 3 && (curPos + i) <= n; i++){
            String curS = s.substring(curPos,curPos+i);
            if(isVail2(curS)){
                getResult(answer,temp+curS+".",curPos+i,n,potSize+1,s);
            }
        }
    }
    
    public static boolean isVail2(String s) {
        if (s.length() != 1 && s.charAt(0) == '0') 
           return false;
        
        int n = s.charAt(0) - '0';
        for (int i = 1; i < s.length(); ++i) {
            n *= 10;
            n += (s.charAt(i) - '0');
       }
        
       return n <= 255;
   }
    
    
    public static void main(String[] args){
    	RestoreIPAddresses058.restoreIpAddresses2("0000");
    }
    
    
}
