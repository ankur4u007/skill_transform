/**
 *
 */
package spingBank;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.bo.employeeBOs.AbstractEmployeeBO;
import spingBank.bo.employeeBOs.Employee1BO;
import spingBank.factory.customerFactory.ICustomerFactory;
import spingBank.factory.employeeFactory.IEmployeeFactory;
import spingBank.services.ICustomerTransactionServ;
import spingBank.services.IStatementServ;

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
	final ICustomerTransactionServ tranService = (ICustomerTransactionServ) context
		.getBean("customerTransactionService");
	final IStatementServ statementServ = (IStatementServ) context.getBean("statementService");
	final IEmployeeFactory empFactory = (IEmployeeFactory) context.getBean("employeeFactory");
	final List<AbstractEmployeeBO> empList = empFactory.getEmployeeList();
	if (empList != null) {
	    for (final AbstractEmployeeBO empBO : empList) {
		if (empBO instanceof Employee1BO) {
		    final List<AbstractCustomerBO> boList = ((Employee1BO) empBO).getCustomers();
		    if (boList != null) {
			final AbstractCustomerBO bo = boList.get(0);
			tranService.depositFund(bo, bo.getAccountNumber().get(0), 88);
			tranService.withdrawFund(bo, bo.getAccountNumber().get(0), 22);
			for (final AbstractCustomerBO customerBo : boList) {
			    for (final String account : customerBo.getAccountNumber()) {
				statementServ.querryStatement(customerBo, account, new Date(), new Date());
			    }
			}
		    }
		}
	    }
	}
	final ICustomerFactory customerFactory = (ICustomerFactory) context.getBean("customerFactory");
	final List<AbstractCustomerBO> boList = customerFactory.getCustomerList();
	if (boList != null) {
	    final AbstractCustomerBO bo = boList.get(0);
	    tranService.depositFund(bo, bo.getAccountNumber().get(0), 88);
	    tranService.withdrawFund(bo, bo.getAccountNumber().get(0), 22);
	    for (final AbstractCustomerBO customerBo : boList) {
		for (final String account : customerBo.getAccountNumber()) {
		    statementServ.querryStatement(customerBo, account, new Date(), new Date());
		}
	    }
	}
    }
}
