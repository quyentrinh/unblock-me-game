package qui;

import java.util.*;

public class Bfs {
	Queue<Board> queue;
	Queue<Board> explore ;
	
	Bfs() {
		queue = new LinkedList<Board>();
		explore = new LinkedList<Board>();
	}
	
	
	/* remove a state from queue
    Then check that the state match goal?
    If match, then return
    If not, then get children states and add them into queue */
	private void path () {
		while(!queue.isEmpty()) {
			Board state;
			state = queue.remove();            //remove a state from queue
			explore.add(state);
			state.show();                      //display a state
			if (state.checkGoal()) return;     // return if the state match goal
			getChildren(state);                //Get children state and add into queue
		}
		System.out.println("No solution");	
	}
	
	
	/* Get childrent'possible state from the parent state
	   Check the children state and add into queue*/
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
							tmp.move(i,j,1);
							if(canAdd(tmp)) queue.add(tmp);
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
							if(canAdd(tmp)) queue.add(tmp);
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
							if(canAdd(tmp)) queue.add(tmp);
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
							if(canAdd(tmp)) queue.add(tmp);
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
        if (explore.isEmpty()) {
            return true;
        }
        for (Board temp : explore) {
            boolean found = Arrays.deepEquals(state.board, temp.board);
            if (found) {
                return false;
            }
        }
        
        for (Board temp : queue) {
            boolean found = Arrays.deepEquals(state.board, temp.board);
            if (found) {
                return false;
            }
        }
        return true;
    }
	
	public void go(Board state) {
		explore.clear();
		queue.clear();
		explore.add(state);
		queue.add(state);
		this.path();
		
	}
}
