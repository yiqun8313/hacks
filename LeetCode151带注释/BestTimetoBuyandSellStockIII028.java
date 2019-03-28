package leetcode151withexplain;

/**
 * 
 * ���������ν��ף����׶����
 * 
 * ��ͳ��˼·����Ȼ�����ν���  ��ô������֪�������һ�ν��׵����ֵ��Ȼ���ÿһ��λ����Ϊ�зֵ㣬������ֵ�Ϳ����ˡ�
 * 
 * �����˼·�������˼·��̫һ����
 * �����������¼������ֵ��
 * lefttorightProfit�������ĳһ��λ�����Ļ����������Ƕ���
 * 
 * righttoleftProfit�������ĳһ��λ����Ļ����������Ƕ���
 * 
 */
public class BestTimetoBuyandSellStockIII028 {
	
	public int maxProfit(int[] prices){
        if(prices == null || prices.length == 0 || prices.length == 1){
            return 0;
        }
        int priceLength = prices.length;
        int[] lefttorightProfit = new int[priceLength];
        int[] righttoleftProfit = new int[priceLength];
        
        //��Сֵȥ��һ���۸�Ԫ��
        int min = prices[0];
        //�ӿ�ʼ������������������Сֵ����¼ס���Ի�ȡ�����档������ǣ���ô�ͺ�ǰ�������һ�£�{������¼סÿһ���ڵ����Ӯ�õ������Ƕ��٣�����ĳһ���ڵ����Ļ����۸��Ƕ���}
        for(int i = 1; i < priceLength; i++){
            lefttorightProfit[i] = prices[i] - min > lefttorightProfit[i-1]? prices[i] - min : lefttorightProfit[i-1];
            //minһֱȥ��Сֵ
            min = prices[i] < min? prices[i]:min;
        }
        
        //�����jλ����Ļ��������������Ƕ��٣�������jλ����Ļ�����ż�ֵ�Ƕ��٣�
        int max = prices[priceLength-1];
        for(int j = priceLength-2;j >= 0; j--){
            righttoleftProfit[j] = max - prices[j] > righttoleftProfit[j+1]? max - prices[j]:righttoleftProfit[j+1];
            max = prices[j] > max? prices[j] : max;
        }
        
        //�����������飺ĳ�ڵ㴦���������ĳ�ڵ��������֮�ͱ������εļ۸�
        int result = 0;
        for(int k = 0; k < priceLength; k++){
            if(lefttorightProfit[k] + righttoleftProfit[k] > result){
                result = lefttorightProfit[k] + righttoleftProfit[k];
            }
        }
        
        return result;
    }
}
