package javaConcur.client;

import java.util.ArrayList;
import java.util.List;
import javaConcur.domainObj.StockUnits;

/**
 *
 * @author CHANDRAYAN
 *
 */
public class Client {

    private final String name;
    private final StockUnits stocksUnitsDemanded;
    private List<StockUnits> stockUnitList;

    /**
     * @return the stockUnitList
     */
    public final List<StockUnits> getStockUnitList() {
	return stockUnitList;
    }

    /**
     * @param stockUnitList
     *            the stockUnitList to set
     */
    public final void setStockUnitList(final List<StockUnits> stockUnitList) {
	this.stockUnitList = stockUnitList;
    }

    /**
     * @return the stocksUnitsDemanded
     */
    public final StockUnits getStocksUnitsDemanded() {
	return stocksUnitsDemanded;
    }

    /**
     * @param name
     * @param stocksDemanded
     */
    public Client(final String name, final StockUnits stocksUnitsDemanded) {
	super();
	this.name = name;
	this.stocksUnitsDemanded = stocksUnitsDemanded;
    }

    /**
     * @return the name
     */
    public final String getName() {
	return name;
    }

    public final void updateStockUnitList(final StockUnits stockUnits) {
	if (stockUnitList == null) {
	    stockUnitList = new ArrayList<StockUnits>();
	}
	stockUnitList.add(stockUnits);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	return "Client [name=" + name + ", stocksUnitsDemanded=" + stocksUnitsDemanded + "]";
    }

}
