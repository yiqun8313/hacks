package leetcode151withexplain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
 * �������⣺����һ������  ���������ҵ��ĸ�����  ʹ�����ΪĿ��ֵ  �������в��ظ��Ľ��
 * 
 *  For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * ����˼·����hashset�洢���ظ���Ԫ�أ�Ȼ��������飬��һ��Ԫ�ش�ͷ����������ڶ���Ԫ�شӺ���ǰ�������м������Ԫ�����м伷ѹʽѰ�ҡ�
 */
public class FourSum137 {
	
	public List<List<Integer>> fourSum(int[] num, int target){
		//hashset���ڴ洢���ظ���Ԫ��
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();
        //���ڼ�¼��
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        
        int numSize = num.length;
        if(numSize < 4) return answer;
        //�������������
        Arrays.sort(num);
        
        //������ʽ����һ��Ԫ�ش�ǰ����
        for(int i = 0; i < numSize-3; i++) {
        	//�ڶ���Ԫ�أ��Ӻ���ǰ  ע�������Χ
           for(int k = numSize-1; k > i+2; k--) {
               int ab = num[i] + num[k];
               int c = target-ab;
               int m = i+1;
               int n = k-1;
               //������Ԫ�ػ��ǲ������м伷ѹ�ķ�ʽ
               while(m < n) {
                   int sum = num[m] + num[n];
                   if(sum == c) {
                       ArrayList elem = new ArrayList();
                       elem.add(num[i]);
                       elem.add(num[m]);
                       elem.add(num[n]);
                       elem.add(num[k]);
                       set.add(elem);
                       m++;
                       n--;
                   }
                   else if(sum < c) {
                       m++;
                   }
                   else n--;
               }
           }
        }
        
        //��Ȼ������������  new ArrayList(HashSet)
        return new ArrayList<List<Integer>>(set);
    }
}
