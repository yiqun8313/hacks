package leetcode151withexplain;

import java.util.HashMap;
import java.util.Map;

/**
 *  �������⣺����һ����ά����  ����ÿһ�����Ӷ���һ���ַ�   ����һ���ַ���  ���ܷ�������������ҵ�����ַ���
 *  
 *   For example,
	Given board =
	
	[
	  ["ABCE"],
	  ["SFCS"],
	  ["ADEE"]
	]
	word = "ABCCED", -> returns true,
	word = "SEE", -> returns true,
	word = "ABCB", -> returns false.
	
	����˼·���Ѷ�ά�����е�ÿһ������Ϊ��ʼ�ڵ㣬������ά�����������µĵݹ���ã����ܷ�õ���Ҫ���ַ�����
	
	ע��㣺һ���ά������Ѱ�Ҷ����������������������Ĳ���ҲҪע�⣬���ݵ���ʲô�����⣬���ڵ�ǰ�ڵ㣬����Ϊ.���Է�ֹ�����ظ����������Ǳ����˺����������û�ȥ��
	
 *
 */


public class WordSearch073 {
	
	   public static boolean exist(char[][] board, String word) {  
		   //ѭ������ÿһ��Ԫ�أ���Ϊ��ʼ�ڵ㣬������ά����
		   for(int i=0; i<board.length; i++){  
	            for(int j=0; j<board[0].length; j++){  
	                if(dfs(board, word, 0, i, j)){  
	                    return true;  
	                }  
	            }  
	        }  
	        return false;  
	    }  
	       
	    /**
	     * ������ȱ���
	     * @param board ��ά����
	     * @param word Ŀ�굥��
	     * @param index ��ǰ��λ��
	     * @param x ��ǰ�ڵ�����x
	     * @param y ��ǰ�ڵ�����y
	     * @return
	     */
	    public static boolean dfs(char[][] board, String word, int index, int x, int y){  
	    	//�߽�����  �����Ѿ��ҵ��˸õ���
	        if(index == word.length()-1 && word.charAt(index)==board[x][y]){  
	            return true;  
	        }  
	        
	        //��ǰ�ַ�������Ҫ���ҵĵ���
	        if(word.charAt(index) != board[x][y]){  
	            return false;  
	        }  
	        
	        //��ȡ��ǰ�ַ�
	        char tmp = board[x][y];
	        //����Ϊ.  �Է��ظ�����
	        board[x][y] = '.';  
	        boolean b1 = false, b2 = false, b3 = false, b4 = false;
	        
	        //�ݹ����  �������ұ���
	        if(x-1>=0 && board[x-1][y] != '.'){  
	            b1 = dfs(board, word, index+1, x-1, y);  
	        }  
	        if(!b1 && y-1>=0 && board[x][y-1] != '.'){  
	            b2 = dfs(board, word, index+1, x, y-1);  
	        }  
	        if(!b1 && !b2 && x+1<board.length && board[x+1][y] != '.'){  
	            b3 = dfs(board, word, index+1, x+1, y);  
	        }  
	        if(!b1 && !b2 && !b3 && y+1<board[0].length && board[x][y+1] != '.'){  
	            b4 = dfs(board, word, index+1, x, y+1);  
	        }  
	        
	        //�ָ�ԭ��������
	        board[x][y] = tmp;  
	        return b1 || b2 || b3 || b4;  
	    }
	    
	    //another method    
	    public boolean exist2(char[][] board, String word) {
	        boolean answer = false;
	        if(word == null || word.equals("")) return true;
	        int m = board.length;
	        if(m == 0) return false;
	        int n = board[0].length;
	        int wSize = word.length();
	        char[] ws = word.toCharArray();
	        
	        char firstChar = ws[0];
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(board[i][j] == firstChar){
	                    if(getResult(board,ws,i,j,m,n,0)){
	                        return true;
	                    }
	                }
	            }
	        }
	        
	        return answer;
	    }
	    
	    public boolean getResult(char[][] board, char[] ws, int curX, int curY, int m, int n, int curNum){
	        if(curX < 0 || curX >= m) return false;
	        if(curY < 0 || curY >= n) return false;
	        
	        if(board[curX][curY] == '.'){
	            return false;
	        }
	        
	        
	        if(ws[curNum] != board[curX][curY]) return false;
	        if(curNum == ws.length-1) return true;

	        char temp = board[curX][curY];
	        board[curX][curY] = '.';
	        boolean result = getResult(board,ws,curX+1,curY,m,n,curNum+1);
	        if(result == true) return true;
	        boolean result1 = getResult(board,ws,curX-1,curY,m,n,curNum+1);
	        if(result1 == true) return true;
	        boolean result2 = getResult(board,ws,curX,curY+1,m,n,curNum+1);
	        if(result2 == true) return true;
	        boolean result3 = getResult(board,ws,curX,curY-1,m,n,curNum+1);
	        if(result3 == true) return true;
 
	        board[curX][curY] = temp;
	        return result;
	    }
	    
	    public static void main(String[] args){
	    	WordSearch073 obj = new WordSearch073();
	    	
	    	char[][] board = {{'a','b'},{'c','d'}};
	    	String target = "cdba";
	    	
	    	obj.exist2(board, target);
	    }
	    
}
