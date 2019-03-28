package leetcode151withexplain;

/**
 * �������⣺����һ���������������Ӧ�������ַ���
 * 
 * ����˼·��
 *  
 */
public class IntegertoRoman140 {
	
	public String intToRoman(int num) {
		//�����������¼ס��Ӧ��ϵ
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] romanNums = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		//��stringbuilder�����������
		StringBuilder stringBuilder = new StringBuilder();
		//����values����ÿһ��Ԫ�أ�������е����ֳ�Խ������Ҫ���֣���ô�����϶�Ӧ�������ַ�
		for(int i = 0; i < values.length; i++){
			//�����һ��ѭ����ϵ����Ϊ�����ܶ�������϶�Ӧ�������ַ�
			while(num >= values[i]){
				stringBuilder.append(romanNums[i]);
				num = num - values[i];
			}
		}
		return stringBuilder.toString();
    }
}
