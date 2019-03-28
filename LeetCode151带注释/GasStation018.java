package leetcode151withexplain;

/**
 * �������⣺��һ��������n������վ��ÿ������վ����gas[i]�����ͣ�������һ������վ������һ������վ��������cost[i],�������ܷ�תһȦ��
 * 
 *  ̰�ĵķ�ʽ��ͨ��sum��¼��ǰĳһ���ڻ��ж������ͣ����sumС�����ˣ���ô˵���ܲ���ȥ�ˣ�Ȼ��start����Ϊ��ǰ���±�ֵ��total�������ڼ�¼����һȦ֮��������������������С��0����ô
 *  ˵������������һȦ��
 *  
 *  Ϊʲôstartֱ������Ϊ��ǰ�±����һ�������ѡ����ǵ�ǰ��λ�ÿ�ʼ����ô������һ�ο϶�����������⣬��Ϊ���ٵ�һ���ڵ��ǳɹ��ģ����治�ɹ���ԭ��϶����ں���������ϡ�
 *
 */
public class GasStation018 {
	
	public int canCompleteCircuit(int[] gas, int[] cost) { 
        int sum=0;
        int total=0;
        int start=0;
        
        for(int i=0;i<gas.length;i++)
        {
        	//��¼��ǰ������ʣ����
            sum += gas[i]-cost[i];
            
            //��¼�ܵ�����ʣ����
            total += gas[i]-cost[i];
            if(sum < 0)
            {
            	//start����Ϊ��һ���±�ֵ
                start=(i+1)%gas.length;
                sum=0;
            }
        }
        
        if(total <0)
            return -1;
        else
            return start;
    }
}
