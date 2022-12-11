import java.io.*;
import java.util.*;


public class LineList
{
    ArrayList<String> allLines = new ArrayList<String>(); //stores lines

    public void print() //prints line and num
    {
        if(allLines.size() == 0)
            System.out.println("\nERROR: Empty list.\nCannot print.");
        else
        {
            for(int c = 0; c < allLines.size(); c++)
                System.out.println((c + 1) + ". " + allLines.get(c));
        }
    }

    @Override
    public String toString() {
        String result = "";

        // only build string if the list is not empty
        if(allLines.size() > 0) {
            for(int c = 0; c < allLines.size() - 1; c++) {
                result += allLines.get(c) + "\n";
            }
            result += allLines.get(allLines.size() - 1);
        }

        return result;
    }

    public void replace(String originalWord, String newWord) //rplaces orginial words with new word
    {
        ArrayList<String> lines = new ArrayList<String>();

        if(allLines.size() == 0) {
            System.out.println("\nERROR: Empty list.\nCannot replace.");
            return;
        }

        for(int c = 0; c < allLines.size(); c++)
        {
            String line = allLines.get(c);
            line = line.replace(originalWord, newWord);
            lines.add(line);
        }

        allLines = lines; // replace old list with new list
    }

    public int words() //counts and returns line num
    {
        int count = 0;
        for(int c = 0; c < allLines.size(); c++)
        {
            String []words = allLines.get(c).split("\\s|\\t");
            count += words.length;
        }
        return count;
    }

    public void line(int lineNumber) {
        int index = lineNumber - 1;
        if(index < 0 || index >= allLines.size()) {
            System.out.println("Line " + lineNumber + " does not exist.");
        } else {
            System.out.println(allLines.get(index));
        }
    }

    public void addLine(String line) {
        allLines.add(line);
    }

    public void addLine(String line, int lineNumber) //method to add line
    {
        int index = lineNumber - 1;
        if(index >= 0 && index <= allLines.size())
        {
            allLines.add(index, line);
        }

        else //displays error for anything else
            System.out.println("\nInvalid line number: " + lineNumber);
    }

    public void load(String fileName) //will read files
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

            System.out.println("\nFile: " + fileName + " was loaded successfully");
        }

        catch (FileNotFoundException e) //if file isn't found
        {
            System.err.println("Unable to open the file: " + fileName);
        }
    }

    public void save(String fileName) // method that writes the contents of list to file
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

            System.out.println("\nFile: " + fileName + " saved successfully.");
        }

        catch (FileNotFoundException e)
        {
            System.err.println("Unable to open the file: " + fileName);
        }
    }

    public int lines() //returns lines
    {
        return allLines.size();
    }

    public void delete(int lineNumber) //method that deletes a line based on the parameter line number
    {
        int index = lineNumber - 1;
        // Checks if list is empty
        if(allLines.size() == 0)
            System.out.println("\nERROR: Empty list.\nCannot delete.");

        else //if empty
        {
            if(index >= 0 && index < allLines.size())
            {
                allLines.remove(index);
            }

            else //invalid line num
                System.out.println("\nERROR: Invalid line number: " + lineNumber);
        }
    }

    public void empty() //deletes everyting in list
    {
        allLines.clear();
    }
}