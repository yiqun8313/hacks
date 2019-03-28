package leetcode151withexplain;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �������⣺��һ����ά��������ֻ����0��*,�����б�*��Χ��0ת��Ϊ*.��Χ����˼�����涼��*
 * 
 * �������˼·��
 * ����˼ά�����һ��0����*��Χ����ô�Ϳ����ڱ߽��ϣ���ô�ӱ߽����������0��ʼ�������������ô���ܴﵽ�ĵط�����Ըı�Ϊ��ʱZ�ַ�������޸�һ�¾Ϳ����ˡ�
 * ��Ϊͨ��queue�����еĽڵ�ѹ�뵽�����У�Ȼ�������ڿ�����ȱ����ķ�ʽ�����ϵ����������������Χ��
 * 
 * ������ȵķ�ʽ����ͨ��ѹ����У�Ȼ�����δ���ÿһ���ڵ㣬�����ͺ���һȦһȦ��������չһ����
 * 
 * Ҳ����ͨ��������Ƚ�����⣬�Ǿ��ǲ���DFS�Ĳ��ԡ�
 * 
 *
 */
public class SurroundedRegions021 {

	    private int m, n;  
	    private char[][] board;  
	    private Queue<Integer> queue = new LinkedList<Integer>();  
	  
	    public void add(int x, int y) {
	    	//�������ϱ������������������Ϊ0����ô�ͼ��뵽������
	        if (x >= 0 && x < m && y >= 0 && y < n && board[x][y] == 'O') {  
	            board[x][y] = 'Z';
	            //ѹ�����
	            queue.offer(x * n + y);  
	        }  
	    }  
	      
	    public void traversal(int x, int y) {  
	        add(x, y);  
	        while (!queue.isEmpty()) {
	        	//�������У��ָ��õ�ԭ����x��y����
	            int p = queue.poll();  
	            int px = p / n;  
	            int py = p % n;  
	            
	            //�ݹ����� ��ʵҲ��ѭ������
	            add(px - 1, py);  
	            add(px + 1, py);  
	            add(px, py - 1);  
	            add(px, py + 1);  
	        }  
	    }  
	  
	    public void solve(char[][] board) {  
	    	//������������
	        if (board == null || board.length == 0 || board[0].length == 0) {  
	            return;  
	        }  
	        this.board = board;
	        
	        //��ȡ����ĳ��Ϳ�
	        m = board.length;  
	        n = board[0].length;
	        
	        
	        //һ�δ����һ�����ݺ����һ�����ݣ�������߽����ݣ�
	        for (int i = 0; i < n; i++) {  
	            traversal(0, i);  
	            traversal(m - 1, i);              
	        }
	        
	        //�����һ�к����һ�� ���������������߽磩
	        for (int i = 0; i < m; i++) {  
	            traversal(i, 0);  
	            traversal(i, n - 1);  
	        }
	        
	        //���м�����н�������Χ������ΪZ��Ȼ������滻�Ϳ�����
	        for (int i = 0; i < m; i++) {  
	            for (int j = 0; j < n; j++) {  
	                board[i][j] = board[i][j] == 'Z' ? 'O' : 'X';  
	            }  
	        }  
	    }
	    
	    
	    public void solve2(char[][] board) {
	    	int m = board.length;
	        if(m == 0) return;
	        int n = board[0].length;
	        int[][] visited = new int[m][n];
	        for(int i = 0; i < n; i++){
	            if(visited[0][i] == 0 && board[0][i] == 'O'){
	                changeNum(board,visited,0,i,m,n);
	            }
	            
	            if(visited[m-1][i] == 0 && board[m-1][i] == 'O'){
	                changeNum(board,visited,m-1,i,m,n);
	            }
	        }
	        
	        for(int i = 1; i < m-1; i++){
	            if(visited[i][0] == 0 && board[i][0] == 'O'){
	                changeNum(board,visited,i,0,m,n);
	            }
	            
	            if(visited[i][n-1] == 0 && board[i][n-1] == 'O'){
	                changeNum(board,visited,i,n-1,m,n);
	            }
	        }
	        
	        for(int i = 0; i < m; i++){
	            for(int j = 0; j < n; j++){
	                if(board[i][j] == 'c'){
	                    board[i][j] = 'O';
	                }else{
	                    board[i][j] = 'X';
	                }
	            }
	        }
	        
	    }
	    
	    public void changeNum(char[][] board, int[][] visited, int curX, int curY, int m, int n){
	        if(curX < 0 || curX >= m) return;
	        if(curY < 0 || curY >= n) return;
	        if(board[curX][curY] != 'O') return;
	        if(visited[curX][curY] == 1) return;
	        
	        board[curX][curY] = 'c';
	        visited[curX][curY] = 1;
	        
	        changeNum(board,visited,curX+1,curY,m,n);
	        changeNum(board,visited,curX-1,curY,m,n);
	        changeNum(board,visited,curX,curY+1,m,n);
	        changeNum(board,visited,curX,curY-1,m,n);
	    }
	    
	    
	    public static void main(String[] args){
	    	char[][] param = {{'X','X','X'},{'X','o','X'},{'X','X','X'}};
	    	SurroundedRegions021 obj = new SurroundedRegions021();
	    	obj.solve2(param);
	    }
	    
	    
}
