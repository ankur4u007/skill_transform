/**
 *
 */
package spingBank.bo.customerBOs;

import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public class Customer2BO extends AbstractCustomerBO {

    private String loanAccount;

    /**
     * @param name
     * @param address
     * @param accountNumber
     * @param otherInfo
     * @param privileged
     * @param loanAccount
     */
    public Customer2BO(final String name, final String address, final List<String> accountNumber,
	    final String otherInfo, final boolean privileged, final String loanAccount) {
	super(name, address, accountNumber, otherInfo, privileged);
	this.loanAccount = loanAccount;
    }

    /**
     * @return the loanAccount
     */
    public final String getLoanAccount() {
	return loanAccount;
    }

    /**
     * @param loanAccount
     *            the loanAccount to set
     */
    public final void setLoanAccount(final String loanAccount) {
	this.loanAccount = loanAccount;
    }

}
