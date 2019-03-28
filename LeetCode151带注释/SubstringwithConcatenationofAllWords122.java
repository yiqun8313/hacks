package leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * �������⣺����һ���ַ���L��һ�鳤����ȵ��ַ�������s���ҵ��ַ���L�а�������s���ַ���ֻһ�εĿ�ʼλ�ã����Ҹ������ڲ����������ַ���
 * 
	For example, given:
	S: "barfoothefoobarman"
	L: ["foo", "bar"]
	You should return the indices: [0,9].
 *  
 *  ����˼·����L�е�ÿһ��λ�ÿ�ʼ������������Ƿ��ܹ���������������ַ�����ͨ��map����¼ס���ֵĴ��������ֵĴ���̫��Ҳ�Ǵ���Ӧ��ǡ�ɳ���һ����Ĵ��������Ҹó��ֵĶ������ˡ�
 *
 */
public class SubstringwithConcatenationofAllWords122 {
	
	public List<Integer> findSubstring(String S, String[] L) {
		//ͨ��һ��map��¼���е��ַ���
        Map<String,Integer> words = new HashMap<String,Integer>();
        //cur���ڼ�¼�����˶��ٴ�
        Map<String,Integer> cur = new HashMap<String,Integer>();  
        int wordNum = L.length;
        
        //��ʼ������ÿһ���ַ�����ѹ�뵽�������
        for(int i = 0; i < wordNum; i++){
            if(words.get(L[i]) == null){
                words.put(L[i],1);
            }else{
               words.put(L[i],words.get(L[i])+1); 
            }
        }  
             
        //���ʵĳ���    
        int wordLen = L[0].length();
        
        //�������
        List<Integer> res = new ArrayList<Integer>();
        
        //the i condition is very good  because the start position can not over S.length() - wordLen*wordNum
        //�ж��������ǿ������滹�ܷ����������ַ���Ŀ  ���ܺ�����ַ�������  �Ǿ�û�б�Ҫ������
        //i�ǿ�ʼ��λ��
        for(int i = 0; i <= (int)S.length()-wordLen*wordNum; i++){  
            cur.clear();  
            int j;
            //judge if every word occur in the string
            //��ÿһ��λ�ÿ�ʼ�����ַ��� ���Ƿ���Գ�������������ַ���
            for(j = 0; j < wordNum; j++)  
            {  
                String word = S.substring(i+j*wordLen, i+j*wordLen+wordLen);
                //��������˲���Ҫ���ַ�
                if(words.get(word) == null)  
                    break;
                
                //�����ǰ���ֵ��ַ�����û���ֹ�
                if(cur.get(word) == null){
                    cur.put(word,1);
                //�Ѿ����ֹ�
                }else{
                    cur.put(word,cur.get(word)+1);
                }    
                //������ֵĴ�������������Ĵ���
                if(cur.get(word) > words.get(word))  
                    break;  
            }
            //�ܷ�ﵽ����Ҫ����Ŀ
            if(j == wordNum)  
                res.add(i);  
        }  
        return res;   
        
    }
}
