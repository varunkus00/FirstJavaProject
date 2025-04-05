import FirstJavaProject.FirstClass;

import java.util.Objects;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        FirstClass fc = new FirstClass();
        System.out.println("Hey! This is FirstJava Application ");
        System.out.println("I will need few details to demonstrate myself...");
        System.out.println("Please enter your name : ");
        //To read name from console
        Scanner read = new Scanner(System.in);
        String dName = read.nextLine();
        //To read age from console
        System.out.println("Please enter your age : ");
        Scanner rAge = new Scanner(System.in);
        int dAge = read.nextInt();

        fc.setName(dName);
        fc.setAge(dAge);
        System.out.println("Hi "+ fc.name +" Do you know I can save the information you give on console.");
        System.out.println("Please enter 1 for writing to file  and 2 for display previous messages : ");

        Scanner rPrompt = new Scanner(System.in);
        String dPrompt = rPrompt.nextLine();

        if(Objects.equals(dPrompt, "1")) {
            //To read the text message
            System.out.println("Write the message to save to the file :  ");
            Scanner rMessage = new Scanner(System.in);
            String dMessage = rMessage.nextLine();
            fc.WriteToLogFile(dMessage);
        }
        else if(Objects.equals(dPrompt, "2")) {
            fc.ReadFromLogFile();
        }
        else {
            fc.display();
        }
    }
}