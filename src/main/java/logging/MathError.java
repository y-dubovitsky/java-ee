package logging;


import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

public class MathError {

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(MathError.class);

    private int calculate(int i) {
        int result = 0;
        LOGGER.info("4Started method calculate with arg = " + i);
        try {
            result = 5/i;
        } catch (Exception e) {
            LOGGER.error("error " + e.getMessage());
        }
        return result;
    }

    public static void main(String[] args) {
        new MathError().calculate(0);
    }

}
