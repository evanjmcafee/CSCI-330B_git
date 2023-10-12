import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.Arrays;
public class menu extends JPanel {


    public menu() {
        setBackground(Color.GRAY);
        ImageIcon USER = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\Person.png");
        ImageIcon SRCH = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\Glass.png");
        ImageIcon Sett = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\setting.png");
        ImageIcon s = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\Power.png");
        ImageIcon app = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\APP.png");
        ImageIcon file = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\file.png");
        //construct components
        JLabel jcomp0 = new JLabel(Login.YOU);
        jcomp0.setIcon(USER);
        JButton jcomp1 = new JButton("Apps           ");
        jcomp1.setIcon(app);
        JButton jcomp2 = new JButton("Files           ");
        jcomp2.setIcon(file);
        JButton jcomp3 = new JButton("Settings     ");
        jcomp3.setIcon(Sett);
        JButton jcomp4 = new JButton("Search       ");
        jcomp4.setIcon(SRCH);
        JButton jcomp5 = new JButton("Shutdown  ");
        jcomp5.setIcon(s);

        //adjust size and set layout
        jcomp0.setMinimumSize(new Dimension(1000,48));
        jcomp1.setMinimumSize(new Dimension(1000,48));
        jcomp2.setPreferredSize(new Dimension(1000,48));
        jcomp3.setPreferredSize(new Dimension(1000,48));
        jcomp4.setPreferredSize(new Dimension(100,48));
        jcomp5.setPreferredSize(new Dimension(1000,48));
        setPreferredSize (new Dimension (200, 336));
        BoxLayout layout = new BoxLayout (this, BoxLayout.Y_AXIS);
        setLayout (layout);
        for (JButton jLabel : Arrays.asList(jcomp1, jcomp2, jcomp3, jcomp4)) {
            jLabel.setOpaque(true);
            jLabel.setBackground(Color.white);
        }
        jcomp5.setOpaque(true);
        jcomp5.setBackground(Color.RED);
        jcomp0.setForeground(Color.black);

        //add components
        add(jcomp0);
        add (jcomp1);

        add (jcomp2);
        add (jcomp3);
        add (jcomp4);
        add (jcomp5);
        jcomp5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });
        jcomp4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });
        jcomp3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });
        jcomp2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });
        jcomp1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Yay you clicked me");
            }

        });


    }

    void open () {
        int LOCH=(int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        JFrame frame = new JFrame ("MyPanel");
        frame.setUndecorated(true);
        KeyboardFocusManager.getCurrentKeyboardFocusManager().
                addVetoableChangeListener( "focusedWindow",
                        new VetoableChangeListener() {
                            private boolean gained = false;

                            @Override
                            public void vetoableChange( PropertyChangeEvent evt ) throws PropertyVetoException {
                                if ( evt.getNewValue() == frame ) {
                                    gained = true;
                                }
                                if ( gained && evt.getNewValue() != frame ) {
                                    frame.dispose();
                                }
                            }
                        });
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new menu());
        frame.setLocation(0,LOCH-384 );
        frame.pack();
        frame.setVisible (true);
    }

    public static void main (String[] args) {
       System.out.println("gotta use it the other way bud.");
    }
}
