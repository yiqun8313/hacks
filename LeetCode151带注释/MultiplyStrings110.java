package leetcode151withexplain;

/**
 * �������⣺���������ַ����������������֣�Ȼ�������˻�
 * 
 * ����˼·��ͨ��һ����������¼ÿһλ�ϻ��۵���ֵ��ģ��˷����㣬Ȼ������ÿһλ��������֡������˽�λ�ļ��㡣������ȥ������ǰ��Ϊ0�Ĳ��֡�
 *
 */
public class MultiplyStrings110 {
	
	 //���ڼ�¼ÿһλ�������ֵ����
	 public int[] positionValue;
	 
     public String multiply(String num1, String num2) {
        if(num1 == null || num2 == null) return null;
        if(num1.equals("0") || num2.equals("0")) return "0";
       
        //����һ��˳��  ��������ļ���
        if(num1.length() < num2.length()){
        	String temp = num1;
        	num1 = num2;
        	num2 = temp;
        }
        
        //������λ��  ������λ����ˣ��������λ��
        int num1Size = num1.length();
        int num2Size = num2.length();
        int totalSize = num1Size + num2Size + 1;
        positionValue = new int[totalSize];
        
        for(int i = 0; i < num2Size; i++){
            helper(num1,i,num2.substring(num2Size-1-i,num2Size-i));
        }
        
        String answer = getAnswer();  
        return answer;         
     }
     
     //���ؽ��
     public String getAnswer(){
    	 
    	 String answer = "";
    	 int pValueSize = positionValue.length;
    	 int flag = 0;
    	 //����λ������ıȽ϶࣬����0��ȥ��
    	 for(int j = pValueSize-1; j >= 0; j--){
    		 if(positionValue[j] == 0){
    			 pValueSize--;
    			 continue;
    		 }else{
    			 break;
    		 }
    	 }
    	 //����ÿһ��λ�ã�Ȼ������ַ���
    	 for(int i = 0; i < pValueSize; i++){
    		 int currentSum = positionValue[i] + flag;
    		 if(currentSum >= 10){
    			 answer = currentSum % 10 + answer;
    			 flag = currentSum / 10;
    		 }else{
    			 answer = currentSum + answer;
    			 flag = 0;
    		 }
    	 }
    	 
    	 //���������Ľ�λ
    	 if(flag != 0){
    		 answer = flag + answer;
    	 }
    	 
    	 return answer;
     }
     
     /**
      * ���ó˷��Ĵ�ͳ˼��   ��������ÿһλ�ֱ���������   ��ȡ������ֵ��Ӧλ����ӾͿ�����
      * @param num1
      * @param startPosition ��ʼ������λ��
      * @param multipa
      */
     public void helper(String num1,int startPosition, String multipa){
        int num1Length = num1.length();
        int flag = 0;
        for(int i = 0; i < num1Length; i++){
            int currentResult = Integer.parseInt(num1.substring(num1Length-i-1,num1Length-i)) * Integer.parseInt(multipa);
            //�����˽�λ����
            int currentInt = currentResult + flag;
            int gewei = currentInt % 10;
            int shiwei = currentInt / 10;
            //���positionValue
            if(currentInt >= 10){
                flag = shiwei;
                positionValue[startPosition] = positionValue[startPosition] + gewei;
                startPosition++;
            }else{
            	positionValue[startPosition] = positionValue[startPosition] + gewei;
            	startPosition++;
                flag = 0;
            }
        }
        
        //����������λ�Ĵ���
        if(flag != 0){
            positionValue[startPosition] = positionValue[startPosition] + flag;
        }
    }
}
