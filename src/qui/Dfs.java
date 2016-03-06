package qui;

import java.util.*;

public class Dfs {

	Stack<Board> stack;
	Queue<Board> explored;
	
	Dfs() {
		stack = new Stack<Board>();
		explored = new LinkedList<Board>();
	}
	
	
	 /* Pop a state from stack
	    Then check that the state match goal?
	    If match, then return
	    If not, then get children states and push them into stack */
	private void path () {
		while(!stack.isEmpty()) {
			Board state;
			state = stack.pop();                //Pop a state from stack
			explored.add(state);                
			state.show();                       //Display a state
			if (state.checkGoal()) return;      //Check a state 
			getChildren(state);                 //Get children state and push into stack
		}
		System.out.println("No solution");	
	}
	
	
	/* Get childrent'possible state from the parent state
	   Check the children state and push into stack*/
	private void getChildren(Board state) {
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
							tmp.move(i,j,1);                   // get children state
							if(canAdd(tmp)) stack.push(tmp);   //check children state
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
							if(canAdd(tmp)) stack.push(tmp);
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
							if(canAdd(tmp)) stack.push(tmp);
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
							if(canAdd(tmp)) stack.push(tmp);
						}
					}
					catch (Exception e){}
					break;
				}
			}	
		}
	}
	
	
	/*Check if the state had already been traversal? */
	public boolean canAdd(Board state) {
        if (explored.isEmpty()) {
            return true;
        }
        
        for (Board temp : explored) {
            boolean found = Arrays.deepEquals(state.board, temp.board);
            if (found) {
                return false;
            }
        }
        
        for (Board temp : stack) {
            boolean found = Arrays.deepEquals(state.board, temp.board);
            if (found) {
                return false;
            }
        }
        return true;
    }
	
	public void go(Board state) {
		explored.clear();
		stack.clear();
		explored.add(state);
		stack.push(state);
		this.path();
		
	}

}
