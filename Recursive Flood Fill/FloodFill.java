import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;
import java.io.PrintStream;

public class FloodFill {


   static Scanner sc = new Scanner(System.in);

   boolean [][] check;
   public static void main(String[] args){

   FloodFill a = new FloodFill();
   
	Scanner keyboard = new Scanner(System.in); 
	String filename = keyboard.nextLine();
	char[][] array = a.build2DArray(filename);

   
   a.save(array, "newFile.txt");
   a.print(array);
   a.fill(array, 1, 2, '*');
   
   

   }

   // -------------------------------- Method 1 -------------------------------------------------------

   public char[][] build2DArray(String filename){

      char[][] arr = null;
   
      try {


         File file = new File(filename);
         Scanner scnr = new Scanner(file); // FileNotFoundException
      
         String first = scnr.nextLine(); // "15 32"
         String[] split = first.split(" "); // {"15", "32}
         int rows = Integer.parseInt(split[0]); // 15
         int cols = Integer.parseInt(split[1]); // 32

         //System.out.println(rows + " " + cols);
         arr = new char[rows][cols];
         check = new boolean[rows][cols];

      	// reading each line of file
         int row = 0;

         while(scnr.hasNextLine()) {

            String line = scnr.nextLine();
            arr[row] = line.toCharArray();
            row++;
            
         }
      }

      catch(FileNotFoundException fnfe){
         fnfe.printStackTrace();
      }
   
      return arr;
   }

// -------------------------------- Method 2 -------------------------------------------------------


   public void fill( char[][] arr, int row, int col, char replacement ){
      
      char temp = arr[row][col];

      if (temp != replacement){

         arr[row][col] = replacement ;  

          if (row-1 >= 0 && arr[row-1][col] == temp ) fill(arr, row-1, col, replacement) ;
          if (row + 1 < arr.length && arr[row+1][col] == temp) fill(arr, row+1, col, replacement);
          
          if (col-1 >= 0 && arr[row][col-1] == temp ) fill(arr, row, col-1, replacement) ;
          if (col + 1 < arr[0].length && arr[row][col+1] == temp) fill(arr, row, col+1, replacement) ;
      } 
  }

// -------------------------------- Method 3 -------------------------------------------------------

      public void print(char[][] arr){

         System.out.println(arr.length+" "+arr[0].length);

         for(int row = 0; row < arr.length; row++) {
            for(int col = 0; col < arr[0].length; col++) {
               System.out.print(arr[row][col]);
            }
            System.out.println(); // newline
         }
      }

// -------------------------------- Method 4 -------------------------------------------------------

   public void save(char[][] arr, String filename) {

      PrintStream p_s;
      try {
         p_s = new PrintStream(new FileOutputStream(filename));


      p_s.println(arr.length+" "+arr[0].length);
      for(int row=0;row < arr.length;row++){

         for(int col=0; col < arr[row].length;col++){
            char s = arr[row][col];
            p_s.print(s); 
         }
         p_s.println(); //new line
      }

      p_s.close(); // close the file
      }
      
      catch (FileNotFoundException e) {

      System.out.print(e.getMessage());
                                       }
                                       
}}
