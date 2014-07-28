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
public class Customer1 extends AbstractCustomer implements ICustomer {

    private boolean onlineAccount;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     * @param onlineAccount
     */
    public Customer1(final String name, final String address, final List<String> accountNumber, final String otherInfo,
	    final boolean onlineAccount) {
	super(name, address, accountNumber, otherInfo);
	this.onlineAccount = onlineAccount;
    }

    /**
     * @return the onlineAccount
     */
    public final boolean isOnlineAccount() {
	return onlineAccount;
    }

    /**
     * @param onlineAccount
     *            the onlineAccount to set
     */
    public final void setOnlineAccount(final boolean onlineAccount) {
	this.onlineAccount = onlineAccount;
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
