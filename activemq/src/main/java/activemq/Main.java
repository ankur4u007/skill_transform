/**
 *
 */
package activemq;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
	// nothing else needs to be done as the
	// message sending and receiving is being handled by the JMS
	// template so by just initialising the spring config we
	// are able to produce the message and consume it.
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring-context1.xml");
    }

}
