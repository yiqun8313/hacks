package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 * �������⣺����һ���ַ�����Ȼ�����һ�����ȣ�ϣ���ܹ����ַ����ֽ��Ϊÿһ�г��ȶ��Ǹ������ȵļ����ַ�����
 * 
 *  For example,
	words: ["This", "is", "an", "example", "of", "text", "justification."]
	L: 16.
	
	Return the formatted lines as:
	[
	   "This    is    an",
	   "example  of text",
	   "justification.  "
	]
	
	����˼·��ͨ��һ�����ݽṹ��¼סÿһ�еĿ�ʼԪ�أ�����Ԫ���Լ��ո����Ŀ��Ȼ�����ÿһ��Ԫ�أ���ӡ���ַ��������Ǽ���ո��ʱ��Ҫ�ر��ע�⡣
	
	
 *
 */
public class TextJustification084 {
	
	//������һ�����ݽṹ   �����ݽṹ���ڴ洢�ֽ������ÿһ��  ���ĸ��ַ�����ʼ����һ������  ��һ�����ж��ٿո�
	class Item{
        int startPosition;
        int endPosition;
        int blankNum;
        Item(int s, int e, int b){
            startPosition = s;
            endPosition  = e;
            blankNum = b;
        }
    }
    
    public List<String> fullJustify(String[] words, int L) {
        List<String> result = new ArrayList<String>();
        int wordsSize = words.length;
        if(wordsSize == 0) return result;
        
        //���ڼ�¼�ֽ���
        ArrayList<Item> items = new ArrayList<Item>();
        for(int i = 0; i < wordsSize; i++){
            int tempL = L;
            int startPosition = i;
            int endPosition = i;
            while(tempL > 0 && i < wordsSize){
            	//��ȡ�ַ����һ�ȡ�䳤��
                String currentWord = words[i];
                int cwLength = currentWord.length();
                //���һ���ַ��ĳ��ȴ���L����ô��Ŀ�д���
                if(cwLength > L){
                    return null;
                //���ʣ��ĳ��ȴ��ڸ��ַ��ĳ��ȣ���ô˵�����ַ������Լ��뵽�����
                }else if(tempL >= cwLength){
                    endPosition++;
                    tempL -= cwLength;
                    //blank ����һ���ո�
                    tempL--;
                }else{
                    break;
                }
                i++;
            }
            if(i > 0){i--;} //������i������һ��
        	endPosition--;
        	//����һ���µ�item
            Item newitem = new Item(startPosition,endPosition,tempL+(endPosition-startPosition)+1);
            items.add(newitem);
        }
        
        int itemsSize = items.size();
        //����ÿһ��item���������
        for(int j = 0; j < itemsSize; j++){
            String jthResult = "";
            Item currentItem = items.get(j);
            int startP = currentItem.startPosition;
            int endP = currentItem.endPosition;
            int blankSize = currentItem.blankNum;
            //������������һ��Ԫ��  ��ô���˸�Ԫ��  ���涼�ǿո�
            if(j == (itemsSize - 1)){
            	for(int k = startP; k <= endP; k++){
	            	int blank = 0;
	                jthResult += words[k];
	                for(int p = 0; k == endP && p < blankSize; p++){
	                    jthResult += " ";
	                }
	                if(k == endP) continue;
	                jthResult += " ";
	                blankSize--;
	            }
            }else{
            	//�������������  Ҫѧ�����ո�Ķ���
	            for(int k = startP; k <= endP; k++){
	            	int blank = 0;
	            	if(endP-k != 0){
	            		blank = (int)Math.ceil((double)blankSize/(endP-k));
	            	}
	            	if(startP == endP){
	            		blank = blankSize;
	            	}
	                jthResult += words[k];
	                for(int p = 0; p < blank; p++){
	                    jthResult += " ";
	                }
	                blankSize -= blank;
	            }
            }
            result.add(jthResult);
        }
        
        return result;
    }  
}
