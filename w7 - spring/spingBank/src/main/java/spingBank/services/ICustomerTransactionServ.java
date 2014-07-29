/**
 *
 */
package spingBank.services;

import spingBank.bo.customerBOs.AbstractCustomerBO;

/**
 * @author CHANDRAYAN
 *
 */
public interface ICustomerTransactionServ {

    void depositFund(AbstractCustomerBO customer, String accountNo, int amount);

    void withdrawFund(AbstractCustomerBO customer, String accountNo, int amount);
}
