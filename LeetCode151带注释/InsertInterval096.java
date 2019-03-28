package leetcode151withexplain;

import java.util.ArrayList;
import java.util.List;

/**
 *	�������⣺����һ�����䣬������û�и�������ģ������ǰ���ʼ�ڵ�ĵ�����������ġ�����һ�����䣬���ڲ��뵽ԭ�е������У�Ȼ������ϲ�������䡣
 *
 *	Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 	
 * 	����˼·�������������һ���ߣ�Ȼ������������ɫ������ǵ�ģ���ô������һ���㣻�����һ�����䣬��ô��������һ�����䡣�����������ߣ�����֪����Щ���Ǵ𰸣�������һ�����ݽṹ�����ڼ�¼��ǰ����һ���㻹������
 * һ�����䡣
 *
 */
public class InsertInterval096 {
	
	 //��������ݽṹ
	 public class Interval {
		 int start;
		 int end;
		 Interval() { start = 0; end = 0; }
		 Interval(int s, int e) { start = s; end = e; }
	}
	
	//��һ���㣬������һ�׶ε�ֵ
	class Item{
        boolean dot;
        boolean nextValue;
        Item(boolean d, boolean n){
            dot = d;
            nextValue = n;
        }
    }
    
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
    	
        List<Interval> answer = new ArrayList<Interval>();
        int intervalSize = intervals.size();
        //�����������
        if(intervalSize == 0){
            answer.add(newInterval);
            return answer;
        }
        
        //��ȡ��������������ֵ
        int preMaxNum = intervals.get(intervalSize-1).end;
        //����������������ֵ
        int newMaxNum = newInterval.end;
        
        //֪��������������ֵ
        int maxNum = preMaxNum > newMaxNum? preMaxNum : newMaxNum;
        
        //��ʼ��itemFlag
        ArrayList<Item> itemFlag = new ArrayList<Item>();
        for(int u = 0; u < maxNum+1; u++){
            Item newi = new Item(false,false);
            itemFlag.add(newi);
        }

        //����ÿһ������  Ȼ������itemFlag
        for(int i = 0; i < intervalSize; i++){
            Interval currentInterval = intervals.get(i);
            int start = currentInterval.start;
            int end = currentInterval.end;
            //���������ʼλ����ͬ  ��ôdot����Ϊtrue
            if(start == end){
                itemFlag.get(start).dot = true;
            }else{
            	//�����Ӧ����һ����������Ϊtrue
                for(int j = start; j < end; j++){
                    itemFlag.get(j).nextValue = true;
                }
            }
        }
        
        //ͬ���ĵ�������������ӵ�itemFlag��
        int newIntervalStart = newInterval.start;
        int newIntervalEnd = newInterval.end;
        if(newIntervalStart == newIntervalEnd){
            itemFlag.get(newIntervalStart).dot = true;
        }else{
            for(int k = newIntervalStart; k < newIntervalEnd; k++){
               itemFlag.get(k).nextValue = true;
            }
        }
        
        //������ʾ�õ���������
        for(int i = 0; i <= maxNum; i++){
        	//�����һ���ڵ�
            if(itemFlag.get(i).dot == true && itemFlag.get(i).nextValue == false){
                //���ǰ����һ�����䣬��ô˵�����ڵĵ����������������
            	if(i > 0 && itemFlag.get(i-1).nextValue == false){
                    Interval newItem = new Interval(i,i);
                    answer.add(newItem);
               //����ǵ�һ���㣬��ô����һ����
               }else if(i == 0){
                   Interval newItem = new Interval(i,i);
                   answer.add(newItem);
               }
            }else if(itemFlag.get(i).nextValue == true){
                
                int start = i;
                int end = i;
                //�����һ�����䣬Ȼ���������
                while(itemFlag.get(end).nextValue == true && end <= maxNum){
                    end++;
                    i++;
                }
                
                //�����˼�����ӵ�1
                if(i > 0) i--;
                Interval newItem = new Interval(start,end);
                answer.add(newItem);

            }else{
                continue;
            }
        }
        
        return answer;
    }
}
