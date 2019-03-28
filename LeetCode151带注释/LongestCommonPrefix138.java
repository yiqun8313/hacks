package leetcode151withexplain;

/**
 * �������⣺����һ���ַ������ҵ������ַ����Ĺ���ǰ׺��
 * 
 * ����˼·�������ӵĲ���ʱ�������ַ����Ĺ���ǰ׺��Ȼ��ͨ�����ַ��ҵ����е�������Ӵ���
 *
 */
public class LongestCommonPrefix138 {
	
	public String longestCommonPrefix(String[] strs) {
        //���������������
		if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        
        return getPartCommonPrefix(strs,0,strs.length-1);
    }
    
	/**
	 * ��ȡ����ǰ׺
	 * @param strs
	 * @param startPosition  ��ʼλ��
	 * @param endPosition  ����λ��
	 * @return
	 */
    public String getPartCommonPrefix(String[] strs,int startPosition,int endPosition){
    	//������  ���ص�ǰ�ַ���
        if(startPosition == endPosition){
            return strs[startPosition];
        }
        
        
        //�����ǰ������Ԫ�أ���ô���ҵ��乫���Ӵ�
        if(startPosition == (endPosition-1)){
            return getCommonPrefix(strs[startPosition],strs[endPosition]);
        }
        
        //���ֵķ���
        int middle = (startPosition+endPosition)/2;
        //�ҵ���߲��ֵĹ���ǰ׺
        String leftString = getPartCommonPrefix(strs,startPosition,middle);
        //�ҵ��ұ߲��ֵĹ���ǰ׺
        String rightString = getPartCommonPrefix(strs,middle+1,endPosition);
        //�������
        String result = getCommonPrefix(leftString,rightString);
        return result;
        
    }
    
    //���Ӳ���  ���������ַ���  ����乫��ǰ׺
    public String getCommonPrefix(String a,String b){
        int aLength = a.length();
        int bLength = b.length();
        int size = aLength;
        if(aLength > bLength){
            size = bLength;
        }
        
        String result = "";
        for(int i = 0; i <size; i++){
            if(a.substring(i,i+1).equals(b.substring(i,i+1))){
                result += a.substring(i,i+1);
            }else{
                break;
            }
        }
        
        return result;
    }
}
