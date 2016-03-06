package qui;
import java.util.Calendar;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		// some code.....
		// TODO Auto-generated method stub
		
		Scanner inp = new Scanner(System.in);
		int [][]board;
		
		System.out.println("Chọn testcase để xử lí: \n" +
				           "1: Testcase 1 \n" +
                           "2: Testcase 2 \n" +
	                       "3: Testcase 3 \n" +
                           "5: Testcase 5 \n" +
                           "6: Testcase 6 \n" +
                           "7: Testcase 7 \n" +
                           "8: Testcase 8 \n" +
                           "9: Testcase 9 \n" +
                           "10:Testcase 10 \n" +
                           "0: Tự nhập \n");
		
		String testcase = inp.nextLine();
		switch (testcase) {
		case "1":
			board = new int [][]{
					{3, 1, 2, 1, 2, 0},
	                {4, 0, 0, 0, 0, 0},
	                {8, 9, 3, 0, 0, 0},
	                {0, 0, 4, 3, 3, 0},
	                {1, 2, 0, 5, 5, 0},
	                {0, 0, 0, 4, 4, 0}};
			break;
		case "2":
			board = new int [][]{
					{1, 6, 2, 3, 0, 0},
	                {3, 1, 2, 5, 1, 2},
	                {5, 8, 9, 4, 0, 3},
	                {4, 0, 3, 1, 2, 5},
	                {0, 0, 4, 0, 3, 4},
	                {1, 6, 2, 0, 4, 0}};
			break;
		case "3":
			board = new int [][]{
					{3, 1, 2, 1, 2, 3},
	                {4, 0, 3, 0, 3, 5},
	                {8, 9, 4, 3, 5, 4},
	                {3, 3, 3, 4, 4, 3},
	                {5, 5, 5, 3, 3, 5},
	                {4, 4, 4, 4, 4, 4}};
			break;
		case "4":
			board = new int [][]{		
					{0, 0, 0, 0, 0, 0},
	                {0, 0, 0, 0, 0, 0},
	                {8, 9, 0, 0, 0, 0},
	                {0, 0, 0, 0, 3, 0},
	                {0, 0, 0, 3, 4, 0},
	                {0, 0, 0, 4, 1, 2}};
			break;
		case "5":
			board = new int [][]{
					{1, 2, 1, 2, 3, 3},
	                {3, 0, 1, 2, 4, 5},
	                {4, 3, 3, 8, 9, 4},
	                {0, 4, 5, 1, 2, 0},
	                {0, 0, 4, 0, 0, 0},
	                {1, 2, 0, 0, 0, 0}};
			break;
		case "6":
			board = new int [][]{	
					{0, 0, 1, 2, 1, 2},
	                {0, 1, 2, 1, 2, 3},
	                {0, 0, 8, 9, 3, 5},
	                {1, 2, 1, 2, 4, 4},
	                {3, 0, 0, 3, 1, 2},
	                {4, 0, 0, 4, 1, 2}};
			break;
		case "7":
			board = new int [][]{	
					 {0, 0, 0, 0, 1, 2},
		             {0, 1, 2, 1, 2, 3},
		             {0, 0, 8, 9, 3, 5},
		             {1, 2, 1, 2, 4, 4},
		             {3, 0, 0, 3, 1, 2},
		             {4, 0, 0, 4, 1, 2}};
			break;
		case "8":
			board = new int [][]{		
					{3, 3, 0, 1, 2, 0},
	                {5, 5, 0, 0, 3, 3},
	                {4, 4, 8, 9, 5, 5},
	                {1, 2, 3, 3, 4, 4},
	                {0, 0, 4, 4, 1, 2},
	                {0, 1, 2, 1, 2, 0}};
			break;
		case "9":
			board = new int [][]{
					{0, 0, 0, 3, 3, 3},
			        {0, 1, 2, 4, 5, 5},
			        {0, 0, 8, 9, 4, 4},
			        {1, 2, 3, 0, 0, 0},
			        {0, 3, 4, 0, 1, 2},
			        {0, 4, 1, 2, 1, 2}};
			break;
		case "10":
			board = new int [][]{		
					{1, 6, 2, 3, 3, 3},
	                {3, 1, 2, 4, 5, 5},
	                {4, 0, 8, 9, 4, 4},
	                {1, 2, 3, 0, 0, 0},
	                {0, 3, 4, 0, 1, 2},
	                {0, 4, 1, 2, 1, 2}};
			break;
		default:
			board = new int[6][6];
			for(int i=0; i< board.length; i++)
				for(int j=0; j< board.length; j++) {
					board[i][j] = inp.nextInt();
				}
		}
		

		Board start = new Board(board);
		
		System.out.println("1: DFS \n" +
		                   "2: BFS \n" +
			               "3: Heuristic \n");
		String id;
		id = inp.nextLine();
		
		long begin = Calendar.getInstance().getTimeInMillis();
		switch(id) {
		default :
		case "1":
			Dfs dfs = new Dfs();
			dfs.go(start);
			break;
		case "2":
			Bfs bfs = new Bfs();
			bfs.go(start);
			break;
		case "3":
			Heuristic heuristic = new Heuristic();
			heuristic.go(start);
			break;
		}
		long end = Calendar.getInstance().getTimeInMillis();
		
		
		System.out.println("Executed Time: " + (end - begin));
		System.out.println((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / Math.pow(2, 20));
	}

}
