package qui;

public class Heuristic {
	
	Board state;
	int possibleMove;
	
	private void path () {
		this.state.show();
		if(state.checkGoal()) return;
		possibleMove = possible_move(this.state);
		getChildren();
	}
	
	private int possible_move(Board state) {
		int possibleMove = 0;
		for( int i=0; i < state.board.length; i++) {
			for( int j=0; j < state.board[i].length; j++) {
				switch(state.board[i][j]) {
				case 8:
				case 1:
					try {
						if(state.board[i][j-1] == 0) 
							possibleMove++;
					}
					catch (Exception e){}
					break;
					
				case 9:
				case 2:
					try {
						if(state.board[i][j+1] == 0)
							possibleMove++;
					}
					catch (Exception e){}
					break;
					
				case 3:
					try {
						if(state.board[i-1][j] == 0)
							possibleMove++;
					}
					catch (Exception e){}
					break;
					
				case 4:
					try {
						if(state.board[i+1][j] == 0)
							possibleMove++;
					}
					catch (Exception e){}
					break;
				}
			}	
		}
		return possibleMove;
	}
	
	private boolean check(Board state) {
		int a = possible_move(state);
		if(a > possibleMove) 
		{
			this.state = state;
			this.path();
			return true;
		}
		return false;
	}
	
	private void getChildren() {
		Board tmp;
		
		for( int i=0; i < state.board.length; i++) {
			for( int j=0; j < state.board[i].length; j++) {
				switch(state.board[i][j]) {
				case 8:
				case 1:
					try {
						tmp = new Board(); 
						tmp.copy(state);
						tmp.previous = state;
						if(state.board[i][j-1] == 0) 
						{
							tmp.move(i,j,1);
							if (check(tmp)) return;
						}
					}
					catch (Exception e){}
					break;
					
				case 9:
				case 2:
					try {
						tmp = new Board(); 
						tmp.copy(state);
						tmp.previous = state;
						if(state.board[i][j+1] == 0) {
							tmp.move(i,j,2);
							if (check(tmp)) return;
						}
						
					}
					catch (Exception e){}
					break;
					
				case 3:
					try {
						tmp = new Board(); 
						tmp.copy(state);
						tmp.previous = state;
						if(state.board[i-1][j] == 0) {
							tmp.move(i,j,3);
							if (check(tmp)) return;
						}
					}
					catch (Exception e){}
					break;
					
				case 4:
					try {
						tmp = new Board(); 
						tmp.copy(state);
						tmp.previous = state;
						if(state.board[i+1][j] == 0) {
							tmp.move(i,j,4);
							if (check(tmp)) return;
						}
					}
					catch (Exception e){}
					break;
				}
			}	
		}
	}
	
	public void go(Board state) {
		this.state = state;
		this.path();
		
	}
}
