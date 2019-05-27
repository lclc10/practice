


public class MineSweeper
{
	public static String[][] board;
	
	public static void main(String[] args)
	{
		//the minesweeper I get by google has default width 18, height 14, 40 mines
		//shouldn't do more than 26 because using letters as row and column guides
		setUpBoard(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
		
		printBoard();
	}
	
	public static void setUpBoard(int height, int width, int mines)
	{
		board = new String[height][width];
	}
	
	//print the board with row and column guides
	public static void printBoard()
	{
		String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; //there's def a way to do this without this but this is easier for me so
		
		//first row: column guides
		System.out.print(" ");
		//was going to do letters, then figured numbers to increment easier and use lines to set them off, then decided numbers after all because they remain one space long longer
		for(int i=0; i<board[0].length; i++)
		{
			System.out.print(letters.charAt(i));
		}
		System.out.println();
		
		//next rows: row guide, then that row of the board
		for(int i=0; i<board.length; i++)
		{
			System.out.print(letters.charAt(i));
			for(int j=0; j<board[0].length; j++)
			{
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}