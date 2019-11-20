package jsp.beans;

/**
 * Этот бин нужен для показа того, как внедрять другой Бин!
 */
public class SmartBean {
    private Runnable runnable;

    public void start() {
        runnable.run();
    }

    public Runnable getRunnable() {
        return runnable;
    }

    public void setRunnable(Runnable runnable) {
        System.out.println("public class SmartBean {");
        this.runnable = runnable;
    }
}
