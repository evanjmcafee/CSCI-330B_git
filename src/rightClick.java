//Generated by GuiGenie - Copyright (c) 2004 Mario Awad.
//Home Page http://guigenie.cjb.net - Check often for new versions!

import javax.swing.*;
import java.awt.*;

public class rightClick extends JPanel {
    String BTN;
    public rightClick() {
        //construct components
        JButton open = new JButton ("Open");
        open.setEnabled(false);
        JButton openW = new JButton ("Open With");
        openW.setEnabled(false);
        JButton cut = new JButton ("Cut");
        cut.setEnabled(false);
        JButton copy = new JButton ("Copy");
        copy.setEnabled(false);
        JButton paste = new JButton ("Paste");
        JButton shortcut = new JButton ("Create shortcut");
        JButton delete = new JButton ("Delete");
        delete.setEnabled(false);
        JButton rename = new JButton ("Rename");
        rename.setEnabled(false);
        JButton newFile = new JButton ("New");
        JButton properties = new JButton ("Properties");
        JLabel line = new JLabel("--------");
        JLabel line2 = new JLabel("--------");
        JLabel line3 = new JLabel("--------");
        //adjust size and set layout
        setPreferredSize (new Dimension (150, 200));
        GridLayout layout = new GridLayout(13, 1, 0, 0);
        setLayout (layout);
        open.setHorizontalAlignment(SwingConstants.LEFT);
        openW.setHorizontalAlignment(SwingConstants.LEFT);
        cut.setHorizontalAlignment(SwingConstants.LEFT);
        copy.setHorizontalAlignment(SwingConstants.LEFT);
        paste.setHorizontalAlignment(SwingConstants.LEFT);
        shortcut.setHorizontalAlignment(SwingConstants.LEFT);
        delete.setHorizontalAlignment(SwingConstants.LEFT);
        rename.setHorizontalAlignment(SwingConstants.LEFT);
        newFile.setHorizontalAlignment(SwingConstants.LEFT);
        properties.setHorizontalAlignment(SwingConstants.LEFT);
        line.setPreferredSize(new Dimension(100,64));

        //add components
        add (open);
        add (openW);
        add (line);
        add (cut);
        add (copy);
        add (paste);
        add (delete);
        add (rename);
        add (newFile);
        add (line2);
        add (shortcut);
        add (line3);
        add (properties);
    }

    public static void main (String[] args) {
        JFrame frame = new JFrame ("MyPanel");
        frame.getContentPane().add (new rightClick());
        frame.pack();
        frame.setVisible (true);
    }

}
