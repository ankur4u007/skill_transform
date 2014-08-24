package spingBank.logging;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component("loggerAspect")
public class LoggerAspect {

    private static final Logger logger = Logger.getLogger(LoggerAspect.class);

    @Before("execution(* spingBank.services.*.*(..))")
    public void transactionAdvice(final JoinPoint joinPoint) {
	logger.info("call to transaction service : " + joinPoint.getTarget().getClass().getName() + " on method : "
		+ joinPoint.getSignature().getName());
	final StringBuilder sb = new StringBuilder();
	for (final Object ob : joinPoint.getArgs()) {
	    sb.append(ob + " ; ");
	}
	logger.info("with args :" + sb);
    }
}
