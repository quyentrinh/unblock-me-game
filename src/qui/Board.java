package qui;

public class Board {
	Board previous;
	int [][]board;
	
	Board(int [][] start) {
		board = start;
		previous = null;
	}
	
	Board() {
		board = new int [][]{
		
				{1, 6, 2, 3, 3, 3},
                {3, 1, 2, 4, 5, 5},
                {4, 0, 8, 9, 4, 4},
                {1, 2, 3, 0, 0, 0},
                {0, 3, 4, 0, 1, 2},
                {0, 4, 1, 2, 1, 2}};
		
		
         
		previous = null;
	}
	
	public void copy(Board state) {
		for( int i = 0; i < board.length; i++) {
			for( int j = 0; j < board[i].length; j++) {
				board[i][j] = state.board[i][j];
			}
		}
	}
	
	public void move(int x, int y, int direction) {
		switch(direction) {
		case 8 :
		case 1 : 
			while( board[x][y]!=2 && board[x][y]!=9) {
				board[x][y-1] = board[x][y];
				y+=1;
			}
			board[x][y-1] = board[x][y];
			board[x][y] = 0;
			break;
			
		case 9:
		case 2 : 
			while( board[x][y]!=1 && board[x][y]!=8) {
				board[x][y+1] = board[x][y];
				y-=1;
			}
			board[x][y+1] = board[x][y];
			board[x][y] = 0;
			break;
			
		case 3 : 
			while( board[x][y]!=4 ) {
				board[x-1][y] = board[x][y];
				x+=1;
			}
			board[x-1][y] = board[x][y];
			board[x][y] = 0;
			break;
			
		case 4 : 
			while( board[x][y]!=3 ) {
				board[x+1][y] = board[x][y];
				x-=1;
			}
			board[x+1][y] = board[x][y];
			board[x][y] = 0;
			break;
		}
	}
	
	public void show() {
		for( int i = 0; i < board.length; i++) {
			for( int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void showResult(Board state) {
		if(state.previous != null)
			state.showResult(state.previous);
		state.show();
	}
	
	public boolean checkGoal(){
		if(this.board[2][5] == 9) return true;
			//this.showResult(this);
		else return false;
		//return true;
	}
}
