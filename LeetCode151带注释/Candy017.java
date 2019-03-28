package leetcode151withexplain;

/**
 * �������������һȺ���ӣ�ÿ�������и����֣�ÿ���������ٷֵ�һ���ǣ������ߵĺ���Ҫ�ȷ����͵ĺ�����Ҫ�࣬�����ٷֶ����ǡ� 
 *
 * �������˼·��
 * ���������飬һ���������ұ������������ĺ��ӱ�ǰ������ŵĺ��ӷ����ߣ���ô�ֵ����Ǿ�++��������溢�ӵķ����Ƚ����ź��ӵķ����ͻ��ߵ��ڣ���ô�ֵ����Ǿͱ�Ϊ1��
 * 
 * Ȼ��ͬʱ�����������飬�������Ϳ����ˡ�
 */
public class Candy017 {
	
	public int candy(int[] ratings) {
        int length = ratings.length;
        int[] lefttoright = new int[length];
        int[] righttoleft = new int[length];
        
        //�����б���  �����ǹ�����ֵ
        for(int i = 0; i < length; i++){
            if(i == 0){
                lefttoright[i] = 1;
            }else{
                if(ratings[i] > ratings[i-1]){
                    lefttoright[i] = lefttoright[i-1]+1;
                //����Ƚ�����  ���С�ڵ��ڵ�ʱ��  ֱ������Ϊ1
                }else if(ratings[i] <= ratings[i-1]){
                    lefttoright[i] = 1;
                }
            }
        }
        
        for(int j = length-1; j >= 0; j--){
            if(j == (length-1)){
                righttoleft[j] = 1;
            }else{
                if(ratings[j] > ratings[j+1]){
                    righttoleft[j] = righttoleft[j+1]+1;
                }else if(ratings[j] <= ratings[j+1]){
                    righttoleft[j] = 1;
                }
            }
        }
        
        int result = 0;
        for(int k = 0; k < length; k++){
            result += max(lefttoright[k],righttoleft[k]); 
        }
        
        return result;
        
    }
    
    public int max(int a, int b){
        if(a > b){
            return a;
        }else{
            return b;
        }
    }
}
