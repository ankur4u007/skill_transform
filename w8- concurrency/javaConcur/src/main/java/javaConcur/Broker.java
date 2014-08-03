/**
 *
 */
package javaConcur;


/**
 * @author CHANDRAYAN
 *
 */
public class Broker implements IBroker {

    private Integer timeInterval;
    private Integer quantity;

    /**
     * @param timeInterval
     * @param quantity
     * @param stocksOfCompany
     */
    public Broker(final Integer timeInterval, final Integer quantity) {
	super();
	this.timeInterval = timeInterval;
	this.quantity = quantity;
    }

    /**
     * @return the timeInterval
     */
    public final Integer getTimeInterval() {
	return timeInterval;
    }

    /**
     * @param timeInterval
     *            the timeInterval to set
     */
    public final void setTimeInterval(final Integer timeInterval) {
	this.timeInterval = timeInterval;
    }

    /**
     * @return the quantity
     */
    public final Integer getQuantity() {
	return quantity;
    }

    /**
     * @param quantity
     *            the quantity to set
     */
    public final void setQuantity(final Integer quantity) {
	this.quantity = quantity;
    }

    public synchronized StockUnits getStocksOfComapny(final String company) {
	StockUnits stocksToReturn = null;
	if (company != null && quantity != null && timeInterval != null) {
	    stocksToReturn = new StockUnits(quantity, company);
	    try {
		Thread.sleep(timeInterval * 1000l);
	    } catch (final InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	    }
	}
	return stocksToReturn;
    }
}
