

import java.io.*;
import java.util.*;

class LineList
{
   ArrayList<String> allLines = new ArrayList<String>(); //stores lines

   void load(String fileName) //will read files
   {
      Scanner fileRead = null;
   
      try
      {
         fileRead = new Scanner(new File(fileName));
      
         while(fileRead.hasNextLine())
         {
            allLines.add(fileRead.nextLine());
         }
      
         fileRead.close();
      
         System.out.println("\n File: " + fileName + " was loaded successfully");
      }
      
      catch (FileNotFoundException e) //if file isn't found
      {
         System.err.println("Unable to open the file: " + fileName);
      }
   }

   void save(String fileName) // method that writes the contents of list to file
   {
      PrintStream pw = null; //saves file contents
   
      try
      {
         pw = new PrintStream(new FileOutputStream(fileName)); 
      
         for(int c = 0; c < allLines.size(); c++)
         {
            pw.print(allLines.get(c));
         
            if(c != allLines.size() - 1)
               pw.println();
         }
      
         pw.close();
      
         System.out.println("\n File: " + fileName + " saved successfully.");
      }
      
      catch (FileNotFoundException e)
      {
         System.err.println("Unable to open the file: " + fileName);
      }
   }

   void addLine(int lineNumber, String line) //method to add line
   {
      if(lineNumber >= 0 && lineNumber <= allLines.size())
      {
         allLines.add(lineNumber, line);
         System.out.println("\n Line added successfully");
      }
      
      else //displays error for anything else
         System.out.println("\n Invalid line number: " + lineNumber);
   }
 
   int words() //counts and returns line num
   {
      int count = 0;
      for(int c = 0; c < allLines.size(); c++)
      {
         String []words = allLines.get(c).split(" ");
         count += words.length;
      }
      return count;
   }

   int lines() //returns lines
   {
      return allLines.size();
   }

   void delete(int lineNumber) //method that deletes a line based on the parameter line number

   {
   // Checks if list is empty
      if(allLines.size() == 0)
         System.out.println("\n ERROR: Empty list. \n Cannot delete.");
      
      else //if empty
      {
         if(lineNumber >= 0 && lineNumber < allLines.size())
         {
            allLines.remove(lineNumber);
            System.out.println("\n Line number: " + lineNumber +
               " deleted successfully.");
         }
         
         else //invalid line num
            System.out.println("\n ERROR: Invalid line number: " + lineNumber);
      }
   }

   void print() //prints line and num
   {
      if(allLines.size() == 0)
         System.out.println("\n ERROR: Empty list. \n Cannot print.");
      else
      {
         for(int c = 0; c < allLines.size(); c++)
            System.out.println(allLines.get(c));
      }
   }

   void replace(String originalWord, String newWord) //rplaces orginial words with new word
   {
      if(allLines.size() == 0)
         System.out.println("\n ERROR: Empty list. \n Cannot replace.");
      
      else //if not empty
      {
         int index = allLines.indexOf(originalWord);
      
         if(index == -1)
            System.out.println("\n ERROR: String: " + originalWord +
               " not found.");
         
         else //if found
         {
            allLines.remove(index);
            allLines.add(index, newWord);
            System.out.println("\n Line replaced successfully.");
         }
      }
   }

   void empty() //deletes everyting in list
   {
      allLines.clear();
   }
}

// Driver class definition
public class LineEditor
{
// Method to display menu, accept user choice and returns it
   static int menu(Scanner sc)
   {
      int choice;
   // Displays menu
      System.out.print("\n\n ************** MENU ************** ");
      System.out.print("\n\t 1) Load \n\t 2) Save \n\t 3) Append \n\t 4) Insert" +
         "\n\t 5) Words \n\t 6) Lines \n\t 7) Delete \n\t 8) Print " +
         "\n\t 9) Replace \n\t 10) Clear \n\t 11) Exit." +
         "\n\t\t Select a choice: ");
   // Accepts user choice
      choice = sc.nextInt();
      sc.nextLine();
   // Returns user choice
      return choice;
   }

   public static void main(String[] args)
   {
      LineList ll = new LineList();
   
      Scanner sc = new Scanner(System.in);
      String line;
      int lineNumber;
   
   // Loops till user choice is not 11
      do
      {
      // Calls the method to get user choice
      // Checks user choice and calls appropriate method
         switch(menu(sc))
         {
            case 1:
               ll.load(args[0]);
               break;
            case 2:
               ll.save(args[0]);
               break;
            case 3:
               System.out.print("\n Enter the line to append: ");
               line = sc.nextLine();
               ll.addLine(ll.lines(), line);
               break;
            case 4:
               System.out.print("\n Enter the line to insert: ");
               line = sc.nextLine();
               System.out.print("\n Enter the line number to insert: ");
               lineNumber = sc.nextInt();
               ll.addLine(lineNumber, line);
               break;
            case 5:
               System.out.println("\n Number of words: " + ll.words());
               break;
            case 6:
               System.out.println("\n Number of lines: " + ll.lines());
               break;
            case 7:
               System.out.print("\n Enter the line number to delete: ");
               lineNumber = sc.nextInt();
               ll.delete(lineNumber);
               break;
            case 8:
               ll.print();
               break;
            case 9:
               System.out.print("\n Enter the old line: ");
               line = sc.nextLine();
               System.out.print("\n Enter the new line: ");
               String newLine = sc.nextLine();
               ll.replace(line, newLine);
               break;
            case 10:
               ll.empty();
               break;
            case 11:
               System.out.print("\n\t\t Thank you!");
               System.exit(0);
               break;
            default:
               System.out.print("\n\t\t Invalid Choice!");
         }
      }while(true);
   }
}