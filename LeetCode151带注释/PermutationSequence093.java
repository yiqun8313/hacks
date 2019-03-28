package leetcode151withexplain;

import java.util.ArrayList;

/**
 *	�������⣺������������n��k,��1-n��������ֽ������У�һ����n!�֣��������еĵ�k����
 *
 * We get the following sequence (ie, for n = 3):
	"123"
	"132"
	"213"
	"231"
	"312"
	"321"
	Given n and k, return the kth permutation sequence.
 *	
 *	����˼·�������ҵ��˹��ɣ�ÿһ������Ϊ��ͷ�Ŀ���ֻ�У�n-1��!�֣����ҵ�һ�����ĳ�����ѭ������
 */
public class PermutationSequence093 {
	
	public String getPermutation(int n, int k) {
        if(n < 0) return null;
        if(n == 0) return "";
        
        //��nlist���洢ÿһ������  �����������ֵ�Ļ�ȡ
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        for(int i = 0; i < n; i++){
            nlist.add(i+1);
        }
        
        return getAnswer(nlist,n,k-1);
    }
    
	/**
	 * 
	 * @param nlist
	 * @param n ����ǰ�м�����
	 * @param k  �ڼ���
	 * @return
	 */
    public String getAnswer(ArrayList<Integer> nlist, int n, int k){
        String result = "";
        //�߽�����  ����ֻ��һ��Ԫ�ص�ʱ�� 
        if(n == 1){
            result += nlist.get(0);
            nlist.remove(0);
            return result;
        }
        
        //��ȡn-1�Ľ׳�
        int nFactorial = getFactorial(n-1);
        //���㵱���k����ʱ��Ӧ���ǵڼ�������
        int i = k/nFactorial;
        result += nlist.get(i);
        nlist.remove(i);

        //�ݹ����  ����ĵ�k��Ԫ��Ҫ�任  ��Ϊǰ���Ѿ�ȥ����һ����  ���Ծ�����k-i*nFactorial��Ԫ��
        return result+getAnswer(nlist,n-1,k-i*nFactorial);
    }
    
    //��ȡn�Ľ׳�
    public int getFactorial(int n){
        if(n == 0) return 1;
        int nFactorial = 1;
        for(int i = 1; i <= n; i++){
            nFactorial *= i;
        }
        return nFactorial;
    }
}
