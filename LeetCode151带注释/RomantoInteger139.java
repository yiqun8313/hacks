package leetcode151withexplain;

/**
 * �������⣺����һ���������ֵ��ַ�����ת��Ϊ����
 * 
 * ����˼·��ͨ�������ַ�����¼ס���ֺ������ַ�֮��Ķ�Ӧ��ϵ��Ȼ���ͷ��������ַ���s,Ȼ��ժ����Ӧ���ַ�ʱ��������Ӧ�����־Ϳ����ˡ����Ӧ�������ȼ���ϵ���ȳ���ʲô�ͼ�ʲô���ݡ�
 *
 */
public class RomantoInteger139 {
	
	public int romanToInt(String s) {
		//���������¼ס�����Ӧ��ϵ
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		//��ͷ��ʼ�����ַ���s
		int result = 0;
		for(int i = 0; i < s.length() ;){
			
			//����romanNums�����ÿһ��λ�ã����Ƿ�s�д���
			for(int j = 0; j < romanNums.length; j++){
				//��ȡromanLength
				int romanLength = romanNums[j].length();
				//�������ʣ����ַ���������Ҫ�󣬻����ҵ�������ַ���
				if((s.length() - i >= romanLength) && s.substring(i,i+romanLength).equals(romanNums[j])){
					result += values[j];
					i = i+romanLength;
					break;
				}
				
			}
		}
		
		return result;
	}
}
