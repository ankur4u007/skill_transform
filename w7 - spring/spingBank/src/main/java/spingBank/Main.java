/**
 *
 */
package spingBank;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.factory.customerFactory.CustomerFactory;

/**
 * @author CHANDRAYAN
 *
 */
public class Main {

    /**
     * @param args
     */
    public static void main(final String[] args) {
	final ApplicationContext context = new ClassPathXmlApplicationContext("spring_config.xml");
	final CustomerFactory custFact = (CustomerFactory) context.getBean("customerFactory");
	final List<AbstractCustomerBO> boList = custFact.getCustomerList();
	for (final AbstractCustomerBO bo : boList) {
	    System.out.println(bo);
	}
    }
}
