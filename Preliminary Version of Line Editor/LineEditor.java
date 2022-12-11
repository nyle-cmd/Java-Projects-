import java.io.*;
import java.util.*;


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
                    ll.addLine(line);
                    break;
                case 4:
                    System.out.print("\n Enter the line to insert: ");
                    line = sc.nextLine();
                    System.out.print("\n Enter the line number to insert: ");
                    lineNumber = sc.nextInt();
                    ll.addLine(line, lineNumber);
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