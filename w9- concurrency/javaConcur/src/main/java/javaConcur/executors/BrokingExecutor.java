/**
 *
 */
package javaConcur.executors;

import java.util.concurrent.Callable;
import javaConcur.broker.IBroker;
import javaConcur.domainObj.StockUnits;

/**
 * @author CHANDRAYAN
 *
 */
public class BrokingExecutor implements Callable<StockUnits> {

    private final String company;
    private final IBroker broker;

    /**
     * @param numberOfStocksDemanded
     * @param company
     * @param broker
     */
    public BrokingExecutor(final String company, final IBroker broker) {
	super();
	this.company = company;
	this.broker = broker;
    }

    public StockUnits call() throws Exception {
	// TODO Auto-generated method stub
	return broker.getStocksOfComapny(company);
    }

}
