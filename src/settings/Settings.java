package settings;

import javax.swing.*;
import java.awt.*;

public class Settings extends JPanel {


    public Settings() {
        //construct components
        JTextField searchable = new JTextField(30);
        JPanel P1 = new JPanel();
        JPanel P2 = new JPanel();
        JButton personalization = new JButton ("Personalization");
        JButton networking = new JButton ("Networking");
        JButton users = new JButton ("Users");
        JButton power = new JButton ("Power");
        JButton hardware = new JButton ("Hardware");
        JButton tl = new JButton ("Time & Language");
        JButton privacy = new JButton ("Privacy");
        JButton update = new JButton ("Updates");
        JButton access = new JButton ("Accessibility");
        JButton password = new JButton ("Password");
        JButton app = new JButton ("Apps");
        personalization.setToolTipText ("Change the appearance and behavior of your environment");
        networking.setToolTipText ("Manage Network settings, bluetooth.");
        users.setToolTipText ("add or remove user accounts.");
        power.setToolTipText ("Power options");
        hardware.setToolTipText ("add or remove hardware devices");
        tl.setToolTipText ("Change the time or language of the interface");
        privacy.setToolTipText ("Location services, Camera access, etc");
        update.setToolTipText ("check for updates");
        access.setToolTipText ("Settings for the impaired. Font is also here.");
        password.setToolTipText ("Change your password");
        app.setToolTipText ("Review Software on this computer that you installed.");
        BoxLayout box = new BoxLayout(this,BoxLayout.Y_AXIS);
        setLayout(box);
        //adjust size and set layout
        setPreferredSize (new Dimension (944, 563));
        GridLayout layout = new GridLayout(4, 3, 32, 32);
        P2.setLayout (layout);
        //add components
        add (P1);
        P1.add(searchable);
        add (P2);
        //P1.add components
        P2.add (personalization);
        P2.add (networking);
        P2.add (users);
        P2.add (power);
        P2.add (hardware);
        P2.add (tl);
        P2.add (privacy);
        P2.add (update);
        P2.add (access);
        P2.add (password);
        P2.add (app);

    }
void Open(){
    JFrame frame = new JFrame ("MyPanel");
    frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add (new Settings());
    frame.pack();
    frame.setVisible (true);
}
void error(){

}
    public static void main (String[] args) {

    }
}
