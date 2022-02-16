package org.makingstan.functionality.storing;

import org.makingstan.client.Client;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.InvalidParameterSpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Store {

    private static final String resourcePath = "src/main/resources";
    public static String masterPassword = "";


    public static void storePassword(String websiteUrl, String name, String password) throws IOException {
        File passwordFile = new File(resourcePath + "/spas.txt");


        BufferedWriter writer = new BufferedWriter(new FileWriter(passwordFile, true));

        String encryptedData = encryptData(websiteUrl, name, password);

        writer.append(encryptedData + "\n");

        writer.close();
        //make sure to encrypt your password we are going to use aes
    }

    private static String encryptData(String websiteUrl, String name, String password) {
        try {
            return encryptAes("Website: "+websiteUrl +"| name: "+ name +"| password: "+ password);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException | InvalidParameterSpecException | IllegalBlockSizeException | BadPaddingException | NoSuchPaddingException | InvalidKeyException e) {
            e.printStackTrace();
            return null;
        }

    }

    private static String encryptAes(String text) throws NoSuchAlgorithmException, InvalidKeySpecException, InvalidParameterSpecException, IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, InvalidKeyException {
        {
            try
            {
                /* Declare a byte array. */
                byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
                IvParameterSpec ivspec = new IvParameterSpec(iv);
                /* Create factory for secret keys. */
                SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

                KeySpec spec = new PBEKeySpec(Client.getSHA265Code(masterPassword).toCharArray(), masterPassword.getBytes(), 65536, 256);
                SecretKey tmp = factory.generateSecret(spec);
                SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");

                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
                /* Retruns encrypted value. */
                return Base64.getEncoder()
                        .encodeToString(cipher.doFinal(text.getBytes(StandardCharsets.UTF_8)));
            }

            catch (InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException | InvalidAlgorithmParameterException e)
            {
                System.out.println("Error occured during encryption: " + e.toString());
            }
            return null;
        }

    }

}
