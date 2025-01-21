import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {



int charNumber = 12;
Boolean Symbols = false;

Boolean quit = false;
while(!quit) {
    System.out.println("Welcome to password generator\n[1] Generate\n[2] Settings\n[3] QUIT");

    Scanner scanner = new Scanner(System.in);
    int userInput = scanner.nextInt();

    if (userInput == 1) {

        generatePassword(12, Symbols);

    }
    if(userInput == 2)
    {
        String symbolString;
        if(!Symbols)
        {
            symbolString = "OFF";
        }
        else
        {
            symbolString = "ON";
        }
        System.out.println("Change Settings");
        System.out.println("[1] Character Number (" + charNumber + ")");
        System.out.println("[2] Use Symbols (" + symbolString + ")");

        int newUserInput = scanner.nextInt();
        switch(newUserInput)
        {
            case 1:
                System.out.println("Input new char number:");
                charNumber = scanner.nextInt();
                break;
            case 2:
                Symbols = !Symbols;
                break;
            default:
                System.out.println("invalid input");
                break;

        }
    }
    if(userInput == 3)
    {
        System.out.println("QUITTING....");
        quit = true;
    }


    //WHILE END
}


    //FUNC END
    }







    public static void generatePassword(int characterNum,Boolean useSymbols)
    {

        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String symbols = "*@#$&%><!~";

        StringBuilder validChars = new StringBuilder(letters + numbers);
        if (useSymbols) {
            validChars.append(symbols);
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();


        password.append(letters.charAt(random.nextInt(letters.length()))); // letter
        password.append(numbers.charAt(random.nextInt(numbers.length()))); // number
        if (useSymbols) {
            password.append(symbols.charAt(random.nextInt(symbols.length()))); // symbol
        }
        while (password.length() < characterNum) {
            password.append(validChars.charAt(random.nextInt(validChars.length())));
        }

        // Shuffle the password
        char[] passwordArray = password.toString().toCharArray();
        for (int i = passwordArray.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[j];
            passwordArray[j] = temp;
        }

        System.out.println("PASSWORD:");
        System.out.println(new String(passwordArray));



}




    }
