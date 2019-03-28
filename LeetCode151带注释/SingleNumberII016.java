package leetcode151withexplain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *  ����������Ǹ���һ�����飬��������һ�㶼�������Σ�ֻ��һ���������˲������Ρ�
 *  
 *   ����ͨ��һ��map���洢���Լ����ֵĴ�����
 *   
 *   ����map�Ĳ���Ҫ��ȷ
 *
 */
public class SingleNumberII016 {

	public int singleNumber(int[] A) {
        Map<Integer,Integer> numberNums = new HashMap<Integer,Integer>();
        for(int i = 0; i < A.length; i++){
            if(numberNums.get(A[i]) != null){
                int aiNums = numberNums.get(A[i]);
                numberNums.remove(A[i]);
                numberNums.put(A[i],aiNums+1);
            }else{
                numberNums.put(A[i],1);
            }
        }
        
        Iterator ite = numberNums.keySet().iterator();
        while(ite.hasNext()){
            int currentKey = (int)ite.next();
            if(numberNums.get(currentKey) != 3){
                return currentKey;
            }
        }
        
        return 0;
    }
}
