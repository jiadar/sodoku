package sudoku;

import java.util.ArrayList;

public class Tester {
   public static void main(String[] args) {

      final String[]	PUZZLE_1 =
         {
            "..3.1.5..",
            "8..395..1",
            "15.....27",
            ".8..7..5.",
            "62.9.4.13",
            ".9..2..7.",
            "91.....34",
            "2..748..9",
            "..6.3.2.."		
         };    

            final String[]	PUZZLE_2 =
         {
            "1........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            ".........",
            "........."};

      System.out.println("origional");
      Grid g = new Grid(PUZZLE_2);

      System.out.println(g.toString());
      
      ArrayList<Grid> options = g.next9Grids();
      System.out.println("next 9 ");

      // write a loop to print all the grids in teh arraylist
      for (Grid test: options)
         {
            System.out.println(test);
         }
   }
}
