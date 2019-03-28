package leetcode151withexplain;

/**
 *  �������⣺����һ���ַ���  �ж����Ƿ�Ϊ���� 
 *  Some examples:
	"0" => true
	" 0.1 " => true
	"abc" => false
	"1 a" => false
	"2e10" => true
 *	
 *	 ����˼·�������������������������ж��Ƿ��Ѿ�������ĳ�������
 *	1���ж�e�Ƿ���� 2���ж�С�����Ƿ����  3���ж�e����߲��ֺ��ұ߲���  4���ո��Ƿ����
 *
 *	�������ͨ��������������һ���ж��Ƿ�ĳЩ����������
 */
public class ValidNumber086 {
	
	public boolean isNumber(String s) {
        if(s == null)  return false;  
              
        s = s.trim();
        //�Ƿ����e С����  �ո�   
        boolean eAppear = false;  
        boolean dotAppear = false;
        //e֮ǰΪfirstPart,֮��ΪsecondPart
        boolean firstPart = false;  
        boolean secondPart = false;  
        boolean spaceAppear = false;
        //�ַ����ĳ���
        int sLength = s.length();
        for(int i = 0; i < sLength; i++){
        	
        	//�����һ�������Ż��߸���
        	if (i==0 && (s.charAt(i) == '+' || s.charAt(i) == '-'))  
                continue; 
        	
        	//���������.��
            if (s.charAt(i) == '.'){
            	//�������֮ǰ�Ѿ����ֹ�.  e  �ո�  ����false
                if (dotAppear || eAppear || spaceAppear)  
                    return false;  
                else  
                    dotAppear = true;  
            }
            //���������e
            else if (s.charAt(i) == 'e' || s.charAt(i) == 'E')  
            {  
            	//���֮ǰ�ͳ�����e ǰ��û������  �����˿ո�
                if (eAppear || !firstPart || spaceAppear)  
                    return false;  
                else  
                    eAppear = true;  
            }
            //�������������  ���ǰ�����������
            else if (s.charAt(i) >= 48 && s.charAt(i) <= 57)  
            {  
            	//���ǰ���пո�  ��ô�ͷ���false
                if (spaceAppear)  
                    return false;  
                //�����û����e      
                if (!eAppear)  
                    firstPart = true;
                //���������e
                else  
                    secondPart = true;  
            }  
            else if (s.charAt(i) == '+' || s.charAt(i) == '-')   // behind of e/E  
            {  
                if (spaceAppear)  
                    return false;  
                //e��δ����  ����ǰ����ַ�����e��E      
                if (!eAppear || !(s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E'))  
                    return false;  
            }  
            else if (s.charAt(i) == 32)  
                spaceAppear = true;  
            else  
                return false;               
        }  
          
        if (!firstPart) {  
            return false;  
        }  else if (eAppear && !secondPart) {  
            return false;  
        }   
        return true;    
	}
}
