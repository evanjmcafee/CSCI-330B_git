import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Desktop extends JPanel {



    public Desktop() {
        ImageIcon Menubutton = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\menuIcon.png");
        ImageIcon volumeIcon = new ImageIcon("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\Vol3.png");


        // elsewhere
        //construct components
        JButton VOL = new JButton();
        VOL.setIcon(volumeIcon);
        JButton BAT= new JButton();
        JPanel TD = new JPanel();
        JPanel DT = new JPanel ();
        JPanel TB = new JPanel ();
        JButton menu = new JButton("menu");
        JPanel tasks = new JPanel();
        JPanel tray = new JPanel();
        JPanel taskbar = new JPanel();
        //adjust size and set layout
        menu.setIcon(Menubutton);
        Dimension menuSize = new Dimension(128,48);
        int screenren=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        Dimension tasksize = new Dimension(screenren-128,48);
        Dimension tightFit = new Dimension(256,48);
        Dimension barAdd = new Dimension(screenren-384,48);
        taskbar.setPreferredSize(barAdd);
        menu.setPreferredSize(menuSize);
        tasks.setPreferredSize(tasksize);
        tray.setPreferredSize(tightFit);
        double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int wid= (int)w;
        int high= (int)h;
        int toolHeight = 48;
        Dimension tools = new Dimension(wid, toolHeight);
        Dimension Desk = new Dimension(wid, high-toolHeight);
        TB.setPreferredSize(tools);
        DT.setPreferredSize(Desk);
        DT.setBackground(Color.RED);
        TB.setBackground(Color.BLUE);
        tray.setBackground(Color.GREEN);


        tasks.setBackground(Color.black);
        BorderLayout layout = new BorderLayout();
        setLayout (layout);
        FlowLayout tbFlow=new FlowLayout();
        tbFlow.setHgap(0);
        tbFlow.setVgap(0);
        TB.setLayout(tbFlow);
        tray.setLayout(tbFlow);
        taskbar.setLayout(tbFlow);
        menu.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menu Menu = new menu();
                Menu.open();
            }

        });
        VOL.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                volume Volbutton = new volume();
                Volbutton.vol();
            }

        });
        //add components

        add(DT,BorderLayout.CENTER);
        add(TB,BorderLayout.SOUTH);
        TB.add(menu,FlowLayout.LEFT);
        TB.add(taskbar);
        taskbar.add(tasks);
        TB.add(tray);
        tray.add(VOL);

    }


    public static void create() {
        String Username = Login.YOU;
        System.out.println("Im on desktop "+Username);
        JFrame frame = new JFrame ("MyPanel");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new Desktop());
        frame.pack();
        frame.setVisible (true);
    }
}