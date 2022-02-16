/*
MakingStan
10 feb 2022
 */
package org.makingstan.client;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Client {

    public static String masterPassword;

    public Client()
    {

    }


    public static String[] getCurrentManagerInformation()
    {
        File passwordFile = new File("src/main/resources/spas.txt");
        String[] managerInformation = new String[1000];

        try {
            System.out.println(Files.lines(passwordFile.toPath()).count());
        } catch (IOException e) {
            e.printStackTrace();
        }


        return managerInformation;
    }

    public static String getMasterPassword()
    {
        return masterPassword;
    }


    public static String getSHA265Code(String text) throws NoSuchAlgorithmException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        byte[] messageDigest = md.digest(text.getBytes());

        BigInteger no = new BigInteger(1, messageDigest);

        String hashtext = no.toString(16);

        while (hashtext.length() < 32) {
            hashtext = "0" + hashtext;
        }

        return hashtext;
    }
}
