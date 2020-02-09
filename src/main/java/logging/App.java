package logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {

    public static void main( String[] args ) {
        Logger logger = LoggerFactory.getLogger("Example App");
        logger.info("'sup? I'm your info logger");
        logger.debug("hey HEY hey! I'm your debug logger");
    }

}
