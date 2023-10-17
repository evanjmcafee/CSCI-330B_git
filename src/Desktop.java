import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileFilter;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class FileRenderer extends DefaultListCellRenderer {

    private boolean pad;
    private Border padBorder = new EmptyBorder(3,3,3,3);

    FileRenderer(boolean pad) {
        this.pad = pad;
    }

    @Override
    public Component getListCellRendererComponent(
            JList list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {

        Component c = super.getListCellRendererComponent(
                list,value,index,isSelected,cellHasFocus);
        JLabel l = (JLabel)c;
        File f = (File)value;
        l.setText(f.getName());
        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f));
        addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if(e.getClickCount()==2){
                    System.out.println();
                }
            }
        });
        if (pad) {
            l.setBorder(padBorder);
        }

        return l;
    }
}
class TextFileFilter implements FileFilter {

    public boolean accept(File file) {
        // implement the logic to select files here..
        String name = file.getName().toLowerCase();
        //return name.endsWith(".java") || name.endsWith(".class");
        return name.length()<20;
    }
}
class FileList {

    public Component getGui(File[] all, boolean vertical) {
        // put File objects in the list..
        JList fileList = new JList(all);
        // ..then use a renderer
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(JList.VERTICAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        return new JScrollPane(fileList);
    }


}
public class Desktop extends JPanel {

    public Component getGui(File[] all, boolean vertical) {
        // put File objects in the list..
        JList fileList = new JList(all);
        // ..then use a renderer
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(javax.swing.JList.HORIZONTAL_WRAP);
            fileList.setVisibleRowCount(-1);
        } else {
            fileList.setVisibleRowCount(9);
        }
        return new JScrollPane(fileList);
    }
    Point initialMouseLocation;

    Point initialComponentLocation;
    class desktopIcon extends JPanel{
        Icon desktopIcon;
        String Name;
        Point iconLocation;
        boolean highlight;
        File fileLocation;
        public desktopIcon(Component component) {


            component.addMouseListener(new MouseAdapter() {
                public void mousePressed(MouseEvent e) {
                    initialMouseLocation = e.getLocationOnScreen();
                    initialComponentLocation = component.getLocation();
                }
            });

            component.addMouseMotionListener(new MouseAdapter() {
                public void mouseDragged(MouseEvent e) {
                    Point finalMouseLocation = e.getLocationOnScreen();
                    int deltaX = finalMouseLocation.x - initialMouseLocation.x;
                    int deltaY = finalMouseLocation.y - initialMouseLocation.y;
                    Point newLocation = new Point(initialComponentLocation.x + deltaX, initialComponentLocation.y + deltaY);
                    component.setLocation(newLocation);
                }
            });
        }
    }
    boolean highLighted;
    int screenren=(int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();

    Dimension tasksize = new Dimension(screenren-128,48);
    Dimension tightFit = new Dimension(256,48);
    Dimension barAdd = new Dimension(screenren-384,48);
    Dimension menuSize = new Dimension(128,48);
    double h = Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    double w = Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    int wid= (int)w;
    int high= (int)h;
    int toolHeight = 48;
    Dimension tools = new Dimension(wid, toolHeight);
    Dimension Desk = new Dimension(wid, high-48);
    double iconH = Math.round(h/128);
    double iconW = Math.round(w/128);
    int x;
    int y;

    String path = "C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\users\\"+Login.YOU+"\\desktop";
    class Explorer extends JPanel implements ActionListener {
        void refresh(){
            
        }
        Explorer (String path){

        }
        @Override
        public void actionPerformed(ActionEvent e) {

            refresh();
        }

        public void mouseClicked(MouseEvent mouseEvent) {

            }
        }


    public Desktop(){
        File f = new File("C:\\Users\\EvanJMcAfee\\Desktop\\OS\\Stage 2\\OS\\src\\users\\"+Login.YOU+"\\desktop");
        FileList fl = new FileList();
        Explorer DESK= new Explorer(path);
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


        taskbar.setPreferredSize(barAdd);
        menu.setPreferredSize(menuSize);
        tasks.setPreferredSize(tasksize);
        tray.setPreferredSize(tightFit);


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
       // GridLayout desktopLayout = new GridLayout(w/128,h/128);
        BorderLayout bddt = new BorderLayout();
        bddt.setHgap(0);
        bddt.setVgap(0);
        add(DT,BorderLayout.CENTER);
        DESK.setPreferredSize(Desk);



        //f = new File(System.getProperty("user.home"));
        Component c2 = fl.getGui(f.listFiles(new TextFileFilter()),false);

        JFrame frame = new JFrame("File List");
        JPanel gui = new JPanel(new BorderLayout());

        c2.setPreferredSize(Desk);
        gui.setBorder(new EmptyBorder(3,3,3,3));

        DT.add(c2,BorderLayout.CENTER);
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
        frame.setDefaultCloseOperation (EXIT_ON_CLOSE);
        frame.getContentPane().add (new Desktop());
        frame.pack();
        frame.setVisible (true);
    }
}