/**
 *
 */
package com.gs.bank.customer.impl;

import java.util.List;

import com.gs.bank.customer.AbstractCustomer;
import com.gs.bank.customer.ICustomer;

/**
 * @author CHANDRAYAN
 *
 */
public class Customer2 extends AbstractCustomer implements ICustomer {

    private boolean hasLoanAccount;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     * @param hasLoanAccount
     */
    public Customer2(final String name, final String address, final List<String> accountNumber, final String otherInfo,
	    final boolean hasLoanAccount) {
	super(name, address, accountNumber, otherInfo);
	this.hasLoanAccount = hasLoanAccount;
    }

    /**
     * @return the hasLoanAccount
     */
    public final boolean isHasLoanAccount() {
	return hasLoanAccount;
    }

    /**
     * @param hasLoanAccount
     *            the hasLoanAccount to set
     */
    public final void setHasLoanAccount(final boolean hasLoanAccount) {
	this.hasLoanAccount = hasLoanAccount;
    }

    public void depositFund() {
	// TODO Auto-generated method stub

    }

    public void createAccount() {
	// TODO Auto-generated method stub

    }

    public void removeAccount() {
	// TODO Auto-generated method stub

    }

    public void querryStatement() {
	// TODO Auto-generated method stub

    }

    public void withdrawFund() {
	// TODO Auto-generated method stub

    }

}
