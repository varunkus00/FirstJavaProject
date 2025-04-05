package FirstJavaProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FirstClass {

    public String name;
    int age;
    String FileName = "FirstClass.log";
    String FilePath = "C:/Users/shriv/Downloads/Documents/";

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void display() {
        System.out.println("My name is : "+name+". My age is : "+age);
    }

    public void WriteToLogFile(String logMessage) {
        try {
            FileWriter obj = new FileWriter(FilePath+FileName, true);

            obj.write(logMessage);
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
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An Error Occured");
            e.printStackTrace();
        }

    }

}
