import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.awt.Window;
public class taskbar {
    void create(){

    }
    void update(){

    }
    static void get(){
        try {
            String line;
            // this one is for linuxProcess p = Runtime.getRuntime().exec("ps -e");
            Process p = Runtime.getRuntime().exec
                    (System.getenv("windir") +"\\system32\\"+"tasklist.exe");
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((line = input.readLine()) != null) {
                System.out.println(line); //<-- Parse data here.
            }
            input.close();
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
    void end(){

    }
    void bar(){

    }
    public static void main(String Args[]){
        get();
        Window [] ownerlessWindows = Window.getOwnerlessWindows ();
        for (Window window: ownerlessWindows){
            System.out.println (window.getName ()+": "+window.getClass ());
}
    }


}
