package project3;

public class Test extends Thread
{
    public static void JustPrint()
    {
        System.out.print("Just Test");
    }

    public void run()
    {
        Thread T1 = new Thread();
        T1.start();

    }
}
