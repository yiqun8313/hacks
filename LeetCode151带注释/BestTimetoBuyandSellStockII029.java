package leetcode151withexplain;

/**
 * �������⣺��Ʊ�Ĵ�����������ܶ�Σ�����ֻ�����˲���������
 * 
 *  ��ô�Ҿͱ�����ֻҪ�ڶ���Ƚ���ĸߣ��Ҿ����˾�����̰�ķ��������ս����ȷ��
 *  
 *
 */
public class BestTimetoBuyandSellStockII029 {
	
	public int maxProfit(int[] prices) {    
        int answer = 0;
        int pricesSize = prices.length;
        //һ�α���������
        for(int i = 0; i < (pricesSize-1); i++){
            if(prices[i+1] > prices[i]){
                answer += prices[i+1] - prices[i];
            }
        }
        
        return answer;
        
    }
}
