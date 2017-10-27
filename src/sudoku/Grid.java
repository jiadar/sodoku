package sudoku;

import java.util.*;
import java.util.Optional;


public class Grid 
{
	private int[][]						values;
	
	//
	// DON'T CHANGE THIS.
	//
	// Constructs a Grid instance from a string[] as provided by TestGridSupplier.
	// See TestGridSupplier for examples of input.
	// Dots in input strings represent 0s in values[][].
	//
	public Grid(String[] rows)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
		{
			String row = rows[j];
			char[] charray = row.toCharArray();
			for (int i=0; i<9; i++)
			{
				char ch = charray[i];
				if (ch != '.')
					values[j][i] = ch - '0';
			}
		}
	}
	
	
	//
	// DON'T CHANGE THIS.
	//
	public String toString()
	{
		String s = "";
		for (int j=0; j<9; j++)
		{
			for (int i=0; i<9; i++)
			{
				int n = values[j][i];
				if (n == 0)
					s += '.';
				else
					s += (char)('0' + n);
			}
			s += "\n";
		}
		return s;
	}


	//
	// DON'T CHANGE THIS.
	// Copy ctor. Duplicates its source. You’ll call this 9 times in next9Grids.
	//
	Grid(Grid src)
	{
		values = new int[9][9];
		for (int j=0; j<9; j++)
			for (int i=0; i<9; i++)
				values[j][i] = src.values[j][i];
	}
	
	
	//
	// COMPLETE THIS
	//
	//
	// Finds an empty member of values[][]. Returns an array list of 9 grids that look like the current grid,
	// except the empty member contains 1, 2, 3 .... 9. Returns null if the current grid is full. Don’t change
	// “this” grid. Build 9 new grids.
	// 
	//
	// Example: if this grid = 1........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//                         .........
	//
	// Then the returned array list would contain:
	// 
	// 11.......          12.......          13.......          14.......    and so on     19.......
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	// .........          .........          .........          .........                  .........
	//

   private Optional<ArrayList<Integer>> nextEmptyCell(int[][] values ) {
      int x = 0;
      int y = 0;

      ArrayList<Integer> rval = new ArrayList<Integer>();
      
      for (int i = 0; i < values.length; i++)  {
			for (int j = 0; j < values[i].length; j++) {
				if (values[i][j] == 0) {
               rval.add(i);
               rval.add(j);
               return Optional.of(rval);
            }
         }     
      }
      return Optional.empty();
   }

   public ArrayList<Grid> next9Grids()
	{		

		// Find x,y of an empty cell.

      Optional<ArrayList<Integer>> o = nextEmptyCell(values);
      // check if o.empty() and if not... 
      int xOfNextEmptyCell = o.get().get(0);
		int yOfNextEmptyCell = o.get().get(1);
      
      System.out.println("x, y: " + xOfNextEmptyCell + ", " + yOfNextEmptyCell);
      
		// Construct array list to contain 9 new grids.
		ArrayList<Grid> grids = new ArrayList<Grid>();

		// Create 9 new grids as described in the comments above. Add them to grids.
      for (int i = 1; i < 10; i++)
		{
         // copy this grid to a new grid
         Grid grid = new Grid(this);
         
         // at empty x, y insert i
         grid.values[xOfNextEmptyCell][yOfNextEmptyCell] = i;

         // add to grids
         
			grids.add(grid);
		}

		return grids;
	 
	}
	
	
	//
	// COMPLETE THIS
	//
	// Returns true if this grid is legal. A grid is legal if no row, column, or
	// 3x3 block contains a repeated 1, 2, 3, 4, 5, 6, 7, 8, or 9.
	//
	public boolean isLegal()
	{
		// Check every row. If you find an illegal row, return false.

		// Check every column. If you find an illegal column, return false.

		// Check every block. If you find an illegal block, return false.

		// All rows/cols/blocks are legal.
		return true;
	}

	
	//
	// COMPLETE THIS
	//
	// Returns true if every cell member of values[][] is a digit from 1-9.
	//
	public boolean isFull()
	{
      boolean isFull = true;
		int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		for (int i = 0; i < values.length; i++)
		{
			for (int j = 0; j < values[i].length; j++)
			{
				//Checks if every cell has an empty digit
				if (values[i][j] == 0)
				{
					isFull = false;
				}
				else
				{
					for (int num: number)
					{
                  isFull = true;
					}
				}
				
			}
		}
		return isFull;
	}
	
	

	//
	// COMPLETE THIS
	//
	// Returns true if x is a Grid and, for every (i,j), 
	// x.values[i][j] == this.values[i][j].
	//
	public boolean equals(Object x)
	{
      Grid that = (Grid)x;
		for (int i = 0; i < values.length; i++) 
		{
			for (int j = 0; j < values[i].length; j++)
			{
				if (this.values[i][j] != that.values[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
}
