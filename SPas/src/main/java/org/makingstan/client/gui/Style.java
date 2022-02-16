/*
feb 13 2022
MakingStan
 */
package org.makingstan.client.gui;

import javax.swing.*;
import java.awt.*;

public class Style {

    public static void giveButtonStyle(JButton button)
    {
        button.setBackground(Color.decode("#5B84C4"));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setFont(new Font("Tahoma", Font.BOLD, 14));
        button.setOpaque(true);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
    }

    public static void giveTextAreaStyle(JTextArea area)
    {
        area.setPreferredSize(new Dimension(130, 20));
        area.setFont(new Font("Tahoma", Font.BOLD, 14));
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
    }

    public static Font getApplicationFont(int size)
    {
        return new Font("Tahoma", Font.BOLD, size);
    }
}
