/**
 *
 */
package spingBank.factory.customerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import spingBank.bo.customerBOs.AbstractCustomerBO;
import spingBank.bo.customerBOs.Customer1BO;
import spingBank.bo.customerBOs.Customer2BO;

/**
 * @author CHANDRAYAN
 *
 */
@Component("customerFactory")
public class CustomerFactory implements ICustomerFactory {

    @Value("${priviledge_accounts}")
    private String priviledgeAccounts;

    private List<String> getAllPriviledgeCustomers() {
	List<String> list = null;
	if (priviledgeAccounts != null) {
	    final StringTokenizer st = new StringTokenizer(priviledgeAccounts, ",");
	    list = new ArrayList<String>();
	    while (st.hasMoreTokens()) {
		list.add(st.nextToken());
	    }
	}
	return list;
    }

    public List<AbstractCustomerBO> getCustomerList() {
	return getCustomerFromDb();
    }

    private List<AbstractCustomerBO> getCustomerFromDb() {
	// since there is no db here, we are getting dummy customer list
	final List<AbstractCustomerBO> boList = new ArrayList<AbstractCustomerBO>();
	final Customer1BO c1 = new Customer1BO("C1", "C1_ADDRESS", Arrays.asList("c1_account1", "c1_account2"), null,
		false, false);
	final Customer2BO c2 = new Customer2BO("C2", "c2_address", Arrays.asList("c2_account2", "c2_account2"), null,
		false, null);
	boList.add(c1);
	boList.add(c2);
	return processedPriviledCusList(boList);
    }

    private List<AbstractCustomerBO> processedPriviledCusList(final List<AbstractCustomerBO> boList) {
	if (boList != null) {
	    for (final AbstractCustomerBO bo : boList) {
		if (bo.getAccountNumber() != null) {
		    for (final String accountNumber : bo.getAccountNumber()) {
			if (isCustomerPrivileged(accountNumber)) {
			    bo.setPrivileged(Boolean.TRUE);
			    break;
			}
		    }
		}
	    }
	}
	return boList;

    }

    private Boolean isCustomerPrivileged(final String accountNumber) {
	final List<String> priviledgeList = getAllPriviledgeCustomers();
	if (priviledgeList != null) {
	    return priviledgeList.contains(accountNumber);
	}
	return false;
    }
}
