import java.util.ArrayList;
import java.util.Collections;


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
		//fill board with 0's to initialize
		for(int i=0; i<board.length; i++)
			for(int j=0; j<board[0].length; j++)
				board[i][j]=Integer.toString(0);
				
		//need to randomly generate the mines. How to get nonrepeating random numbers? https://stackoverflow.com/questions/8115722/generating-unique-random-numbers-in-java
		
		ArrayList<Integer> randlist = new ArrayList<Integer>();
        for (int i=1; i<=height*width; i++) //for generating the mines each square of the board gets a number, starting a 1, running across rows then down columns. Number of squares is thus width*height
        {
            randlist.add(new Integer(i));
        }
        Collections.shuffle(randlist);
        for (int i=0; i<mines; i++) 
        {
            System.out.println(randlist.get(i));
            //mapping the generated mine location onto the board (had to figure out how to do)
            int modresult = randlist.get(i)%width-1;
            int y = (modresult == -1) ? width-1 : modresult;
            int x = (modresult == -1) ? randlist.get(i)/width-1 : randlist.get(i)/width;
            board[x][y]="M";
        }
			
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