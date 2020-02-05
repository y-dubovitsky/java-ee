package ee.cdi.injection_point;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;


//TODO Не очень понял зачем это, простая обертка! Смысл мне получать injectionPoint тут в этом методе?
public class LoggerProducer {
    @Produces
    public Logger getLogger(InjectionPoint injectionPoint) {
        System.out.println(injectionPoint.getMember());
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getCanonicalName());
    }
}
