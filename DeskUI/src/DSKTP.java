import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
class FileRenderer extends DefaultListCellRenderer {
    public ArrayList T = new ArrayList();
    private boolean pad;
    private Border padBorder = new EmptyBorder(3,3,3,3);
    private ComponentListener DSKTPListener;

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
                list, value, index, isSelected, cellHasFocus);

        JLabel l = (JLabel) c;
        l.setHorizontalTextPosition(JLabel.CENTER);
        l.setVerticalTextPosition(JLabel.BOTTOM);
        File f = (File) value;
        l.setText(f.getName());

        l.setIcon(FileSystemView.getFileSystemView().getSystemIcon(f,48,48));





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
        fileList.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                System.out.println("CLICK");
                JList list = (JList)evt.getSource();
                if (evt.getClickCount() == 2) {
                    File opnr = new File(list.getSelectedValue().toString());
                    try {
                        Desktop.getDesktop().open(opnr);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }


                }
            }
        });
        // ..then use a renderer
        fileList.setCellRenderer(new FileRenderer(!vertical));

        if (!vertical) {
            fileList.setLayoutOrientation(JList.VERTICAL_WRAP);
            Long rowcounterh = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/128);
            int rowsh = rowcounterh.intValue();
            fileList.setVisibleRowCount(rowsh);

        } else {
            Long rowcounterw = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/128);
            int rowsw = rowcounterw.intValue();
            fileList.setVisibleRowCount(rowsw);
        }
        return new JScrollPane(fileList);
    }


}


public class

