/*
MakingStan
10 feb 2022
 */

package org.makingstan.client.gui.generatepasswordgui;

import javax.swing.*;
import java.awt.*;

public class GeneratePasswordFrame extends JFrame {


    public GeneratePasswordFrame()
    {
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.add(new GeneratePasswordPanel());
        this.setLocationRelativeTo(null);
        this.setSize(new Dimension(600, 400));

        this.setResizable(false);
        this.setVisible(true);
    }
}
