/*
feb 13 2022
MakingStan
 */

package org.makingstan.functionality.storing;

import org.makingstan.client.Client;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

public class Reading {

    public static String decryptAes(int fileIndex, String[] fileLine) throws IOException
    {
        if(fileLine[fileIndex] == null)
        {
            return "";
        }

        try
        {
            /* Declare a byte array. */
            byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            IvParameterSpec ivspec = new IvParameterSpec(iv);
            /* Create factory for secret keys. */
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            /* PBEKeySpec class implements KeySpec interface. */
            KeySpec spec = new PBEKeySpec(Client.getSHA265Code(Client.getMasterPassword()).toCharArray(), Client.getMasterPassword().getBytes(), 65536, 256);
            SecretKey tmp = factory.generateSecret(spec);

            SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey, ivspec);
            /* Retruns decrypted value. */

            if(fileLine[fileIndex] != null)
            {
                return new String(cipher.doFinal(Base64.getDecoder().decode(fileLine[fileIndex])));
            }
            else
            {
                return "";
            }
        }

        catch (InvalidAlgorithmParameterException | InvalidKeyException | NoSuchAlgorithmException | InvalidKeySpecException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e)
        {
            System.out.println("Error occured during decryption: " + e.toString());
        }
        return null;
    }


}
