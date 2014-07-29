/**
 *
 */
package spingBank.services.impl;

import java.util.Date;

import org.springframework.stereotype.Component;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.services.AbstractService;
import spingBank.services.IStatementServ;

/**
 * @author CHANDRAYAN
 *
 */
@Component("statementService")
public class StatementService extends AbstractService implements IStatementServ {

    /*
     * (non-Javadoc)
     * 
     * @see
     * spingBank.services.IStatementServ#querryStatement(spingBank.bo.customerBOs
     * .AbstractCustomerBO, java.lang.String, java.util.Date, java.util.Date)
     */
    public void querryStatement(final AbstractCustomerBO customer, final String accountNo, final Date fromDate,
	    final Date toDate) {
	if (customer.isPrivileged()) {
	    loger.info(" Account Statement query performed for Customer : " + customer.getName() + " for Account : "
		    + accountNo + " from Date : " + fromDate + " to Date : " + toDate);
	} else {
	    loger.info("Customer : " + customer.getName() + " is not a privilged customer");
	}

    }
}
