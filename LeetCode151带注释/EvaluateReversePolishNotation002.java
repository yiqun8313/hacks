package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;


/**
 * �����������a+b����׺���ʽ��Ҳ��ǰ׺���ʽ�ͺ�׺���ʽ��Ϊ�˼��겨����ѧ�ң�����׺���ʽ��Ϊ�沨�����ʽ��ǰ׺���ʽ��Ϊ�������ʽ��
 * ��׺���ʽ���ŵ����Զ��׼��ģ��������ڴ���ʱ���մ������ҵ�˳���ȡ�沨�����ʽ�������������ֱ��ѹ���ջ������������ʹӶ�ջ��ȡ���������������м��㣬����������÷����˼���������ԭ��
 *Reverse Polish Notation   
 *["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5))
 * 
 * ��һ�������б�ģ��ջ���������־�ѹ��ջ������������ʹ�ջ��ȡ�����ֽ��м��㣬Ȼ���м�������ջ�С�
 * 
 * ʱ�临�Ӷȣ�O��n��
 * 
 * ע��㣺��ʱ����ջ�Ĵ�С
 */
public class EvaluateReversePolishNotation002 {
	
	public int evalRPN(String[] tokens) {
		
		//��numbersģ��ջ  ջ���ڴ洢��Ҫ�����������
        List<Integer> numbers = new ArrayList<Integer>();
        int firstNum;
        int secondNum;
        int numberSize;
        
        //���λ�ȡÿһ���ַ���Ȼ���ж�����
        for(String currentToken : tokens){
        	
        	//ÿһ�ζ�Ҫ�ǵø���numberSize
        	numberSize = numbers.size();
        	if(currentToken.equals("+")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		//������м�������ѹ��ջ��
        		int middleResult = firstNum + secondNum;
        		numbers.add(middleResult);
        		
        	}else if(currentToken.equals("-")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum - secondNum;
        		numbers.add(middleResult);
        		
        	}else if(currentToken.equals("*")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum * secondNum;
        		numbers.add(middleResult);
        	}else if(currentToken.equals("/")){
        		firstNum = numbers.get(numberSize-2);
        		secondNum = numbers.get(numberSize-1);
        		numbers.remove(numberSize-1);
        		numberSize = numbers.size();
        		numbers.remove(numberSize-1);
        		int middleResult = firstNum / secondNum;
        		numbers.add(middleResult);
        	}else{
        		numbers.add(Integer.parseInt(currentToken));
        	}
        	
        	
        }
        return numbers.get(0);
    }
}
