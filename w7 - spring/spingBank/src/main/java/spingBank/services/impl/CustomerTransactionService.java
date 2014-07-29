package spingBank.services.impl;

import org.springframework.stereotype.Service;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.services.AbstractService;
import spingBank.services.ICustomerTransactionServ;

@Service("customerTransactionService")
public class CustomerTransactionService extends AbstractService implements ICustomerTransactionServ {

    public void depositFund(final AbstractCustomerBO customer, final String accountNo, final int amount) {
	loger.info("fund deposition performed for " + customer);

    }

    public void withdrawFund(final AbstractCustomerBO customer, final String accountNo, final int amount) {
	// TODO Auto-generated method stub
	loger.info("fund withdrwal performed for " + customer);
    }

}
