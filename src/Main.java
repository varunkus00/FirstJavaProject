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
        System.out.println("I am designed to play with files. Read/Write Some Text In File");
        System.out.println("Default File Name is - FirstClass.log");
        System.out.println("Default File Path is - C:/Users/shriv/Downloads/Documents/");

        int promptCounter = 0;
        do {
            System.out.println("Do you wish to change file name and path ? [y/n] :");
            Scanner rPrompt = new Scanner(System.in);
            String dPrompt = rPrompt.nextLine();
            if(Objects.equals(dPrompt, "y")) {
                System.out.println("Enter the file name : ");
                Scanner rfileName = new Scanner(System.in);
                String dFileName = rfileName.nextLine();

                System.out.println("Enter the valid file path : ");
                Scanner rfilePath = new Scanner(System.in);
                String dFilePath = rfilePath.nextLine();
                fc.setFileName(dFileName);
                fc.setFilePath(dFilePath);
                break;
            }
            else if(Objects.equals(dPrompt, "n")){
                break;
            }
            else if(promptCounter == 3) {
                break;
            }
            promptCounter++;
        } while(true);

        do {
            fc.promptMessage();

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
            else if(Objects.equals(dPrompt, "3")) {
                System.out.println("Enter the line number to read : ");
                Scanner readFromPrompt = new Scanner(System.in);
                int lineNumber = readFromPrompt.nextInt();
                System.out.println( " Line is : " + fc.ReadAtLineNumberInLogFile(lineNumber));
            }
            else if(Objects.equals(dPrompt, "4")) {
                fc.clear();
            }
            else if(Objects.equals(dPrompt, "5")){
                System.out.println("Enter the line to modify: ");
                Scanner readFromPrompt = new Scanner(System.in);
                int lineNumber = readFromPrompt.nextInt();
                System.out.println("Enter the text that needs to modified at line number "+lineNumber);
                Scanner readTextFromPrompt = new Scanner(System.in);
                String readText = readTextFromPrompt.nextLine();
                fc.modifyAtLine(lineNumber, readText);
                System.out.println(" Line Modified ");
            }
            else if(Objects.equals(dPrompt, "6")) {
                System.out.println(" Total Lines in file : "+fc.getFileName()+" is : "+fc.getNumberOfLines());
            }
            else if(Objects.equals(dPrompt, "9")) {
                System.out.println("Exiting From Prompt Window...");
                break;
            }
        } while(true);
    }
}