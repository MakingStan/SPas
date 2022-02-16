/*
MakingStan
10 feb 2022
 */
package org.makingstan.client.gui.generatepasswordgui;

import org.makingstan.client.gui.Style;
import org.makingstan.functionality.generating.Generate;
import org.makingstan.functionality.storing.Store;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GeneratePasswordPanel extends JPanel {

    JButton generateButton = new JButton("Generate");
    JButton saveButton = new JButton("Save");

    JTextArea randomPasswordTextArea = new JTextArea("Password will come here when generated");
    JTextArea websiteUrlTextArea = new JTextArea("website");
    JTextArea nameTextArea = new JTextArea("name");

    JCheckBox isCapsCheckBox = new JCheckBox("Caps");
    JCheckBox isSpecialCharacters = new JCheckBox("Special Chars");
    JCheckBox isNumbers = new JCheckBox("numbers");
    JSpinner lengthSpinner = new JSpinner();

    public GeneratePasswordPanel()
    {
        lengthSpinner.setValue(12);
        this.setBounds(0, 0, 700, 800);
        this.setBackground(new Color(150,130,50));

        formatPanel();

        this.add(randomPasswordTextArea);
        this.add(generateButton);

        this.add(isCapsCheckBox);
        this.add(isSpecialCharacters);
        this.add(isNumbers);
        this.add(lengthSpinner);
        this.add(Box.createVerticalStrut(30));

        this.add(Box.createHorizontalStrut(200));
        this.add(saveButton);
        this.add(websiteUrlTextArea);
        this.add(nameTextArea);
        this.add(Box.createVerticalStrut(200));
    }

    private void formatPanel()
    {
        randomPasswordTextArea.setPreferredSize(new Dimension(450, 30));
        randomPasswordTextArea.setFont(new Font("Tahoma", Font.BOLD, 19));

        isCapsCheckBox.setSelected(true);
        isSpecialCharacters.setSelected(true);
        isNumbers.setSelected(true);


        saveButton.setBounds(300, 300, 0, 0);
        Style.giveButtonStyle(generateButton);
        Style.giveButtonStyle(saveButton);

        Style.giveTextAreaStyle(websiteUrlTextArea);
        Style.giveTextAreaStyle(nameTextArea);

        generateButton.addActionListener(e-> {

            String randomPassword = Generate.generateNewPassword(isSpecialCharacters.isSelected(), isNumbers.isSelected(), isCapsCheckBox.isSelected(), (int)lengthSpinner.getValue());

            randomPasswordTextArea.setText(randomPassword);
        });

        saveButton.addActionListener(e-> {
            try {
                Store.storePassword(websiteUrlTextArea.getText(), nameTextArea.getText(), randomPasswordTextArea.getText());
                JOptionPane.showMessageDialog(null, "Saved Password");
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Some error occurred");
            }

        });
    }
}




