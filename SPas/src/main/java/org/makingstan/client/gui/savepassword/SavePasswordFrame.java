package org.makingstan.client.gui.savepassword;

import org.makingstan.client.Client;
import org.makingstan.client.gui.managergui.ManagerPanel;

import javax.swing.*;
import java.awt.*;

public class SavePasswordFrame extends JFrame {


    public SavePasswordFrame()
    {
        Client.getCurrentManagerInformation();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new SavePasswordPanel());
        this.setSize(new Dimension(600, 400));
        this.setResizable(true);

        this.setVisible(true);
    }
}
