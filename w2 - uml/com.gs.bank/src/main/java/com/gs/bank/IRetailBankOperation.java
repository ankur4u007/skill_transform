package com.gs.bank;

import com.gs.bank.customer.ICustomer;

public interface IRetailBankOperation {

    void depositFund(ICustomer customer, String accountNo, int amount);

    void createAccount(ICustomer customer);

    void removeAccount(ICustomer customer);

    void querryStatement(ICustomer customer, String accountNo);

    void withdrawFund(ICustomer customer, String accountNo, int amount);

}
