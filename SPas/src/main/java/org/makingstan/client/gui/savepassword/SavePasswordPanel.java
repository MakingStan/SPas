package org.makingstan.client.gui.savepassword;

import org.makingstan.client.gui.Style;
import org.makingstan.functionality.storing.Store;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class SavePasswordPanel extends JPanel {

    JTextArea passwordTextField = new JTextArea("password");
    JTextArea websiteTextField = new JTextArea("website");
    JTextArea nameTextField = new JTextArea("name");

    JButton saveButton = new JButton("save");

    public SavePasswordPanel()
    {
        this.setBounds(0, 0, 0, 0);
        this.setBackground(new Color(150,130,50));


        this.add(nameTextField);
        this.add(websiteTextField);
        this.add(passwordTextField);
        this.add(saveButton);

        formatSetup();
    }

    private void formatSetup()
    {
        Style.giveButtonStyle(saveButton);

        Style.giveTextAreaStyle(websiteTextField);
        Style.giveTextAreaStyle(nameTextField);
        Style.giveTextAreaStyle(passwordTextField);

        saveButton.addActionListener(e ->
        {
            try
            {
                Store.storePassword(websiteTextField.getText(), nameTextField.getText(), passwordTextField.getText());
                JOptionPane.showMessageDialog(null, "Saved Password");
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "error occurred");
            }
        });
    }
}
