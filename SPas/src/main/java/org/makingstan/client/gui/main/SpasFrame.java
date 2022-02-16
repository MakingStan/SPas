/*
MakingStan
10 feb 2022
 */
package org.makingstan.client.gui.main;

import org.makingstan.client.Client;
import org.makingstan.functionality.storing.Store;

import javax.swing.*;
import java.awt.*;

public class SpasFrame extends JFrame {

    public SpasFrame()
    {
        String masterPassword = JOptionPane.showInputDialog("Fill in your master password!");
        Store.masterPassword = masterPassword;
        Client.masterPassword = masterPassword;


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(new SpasPanel());
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(700, 800));


        this.setResizable(false);
        this.setVisible(true);


    }
}
