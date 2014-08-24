/**
 *
 */
package spingBank.bo.customerBOs;

import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class Customer1BO extends AbstractCustomerBO {

    private boolean onlineAccount;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     * @param privileged
     * @param onlineAccount
     */
    public Customer1BO(final String name, final String address, final List<String> accountNumber,
	    final String otherInfo, final boolean privileged, final boolean onlineAccount) {
	super(name, address, accountNumber, otherInfo, privileged);
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

}
