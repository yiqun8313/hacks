package leetcode151withexplain;

import java.util.ArrayList;


/**
 * �������⣺ͨ������ÿһ��λ�õĿ���д���֣�Ȼ��ͨ��������ȱ�������ȡ���յĽ����
 * 
 * ����˼·���߽�����Ҫע�⣬����Ѿ����˱߽磬��ô�ͷ���true�������ֵ��Խ��Χ����ô��ֵ��1,��ֵ����Ϊ0
 *
 *
 */
public class SudokuSolver106 {
	
	public void solveSudoku(char[][] board) {
        int rows = board.length;
        if(rows == 0) return;
        int columns = board[0].length;
        solveSudokuHelper(board,0,0,rows,columns);
    }
    
	/**
	 * �������
	 * @param board ��������
	 * @param currentRow ��ǰ��
	 * @param currentColumn ��ǰ��
	 * @param rows �ܹ�������
	 * @param columns �ܹ�������
	 * @return
	 */
    public boolean solveSudokuHelper(char[][] board, int currentRow, int currentColumn, int rows, int columns){
        //�����������λ��
    	if(currentRow == (rows-1) && currentColumn == (columns-1)){
            return true;
        }
        
    	//����г�����  ��ô���п�ʼ   ��ֵ����Ϊ0
        if(currentColumn >= columns){
            currentRow++;
            currentColumn = 0;
        }
        
        //�����ǰ����.�ţ�˵�����������֣���ô�Ϳ���ֱ�ӿ��
        if(board[currentRow][currentColumn] != '.'){
            solveSudokuHelper(board,currentRow,currentColumn+1,rows,columns);
        }else{
        	
        	//�Ȼ�ȡĳһ�ո������д�����п���
	        ArrayList<Integer> availableNum = getAvailableValues(board,currentRow,currentColumn,rows,columns);
	        int avaSize = availableNum.size();
	        //���������д������Ϊ0 ��ô����false
	        if(avaSize == 0) return false;
	        //����ÿһ������
	        for(int i = 0; i < avaSize; i++){
	        	//��ǰ������Ϊĳ����
	            board[currentRow][currentColumn] = (char)(availableNum.get(i)+48);
	            //������һ������������ԣ���ô�ͷ���true
	            if(solveSudokuHelper(board,currentRow,currentColumn+1,rows,columns)) return true;
	            //����ǰ������Ϊ.
	            board[currentRow][currentColumn] = '.';
	        }
        }
        
        return false;
    }
    
    
    /**
     * ����λ��i j,������п�����д������
     * @param board
     * @param i
     * @param j
     * @param rows
     * @param columns
     * @return
     */
    public ArrayList<Integer> getAvailableValues(char[][] board,int i, int j,int rows,int columns){
        //��һ�������¼ÿһ���������ڳ��ֵĴ���
    	int[] numbers = new int[9];
        
        ArrayList<Integer> answer = new ArrayList<Integer>();
        
        //get row availale
        for(int column = 0; column < columns; column++){
            if(column == j) continue;
            //���������  ��ô���ڶ�Ӧλ��++
            if(board[i][column] != '.'){
                numbers[board[i][column]-49]++;
            }
        }
        
        //get column available
        for(int row = 0; row < rows; row++){
            if(row ==  i) continue;
            if(board[row][j] != '.'){
                numbers[board[row][j]-49]++;
            }
        }
        
        //get area available
        int startRow = i / 3;
        int startColumn = j / 3;
        //����ĳһ��λ�ã�����������ʼ�ķ�Χ����
        for(int r = startRow * 3; r < (startRow * 3 + 3); r++){
            for(int c = startColumn * 3; c < (startColumn * 3 + 3); c++){
                if(r == i && c == j) continue;
                if(board[r][c] != '.'){
                    numbers[board[r][c]-49]++;
                }
            }
        }
        
        //��û�г��ֵ����ּ�������
        for(int k = 0; k < 9; k++){
            if(numbers[k] == 0){
                answer.add(k+1);
            }
        }
        
        return answer;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    //another method
    
    public void solveSudoku2(char[][] board) {
        solveSudokuHelper(board);
    }
    
    public boolean solveSudokuHelper(char[][] board){
        int m = board.length;
        if(m == 0) return false;;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == '.'){
                    for(int k = 1; k <= 9; k++){
                        board[i][j] = (char) (k + '0');
                        if(isValid(board,i,j) && solveSudokuHelper(board)){
                            return true;
                        }   
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
    

    public boolean isValid(char[][] board,int i, int j){
        for(int p = 0; p < 9; p++){
            if(p != j && board[i][p] == board[i][j]){
                return false;
            }
        }
        
        for(int q = 0; q < 9; q++){
            if(q != i && board[q][j] == board[i][j]){
                return false;
            }
        }
        
        int x = i/3;
        int y = j/3;
        
        for(int r = 0; r < 3; r++){
            for(int w = 0; w < 3; w++){
                if((x + r) != i && (y + w) != j && board[x + r][y + w] == board[i][j]){
                    return false;
                }
            }
        }
        
        return true;
    }
    
    
    
    
    
    
    
    
    
}
