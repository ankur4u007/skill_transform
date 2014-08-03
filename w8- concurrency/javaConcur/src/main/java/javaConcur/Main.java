/**
 *
 */
package javaConcur;

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
	// TODO Auto-generated method stub
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	final InitTradingSystem system = (InitTradingSystem) context.getBean("initSytem");
	final ITrader trader = system.getTrader();
	trader.performTrading();
    }

}
