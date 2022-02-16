/*
MakingStan
10 feb 2022
 */
package org.makingstan.functionality.generating;

import java.util.Random;

public class Generate {

    private static Random random = new Random();


    public static String generateNewPassword(boolean isSpecialCharacters, boolean isNumbers, boolean isCaps, int passwordLength)
    {
        String result = " ";
        char[] letters = new char[passwordLength];
        int decider;

        for(int i = 0; i < passwordLength; i++)
        {
            decider = random.nextInt(3);

            if(decider == 0 && isNumbers)
            {
                letters[i] = generateRandomNumber();
            }
            else if(decider == 1 && isCaps)
            {
                letters[i] = generateRandomCapsChar();
            }
            else if(decider == 2 && isSpecialCharacters)
            {
                letters[i] = generateRandomSpecialSymbol();
            }
            else
            {
                letters[i] = generateRandomChar();
            }
            result += letters[i];
        }


        return result;
    }

    private static char generateRandomChar()
    {
        int high = 123;
        int low = 97;
        int randomNumber = random.nextInt(high-low) + low;
        return (char)randomNumber;
    }

    private static char generateRandomNumber()
    {
        int high = 58;
        int low = 48;
        int randomNumber = random.nextInt(high-low) + low;
        return (char)randomNumber;
    }

    private static char generateRandomCapsChar()
    {
        int high = 91;
        int low = 65;
        int randomNumber = random.nextInt(high-low) + low;
        return (char)randomNumber;
    }

    private static char generateRandomSpecialSymbol()
    {
        int high = 48;
        int low = 33;
        int randomNumber = random.nextInt(high-low) + low;
        return (char)randomNumber;
    }
}
