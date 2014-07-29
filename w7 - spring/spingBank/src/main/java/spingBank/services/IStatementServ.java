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

    void querryStatement(AbstractCustomerBO customer, String accountNo, Date fromDate, Date toDate);
}
