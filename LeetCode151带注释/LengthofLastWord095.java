package leetcode151withexplain;

/**
 *  �������⣺����һ���ַ��������ظ��ַ������һ�����ʵĳ��ȡ�
 *  
 *  For example, 
	Given s = "Hello World",
	return 5.
 *
 *	����˼·���ܼ򵥣�ֱ�ӴӺ��濪ʼ���������ҵ���һ�����ǿո��λ�ã�Ȼ��Ӹ�λ�ü�����ǰ�ң�ֱ��������һ���ո񣬾Ϳ����������
 */
public class LengthofLastWord095 {
	
 	public int lengthOfLastWord(String s) {
        int answer = 0;
        int sLength = s.length();
        
        //�Ӻ�����ǰ������ֱ��������һ���ַ�
        int firstPosition = sLength;
        for(int i = 0; i < sLength; i++){
            String currentS = s.substring(sLength-1-i,sLength-i);
            if(currentS.equals(" ")){
                firstPosition--;
            }else{
                break;
            }
        }
        
        //�Ӻ���ĵ�һ���ַ���ʼ������ֱ�����ֿո���ô�������answer
        for(int j = 0; j < firstPosition; j++){
            String currentS = s.substring(firstPosition-1-j,firstPosition-j);
            if(currentS.equals(" ")){
                break;
            }else{
                answer++;
            }
        }
        
        return answer;
    }
}
