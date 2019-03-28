package leetcode151withexplain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * �������⣺����һ�����飬�����п��ܻ����ظ������֣��������е��������
 *
 */
public class PermutationsII106_DoAgain {
	
	public List<List<Integer>> permuteUnique(int[] num) {
		//ͨ��set���洢��������������ȥ���ظ���Ԫ��
		Set<ArrayList<Integer>> tempResult =  getPermute(num,num.length-1);
		//�������������ʽList<List> = ArrayList<List>
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		//��set�е�����ȡ������ֵ��result
		for(ArrayList<Integer> tempR : tempResult){
			result.add(tempR);
		}
		return result;
    }
    
	/**
	 * ��ȡ���н��
	 * @param num  ��������
	 * @param currentPosition  ��ǰ��������λ��
	 * @return
	 */
    public Set<ArrayList<Integer>> getPermute(int[] num, int currentPosition){
        //��set��¼���Set<ArrayList> = HashSet<ArrayList>
    	Set<ArrayList<Integer>> result = new HashSet<ArrayList<Integer>>();
        
    	//�����ǰλ�������һ������ô���ؽ�������߽�����
        if(currentPosition == 0){
        	ArrayList<Integer> currentR = new ArrayList<Integer>();
            currentR.add(num[0]);
            result.add(currentR);
            return result;
        }
        
        //��ȡ��һ�ֵĽ����Ȼ���ڽ���е�ÿһ��λ�ò��뵱ǰԪ�أ���ô����һ���µ�����
        Set<ArrayList<Integer>> nextResult = getPermute(num,currentPosition-1);
        for(ArrayList<Integer> oneResult : nextResult){
            int size = oneResult.size();
            //����ÿһ��Ԫ�ص�ÿһ��λ�ã������뵱ǰ��ֵ
            for(int i = 0; i <= size; i++){
                oneResult.add(i,num[currentPosition]);
                result.add(new ArrayList(oneResult));
                //�����˲���֮����ɾ����
                oneResult.remove(i);
            }
        }
        
        return result;
    }
}
