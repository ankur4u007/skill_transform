/**
 *
 */
package javaConcur.executors;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javaConcur.broker.IBroker;
import javaConcur.domainObj.StockUnits;

import org.apache.log4j.Logger;

/**
 * @author CHANDRAYAN
 *
 */
public class TradingExecutor implements Callable<StockUnits> {

    private final Integer numberOfStocksDemanded;
    private final String company;
    private final List<IBroker> brokersList;
    private Integer stockscollected;

    private static final Logger logger = Logger.getLogger(TradingExecutor.class);

    /**
     * @param clientToServe
     * @param numberOfStocksDemanded
     * @param company
     * @param brokersList
     */
    public TradingExecutor(final Integer numberOfStocksDemanded, final String company, final List<IBroker> brokersList) {
	super();
	this.numberOfStocksDemanded = numberOfStocksDemanded;
	this.company = company;
	this.brokersList = brokersList;
	stockscollected = 0;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Runnable#run()
     */
    public StockUnits call() {
	if (company != null && numberOfStocksDemanded != null && brokersList != null && !brokersList.isEmpty()) {

	    final List<Future<StockUnits>> futureresultList = new ArrayList<Future<StockUnits>>();
	    while (stockscollected < numberOfStocksDemanded) {
		final ExecutorService executorServiceBrokers = Executors.newFixedThreadPool(brokersList.size());
		for (final IBroker broker : brokersList) {
		    final Callable<StockUnits> brokingExecutor = new BrokingExecutor(company, broker);
		    final Future<StockUnits> result = executorServiceBrokers.submit(brokingExecutor);
		    futureresultList.add(result);
		}
		stockscollected += getTotalStocksCollected(futureresultList);
		executorServiceBrokers.shutdown();
	    }
	}
	return new StockUnits(stockscollected, company);
    }

    private Integer getTotalStocksCollected(final List<Future<StockUnits>> futureresultList) {
	Integer totalCollections = 0;
	try {
	    for (final Future<StockUnits> futureresult : futureresultList) {
		StockUnits units;
		units = futureresult.get();
		totalCollections += units.getNumberOfStocks();
	    }
	} catch (final InterruptedException e) {
	    logger.error(e.getMessage(), e);
	} catch (final ExecutionException e) {
	    logger.error(e.getMessage(), e);
	}
	return totalCollections;
    }
}
