package leetcode151withexplain;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * ����������Ǹ�һ���ַ�����Ȼ���һ�δʵ䣬���Ƿ�����ַ�������������ʵ��еĴ�ƴ�ճ�����
 * 
 *  ����Ľ���˼·���ݹ����
 *  ��������дʵ��дʵ���̳��Ⱥ���󳤶ȣ���������������ٴ�������㣻������һ��map��map�����洢��Щ�����Ա��ֽ���ַ�����Ҳ��Ϊ�˼�֦ʹ�õģ�
 *  Ȼ��ͨ���ݹ��˼�룬���ϵĻ�ȡǰ׺���ж�ǰ׺�Ƿ��ڴʵ��У�����ٴʵ��У���ô���ж����ڵĺ�׺�ܷ�������ֽ⣬�����õݹ���õ�˼�롣
 *  
 *  
 *
 */
public class WordBreak013 {
	
	public boolean wordBreakHelper(String s,Set<String> dict,Set<String> unmatched,int mn,int mx) {  
        if(s.length() < 1) return true;
        
        //find the max length between mx and s.length
        int i = mx < s.length() ? mx : s.length(); 
        
        //��ʵ����������ȱ�����ֻ��ÿһ����ζ��м��ֿ��ܵĽ��
        for(; i >= mn ; i--){
        	
            String preffixstr = s.substring(0,i);  
            if(dict.contains(preffixstr) != false){  
                String suffixstr = s.substring(i); 
                //�жϺ�׺�Ƿ���map�У�����ڣ���ô��ʡȥ�˺ܶ���㡣
                if(unmatched.contains(suffixstr) == true)  
                    continue;  
                else  
                	//�ݹ����
                    if(wordBreakHelper(suffixstr, dict, unmatched,mn,mx))  
                        return true;  
                    else  
                        unmatched.add(suffixstr);  
            }  
        }  
        return false;  
    }  
    
    public boolean wordBreak(String s, Set<String> dict) {  
        // Note: The Solution object is instantiated only once.  
        if(s.length() < 1) return true;  
        if(dict.size() == 0) return false;  
        Iterator<String> ite = dict.iterator();
        int minlen = 0;
        int maxlen = 0;
        //������ʵ���󳤶Ⱥ���С����
        while(ite.hasNext()){
        	String cDict = ite.next();
        	if(minlen > cDict.length()){
        		minlen = cDict.length();
        	}
        	
        	if(maxlen < cDict.length()){
        		maxlen = cDict.length();
        	}
        	
        }

        Set<String> unmatched = new HashSet<>();  
        return wordBreakHelper(s,dict,unmatched,minlen,maxlen);  
    }
    
}
