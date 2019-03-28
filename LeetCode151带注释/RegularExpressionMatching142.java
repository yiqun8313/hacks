package leetcode151withexplain;

/**
 * �������⣺�����ַ���ƥ��   .��������һ���ַ���*����ǰ���Ԫ���ظ�0�λ�����������
 * 
 *  Some examples:
	isMatch("aa","a") �� false
	isMatch("aa","aa") �� true
	isMatch("aaa","aa") �� false
	isMatch("aa", "a*") �� true
	isMatch("aa", ".*") �� true
	isMatch("ab", ".*") �� true
	isMatch("aab", "c*a*b") �� true
 * 
 *  ����˼·�����õݹ���õ�˼�룻����p���ȿ����ڶ����ַ��ǲ���*���������*�Ļ�����ô��һ��Ҫ�ж�ǰ��ĵ�һ���ַ��ǲ��ǿ���ƥ��ģ����ǰ���ַ�ƥ���ˣ���ô�Ϳ����Ǻ�����ַ����ǲ���ƥ��ģ�
 *  �����*,��ô��Ҫ�ж�*�Ŵ���ǰ����ַ����ּ��Ρ����ǰ��Ĳ���ƥ�䣬��ô��Ҫ�����������s����ǰ�治ƥ���ʱ����ô��Ҫ���������ַ�������Ĳ����ǲ���ƥ�䡣
 *
 */
public class RegularExpressionMatching142 {
	
	public boolean isMatch(String s, String p) {
        // if pattern is empty - whole string should be empty to match
		//�����������
        if (p.length() == 0) return s.length() == 0;
    
        // retrieve 2nd character of the pattern
        //��ȡp����ĵڶ����ַ�
        String nextChar = (p.length() > 1) ? String.valueOf(p.charAt(1)) : "";
        //��ȡ���ַ�
        char tfirst = (s.length() > 0) ? s.charAt(0) : 0;
        char pfirst = p.charAt(0);
    
        // if 2nd char is not '*' - it means that we are checking if next char in text matches with next char in pattern
        // and recursively run the code starting from +1 char in both pattern/text
        //����ڶ����ַ�����*  ��ô��Ҫ�ж�ǰ��Ĳ����Ƿ���ƥ���
        if (!"*".equals(nextChar)) {
        	//��ϵ����
            return ((tfirst == pfirst) || (pfirst == '.' && tfirst != 0)) && isMatch(s.substring(1), p.substring(1));
        }else{
        	//����ڶ�����*  ��ô��Ҫ��
            while ((tfirst == pfirst) || (pfirst == '.' && tfirst != 0)) {
                // check if current text matches tail part of the pattern (+2 symbols)
            	//����������ǰ�����ַ�����ʱ��Ҳ����*��������ǰ����ַ�����0�ε�ʱ��
                if (isMatch(s, p.substring(2))) return true;
                // cut first symbol in original text and repeat the check in the loop
                s = s.substring(1);
                tfirst = (s.length() > 0) ? s.charAt(0) : 0;
            }
            //˵��ǰ����ַ�����ȣ���ôҪǿ��*�����þ���0�γ���
            return isMatch(s, p.substring(2));
        }

    }
}
