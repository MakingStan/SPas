package org.makingstan.client.gui.managergui;

import org.makingstan.client.Client;
import org.makingstan.client.gui.generatepasswordgui.GeneratePasswordPanel;

import javax.swing.*;
import java.awt.*;

public class ManagerFrame extends JFrame {

    public ManagerFrame()
    {
        Client.getCurrentManagerInformation();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new ManagerPanel());
        this.setSize(new Dimension(1000, 700));
        this.setResizable(true);

        this.setVisible(true);
    }
}
