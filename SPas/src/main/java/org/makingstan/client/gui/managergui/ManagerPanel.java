package org.makingstan.client.gui.managergui;

import org.makingstan.client.gui.Style;
import org.makingstan.functionality.storing.Reading;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.nio.file.Files;

public class ManagerPanel extends JPanel {

    public ManagerPanel()
    {
        this.setBounds(0, 0, 700, 800);
        this.setBackground(new Color(150,130,50));
        this.setLayout(new GridLayout(15, 1));

        try
        {
            createRows();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static String removeTillWord(String input, String word)
    {
        return input.substring(input.indexOf(word)+1);
    }


    private String polishPassword(String managerInformation)
    {
        String password = removeTillWord(managerInformation, "password:");

        //for some reason it takes the p with the deletion :D (probaly because of the +1 but it won't compile if i just do it without)
        password = password.replace("assword:", "");
        //removes spaces. aes doesn't generate any spaces anyway
        password = password.trim();

        return password;
    }
    private void createRows() throws IOException {

        String fileLine[] = getFileLine();

        for(int i = 0; i < 15; i++)
        {
            JLabel label = new JLabel();
            JButton copyPasswordButton = new JButton("Copy password");


            Style.giveButtonStyle(copyPasswordButton);

            try
            {
                String managerInformation = Reading.decryptAes(i, fileLine);

                String password = "";
                password = polishPassword(managerInformation);

                String finalPassword = password;


                copyPasswordButton.addActionListener(e ->
                {
                    //copy the password to the users clipboard
                    StringSelection selection = new StringSelection(finalPassword);
                    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                    clipboard.setContents(selection, selection);
                });

                managerInformation = managerInformation.split("password: ")[0];

                //set the text
                label.setText(managerInformation);
            }
            catch (IOException | NullPointerException e)
            {
                    e.printStackTrace();
            }

            label.setFont(Style.getApplicationFont(30));
            label.setBorder(BorderFactory.createLineBorder(Color.black));

            //add the stuff
            this.add(label);
            this.add(copyPasswordButton);
        }
    }

    private String[] getFileLine() throws IOException {
        File passwordFile = new File("src/main/resources/spas.txt");

        BufferedReader reader;
        reader = new BufferedReader(new FileReader(passwordFile));
        String[] fileLine = new String[10000];

        //get all the lines of the file
        int lineCount = 0;

        while(true)
        {
            if (reader.readLine() == null) break;
            lineCount++;
        }


        for(int i = 0; i < lineCount; i++)
        {
            try
            {
                fileLine[i] = Files.readAllLines(passwordFile.toPath()).get(i);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        return fileLine;
    }
}
