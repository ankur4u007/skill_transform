package spingBank.bo.customerBOs;

import java.util.List;

public abstract class AbstractCustomerBO {

    private String name;
    private String address;
    private List<String> accountNumber;
    private String otherInfo;
    private boolean privileged;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     * @param privileged
     */
    public AbstractCustomerBO(final String name, final String address, final List<String> accountNumber,
	    final String otherInfo, final boolean privileged) {
	super();
	this.name = name;
	this.address = address;
	this.accountNumber = accountNumber;
	this.otherInfo = otherInfo;
	this.privileged = privileged;
    }

    /**
     * @return the name
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

    /**
     * @return the privileged
     */
    public final boolean isPrivileged() {
	return privileged;
    }

    /**
     * @param privileged
     *            the privileged to set
     */
    public final void setPrivileged(final boolean privileged) {
	this.privileged = privileged;
    }

}
