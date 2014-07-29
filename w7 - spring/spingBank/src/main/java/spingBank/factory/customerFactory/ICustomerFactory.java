/**
 *
 */
package spingBank.factory.customerFactory;

import java.util.List;

import spingBank.bo.customerBOs.AbstractCustomerBO;

/**
 * @author CHANDRAYAN
 *
 */
public interface ICustomerFactory {

    List<AbstractCustomerBO> getCustomerList();
}
