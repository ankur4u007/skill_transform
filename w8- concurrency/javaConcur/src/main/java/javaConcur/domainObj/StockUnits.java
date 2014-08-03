/**
 *
 */
package javaConcur.domainObj;

/**
 * @author CHANDRAYAN
 *
 */
public class StockUnits {

    private int numberOfStocks;
    private String company;

    /**
     * @param numberOfStocks
     * @param company
     */
    public StockUnits(final int numberOfStocks, final String company) {
	super();
	this.numberOfStocks = numberOfStocks;
	this.company = company;
    }

    /**
     * @return the numberOfStocks
     */
    public final int getNumberOfStocks() {
	return numberOfStocks;
    }

    /**
     * @param numberOfStocks
     *            the numberOfStocks to set
     */
    public final void setNumberOfStocks(final int numberOfStocks) {
	this.numberOfStocks = numberOfStocks;
    }

    /**
     * @return the company
     */
    public final String getCompany() {
	return company;
    }

    /**
     * @param company
     *            the company to set
     */
    public final void setCompany(final String company) {
	this.company = company;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "StockUnits [numberOfStocks=" + numberOfStocks + ", company=" + company + "]";
    }

}
