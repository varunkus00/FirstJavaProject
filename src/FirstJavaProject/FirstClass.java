package FirstJavaProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstClass {

    //public String name;
    //int age;
    String FileName = "FirstClass.log";
    String FilePath = "C:/Users/shriv/Downloads/Documents/";

    /*public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }*/

    public void setFileName(String FileName) {
        this.FileName = FileName;
    }

    public void setFilePath(String FilePath) {
        this.FilePath = FilePath;
    }

    /*public void display() {
        System.out.println("My name is : "+name+". My age is : "+age);
    }*/

    public String getFileName() {
        return FileName;
    }

    public void WriteToLogFile(String logMessage) {
        try {
            FileWriter obj = new FileWriter(FilePath+FileName, true);

            obj.write(logMessage);
            obj.write("\n");
            System.out.println("Write to log file successfull");
            obj.close();

        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    public void ReadFromLogFile() {
        try {
            File obj = new File(FilePath+FileName);
            Scanner myReader = new Scanner(obj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
                System.out.println();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occured");
            e.printStackTrace();
        }

    }

    public String ReadAtLineNumberInLogFile(int lineNumber) {
        String line = "";
        try {
            int totalLines = getNumberOfLines();
            if( lineNumber <= 0 || lineNumber > totalLines) {
                System.out.println("Invalid Line Number");
                return "";
            }

            int linesRead = 0;

            File obj = new File(FilePath+FileName);
            Scanner myReader = new Scanner(obj);
            while(myReader.hasNextLine()) {
                String data = myReader.nextLine();
                //System.out.println(data + " Line Number is : " + linesRead);
                if( lineNumber == (linesRead + 1) ) {
                    line = data;
                    break;
                }
                linesRead++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
       // System.out.println(line);
        return line;
    }

    public void clear() {
        try {
            FileWriter obj = new FileWriter(FilePath+FileName);
            obj.write("");
            System.out.println("Content Cleared");
            obj.close();
        } catch (IOException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
    }

    public void modifyAtLine(int lineNumber, String text) {
        ArrayList<String> myList = new ArrayList<>();
        try {
            File obj = new File(FilePath+FileName);
            Scanner read = new Scanner(obj);
            while(read.hasNextLine()) {
                String data = read.nextLine();
                myList.add(data);
            }
            read.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occurred");
            e.printStackTrace();
        }
        if( lineNumber <= 0 || lineNumber > myList.size() ) {
            System.out.println("Invalid Line Number");
            return;
        }

        myList.set(lineNumber-1, text);
        clear();
        for(String lines : myList ) {
            if(!lines.isEmpty()) {
                WriteToLogFile(lines);
            }
        }
    }

    public int getNumberOfLines() {
        int countOfLines = 0;
        try {
            File obj = new File(FilePath+FileName);
            Scanner read = new Scanner(obj);
            while(read.hasNextLine()) {
                read.nextLine();
                countOfLines++;
            }
            read.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
        return countOfLines;
    }

    public void promptMessage() {
        System.out.println("|--------------------------------------------------------------------------");
        System.out.println("| Select the choice from below list :                                      ");
        System.out.println("| For saving the content to file "+FileName+"               Enter 1 :      ");
        System.out.println("| For reading the existing content of file "+FileName+"     Enter 2 :      ");
        System.out.println("| For reading the exact line number of file "+FileName+"    Enter 3 :      ");
        System.out.println("| For removing the entire content of file "+FileName+"      Enter 4 :      ");
        System.out.println("| For removing the line of file "+FileName+"                Enter 5 :      ");
        System.out.println("| To print the number of lines in file "+FileName+"         Enter 6 :      ");
        System.out.println("| Exit :                                                    Enter 9 :      ");
        System.out.println("|--------------------------------------------------------------------------");
    }

}
