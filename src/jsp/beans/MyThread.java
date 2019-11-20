package jsp.beans;

/**
 * This is not bean
 */
public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.print("MyThread");
    }
}
