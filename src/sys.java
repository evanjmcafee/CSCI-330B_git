public class sys {

    static String username;
    public static int osState=1;
    enum shutdown {dont, normal, error, eject}

    public static class user {
        String Name;
        String Password;
        String Background;
        boolean loggedIn;

        class window extends task{

        }
        class task extends process{

        }
        class process{

        }
        class metadata{
            String name;
            String icon;
            String title;
            String ttip;
        }
        static void destroyAll(){

        }
    }
    public static void sw(){
        username = Login.YOU;

        System.exit(0);
        System.out.println("swtch");
    }
    void breaker(){

    }
    public void logoff(){

        user.destroyAll();
        sw();
    }
    private static void normal(){

    }
    private static void BSOD(){
        String errNum = "0";
        BSOD.createBSOD(errNum);
    }
    private static void eject() {

    }
    private static void end()
    {
        shutdown shutdown = sys.shutdown.dont;
        if (shutdown == sys.shutdown.normal){
            normal();
            //roger roger shutdown normally
        }
        if (shutdown== sys.shutdown.error){
            BSOD();

        }
        if (shutdown== sys.shutdown.eject){
            eject();

        }

    }
    private static void alpha() {
        int osState=1;

            if(osState == 1){
                Login Login = new Login();
                Login.logScreen();
                while(osState==1){


                }
            }

        if(osState == 2){
            username = Login.YOU;
            Desktop Desktop = new Desktop();
            Desktop.create();
            Login.destroy();
            while(osState==2){
                System.out.println("destroy");
            }
        }

            }


    public static void main(String[] args) {

        while(true){
            alpha();
        }

    }


}