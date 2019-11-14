package jsp.beans;

public class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.print("MyThread");
    }
}