DSKTP extends JPanel {

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
    class DSKTPIcon extends JPanel{
        Icon DSKTPIcon;
        String Name;
        Point iconLocation;
        boolean highlight;
        File fileLocation;
        public DSKTPIcon(Component component) {


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
    double iconH = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getHeight()/128);
    double iconW = Math.round(Toolkit.getDefaultToolkit().getScreenSize().getWidth()/128);
    int x;
    int y;

    String path = "\\home\\"+System.getProperty("user.name")+"\\Desktop";
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




    public DSKTP(){
        /*class SimpleDigitalClock extends JPanel {
            String stringTime;
            int hour, minute, second;
            String aHour = "";
            String bMinute = "";
            String cSecond = "";
            String cs ="";
            public void setStringTime(String abc) {
                this.stringTime = abc;
            }
            public int Number(int a, int b) {
                return (a <= b) ? a : b;
            }
            SimpleDigitalClock() {
                Timer t = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                });
                t.start();
            }
            @Override
            public void paintComponent(Graphics v) {
                super.paintComponent(v);
                Calendar rite = Calendar.getInstance();
                hour = rite.get(Calendar.HOUR);
                minute = rite.get(Calendar.MINUTE);
                second = rite.get(Calendar.SECOND);
                int PMAM = rite.get(Calendar.AM_PM);
                if (hour < 10) {
                    this.aHour = "0";
                }
                if (hour >= 10) {
                    this.aHour = "";
                }
                if (minute < 10) {
                    this.bMinute = "0";
                }
                if (minute >= 10) {
                    this.bMinute = "";
                }
                if (second < 10) {
                    this.cSecond = "0";
                }
                if (second >= 10) {
                    this.cSecond = "";
                }
                if (PMAM==1){
                    this.cs = "PM";
                }
                if (PMAM==0){
                    this.cs = "AM";
                }
                setStringTime(aHour + hour + ":" + bMinute + minute + " " +cs);
                v.setColor(Color.BLACK);
                int length = Number(this.getWidth(), this.getHeight());
                Font Font1 = new Font("SansSerif", Font.PLAIN, 10);
                v.setFont(Font1);
                v.drawString(stringTime, (int) length / 6, length / 2);
            }

        }
        class scalxtends JPanel {
            String stringTime;

            int v;

            int hour, minute, second;
            String aHour = "";
            String bMinute = "";
            String cSecond = "";
            String cs ="";
            public void setStringTime(String abc) {
                this.stringTime = abc;
            }
            public int Number(int a, int b) {
                return (a <= b) ? a : b;
            }
            scalndr() {
                Timer t = new Timer(1000, new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        repaint();
                    }
                });
                t.start();
            }
            @Override
            public void paintComponent(Graphics v) {
                super.paintComponent(v);
                Calendar rite = Calendar.getInstance();
                hour = rite.get((Calendar.MONTH));
                minute = rite.get(Calendar.DAY_OF_MONTH);
                second = rite.get(Calendar.YEAR);
                int PMAM = rite.get(Calendar.AM_PM);
                if (hour < 10) {
                    this.aHour = "0";
                }
                if (hour >= 10) {
                    this.aHour = "";
                }
                if (minute < 10) {
                    this.bMinute = "0";
                }
                if (minute >= 10) {
                    this.bMinute = "";
                }
                if (second < 10) {
                    this.cSecond = "0";
                }
                if (second >= 10) {
                    this.cSecond = "";
                }

                setStringTime(hour+1 + "/" + bMinute + minute + "/" + second);
                v.setColor(Color.BLACK);
                int length = Number(this.getWidth(), this.getHeight());
                Font Font1 = new Font("SansSerif", Font.PLAIN, 10);
                v.setFont(Font1);
                v.drawString(stringTime, (int) length / 6, length / 2);
            }

        }

        SimpleDigitalClock clock1 = new SimpleDigitalClock();

        scalndr sc = new scalndr();

         */
        File f = new File("\\home\\"+System.getProperty("user.name")+"\\Desktop");
        FileList fl = new FileList();

        JPanel DC = new JPanel();
        DC.setPreferredSize(new Dimension(100,48));

        Explorer DESK= new Explorer(path);
        ImageIcon Menubutton = new ImageIcon("src\\menuIcon.png");
        ImageIcon volumeIcon = new ImageIcon("src\\Vol3.png");
        // elsewhere
        //construct components
        JButton VOL = new JButton();
        VOL.setIcon(volumeIcon);
/*
        URI.addURIChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent event) {
                int value = volume.getValue();
                if (value == 0) {
                    VOL.setIcon(vol0);
                } else if (value > 0 && value <= 50) {
                    VOL.setIcon(vol1);
                } else if (value > 50 && value < 80) {
                    VOL.setIcon(vol2);
                } else {
                    VOL.setIcon(vol3);

                }
            }
        });

 */
        JButton BAT= new JButton();
        JPanel TD = new JPanel();
        JLabel DATETIME = new JLabel();
        JButton net = new JButton();
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
        //BoxLayout box = new BoxLayout(DATETIME,BoxLayout.Y_AXIS);
        setLayout (layout);
        FlowLayout tbFlow=new FlowLayout();
        tbFlow.setHgap(0);
        tbFlow.setVgap(0);
        TB.setLayout(tbFlow);
        tray.setLayout(tbFlow);

        taskbar.setLayout(tbFlow);


        //add components
        // GridLayout desktopLayout = new GridLayout(w/128,h/128);
        BorderLayout bddt = new BorderLayout();
        bddt.setHgap(0);
        bddt.setVgap(0);
        add(DT,BorderLayout.CENTER);
        DESK.setPreferredSize(Desk);
        BoxLayout boxy = new BoxLayout(DC,BoxLayout.Y_AXIS);
        DC.setLayout(boxy);

        //f = new File(System.getProperty("user.home"));
        Component c2 = fl.getGui(f.listFiles(new TextFileFilter()),false);
        //Component c4 = t.tskr(t, false);
        JPanel gui = new JPanel(new BorderLayout());

        c2.setPreferredSize(Desk);
        gui.setBorder(new EmptyBorder(3,3,3,3));

        DT.add(c2,BorderLayout.CENTER);
        // add(TB,BorderLayout.SOUTH);
        // TB.add(menu,FlowLayout.LEFT);
        // TB.add(taskbar);
        // taskbar.add(tasks);
        //tasks.add(c4);
        // TB.add(tray);
        // tray.add(net);
        // tray.add(VOL);
        // tray.add(BAT);
        //tray.add(DC);
        // DC.add(clock1);
        //  DC.add(sc);

    }


    public static void main(String Args[]) {
        String Username = System.getProperty("user.name");
        System.out.println("Im on desktop "+Username);
        JFrame frame = new JFrame ("MyPanel");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.getContentPane().add (new DSKTP());
        frame.pack();
        frame.setVisible (true);
    }


}