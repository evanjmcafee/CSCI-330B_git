public class BSOD {

public static void HALT(){

}
public static void ERROR(String i){
    System.out.print("Your computer has been shut down due to an error.");
    System.out.print("this error is of number:"+i);
    System.out.print("Please shut down your machine now.");
    System.out.print("I just shit my britches");
}
    public static void createBSOD(String errNum) {
        HALT();
        ERROR(errNum);
    }
}
