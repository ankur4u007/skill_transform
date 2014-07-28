package com.gs.bank.customer;

import java.util.List;

public abstract class AbstractCustomer {

    private String name;
    private String address;
    private List<String> accountNumber;
    private String otherInfo;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     */
    public AbstractCustomer(final String name, final String address, final List<String> accountNumber,
	    final String otherInfo) {
	super();
	this.name = name;
	this.address = address;
	this.accountNumber = accountNumber;
	this.otherInfo = otherInfo;
    }

    /**
     * @return the name/
     */
    public final String getName() {
	return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
	this.name = name;
    }

    /**
     * @return the address
     */
    public final String getAddress() {
	return address;
    }

    /**
     * @param address
     *            the address to set
     */
    public final void setAddress(final String address) {
	this.address = address;
    }

    /**
     * @return the accountNumber
     */
    public final List<String> getAccountNumber() {
	return accountNumber;
    }

    /**
     * @param accountNumber
     *            the accountNumber to set
     */
    public final void setAccountNumber(final List<String> accountNumber) {
	this.accountNumber = accountNumber;
    }

    /**
     * @return the otherInfo
     */
    public final String getOtherInfo() {
	return otherInfo;
    }

    /**
     * @param otherInfo
     *            the otherInfo to set
     */
    public final void setOtherInfo(final String otherInfo) {
	this.otherInfo = otherInfo;
    }

}
