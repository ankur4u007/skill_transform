/**
 *
 */
package javaConcur.trader;

import java.util.List;
import javaConcur.broker.IBroker;
import javaConcur.client.Client;

/**
 * @author CHANDRAYAN
 *
 */
public interface ITrader {

    void performTrading();

    void setBrokersList(List<IBroker> brokersList);

    void setClientsToServeList(List<Client> clientsToServeList);
}
