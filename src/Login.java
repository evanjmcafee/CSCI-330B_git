import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

public class Login {
    static void destroy(){
        splash.dispose();

        System.out.println("destroy");
    }
    static String YOU;
    Image img = Toolkit.getDefaultToolkit().getImage("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\Splash.jpg");
    static JFrame splash = new JFrame();

    static ArrayList<String> Profiles;
    public static class PasswordDemo extends JPanel
            implements ActionListener {
        private static String OK = "ok";
        private static String Exit = "Exit";

        private JFrame controllingFrame;
        private JPasswordField passwordField;
        static JComboBox Userfiles;
        public PasswordDemo(JFrame f) {
            controllingFrame = f;

            Panel overPane = new Panel();
            overPane.setLayout(new BoxLayout(overPane, BoxLayout.X_AXIS));
            passwordField = new JPasswordField(10);
            passwordField.setActionCommand(OK);

            passwordField.addActionListener(this);
            String maindirpath
                    = "C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\users";

            File maindir = new File(maindirpath);

            if (maindir.exists() && maindir.isDirectory()) {


                File arr[] = maindir.listFiles();

                System.out.println(
                        "**********************************************");
                System.out.println(
                        "Files from main directory : " + maindir);
                System.out.println(
                        "**********************************************");



            }


            Userfiles = new JComboBox(maindir.list());

            Userfiles.setBounds(100,100,100,100);
            JLabel label = new JLabel("Sign In");
            label.setLabelFor(passwordField);

            JComponent buttonPane = createButtonPanel();

            JPanel combo = new JPanel();
            JPanel textPane = new JPanel();
            combo.add(Userfiles);

            textPane.add(label);
            textPane.add(passwordField);
            overPane.add(combo);
            overPane.add(textPane);
            add(combo);
            add(textPane);
            add(buttonPane);
        }

        protected JComponent createButtonPanel() {
            JPanel p = new JPanel(new GridLayout(0,1));
            JButton okButton = new JButton("OK");
            JButton ExitButton = new JButton("Help");

            okButton.setActionCommand(OK);
            ExitButton.setActionCommand(Exit);
            okButton.addActionListener(this);
            ExitButton.addActionListener(this);

            p.add(okButton);


            return p;
        }

        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();

            if (OK.equals(cmd)) {
                char[] input = passwordField.getPassword();
                if (isPasswordCorrect(input)) {
                    soundboard.sound("Spagetti.wav");
                    Desktop desktop = new Desktop();
                    Desktop.create();

                } else {

                    soundboard.sound("NO.wav");
                    JOptionPane.showMessageDialog(controllingFrame,
                            "Your password is incorrect",
                            "Incorrect password",
                            JOptionPane.ERROR_MESSAGE);
                }
                Arrays.fill(input, '0');

                passwordField.selectAll();
                resetFocus();
            } else {
                controllingFrame.dispose();
            }
        }



        String YOURNAME;


        void RecursivePrint(File[] arr, int index, int level)
        {
            if (index == arr.length)
                return;
            for (int i = 0; i < level; i++)
                System.out.print("\t");
            if (arr[index].isDirectory()) {
                String YOURNAME=arr[index].getName();
                System.out.println(arr[index].getName());
                Profiles.add(YOURNAME);
            }

            RecursivePrint(arr, ++index, level);
        }
        public class GFG {
            private static String method(String file_path) {

                String str = "";
                try {
                    str = new String(
                            Files.readAllBytes(Paths.get(file_path)));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                return str;
            }

        }
        private static String method(String file_path)
        {

            String str = "";

            try {

                str = new String(
                        Files.readAllBytes(Paths.get(file_path)));
            }

            catch (IOException e) {

                e.printStackTrace();
            }

            return str;
        }
        public static boolean isPasswordCorrect(char[] input) {
            boolean isCorrect = true;
            YOU = PasswordDemo.Userfiles.getSelectedItem().toString();
            String PWD="C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\users\\"+YOU+"\\PWD.txt";
            String ptc=method(PWD);
            System.out.println(PWD);
            char[] correctPassword = ptc.toCharArray();


            if (input.length != correctPassword.length) {
                isCorrect = false;
            } else {
                isCorrect = Arrays.equals (input, correctPassword);
            }

            Arrays.fill(correctPassword,'0');

            return isCorrect;
        }

        protected void resetFocus() {
            passwordField.requestFocusInWindow();
        }


        private static void createAndShowGUI() {
            //Create and set up the window.
            JFrame frame = new JFrame("Password");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            final PasswordDemo newContentPane = new PasswordDemo(frame);
            newContentPane.setOpaque(true);
            frame.setContentPane(newContentPane);

            frame.addWindowListener(new WindowAdapter() {
                public void windowActivated(WindowEvent e) {
                    newContentPane.resetFocus();
                }
            });
            frame.setLocationRelativeTo(null);
            frame.pack();
            frame.setVisible(true);
        }}

    public void logScreen(){
        splash.setExtendedState(JFrame.MAXIMIZED_BOTH);
        splash.setUndecorated(true);
        splash.getContentPane().setBackground(Color.BLUE);
        splash.setVisible(true);
        Panel BG = new Panel();
        PWD();

    }

    void PWD(){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                PasswordDemo.createAndShowGUI();}
        });
    }
    public static void main(String[] args){
        System.out.println("So lemme ask you, what are you doing here? why are you in here? your not supposed to be here");

    }
}
