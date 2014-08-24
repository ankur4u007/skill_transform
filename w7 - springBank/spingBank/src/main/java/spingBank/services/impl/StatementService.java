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
     * spingBank.services.IStatementServ#querryStatementForSpecifiPeriod(spingBank
     * .bo.customerBOs .AbstractCustomerBO, java.lang.String, java.util.Date,
     * java.util.Date)
     */
    public void querryStatementForSpecifiPeriod(final AbstractCustomerBO customer, final String accountNo,
	    final Date fromDate, final Date toDate) {
	if (customer.isPrivileged()) {
	    loger.info(" Account Statement query performed for Customer : " + customer.getName() + " for Account : "
		    + accountNo + " from Date : " + fromDate + " to Date : " + toDate);
	} else {
	    loger.info("Customer : " + customer.getName() + " is not a privilged customer");
	}

    }

    /*
     * (non-Javadoc)
     *
     * @see
     * spingBank.services.IStatementServ#querryStatementForMonth(spingBank.bo
     * .customerBOs .AbstractCustomerBO, java.lang.String,java.lang.String)
     */
    public void querryStatementForMonth(final AbstractCustomerBO customer, final String accountNo, final String month) {
	loger.info(" Account Statement query performed for Customer : " + customer.getName() + " for Account : "
		+ accountNo + " for Month : " + month);

    }
}