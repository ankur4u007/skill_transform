/**
 *
 */
package javaConcur;

import java.util.List;

/**
 * @author CHANDRAYAN
 *
 */
public interface ITrader {

    void performTrading();

    void setBrokersList(List<IBroker> brokersList);

    void setClientsToServeList(List<Client> clientsToServeList);
}
