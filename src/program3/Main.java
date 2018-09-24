package program3;

import java.io.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //vars
        String filePath;
        String teePath;
        int decoratorChoice;
        boolean quit = false;
        int filterOutputChoice;
        Scanner in = new Scanner(System.in);

        //File to write data to
        File file = new File("Output.txt");

        System.out.println("Decorator Program");
        System.out.println("Please enter a file to be decorated: ");
        filePath = in.nextLine();
        //Make the writer and reader
        try {
            Reader reader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(reader);
            Writer writer = new FileWriter(file,true);
            Output streamOutput = new StreamOutput(writer);
            System.out.println("Thank you you've entered: " + filePath);

            System.out.println("Please select any decorators you want.\nThey will be applied in the order of select.\n\nEnter 1 for LineOutput" +
                    "\t 2 for NumberedOutput\t 3 for TeeOutput\t 4 for SpecialChar\t 0 to stop applying decorators");
            System.out.println("***The order these are applied will change output. i.e. teeoutput will apply any decorators assigned after it's applied.***\n");

            do {
                System.out.println("Enter a choice: ");
                try {
                    decoratorChoice = in.nextInt();

                    switch (decoratorChoice) {
                        case 1:
                            System.out.println("You've chosen 1 LineOuput");
                            streamOutput = new LineOutput(streamOutput);
                            break;
                        case 2:
                            System.out.println("You've chosen 2 NumberedOutput");
                            streamOutput = new NumberedOutput(streamOutput);
                            break;
                        case 3:
                            System.out.println("You've chosen 3 TeeOuput");
                            System.out.println("Please enter file to Tee to: ");
                            teePath = in.next();
                            File teeFile = new File(teePath);
                            streamOutput = new TeeOuput(streamOutput,teeFile);
                            break;
                        case 4:
                            System.out.println("You've chosen 4 FilterOuput");
                            System.out.println("Which Filter?\n 1 for Contains a Digit - the line will write if it contains a digit\n2 for SpecialChar which will print if line contains a special char (*#$%@)\n");
                            filterOutputChoice = in.nextInt();
                            switch (filterOutputChoice){
                                case 1:
                                    System.out.println("You've chosen Contains a digit");
                                    streamOutput = new ContainsDigit(streamOutput);
                                    break;
                                case 2:
                                    System.out.println("You've chosen SpecialChar");
                                    streamOutput = new SpecialChar(streamOutput);
                                    break;

                                    default:
                                        System.out.println("None selected");
                                        break;
                            }
                            break;
                        case 0:
                            quit = true;
                            System.out.println("Applying decorators");
                            break;

                        default:
                            System.out.println("invalid input");
                            break;
                    }
                } catch (Exception e) {
                    System.out.println("numbers please");
                    quit = true;
                }
            } while (!quit);


            //loop through file line by line
            String line = bufferedReader.readLine();
            while (line != null) {
                streamOutput.write(line);
                line = bufferedReader.readLine();
            }

            //close it up
            writer.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
