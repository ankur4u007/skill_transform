/**
 *
 */
package spingBank.services;

import java.util.Date;

import spingBank.bo.customerBOs.AbstractCustomerBO;

/**
 * @author CHANDRAYAN
 *
 */
public interface IStatementServ {

    void querryStatementForSpecifiPeriod(AbstractCustomerBO customer, String accountNo, Date fromDate, Date toDate);

    void querryStatementForMonth(AbstractCustomerBO customer, String accountNo, String month);

}
