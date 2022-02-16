/*
MakingStan
10 feb 2022
 */
package org.makingstan.client.gui.main;

import org.makingstan.client.Client;
import org.makingstan.client.gui.Style;
import org.makingstan.client.gui.generatepasswordgui.GeneratePasswordFrame;
import org.makingstan.client.gui.managergui.ManagerFrame;
import org.makingstan.client.gui.savepassword.SavePasswordFrame;
import org.makingstan.functionality.generating.Generate;

import javax.swing.*;
import java.awt.*;

public class SpasPanel extends JPanel {

    JButton storePasswordButton = new JButton("Store Password");
    JButton generatePasswordButton = new JButton("Generate Password");
    JButton passwordManagerButton = new JButton("Password Manager");


    public SpasPanel()
    {
        this.setBounds(0, 0, 700, 800);
        this.setBackground(new Color(150,130,50));


        formatSetup();

        this.add(storePasswordButton);
        this.add(generatePasswordButton);
        this.add(passwordManagerButton);
    }

    private void formatSetup()
    {
        Style.giveButtonStyle(storePasswordButton);
        Style.giveButtonStyle(generatePasswordButton);
        Style.giveButtonStyle(passwordManagerButton);

        storePasswordButton.addActionListener(e ->
        {
            new SavePasswordFrame();
        });
        generatePasswordButton.addActionListener(e ->
        {
            new GeneratePasswordFrame();
        });
        passwordManagerButton.addActionListener(e ->
        {
            new ManagerFrame();
        });
    }

}
