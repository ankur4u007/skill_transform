/**
 *
 */
package javaConcur.trader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javaConcur.broker.IBroker;
import javaConcur.client.Client;
import javaConcur.domainObj.StockUnits;
import javaConcur.executors.TradingExecutor;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

/**
 * @author CHANDRAYAN
 *
 */
@Component
public class Trader implements ITrader {

    private List<IBroker> brokersList;
    private List<Client> clientsToServeList;

    private static final Logger logger = Logger.getLogger(Trader.class);

    /**
     *
     */
    public Trader() {
	super();
    }

    /**
     * @param brokersList
     * @param clientsToServe
     */
    public Trader(final List<IBroker> brokersList, final List<Client> clientsToServeList) {
	super();
	this.brokersList = brokersList;
	this.clientsToServeList = clientsToServeList;
    }

    public void performTrading() {
	if (clientsToServeList != null && !clientsToServeList.isEmpty()) {
	    final ExecutorService executorServiceClients = Executors.newFixedThreadPool(clientsToServeList.size());
	    final List<Future<StockUnits>> futureresultList = new ArrayList<Future<StockUnits>>();
	    for (final Client client : clientsToServeList) {
		final Callable<StockUnits> tradingExecutor = new TradingExecutor(client.getStocksUnitsDemanded()
			.getNumberOfStocks(), client.getStocksUnitsDemanded().getCompany(), brokersList);
		final Future<StockUnits> result = executorServiceClients.submit(tradingExecutor);
		futureresultList.add(result);
	    }
	    try {
		for (int i = 0; i < clientsToServeList.size(); i++) {
		    final Future<StockUnits> futureStocks = futureresultList.get(i);
		    final StockUnits units = futureStocks.get();
		    clientsToServeList.get(i).updateStockUnitList(units);
		    logger.info(clientsToServeList.get(i));
		}
	    } catch (final InterruptedException e) {
		logger.error(e.getMessage(), e);
	    } catch (final ExecutionException e) {
		logger.error(e.getMessage(), e);
	    }
	    executorServiceClients.shutdown();
	}

    }

    /**
     * @param brokersList
     *            the brokersList to set
     */
    public final void setBrokersList(final List<IBroker> brokersList) {
	this.brokersList = brokersList;
    }

    /**
     * @param clientsToServeList
     *            the clientsToServeList to set
     */
    public final void setClientsToServeList(final List<Client> clientsToServeList) {
	this.clientsToServeList = clientsToServeList;
    }

}
