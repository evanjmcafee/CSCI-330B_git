using System;
using System.Windows;
using MerulaShellController.ManageWindows;
using System.Linq;

namespace DemoProject
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private ManageWindows windowManager;

        public MainWindow()
        {
            InitializeComponent();
            windowManager = new ManageWindows(); //create a new windowmanager / only one needed
            Closed += MainWindow_Closed; // on close event
            windowManager.WindowListChanged += WindowManagerWindowListChanged; //when the list of windows is changed
            LoadWindows(); //load the windows
        }

        private delegate void DelegateVoid();

        void WindowManagerWindowListChanged(object sender, EventArgs e)
        {
            //invoke beacause merula shell runs in another thread
            Dispatcher.Invoke(new DelegateVoid(LoadWindows));
        }

        void MainWindow_Closed(object sender, EventArgs e)
        {
            Environment.Exit(0); //stops the merula shell
        }


        private void LoadWindows()
        {
            ClearTasks();//delete old tasks
            var windows = windowManager.GetWindows();//windowManager.GetWindows() returns all the active windows
            foreach (var window in windows) 
            { //foreach window add a taskbar button
                var button = new TaskbarButton(window);
                button.Activated += ButtonActivated; //add a event to the taskbarbutton
                pnlTasks.Children.Add(button);
            }
        }

        void ButtonActivated(object sender, EventArgs e)
        {
            var senderButton = (TaskbarButton) sender; //the sender button
            var otherButtons = pnlTasks.Children.OfType<TaskbarButton>().Where(b => b != senderButton); //select the other buttons
            foreach (var otherButton in otherButtons)
            {
                otherButton.SetNonActive(); //sets the other buttons to nonactive
            }
        }

        private void ClearTasks() //delete old tasks
        {
            pnlTasks.Children.Clear();
        }
    }
}
