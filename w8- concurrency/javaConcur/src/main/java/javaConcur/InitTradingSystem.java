/**
 *
 */
package javaConcur;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author CHANDRAYAN
 *
 */
@Component("initSytem")
public class InitTradingSystem {

    @Value("#{'${client.list}'.split(';')}")
    private List<String> clientList;
    @Value("#{'${broker.list}'.split(';')}")
    private List<String> brokerList;
    @Autowired
    private ITrader trader;

    private List<Client> getListOfClientsFromStringList(final List<String> clientListInString) {
	List<Client> clientList = null;
	if (clientListInString != null) {
	    clientList = new ArrayList<Client>();
	    for (final String s : clientListInString) {
		final StringTokenizer st = new StringTokenizer(s, ",");
		final String name = st.nextToken();
		final Integer stocksDemanded = Integer.parseInt(st.nextToken());
		final String company = st.nextToken();
		if (!StringUtils.isEmpty(name) && stocksDemanded != null && !StringUtils.isEmpty(company)) {
		    clientList.add(new Client(name, new StockUnits(stocksDemanded, company)));
		}
	    }
	}
	return clientList;
    }

    private List<IBroker> getListOfBrokerFromStringList(final List<String> brokerListInString) {
	List<IBroker> brokerList = null;
	if (brokerListInString != null) {
	    brokerList = new ArrayList<IBroker>();
	    for (final String s : brokerListInString) {
		final StringTokenizer st = new StringTokenizer(s, ",");
		final Integer timeInterval = Integer.parseInt(st.nextToken());
		final Integer quantity = Integer.parseInt(st.nextToken());
		if (timeInterval != null && quantity != null) {
		    brokerList.add(new Broker(timeInterval, quantity));
		}
	    }
	}
	return brokerList;
    }

    public ITrader getTrader() {
	if (trader != null) {
	    trader.setBrokersList(getListOfBrokerFromStringList(brokerList));
	    trader.setClientsToServeList(getListOfClientsFromStringList(clientList));
	}
	return trader;
    }
}
